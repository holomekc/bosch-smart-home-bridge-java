package de.holomekc.bshb.client;

import java.util.TimeZone;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import de.holomekc.bshb.model.BoschClientData;

/**
 * @author Christopher Holomek
 * @since 12.01.2020
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ObjectMapperProvider implements ContextResolver<ObjectMapper> {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        // configure OBJECT_MAPPER
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE);
        OBJECT_MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        OBJECT_MAPPER.setTimeZone(TimeZone.getDefault());
        OBJECT_MAPPER.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
        OBJECT_MAPPER.registerSubtypes(BoschClientData.class);
    }

    @Override
    public ObjectMapper getContext(final Class<?> type) {
        return OBJECT_MAPPER;
    }
}
