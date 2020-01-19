package de.holomekc.bshb.model.information;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import de.holomekc.bshb.model.service.controller.SoftwareUpdateState;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 18.01.2020
 */
@Getter
public class PublicInformation {

    private List<String> apiVersions;
    private SoftwareUpdateState softwareUpdateState;
    private boolean claimed;
    private String country;
    private String tacVersion;
    private String shcIpAddress;
    private List<String> clientIds;
    private Map<String, Boolean> featureToggles;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("apiVersions", this.apiVersions)
                .append("softwareUpdateState", this.softwareUpdateState).append("claimed", this.claimed)
                .append("country", this.country).append("tacVersion", this.tacVersion)
                .append("shcIpAddress", this.shcIpAddress).append("clientIds", this.clientIds)
                .append("featureToggles", this.featureToggles).toString();
    }
}
