package de.holomekc.bshb.model.service.program;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@Getter
public class SimpleSwitchPointValue extends SwitchPointValue {

    @JsonProperty("@type")
    private String type;

    @JsonIgnore
    private final Map<String, JsonNode> data = new HashMap<>();

    @JsonAnyGetter
    public Map<String, JsonNode> getData() {
        return this.data;
    }

    @JsonAnySetter
    public void setData(final String name, final JsonNode value) {
        this.data.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString()).append("type", this.type)
                .append("data", this.data).toString();
    }
}
