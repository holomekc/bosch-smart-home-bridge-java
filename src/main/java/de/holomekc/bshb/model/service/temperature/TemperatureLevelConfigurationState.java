package de.holomekc.bshb.model.service.temperature;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import de.holomekc.bshb.model.service.sensor.Sensor;
import lombok.Getter;

@JsonTypeName("temperatureLevelConfigurationState")
@Getter
public class TemperatureLevelConfigurationState extends State {
    private List<Sensor> sensors;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("sensors", this.sensors).toString();
    }
}
