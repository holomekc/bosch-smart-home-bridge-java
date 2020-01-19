package de.holomekc.bshb.model.service.heating;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.holomekc.bshb.model.service.State;
import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeName("temperatureOffsetState")
@Getter
public class TemperatureOffsetState extends State {

    private double offset;
    private double stepSize;
    private double minOffset;
    private double maxOffset;

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString()).append("offset", this.offset)
                .append("stepSize", this.stepSize).append("minOffset", this.minOffset).append("maxOffset",
                        this.maxOffset).toString();
    }
}
