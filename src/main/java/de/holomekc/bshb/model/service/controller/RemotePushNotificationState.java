package de.holomekc.bshb.model.service.controller;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("remotePushNotificationState")
@Getter
public class RemotePushNotificationState extends State {
    private RemoteAccessState.State state;

    public enum State {
        // TODO: Not sure if this is all. This is all I could see
        ENABLED,
        DISABLED,
        ;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString()).append("state", this.state).toString();
    }
}
