package de.holomekc.bshb.model.service.twinguard;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("twinguardNightlyPromiseState")
@Getter
public class TwinguardNightlyPromiseState extends State {
    private boolean nightlyPromiseEnabled;
}
