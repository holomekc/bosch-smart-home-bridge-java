package de.holomekc.bshb.client;

import javax.ws.rs.HttpMethod;

import de.holomekc.bshb.BshbResponse;
import de.holomekc.bshb.CertificateStorage;
import io.reactivex.Observable;

/**
 * @author Christopher Holomek
 * @since 12.01.2020
 */
public class BshcClient extends AbstractBshcClient {

    private static final int COMMON_PORT = 8444;
    private static final String PATH_PREFIX = "/smarthome/";

    public BshcClient(final String host, final CertificateStorage certificateStorage) {
        super(host, certificateStorage);
    }

    public Observable<BshbResponse> getRooms() {
        return this.simpleCall(COMMON_PORT, HttpMethod.GET, PATH_PREFIX + "rooms", null,
                invocationBuilder -> invocationBuilder);
    }
}
