package br.com.boletojuros.application;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info().
                        title("Api de boletos")
                        .description("Api para calcular juros de boletos vencidos")
                        .contact(new Contact().name("odevpedro").email("someemail@gmail.com"))
                        .version("1.0.0"));
    }
}
