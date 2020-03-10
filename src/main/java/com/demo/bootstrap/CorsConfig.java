package com.demo.bootstrap;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class CorsConfig implements RepositoryRestConfigurer
{
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.getCorsRegistry()
		.addMapping("/**")
		.allowedOrigins("http://localhost:8080")
		.allowedMethods("PUT", "DELETE","GET","POST");
	}
}
