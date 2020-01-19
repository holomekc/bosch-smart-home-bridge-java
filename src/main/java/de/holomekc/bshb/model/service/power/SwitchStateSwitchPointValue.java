package de.holomekc.bshb.model.service.power;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.program.SwitchPointValue;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("switchStateSwitchPointValue")
@Getter
public class SwitchStateSwitchPointValue extends SwitchPointValue {

    private SwitchState switchState;

    public enum SwitchState {
        // TODO: Not sure if this is all. This is all I could see
        ON,
        OFF,
        ;
    }
}
