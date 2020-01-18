package de.holomekc.bshb.model.information;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.Type;

/**
 * @author Christopher Holomek
 * @since 18.01.2020
 */
@JsonTypeName("softwareUpdateState")
public class SoftwareUpdateState extends Type {

    public enum UpdateState {
        // TODO: Not sure if this is all. This is all I could see
        NO_UPDATE_AVAILABLE,
        UPDATE_AVAILABLE,
        UPDATE_IN_PROGRESS,
        DOWNLOADING,
        ;
    }

    public enum UpdateLastResult {
        // TODO: Not sure if this is all. This is all I could see
        UPDATE_SUCCESS,
        DOWNLOAD_FAILED,
        ;
    }

    private UpdateState swUpdateState;
    private UpdateLastResult swUpdateLastResult;
    private String swUpdateAvailableVersion;
    private String swInstalledVersion;
    private SoftwareActivationDate swActivationDate;

    public UpdateState getSwUpdateState() {
        return this.swUpdateState;
    }

    public UpdateLastResult getSwUpdateLastResult() {
        return this.swUpdateLastResult;
    }

    public String getSwUpdateAvailableVersion() {
        return this.swUpdateAvailableVersion;
    }

    public String getSwInstalledVersion() {
        return this.swInstalledVersion;
    }

    public SoftwareActivationDate getSwActivationDate() {
        return this.swActivationDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("swUpdateState", this.swUpdateState)
                .append("swUpdateLastResult", this.swUpdateLastResult)
                .append("swUpdateAvailableVersion", this.swUpdateAvailableVersion)
                .append("swInstalledVersion", this.swInstalledVersion).append("swActivationDate", this.swActivationDate)
                .toString();
    }
}
