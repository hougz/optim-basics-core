package com.hgz.optim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hgz.optim.controller"))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(securityScheme()))
                .apiInfo(new ApiInfoBuilder()
                        .description("认证服务接口管理")
                        .title("认证服务接口文档")
                        .contact(new Contact("hgz","https://hougz.github.io/","hgz@163.com"))
                        .version("v1.0")
                        .license("Apache2.0")
                        .build());
    }

    private AuthorizationScope[] scopes() {
        return new AuthorizationScope[]{
                new AuthorizationScope("ROLE_API", "ROLE_API scope")
        };
    }

    private SecurityScheme securityScheme() {
        GrantType grant = new ResourceOwnerPasswordCredentialsGrant("http://localhost:8090/oauth/token");
        return new OAuthBuilder().name("Authorization")
                .grantTypes(Arrays.asList(grant))
                .scopes(Arrays.asList(scopes()))
                .build();
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(Arrays.asList(new SecurityReference("Authorization", scopes())))
                .forPaths(PathSelectors.any())
                .build();
    }

}
