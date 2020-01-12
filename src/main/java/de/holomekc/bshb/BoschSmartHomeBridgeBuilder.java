package de.holomekc.bshb;

import de.holomekc.bshb.builder.ClientCert;
import de.holomekc.bshb.builder.ClientKey;
import de.holomekc.bshb.builder.Host;

/**
 * @author Christopher Holomek (christopher.holomek@bmw.de)
 * @since 12.01.2020
 */
public final class BoschSmartHomeBridgeBuilder implements Host, ClientCert, ClientKey {

    private String host;
    private String clientCert;
    private String clientPrivateKey;

    /**
     * Create a new instance of a builder
     *
     * @return new instance of a builder
     */
    public static Host builder() {
        return new BoschSmartHomeBridgeBuilder();
    }

    /**
     * Hide constructor
     */
    private BoschSmartHomeBridgeBuilder() {
        // Hide constructor
    }

    /**
     * Get host name / ip address of BSHC
     *
     * @return host name / ip address of BSHC
     */
    public String getHost() {
        return this.host;
    }

    @Override
    public BoschSmartHomeBridgeBuilder withHost(final String host) {
        this.host = host;
        return this;
    }

    /**
     * Get client certificate (base64)
     *
     * @return client certificate (base64)
     */
    public String getClientCert() {
        return this.clientCert;
    }

    @Override
    public BoschSmartHomeBridgeBuilder withClientCert(final String clientCert) {
        this.clientCert = clientCert;
        return this;
    }

    /**
     * Get client private key (base64)
     *
     * @return client private key (base64)
     */
    public String getClientPrivateKey() {
        return this.clientPrivateKey;
    }

    @Override
    public BoschSmartHomeBridgeBuilder withClientPrivateKey(final String clientPrivateKey) {
        this.clientPrivateKey = clientPrivateKey;
        return this;
    }

    public BoschSmartHomeBridge build() {
        if (this.host == null) {
            throw new IllegalArgumentException(
                    "host is a required property. withHost must be called with a suitable value.");
        }

        if (this.clientCert == null) {
            throw new IllegalArgumentException(
                    "clientCert is a required property. withClientCert must be called with a suitable value.");
        }

        if (this.clientPrivateKey == null) {
            throw new IllegalArgumentException(
                    "clientPrivateKey is a required property. withClientPrivateKey must be called with a suitable value");
        }
        return new BoschSmartHomeBridge(this);
    }
}
