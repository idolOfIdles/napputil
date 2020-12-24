package napputils.no.assignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.function.Predicate;

@Configuration
public class SwaggerConfiguration {

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Oompa loompas crew management system")
                .description("Api documentation for Oompa Loompas crew management system")
                .license("Apache 2.0")
                .version("1.0.0")
                .build();
    }


    @Bean
     Docket api() {
         return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicate.not(PathSelectors.regex("/error")))
                .build()
                .apiInfo(apiInfo());


    }

}
