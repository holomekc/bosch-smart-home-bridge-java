package de.holomekc.bshb.model.service.power;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("powerMeterState")
@Getter
public class PowerMeterState extends State {
    private double powerConsumption;
    private double energyConsumption;
}
