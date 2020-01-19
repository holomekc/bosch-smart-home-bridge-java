package de.holomekc.bshb.model.device;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.NamedIdentifier;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 18.01.2020
 */
@JsonTypeName("device")
@Getter
public class Device extends NamedIdentifier {
    private String rootDeviceId;
    private List<String> deviceServiceIds;
    private String manufacturer;
    private String roomId;
    private String deviceModel;
    private String serial;
    private Profile profile;
    private String iconId;
    private Availability status;
    private String parentDeviceId;
    private List<String> childDeviceIds;

    public enum Availability {
        // TODO: Not sure if this is all. This is all I could see
        AVAILABLE,
        UNAVAILABLE,
        COMMUNICATION_ERROR,
        DISCOVERED,
        ;
    }

    public enum Profile {
        // TODO: Not sure if this is all. This is all I could see
        REGULAR_WINDOW,
        ENTRANCE_DOOR,
        LIGHT,
        ;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString()).append("rootDeviceId", this.rootDeviceId)
                .append("deviceServiceIds", this.deviceServiceIds).append("manufacturer", this.manufacturer)
                .append("roomId", this.roomId).append("deviceModel", this.deviceModel).append("serial", this.serial)
                .append("profile", this.profile).append("iconId", this.iconId).append("status", this.status)
                .append("parentDeviceId", this.parentDeviceId).append("childDeviceIds", this.childDeviceIds).toString();
    }
}
