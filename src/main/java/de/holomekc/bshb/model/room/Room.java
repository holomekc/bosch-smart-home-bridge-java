package de.holomekc.bshb.model.room;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.Identifier;

/**
 * @author Christopher Holomek
 * @since 18.01.2020
 */
@JsonTypeName("room")
public class Room extends Identifier {

    private String iconId;

    public String getIconId() {
        return this.iconId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("iconId", this.iconId).toString();
    }
}
