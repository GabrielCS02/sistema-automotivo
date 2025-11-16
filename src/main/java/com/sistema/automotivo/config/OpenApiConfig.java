package com.sistema.automotivo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Sistema Automotivo - API de Gestão de Veículos")
                        .description("API RESTful para cadastro, consulta e gerenciamento de marcas, modelos e veículos.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Gabriel Costa Silva")
                                .email("gacosil0204@gmail.com")));
    }
}
