package com.example.experiment08_2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Owem
 * @date 2023/2/20 16:09
 * @description Swagger3 配置, 地址: http://localhost:9090/swagger-ui/
 **/
@Configuration  // 告诉 Spring 容器, 这个类是一个配置类
@EnableOpenApi  // 启用 Swagger3 功能
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // cn 包下所有 API 都交给 Swagger2 管理
                .apis(RequestHandlerSelectors.basePackage("com"))
                .paths(PathSelectors.any()).build();
    }

    // API 文档页面显示信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Experiment08_2 Project API")
                .description("")
                .version("1.0")
                .build();
    }
}