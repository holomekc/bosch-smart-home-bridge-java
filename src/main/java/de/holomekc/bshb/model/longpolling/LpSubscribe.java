package de.holomekc.bshb.model.longpolling;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Christopher Holomek
 * @since 18.01.2020
 */
public class LpSubscribe {
    @JsonProperty
    private final String jsonrpc = "2.0";
    @JsonProperty
    private final String method = "RE/subscribe";
    @JsonProperty
    private final String[] params = { "com/bosch/sh/remote/*", null };
}
