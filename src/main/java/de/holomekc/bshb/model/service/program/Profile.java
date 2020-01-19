package de.holomekc.bshb.model.service.program;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@Getter
public class Profile<T extends SwitchPointValue> {

    private Day day;
    private List<SwitchPoint<T>> switchPoints;

    public enum Day {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY,
        ;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("day", this.day).append("switchPoints", this.switchPoints).toString();
    }
}
