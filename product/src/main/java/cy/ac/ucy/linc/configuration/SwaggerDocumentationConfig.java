package cy.ac.ucy.linc.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@EnableAutoConfiguration
public class SwaggerDocumentationConfig {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("CloudCom2018 Tutorial Products API")
                .description("This is the API of the CloudCom 2018 Tutorial  Products microservice.")
                .contact(new Contact("Thanasis Tryfonos","http://linc.ucy.ac.cy", "a.tryfonos@cs.ucy.ac.cy"))
                .build();
    }

    @Bean
    public Docket api(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cy.ac.ucy.linc"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                ;

        return docket;
    }


}
