package de.holomekc.bshb.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Christopher Holomek
 * @since 18.01.2020
 */
public class Identifier extends Type {

    private String id;
    private String name;

    public Identifier() {
    }

    public Identifier(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", this.id).append("name", this.name).toString();
    }
}
