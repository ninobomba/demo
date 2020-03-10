package com.demo.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer
{

	@Override
	public void addCorsMappings(CorsRegistry registry)
	{
		registry.addMapping("/**").allowedOrigins("**").allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH");
	}

	//	@Bean
	//	public WebMvcConfigurer corsConfigurer() {
	//		return new WebMvcConfigurer() {
	//			@Override
	//			public void addCorsMappings(CorsRegistry registry) {
	//				registry
	//				.addMapping("/**")
	//				.allowedOrigins("**")
	//				.allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH");
	//			}
	//		};
	//	}
}