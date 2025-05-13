package com.taskmanager.apigateway.configuration;


import com.taskmanager.apigateway.configuration.gateway.GatewayRoutesConfiguration;
import com.taskmanager.apigateway.configuration.security.SecurityConfiguration;
import org.springframework.context.annotation.Import;

@org.springframework.context.annotation.Configuration
@Import({
        SecurityConfiguration.class,
        GatewayRoutesConfiguration.class
})
public class Configuration {

}
