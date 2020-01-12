package de.holomekc.bshb.client;

import de.holomekc.bshb.BshbResponse;
import de.holomekc.bshb.CertificateStorage;
import de.holomekc.bshb.model.BoschClientData;
import io.reactivex.Observable;

/**
 * @author Christopher Holomek (christopher.holomek@bmw.de)
 * @since 12.01.2020
 */
public class PairingClient extends AbstractBshcClient {
    private static final String PAIR_PATH = "/smarthome/clients";

    public PairingClient(final String host) {
        super(host, new CertificateStorage(null, null));
    }

    /**
     * Send a pairing request to BSHC
     *
     * @param identifier
     *         unique identifier of certificate / client
     * @param name
     *         name of the client (will be displayed in BSH app
     * @param certificate
     *         CertificateDefinition to use (base64 encoded with header / footer)
     * @param systemPassword
     *         system password of BSHC
     */
    public Observable<BshbResponse> sendPairingRequest(final String identifier, final String name,
            final String certificate, final String systemPassword) {
        final BoschClientData clientData = new BoschClientData(name, identifier, certificate);

        return Observable.create(observer -> {
        });
    }
}
