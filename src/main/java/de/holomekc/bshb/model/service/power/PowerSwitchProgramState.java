package de.holomekc.bshb.model.service.power;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import de.holomekc.bshb.model.service.program.Schedule;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("powerSwitchProgramState")
@Getter
public class PowerSwitchProgramState extends State {

    private OperationMode operationMode;
    private Schedule<SwitchStateSwitchPointValue> schedule;

    public enum OperationMode {
        // TODO: Not sure if this is all. This is all I could see
        MANUAL,
        SCHEDULE,
        ;
    }
}
