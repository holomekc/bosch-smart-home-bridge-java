package de.holomekc.bshb.model.information;

/**
 * @author Christopher Holomek
 * @since 18.01.2020
 */
public class Information {

    private String availableSoftwareVersion;
    private String connectivityVersion;
    private String updateUrl;
    private String version;
    private SoftwareUpdateState.UpdateState updateState;

    public String getAvailableSoftwareVersion() {
        return this.availableSoftwareVersion;
    }

    public String getConnectivityVersion() {
        return this.connectivityVersion;
    }

    public String getUpdateUrl() {
        return this.updateUrl;
    }

    public String getVersion() {
        return this.version;
    }

    public SoftwareUpdateState.UpdateState getUpdateState() {
        return this.updateState;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("availableSoftwareVersion", this.availableSoftwareVersion)
                .append("connectivityVersion", this.connectivityVersion).append("updateUrl", this.updateUrl)
                .append("version", this.version).append("updateState", this.updateState).toString();
    }
}
