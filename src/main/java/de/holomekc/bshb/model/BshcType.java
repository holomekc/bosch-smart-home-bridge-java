package de.holomekc.bshb.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 18.01.2020
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, visible = true, property = "@type")
@Getter
public abstract class BshcType {
    @JsonProperty("@type")
    private String type;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("@type", this.type).toString();
    }
}
