package de.holomekc.bshb.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 18.01.2020
 */
@Getter
public abstract class NamedIdentifier extends Identifier {

    private String name;

    public NamedIdentifier() {
    }

    public NamedIdentifier(final String id, final String name) {
        super(id);
        this.name = name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString()).append("name", this.name).toString();
    }
}
