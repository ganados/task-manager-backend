package com.taskmanager.boardservice.configuration;


import com.taskmanager.boardservice.configuration.feign.FeignClientConfiguration;
import com.taskmanager.boardservice.configuration.openapi.OpenApiConfiguration;
import com.taskmanager.boardservice.configuration.security.CorsConfiguration;
import com.taskmanager.boardservice.configuration.security.SecurityConfiguration;
import org.springframework.context.annotation.Import;

@org.springframework.context.annotation.Configuration
@Import({
        SecurityConfiguration.class,
        CorsConfiguration.class,
        OpenApiConfiguration.class,
        FeignClientConfiguration.class
})
public class Configuration {

}
