package de.holomekc.bshb.model.service.air;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import de.holomekc.bshb.model.service.general.ComfortZone;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("airQualityLevelState")
@Getter
public class AirQualityLevelState extends State {

    private Rating combinedRating;
    private String description;
    private double temperature;
    private Rating temperatureRating;
    private double humidity;
    private Rating humidityRating;
    private double purity;
    private Rating purityRating;
    private ComfortZone comfortZone;

    public enum Rating {
        BAD,
        MEDIUM,
        GOOD,
        ;
    }
}
