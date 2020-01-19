package de.holomekc.bshb.model.service.surveillance;

import lombok.Getter;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
@Getter
public class Entry {
    private String id;
    private boolean active;
    private boolean readonly;
}
