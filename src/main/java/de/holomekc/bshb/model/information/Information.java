package de.holomekc.bshb.model.information;

import org.apache.commons.lang3.builder.ToStringBuilder;

import de.holomekc.bshb.model.service.controller.SoftwareUpdateState;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 18.01.2020
 */
@Getter
public class Information {

    private String availableSoftwareVersion;
    private String connectivityVersion;
    private String updateUrl;
    private String version;
    private SoftwareUpdateState.UpdateState updateState;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("availableSoftwareVersion", this.availableSoftwareVersion)
                .append("connectivityVersion", this.connectivityVersion).append("updateUrl", this.updateUrl)
                .append("version", this.version).append("updateState", this.updateState).toString();
    }
}
