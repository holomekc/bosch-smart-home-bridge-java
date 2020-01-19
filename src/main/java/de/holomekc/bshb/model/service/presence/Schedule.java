package de.holomekc.bshb.model.service.presence;

import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@Getter
public class Schedule {
    private String deviceId;
    private String startTime;
    private String endTime;
}
