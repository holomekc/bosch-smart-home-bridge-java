package de.holomekc.bshb.model.information;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.Type;

/**
 * @author Christopher Holomek
 * @since 18.01.2020
 */
@JsonTypeName("softwareActivationDate")
public class SoftwareActivationDate extends Type {
    private long timeout;

    public long getTimeout() {
        return this.timeout;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("timeout", this.timeout).toString();
    }
}
