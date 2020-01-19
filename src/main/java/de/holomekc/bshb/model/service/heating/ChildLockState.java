package de.holomekc.bshb.model.service.heating;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("childLockState")
@Getter
public class ChildLockState extends State {

    private ChildLock childLock;

    public enum ChildLock {
        // TODO: Not sure if this is all. This is all I could see
        ON,
        OFF,
        ;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("childLock", this.childLock).toString();
    }
}
