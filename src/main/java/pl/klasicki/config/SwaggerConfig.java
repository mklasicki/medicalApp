package pl.klasicki.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import pl.klasicki.services.DoctorService;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {

        Contact contact = new Contact("Marcin Klasicki", "https://www.klasicki.pl", "klasicki.m@gmail.com");

       return new ApiInfo(
               "Medical App API",
               "This is a demo of REST API",
               "1.0",
               "",
               contact,
               "Apache License Version 2.0",
               "https://www.apache.org/licenses/LICENSE-2.0",
               new ArrayList<>());

    }


}
