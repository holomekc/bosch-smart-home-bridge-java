package de.holomekc.bshb.model.information;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.BshcType;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 18.01.2020
 */
@JsonTypeName("softwareActivationDate")
@Getter
public class SoftwareActivationDate extends BshcType {
    private long timeout;

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString()).append("timeout", this.timeout).toString();
    }
}
