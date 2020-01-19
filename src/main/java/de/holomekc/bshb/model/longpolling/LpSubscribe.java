package de.holomekc.bshb.model.longpolling;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 18.01.2020
 */
@Getter
public class LpSubscribe {
    @JsonProperty
    private final String jsonrpc = "2.0";
    @JsonProperty
    private final String method = "RE/subscribe";
    @JsonProperty
    private final String[] params = { "com/bosch/sh/remote/*", null };

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("jsonrpc", this.jsonrpc).append("method", this.method)
                .append("params", this.params).toString();
    }
}
