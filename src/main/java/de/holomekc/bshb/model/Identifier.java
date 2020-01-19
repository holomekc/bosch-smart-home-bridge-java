package de.holomekc.bshb.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@Getter
public abstract class Identifier extends BshcType {

    private String id;

    public Identifier() {
    }

    public Identifier(final String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString()).append("id", this.id).toString();
    }
}
