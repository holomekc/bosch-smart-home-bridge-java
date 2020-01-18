package de.holomekc.bshb.model.longpolling;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Christopher Holomek
 * @since 18.01.2020
 */
public class LpPoll {
    @JsonProperty
    private final String jsonrpc = "2.0";
    @JsonProperty
    private final String method = "RE/longPoll";
    @JsonProperty
    private final Object[] params;

    public LpPoll(final String subscriptionId, final int timeout) {
        this.params = new Object[] { subscriptionId, timeout / 1000 };
    }
}
