package de.holomekc.bshb.security;

/**
 * @author Christopher Holomek
 * @since 12.01.2020
 */
public class CertificateDefinition {
    private final String cert;
    private final String privateKey;

    public CertificateDefinition(final String cert, final String privateKey) {
        this.cert = cert;
        this.privateKey = privateKey;
    }

    public String getCert() {
        return this.cert;
    }

    public String getPrivateKey() {
        return this.privateKey;
    }
}
