package de.holomekc.bshb.model.service.controller;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.information.SoftwareActivationDate;
import de.holomekc.bshb.model.service.State;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 18.01.2020
 */
@JsonTypeName("softwareUpdateState")
@Getter
public class SoftwareUpdateState extends State {

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

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString()).append("swUpdateState", this.swUpdateState)
                .append("swUpdateLastResult", this.swUpdateLastResult)
                .append("swUpdateAvailableVersion", this.swUpdateAvailableVersion)
                .append("swInstalledVersion", this.swInstalledVersion).append("swActivationDate", this.swActivationDate)
                .toString();
    }
}
