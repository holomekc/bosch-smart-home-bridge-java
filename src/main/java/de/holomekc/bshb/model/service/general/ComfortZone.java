package de.holomekc.bshb.model.service.general;

import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@Getter
public class ComfortZone {
    private String name;
    private boolean custom;
    private double minTemperature;
    private double maxTemperature;
    private double minHumidity;
    private double maxHumidity;
    private double maxPurity;

}
