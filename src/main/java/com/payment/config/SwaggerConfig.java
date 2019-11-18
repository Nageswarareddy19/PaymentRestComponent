package com.payment.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket paymentApiInfo() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.payment.controller")).paths(PathSelectors.any()).build()
				.apiInfo(metaDateOfPaymentResource());
	}

	public ApiInfo metaDateOfPaymentResource() {
		Contact contact=new Contact("PaymentGateWayResource", "https://paymentGateWay.com", "paymentInfo@gmail.com");
		List <VendorExtension>  vendorExtensions=new ArrayList<>();
		ApiInfo apiInfo = new ApiInfo("Payment-GateWay", "Payment-GateWay acts as a UPI", "UPI2.0", "www.payment.com",
				contact,
				"Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0",vendorExtensions);
		return apiInfo;
	}

}
