package de.holomekc.bshb.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * @author Christopher Holomek
 * @since 12.01.2020
 */
@JsonTypeName("client")
public class BoschClientData extends Identifier {

    private final String primaryRole;
    private final boolean deleted;
    private final String certificate;

    /**
     * Create data for a new client with necessary information
     *
     * @param name
     *         name of the Open Source Project, which uses this library. "OSS " prefix is added automatically.
     * @param id
     *         identifier of the new client (pick a unique one). "oss_" prefix is added automatically.
     * @param certificate
     *         2048 bit selfsigned client certificate
     */
    public BoschClientData(final String name, final String id, final String certificate) {
        super("oss_" + id, "OSS " + name);
        this.certificate = certificate;
        this.primaryRole = "ROLE_RESTRICTED_CLIENT";
        this.deleted = false;
    }

    public String getPrimaryRole() {
        return this.primaryRole;
    }

    public boolean isDeleted() {
        return this.deleted;
    }

    public String getCertificate() {
        return this.certificate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("primaryRole", this.primaryRole).append("deleted", this.deleted)
                .append("certificate", this.certificate).toString();
    }
}
