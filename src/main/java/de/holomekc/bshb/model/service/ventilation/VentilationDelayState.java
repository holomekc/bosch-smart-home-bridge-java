package de.holomekc.bshb.model.service.ventilation;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import de.holomekc.bshb.model.service.sensor.Sensor;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("ventilationDelayState")
@Getter
public class VentilationDelayState extends State {
    private List<Sensor> devices;
    private int delay;
}
