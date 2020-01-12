package de.holomekc.bshb;

import de.holomekc.bshb.client.BshcClient;
import de.holomekc.bshb.client.PairingClient;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Christopher Holomek
 * @since 12.01.2020
 */
public class BoschSmartHomeBridge {

    private final CertificateStorage certificateStorage;

    private final PairingClient pairingClient;
    private final BshcClient bshcClient;

    private final String host;

    public BoschSmartHomeBridge(final BoschSmartHomeBridgeBuilder bshbBuilder) {
        this.host = bshbBuilder.getHost();
        this.certificateStorage = new CertificateStorage(bshbBuilder.getClientCert(), bshbBuilder.getClientPrivateKey());
        this.pairingClient = new PairingClient(this.host);
        this.bshcClient = new BshcClient(this.host, this.certificateStorage);

        // remove sensitive data from builder
        bshbBuilder.withClientCert("");
        bshbBuilder.withClientPrivateKey("");
    }

    public BshcClient getBshcClient() {
        return this.bshcClient;
    }

    public Observable<BshbResponse> pairIfNeeded(final String name, final String identifier, final String systemPassword) {
        return this.pairIfNeeded(name, identifier, systemPassword, 5000, 50);
    }

    public Observable<BshbResponse> pairIfNeeded(final String name, final String identifier, final String systemPassword,
                                                 final int pairingDelay, final int pairingAttempts) {
        return Observable.create(observer -> {
            System.out.println("Check if client with identifier: " + identifier + " is already paired.");

            this.getBshcClient().getRooms().subscribe(next -> {
                System.out.println("Client with identifier: " + identifier + " already paired. Using existing certificate");
                observer.onNext(new BshbResponse(null));
                observer.onComplete();
            }, testConnectionError -> {
                testConnectionError.printStackTrace();
                System.out.println("Error during call to test if already paired. " + testConnectionError);
                System.out.println("Client with identifier: " + identifier + " was not paired yet.");

                this.pairClient(name, identifier, systemPassword, pairingDelay, pairingAttempts).subscribe(value -> {
                    observer.onNext(value);
                    observer.onComplete();
                }, error -> {
                    observer.onError(error);
                    observer.onComplete();
                });
            });
        });
    }

    public Observable<BshbResponse> pairClient(final String name, final String identifier, final String systemPassword,
                                               final int pairingDelay, final int pairingAttempts) {

        final AtomicInteger counter = new AtomicInteger(0);
        return Observable.create(observer -> {
            System.out.println("Start pairing. Activate pairing on Bosch Smart Home Controller by pressing button until flashing.");
            this.pairingClient.sendPairingRequest(identifier, name, null, systemPassword).retryWhen(errors -> errors.concatMap((e) -> {
                if (counter.get() > pairingAttempts) {
                    return Observable.error(e);
                } else {
                    counter.incrementAndGet();
                    return Observable.create(next -> {
                        System.out.println("Could not pair client. Did you press the paring button? Error details: " + e.getCause());
                        next.onNext(e);
                        next.onComplete();
                    }).delay(pairingDelay, TimeUnit.MILLISECONDS);
                }
            })).subscribe(value -> {
                if (value.getResponse().getStatus() == 201) {
                    System.out.println("Pairing successful.");
                } else {
                    System.out.println("Unexpected pairing response. Most likely wrong input data. Check password, etc. Pairing stopped.");
                }
                observer.onNext(value);
                observer.onComplete();
            }, error -> {
                System.out.println("Could not pair client. Did you press the paring button on Bosch Smart Home Controller? Error details: " + error.getCause());
                observer.onError(error);
            });
        });
    }
}
