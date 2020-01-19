package de.holomekc.bshb.model.service.presence;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("presenceSimulationSchedulingState")
@Getter
public class PresenceSimulationSchedulingState extends State {

    private List<Schedule> schedule;
}
