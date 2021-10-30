package wagner.personapi.config;

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

// Simplificando Projetos Java com Spring Boot: Swagger
//-----------------------------------------------------
//
// Esta classe utiliza o Swagger para documentação da API REST desenvolvida neste projeto
//
// Documentar o projeto com Swagger é facil. Bastou criar esta classe e adicionar
// dependências no pom.xml
//
// Para ver o Swagger em execução:
//      1. Execute este projeto PersonapiApplication
//      2. Entre no endereço: http://localhost:8080/swagger-ui.html
//
//

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("wagner.personapi.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(buildApiInfo());
    }

    private ApiInfo buildApiInfo(){
        return new ApiInfoBuilder()
                .title("Api PersonAPI")
                .description("REST API para gerencimento de pessoas")
                .version("1.0.0")
                .contact(new Contact("Wagner Kaba", "https://github.com/wagnerkaba", null))
                .build();

    }
}
