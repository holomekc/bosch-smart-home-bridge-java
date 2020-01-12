package de.holomekc.bshb.builder;

import de.holomekc.bshb.BoschSmartHomeBridgeBuilder;

/**
 * Part of {@link BoschSmartHomeBridgeBuilder} to make sure that required properties are set. This is for client private
 * key
 *
 * @author Christopher Holomek (christopher.holomek@bmw.de)
 * @since 12.01.2020
 */
public interface ClientKey {

    /**
     * Set client private key (2048bit)
     *
     * @param clientPrivateKey
     *         private key to use.<br>
     *         Format: -----BEGIN RSA PRIVATE KEY-----{your private key}-----END RSA PRIVATE KEY-----
     *
     * @return next step
     */
    BoschSmartHomeBridgeBuilder withClientPrivateKey(final String clientPrivateKey);
}
