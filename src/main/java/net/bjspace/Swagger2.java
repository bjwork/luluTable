package net.bjspace;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @brief    : 
 * @author   : BJ
 * @Date     : 2019年6月15日
 * @Package  : net.bjspace
 * @file     : Swagger2.java
 * @note     : 
 */
@Configuration
public class Swagger2 {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("net.bjspace.controller"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("springboot利用swagger构建api文档")
				.description("lululu")
				.termsOfServiceUrl("http://666.bjspace.net")
				.version("1.0")
				.build();
	}
	
}
