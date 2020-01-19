package de.holomekc.bshb.model.service.power;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("powerSwitchState")
@Getter
public class PowerSwitchState extends State {

    private SwitchState switchState;
    private int automaticPowerOffTime;

    public enum SwitchState {
        // TODO: Not sure if this is all. This is all I could see
        ON,
        OFF,
        ;
    }
}
