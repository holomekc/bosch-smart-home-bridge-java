package de.holomekc.bshb.model.service.presence;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import de.holomekc.bshb.model.service.sensor.Sensor;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("presenceSimulationConfigurationState")
@Getter
public class PresenceSimulationConfigurationState extends State {

    private boolean enabled;
    private List<Sensor> devices;
    private String runningStartTime;
    private String runningEndTime;
}
