package org.javatigers.jersey.providers;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@Provider
public class JsonHandler implements ContextResolver<ObjectMapper>{

	private final ObjectMapper objectMapper;
	
	public JsonHandler() {
		objectMapper = createDefaultMapper();
	}
	
	private static ObjectMapper createDefaultMapper() {
        final ObjectMapper result = new ObjectMapper();
        result.setSerializationInclusion(Include.NON_NULL);
        result.setSerializationInclusion(Include.NON_EMPTY);
        return result;
    }
	
	@Override
	public ObjectMapper getContext(Class<?> type) {
		return objectMapper;
	}

}
