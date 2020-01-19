package de.holomekc.bshb.model.service;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.Identifier;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("DeviceServiceData")
@Getter
public class Service<T extends State> extends Identifier {
    private String deviceId;
    private T state;
    private List<String> operations;
    private String path;

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString()).append("deviceId", this.deviceId)
                .append("state", this.state).append("path", this.path).toString();
    }
}
