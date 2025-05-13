package com.taskmanager.taskservice.configuration;


import com.taskmanager.taskservice.configuration.openapi.OpenApiConfiguration;
import com.taskmanager.taskservice.configuration.security.CorsConfiguration;
import com.taskmanager.taskservice.configuration.security.SecurityConfiguration;
import org.springframework.context.annotation.Import;

@org.springframework.context.annotation.Configuration
@Import({
        SecurityConfiguration.class,
        CorsConfiguration.class,
        OpenApiConfiguration.class,
})
public class Configuration {

}
