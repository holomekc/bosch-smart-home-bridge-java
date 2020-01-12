package de.holomekc.bshb.exception;

/**
 * @author Christopher Holomek (christopher.holomek@bmw.de)
 * @since 12.01.2020
 */
public class BshbException extends RuntimeException {

    public BshbException(final Throwable cause) {
        super(cause);
    }

    public BshbException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
