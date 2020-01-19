package de.holomekc.bshb.model.service.temperature;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("temperatureLevelState")
@Getter
public class TemperatureLevelState extends State {
    private double temperature;

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString()).append("temperature", this.temperature).toString();
    }
}
