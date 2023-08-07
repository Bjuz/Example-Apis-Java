package com.example.Task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.Task.Controller"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Task Project",
                "Rest API about create tasks",
                "Version: 1.0.0",
                "",
                new Contact("Jeaustin Rodriguez", "https://www.linkedin.com/in/jeaustin-rodr%C3%ADguez-rodriguez", "jeaustin.rdz@gmail.com"),
                "", "", Collections.emptyList());
    }
}
