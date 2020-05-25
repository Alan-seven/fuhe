package com.jsite.szy.dispatch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@ComponentScan(basePackages= {"com.jsite.szy.dispatch.formal"})
@EnableWebMvc
public class SwaggerConfig {

	 	@Bean
	    public Docket createRestApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	        		 .select()
	                 .apis(RequestHandlerSelectors.any())
	                 .build()
	                 .apiInfo(apiInfo());
	                /*.apiInfo(apiInfo())
	                .select()
	                .apis(RequestHandlerSelectors.any())  //显示所有类
	                //.apis(RequestHandlerSelectors.basePackage("com.spring.learn.controller"))
	                .paths(PathSelectors.any())
	                .build();*/
	    }
	 
	    private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("常规调度接口API 文档")               //大标题 title
	                .description("HTTP对外开放接口")             //小标题
	                .version("V1.0.0")                           //版本
	                .termsOfServiceUrl("http://localhost:8080/jsite-szy-dispatch/")    //终端服务程序
	                .license("LICENSE")                         //链接显示文字
	                .licenseUrl("http://localhost:8080/jsite-szy-dispatch/")           //网站链接
	                .build();
	    }
}