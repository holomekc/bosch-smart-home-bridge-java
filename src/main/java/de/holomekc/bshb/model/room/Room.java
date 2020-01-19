package de.holomekc.bshb.model.room;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.NamedIdentifier;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 18.01.2020
 */
@JsonTypeName("room")
@Getter
public class Room extends NamedIdentifier {

    private String iconId;

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString()).append("iconId", this.iconId).toString();
    }
}
