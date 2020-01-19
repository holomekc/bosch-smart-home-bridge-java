package de.holomekc.bshb.model.service.program;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import de.holomekc.bshb.model.service.heating.TemperatureLevelSwitchPointValue;
import de.holomekc.bshb.model.service.power.SwitchStateSwitchPointValue;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, visible = true, property = "@type",
        defaultImpl = SimpleSwitchPointValue.class)
@JsonSubTypes({ // wrap
        @JsonSubTypes.Type(value = TemperatureLevelSwitchPointValue.class, name = "temperatureLevelSwitchPointValue"),
        @JsonSubTypes.Type(value = SwitchStateSwitchPointValue.class, name = "switchStateSwitchPointValue"),
        // wrap
})
public abstract class SwitchPointValue {
}
