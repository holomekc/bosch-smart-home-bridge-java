package de.holomekc.bshb.model.service.program;

import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@Getter
public class SwitchPoint<T extends SwitchPointValue> {
    private int startTimeMinutes;
    private T value;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("startTimeMinutes", this.startTimeMinutes).append("value", this.value)
                .toString();
    }
}
