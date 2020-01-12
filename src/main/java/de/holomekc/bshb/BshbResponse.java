package de.holomekc.bshb;

import javax.ws.rs.core.Response;

/**
 * @author Christopher Holomek
 * @since 12.01.2020
 */
public class BshbResponse {

    private final Response response;

    public BshbResponse(final Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return this.response;
    }
}
