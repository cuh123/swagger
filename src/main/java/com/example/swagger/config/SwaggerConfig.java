package com.example.swagger.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.apiInfo(getApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com"))
				.paths(PathSelectors.any())
				.build();
	}


	private ArrayList<ResponseMessage> getArrayList() {
		ArrayList<ResponseMessage> lists = new ArrayList<ResponseMessage>();
		lists.add(new ResponseMessageBuilder().code(500).message("500Error").build());
		lists.add(new ResponseMessageBuilder().code(403).message("403Error").build());
		lists.add(new ResponseMessageBuilder().code(401).message("401rror").build());
		return lists;
	}


	public ApiInfo getApiInfo() {
		return new ApiInfo(
				"Service REST API Documentation",
				"REST Api Documentation",
				"1.0",
				"localhost:8080",
				new Contact("unhak","https://velog.io/@unknown89","chldnsgkr7@gmail.com"),
				"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
				new ArrayList<VendorExtension>());
	}

}
