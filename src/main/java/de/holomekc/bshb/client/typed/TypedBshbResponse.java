package de.holomekc.bshb.client.typed;

import javax.ws.rs.core.Response;

import org.apache.commons.lang3.builder.ToStringBuilder;

import de.holomekc.bshb.client.BshbResponse;

/**
 * @author Christopher Holomek
 * @since 18.01.2020
 */
public class TypedBshbResponse<T> {

    private final BshbResponse bshbResponse;
    private final T data;

    public TypedBshbResponse(final BshbResponse bshbResponse, final T data) {
        this.bshbResponse = bshbResponse;
        this.data = data;
    }

    public Response getResponse() {
        return this.bshbResponse.getResponse();
    }

    public T getData() {
        return this.data;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("data", this.data).toString();
    }
}
