package de.holomekc.bshb.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author Christopher Holomek
 * @since 18.01.2020
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, visible = true)
public class Type {
    @JsonProperty("@type")
    private String type;

    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("type", this.type).toString();
    }
}
