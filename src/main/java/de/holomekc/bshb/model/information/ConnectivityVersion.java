package de.holomekc.bshb.model.information;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Christopher Holomek
 * @since 18.01.2020
 */
public class ConnectivityVersion {
    private String name;
    private int minVersion;
    private int maxVersion;

    public String getName() {
        return this.name;
    }

    public int getMinVersion() {
        return this.minVersion;
    }

    public int getMaxVersion() {
        return this.maxVersion;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", this.name).append("minVersion", this.minVersion)
                .append("maxVersion", this.maxVersion).toString();
    }
}
