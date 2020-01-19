package de.holomekc.bshb.model.service.hue;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("hueBridgeConnectorState")
@Getter
public class HueBridgeConnectorState extends State {

    private HueConnectingState connectingState;
}
