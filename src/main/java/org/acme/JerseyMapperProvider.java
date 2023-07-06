package org.acme;

import org.jboss.logging.Logger;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;

//import javax.ws.rs.ext.ContextResolver;
//import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jakarta.xmlbind.JakartaXmlBindAnnotationModule;
//import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;

/**
 * Provides the {@link ObjectMapper} to use to serialize to json
 */
@Provider
public class JerseyMapperProvider implements ContextResolver<ObjectMapper> {

	private static ObjectMapper mapper = new ObjectMapper();
	private static final Logger LOG = Logger.getLogger(JerseyMapperProvider.class);

	static {
//		mapper.registerModule(new JaxbAnnotationModule());
		mapper.registerModule(new JakartaXmlBindAnnotationModule());
		mapper.findAndRegisterModules();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, true);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
		mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
		
		LOG.info(mapper.getRegisteredModuleIds());
	}

	@Override
	public ObjectMapper getContext(Class<?> type) {
		return mapper;
	}
}