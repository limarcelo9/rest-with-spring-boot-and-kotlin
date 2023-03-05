package br.com.ec.config

import org.springframework.context.annotation.Configuration
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean

@Configuration
class OpenApiConfig {

    @Bean
    fun customOpenApi(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Restful API with Kotlin 1.6.10 and Spring Boot 3.0.0")
                    .version("vi")
                    .description("Some description about your API.")
                    .termsOfService("https://github.com/limarcelo9")
                    .license(
                        License().name("Apache 2.0")
                            .url("https://github.com/limarcelo9")
                    )
            )
    }
}