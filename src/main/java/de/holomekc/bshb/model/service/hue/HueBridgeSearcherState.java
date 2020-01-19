package de.holomekc.bshb.model.service.hue;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("hueBridgeSearcherState")
@Getter
public class HueBridgeSearcherState extends State {

    private SearcherState searcherState;
    private List<HueBridge> searchResult;
    // TODO: seems to be the same as searcherState. Looks like a mistake
    private SearcherState value;

    public enum SearcherState {
        // TODO: Not sure if this is all. This is all I could see
        NO_BRIDGE_FOUND,
        BRIDGES_FOUND,

        BRIDGE_SEARCH_REQUESTED,
        BRIDGE_SEARCH_STARTED,
        ;
    }
}
