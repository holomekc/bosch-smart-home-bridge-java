package de.holomekc.bshb.model.service.general;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("communicationQualityState")
@Getter
public class CommunicationQualityState extends State {

    private Quality quality;

    public enum Quality {
        BAD,
        NORMAL,
        GOOD,
        UNKNOWN,
        ;
    }
}
