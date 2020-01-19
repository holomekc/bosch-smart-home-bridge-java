package de.holomekc.bshb;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.builder.ToStringBuilder;

import de.holomekc.bshb.client.BshbResponse;
import de.holomekc.bshb.client.BshcClient;
import de.holomekc.bshb.client.PairingClient;
import de.holomekc.bshb.style.BshbStyle;
import io.reactivex.Observable;

/**
 * @author Christopher Holomek
 * @since 12.01.2020
 */
public class BoschSmartHomeBridge {

    private final CertificateStorage certificateStorage;

    private final PairingClient pairingClient;
    private final BshcClient bshcClient;

    public BoschSmartHomeBridge(final BoschSmartHomeBridgeBuilder bshbBuilder) {
        this.certificateStorage =
                new CertificateStorage(bshbBuilder.getClientCert(), bshbBuilder.getClientPrivateKey());
        this.pairingClient = new PairingClient(bshbBuilder.getHost());
        this.bshcClient = new BshcClient(bshbBuilder.getHost(), this.certificateStorage);

        // remove sensitive data from builder
        bshbBuilder.withClientCert("");
        bshbBuilder.withClientPrivateKey("");

        ToStringBuilder.setDefaultStyle(new BshbStyle());
    }

    public BshcClient getBshcClient() {
        return this.bshcClient;
    }

    public Observable<BshbResponse> pairIfNeeded(final String name, final String identifier,
            final String systemPassword) {
        return this.pairIfNeeded(name, identifier, systemPassword, 5000, 50);
    }

    public Observable<BshbResponse> pairIfNeeded(final String name, final String identifier,
            final String systemPassword, final int pairingDelay, final int pairingAttempts) {
        return Observable.create(observer -> {
            System.out.println("Check if client with identifier: " + identifier + " is already paired.");

            this.getBshcClient().getRooms().subscribe(next -> {
                System.out.println(
                        "Client with identifier: " + identifier + " already paired. Using existing certificate");
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
            System.out.println(
                    "Start pairing. Activate pairing on Bosch Smart Home Controller by pressing button until flashing.");
            final String cert = this.certificateStorage.getClientCert();
            this.pairingClient.sendPairingRequest(identifier, name, cert, systemPassword)
                    .retryWhen(attempts -> attempts.flatMap(err -> {
                        if (counter.incrementAndGet() < pairingAttempts) {
                            System.out
                                    .println("Could not pair client. Did you press the paring button? Error details:");
                            return Observable.timer(pairingDelay, TimeUnit.MILLISECONDS);
                        }
                        return Observable.error(err);
                    })).subscribe(value -> {
                if (value.getResponse().getStatus() == 201) {
                    System.out.println("Pairing successful.");
                } else {
                    System.out.println(
                            "Unexpected pairing response. Most likely wrong input data. Check password, etc. Pairing stopped.");
                }
                observer.onNext(value);
                observer.onComplete();
            }, error -> {
                System.out.println(
                        "Could not pair client. Did you press the paring button on Bosch Smart Home Controller? Error details: "
                                + error.getCause());
                observer.onError(error);
            });
        });
    }
}
