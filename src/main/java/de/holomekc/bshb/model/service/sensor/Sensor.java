package de.holomekc.bshb.model.service.sensor;

import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@Getter
public class Sensor {
    private String deviceId;
    private boolean active;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("deviceId", this.deviceId).append("active", this.active).toString();
    }
}
