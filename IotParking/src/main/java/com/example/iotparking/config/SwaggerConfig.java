package com.example.iotparking.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI swagger() {
        return new OpenAPI().info(
                new Info()
                        .title("IoT 주차 현황")
                        .description("주차 현황에 사용되는 API")
                        .version("0.0.1")
        );
    }
}
