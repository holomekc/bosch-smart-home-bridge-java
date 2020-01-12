package de.holomekc.bshb.builder;

import de.holomekc.bshb.BoschSmartHomeBridgeBuilder;

/**
 * Part of {@link BoschSmartHomeBridgeBuilder} to make sure that required properties are set. This is for BSHC host
 *
 * @author Christopher Holomek (christopher.holomek@bmw.de)
 * @since 12.01.2020
 */
public interface Host {

    /**
     * Set host name / ip address of BSHC
     *
     * @param host
     *         name / ip address of BSHC
     *
     * @return next step
     */
    ClientCert withHost(final String host);
}
