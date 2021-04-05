package com.swaggerimplemenation.swaggerimplemenation.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	/**
	 * A builder which is intended to be the primary interface into the swagger-springmvc framework. Provides sensible defaults and convenience methods for configuration.
	 * <br><br>
	 *  Docket to decide what kind of APIs you would want to document. 
	 *  <br>In this example, we are documenting all APIs. 
	 *  <br>We can filter out APIs you do not want to document with Swagger.
	 *  <br>
	 *  <br> <b>http://localhost:8080/v2/api-docs</b> gives the swagger documentation.
	 *  <br> <b>http://localhost:8080/swagger-ui.html</b> gives Swagger UI in more readable form.
	 * @return
	 */
	@Bean
	public Docket productApi() {
		Set<String> responseProduceType = new HashSet<String>();
		responseProduceType.add("application/json");
		responseProduceType.add("application/xml");
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any())
				.build().useDefaultResponseMessages(false)
				.genericModelSubstitutes(ResponseEntity.class)
				.produces(responseProduceType).consumes(responseProduceType)
				.apiInfo(apiInfo());
	}

	/**
	 * Meta information about the API - Description, Licensing etc. 
	 * <br>This will be exposed as part of the Swagger Documentation.
	 * @return
	 */
	private ApiInfo apiInfo() {
		@SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo("Item REST API", "All Item related information", "API", "Terms of services",
				"PoojaK", "License of API", "API License URL");
		return apiInfo;

	}

	private Object apiKey() {
		// TODO Auto-generated method stub
		return null;
	}
}
