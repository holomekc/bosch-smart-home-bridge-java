package de.holomekc.bshb.client;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.ws.rs.core.GenericType;
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

    /**
     * Read entity by class
     *
     * @param tClass
     *         class of entity
     * @param <T>
     *         type of entity
     *
     * @return instance of entity
     */
    public <T> T readEntity(final Class<T> tClass) {
        return this.getResponse().readEntity(tClass);
    }

    /**
     * Read entity as list.
     *
     * @param tClass
     *         class of list entries
     * @param <T>
     *         entry type
     *
     * @return a list of the specified entry type
     */
    public <T> List<T> readList(final Class<T> tClass) {
        return this.getResponse().readEntity(new GenericType<>(new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[] { tClass };
            }

            @Override
            public Type getRawType() {
                return List.class;
            }

            @Override
            public Type getOwnerType() {
                return List.class;
            }
        }));
    }

}
