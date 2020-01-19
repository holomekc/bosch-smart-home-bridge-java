package de.holomekc.bshb.model.service.surveillance;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("intrusionDetectionControlState")
@Getter
public class IntrusionDetectionControlState extends State {

    private Value value;
    private List<Entry> triggers;
    private List<Entry> actuators;

    private int armActivationDelayTime;
    private int alarmActivationDelayTime;

    public enum Value {
        SYSTEM_DISARMED,
        ;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("value", this.value).append("triggers", this.triggers)
                .append("actuators", this.actuators).append("armActivationDelayTime", this.armActivationDelayTime)
                .append("alarmActivationDelayTime", this.alarmActivationDelayTime).toString();
    }
}
