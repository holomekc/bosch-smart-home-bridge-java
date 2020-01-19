package de.holomekc.bshb.model.information;

import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 18.01.2020
 */
@Getter
public class ConnectivityVersion {
    private String name;
    private int minVersion;
    private int maxVersion;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", this.name).append("minVersion", this.minVersion)
                .append("maxVersion", this.maxVersion).toString();
    }
}
