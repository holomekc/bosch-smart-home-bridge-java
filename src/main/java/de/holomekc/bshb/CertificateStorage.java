package de.holomekc.bshb;

/**
 * @author Christopher Holomek
 * @since 12.01.2020
 */
public class CertificateStorage {
    private final String clientCert;
    private final String clientPrivateKey;

    public CertificateStorage(final String clientCert, final String clientPrivateKey) {
        this.clientCert = clientCert;
        this.clientPrivateKey = clientPrivateKey;
    }

    public String getClientCert() {
        return this.clientCert;
    }

    public String getClientPrivateKey() {
        return this.clientPrivateKey;
    }
}
