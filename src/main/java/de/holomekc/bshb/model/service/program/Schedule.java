package de.holomekc.bshb.model.service.program;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@Getter
public class Schedule<T extends SwitchPointValue> {
    private List<Profile<T>> profiles;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("profiles", this.profiles).toString();
    }
}
