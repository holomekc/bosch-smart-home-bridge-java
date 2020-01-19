package de.holomekc.bshb.model.service.heating;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import lombok.Getter;

@JsonTypeName("valveTappetState")
@Getter
public class ValveTappetState extends State {

    private Value value;
    private int position;

    public enum Value {
        // TODO: Not sure if this is all. This is all I could see
        NOT_AVAILABLE,

        START_POSITION_REQUESTED,
        RUN_TO_START_POSITION,
        IN_START_POSITION,

        VALVE_ADAPTION_REQUESTED,
        VALVE_ADAPTION_IN_PROGRESS,
        VALVE_ADAPTION_SUCCESSFUL,
        ;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString()).append("value", this.value)
                .append("position", this.position).toString();
    }
}
