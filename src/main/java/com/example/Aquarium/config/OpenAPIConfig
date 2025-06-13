package com.example.Aquarium.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Aquarium API",
        version = "1.0",
        description = "API RESTful para gerenciamento de aquários e seus respectivos animais.",
        contact = @Contact(
            name = "Breno",
            email = "breno@email.com"
        ),
        license = @License(name = "MIT License")
    ),
    servers = {
        @Server(url = "http://localhost:8081", description = "Servidor Local")
    }
)
public class OpenAPIConfig {
}
