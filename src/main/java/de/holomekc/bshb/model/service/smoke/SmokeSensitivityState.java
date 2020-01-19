package de.holomekc.bshb.model.service.smoke;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("smokeSensitivityState")
@Getter
public class SmokeSensitivityState extends State {

    private SmokeSensitivity smokeSensitivity;
    private boolean preAlarmEnabled;

    public enum SmokeSensitivity {
        // TODO: Not sure if this is all. This is all I could see
        LOW,
        MIDDLE,
        HIGH,
        ;
    }
}
