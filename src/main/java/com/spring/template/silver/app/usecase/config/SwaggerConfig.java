//package com.spring.template.silver.app.usecase.config;
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.method.HandlerMethod;
//import springfox.documentation.RequestHandler;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.*;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Predicate;
//
//@Configuration
//@EnableSwagger2
//@RequiredArgsConstructor
//public class SwaggerConfig {
//
//  private ApiKey apiKey() {
//    return new ApiKey("Bearer", "Authorization", "header");
//  }
//
//  private ApiInfo apiInfo() {
//    return new ApiInfoBuilder()
//        .title("Demo Spring template Service")
//        .description("Demo Spring template Service.")
//        .version("1.0")
//        .termsOfServiceUrl("Terms of service")
//        .contact(new Contact("Silver Neko", "", ""))
//        .license("License of API")
//        .licenseUrl("API license URL")
//        .build();
//  }
//
//  private List<SecurityScheme> securityScheme() {
//    List<SecurityScheme> securitySchemes = new ArrayList<>();
//    securitySchemes.add(apiKey());
//    return securitySchemes;
//  }
//
//  @Bean
//  public Docket api() {
//    return new Docket(DocumentationType.SWAGGER_2)
//        .apiInfo(apiInfo())
//        .securitySchemes(securityScheme())
//        .select()
////        .apis(withPreAuthorizeAnnotation())
//        .paths(PathSelectors.any())
//        .build();
////        .securityContexts(List.of(securityContext()));
//  }
//
////  private SecurityContext securityContext() {
////    return SecurityContext.builder()
////        .securityReferences(List.of(new SecurityReference("Bearer", new AuthorizationScope[0])))
////        .forPaths(PathSelectors.any())
////        .build();
////  }
//
////  private Predicate<RequestHandler> withPreAuthorizeAnnotation() {
////    return input -> {
////      HandlerMethod handlerMethod = (HandlerMethod) input;
////      Method method = handlerMethod.getMethod();
////      return method.isAnnotationPresent(PreAuthorize.class);
////    };
////  }
//
//}