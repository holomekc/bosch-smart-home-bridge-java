package de.holomekc.bshb.model.service.heating;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import de.holomekc.bshb.model.service.program.Schedule;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("climateControlState")
@Getter
public class ClimateControlState extends State {
    private OperationMode operationMode;
    private double setpointTemperature;
    private double setpointTemperatureForLevelEco;
    private double setpointTemperatureForLevelComfort;
    private Schedule<TemperatureLevelSwitchPointValue> schedule;
    private boolean ventilationMode;
    private boolean low;
    private boolean boostMode;
    private boolean summerMode;
    private boolean supportsBoostMode;
    private boolean showSetpointTemperature;

    public enum OperationMode {
        // TODO: Not sure if this is all. This is all I could see
        MANUAL,
        AUTOMATIC,
        OFF,
        ;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("operationMode", this.operationMode)
                .append("setpointTemperature", this.setpointTemperature)
                .append("setpointTemperatureForLevelEco", this.setpointTemperatureForLevelEco)
                .append("setpointTemperatureForLevelComfort", this.setpointTemperatureForLevelComfort)
                .append("schedule", this.schedule).append("ventilationMode", this.ventilationMode)
                .append("low", this.low).append("boostMode", this.boostMode).append("summerMode", this.summerMode)
                .append("supportsBoostMode", this.supportsBoostMode)
                .append("showSetpointTemperature", this.showSetpointTemperature).toString();
    }
}
