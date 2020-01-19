package de.holomekc.bshb.model.service.surveillance;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.JsonNode;

import de.holomekc.bshb.model.service.State;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("surveillanceAlarmState")
@Getter
public class SurveillanceAlarmState extends State {

    private Value value;
    // TODO: No clue what kind of data we have here
    private List<JsonNode> incidents;

    public enum Value {
        // TODO: Not sure if this is all. This is all I could see
        ALARM_ON,
        ALARM_OFF,
        ALARM_MUTED,
        PRE_ALARM,
        ;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString()).append("value", this.value)
                .append("incidents", this.incidents).toString();
    }
}
