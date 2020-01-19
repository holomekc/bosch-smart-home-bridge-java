package de.holomekc.bshb.model.service.heating;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.program.SwitchPointValue;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("temperatureLevelSwitchPointValue")
@Getter
public class TemperatureLevelSwitchPointValue extends SwitchPointValue {

    private TemperatureLevel temperatureLevel;

    public enum TemperatureLevel {
        // TODO: Not sure if this is all. This is all I could see
        ECO,
        COMFORT,
        ;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString()).append("temperatureLevel", this.temperatureLevel)
                .toString();
    }
}
