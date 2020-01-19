package de.holomekc.bshb.model.service.power;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("routingState")
@Getter
public class RoutingState extends State {

    private Value value;

    private enum Value {
        ENABLED,
        DISABLED,
        ;
    }
}
