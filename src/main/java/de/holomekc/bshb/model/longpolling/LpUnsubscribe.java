package de.holomekc.bshb.model.longpolling;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
public class LpUnsubscribe {
    @JsonProperty
    private final String jsonrpc = "2.0";
    @JsonProperty
    private final String method = "RE/unsubscribe";
    @JsonProperty
    private final Object[] params;

    public LpUnsubscribe(final String subscriptionId) {
        this.params = new Object[] { subscriptionId };
    }
}
