package de.holomekc.bshb.builder;

import de.holomekc.bshb.BoschSmartHomeBridgeBuilder;

/**
 * Part of {@link BoschSmartHomeBridgeBuilder} to make sure that required properties are set. This is for client
 * certificate
 *
 * @author Christopher Holomek (christopher.holomek@bmw.de)
 * @since 12.01.2020
 */
public interface ClientCert {

    /**
     * Set client certificate (2048 bit self signed, base64 encoded)
     *
     * @param clientCert
     *         certificate to use.<br>
     *         Format: -----BEGIN CERTIFICATE-----{your certificate}-----END CERTIFICATE-----
     *
     * @return next step
     */
    ClientKey withClientCert(final String clientCert);
}
