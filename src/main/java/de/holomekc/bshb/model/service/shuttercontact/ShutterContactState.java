package de.holomekc.bshb.model.service.shuttercontact;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("shutterContactState")
@Getter
public class ShutterContactState extends State {

    private Value value;

    public enum Value {
        // TODO: Not sure if this is all. This is all I could see
        OPEN,
        CLOSED,
        ;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString()).append("value", this.value).toString();
    }
}
