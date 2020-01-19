package de.holomekc.bshb.model.service.smoke;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("smokeDetectionControlState")
@Getter
public class SmokeDetectionControlState extends State {
    // TODO: no clue
}
