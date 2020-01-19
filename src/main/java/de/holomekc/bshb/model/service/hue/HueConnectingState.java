package de.holomekc.bshb.model.service.hue;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
public class HueConnectingState {
    private State state;
    private String ip;
    private String mac;

    public enum State {
        // TODO: Not sure if this is all. This is all I could see
        CONNECTING,
        CONNECTED,
        PUSHLINK_AUTHENTICATION_STARTED,
        BRIDGE_ALREADY_CONNECTED,
    }
}
