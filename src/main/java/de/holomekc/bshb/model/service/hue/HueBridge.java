package de.holomekc.bshb.model.service.hue;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
public class HueBridge {
    private String ip;
    private String mac;
    private ConnectionState connectionState;
    // TODO: not sure stateValue seems to be the same as connectionState. Looks like a mistake
    private ConnectionState stateValue;

    public enum ConnectionState {
        // TODO: Not sure if this is all. This is all I could see
        NOT_CONNECTED,
        ALREADY_CONNECTED_OFFLINE,
        ALREADY_CONNECTED_ONLINE,
        ;
    }
}
