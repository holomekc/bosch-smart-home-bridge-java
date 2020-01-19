package de.holomekc.bshb.model.longpolling;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 18.01.2020
 */
@Getter
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

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("jsonrpc", this.jsonrpc).append("method", this.method)
                .append("params", this.params).toString();
    }
}
