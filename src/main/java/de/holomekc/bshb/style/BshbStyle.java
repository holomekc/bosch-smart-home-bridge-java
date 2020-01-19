package de.holomekc.bshb.style;

import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;

/**
 * @author Christopher Holomek
 * @since 19.01.2020
 */
public class BshbStyle extends MultilineRecursiveToStringStyle {

    private static final long serialVersionUID = 1L;

    public BshbStyle() {
        super();
        this.setUseShortClassName(true);
        this.setUseIdentityHashCode(false);
    }

    private Object readResolve() {
        return new BshbStyle();
    }
}
