package org.javatigers.jersey.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.javatigers.jersey.providers.ApplicationRequestFilter;
import org.javatigers.jersey.providers.ApplicationResponseFilter;
import org.javatigers.jersey.providers.JsonHandler;
import org.javatigers.jersey.ws.DemoService;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@ApplicationPath("/demo")
public class ApplicationConfig extends ResourceConfig {

	public ApplicationConfig() {
		register(ApplicationRequestFilter.class);
		register(ApplicationResponseFilter.class);
		register(JsonHandler.class);
		register(DemoService.class);
		register(ApiListingResource.class);
		register(SwaggerSerializers.class);

		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.2");
		beanConfig.setSchemes(new String[] { "http" });
		beanConfig.setHost("localhost:18080");
		beanConfig.setBasePath("/demo");
		beanConfig.setResourcePackage("org.javatigers.jersey.ws");
		beanConfig.setScan(true);
	}

}
