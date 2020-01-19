package de.holomekc.bshb.model.service.smoke;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("smokeDetectorCheckState")
@Getter
public class SmokeDetectorCheckState extends State {

    private Value value;

    public enum Value {
        // TODO: Not sure if this is all. This is all I could see
        SMOKE_TEST_REQUESTED,
        SMOKE_TEST_OK,
        SMOKE_TEST_FAILED,
        ;

    }
}
