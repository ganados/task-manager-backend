package com.taskmanager.taskservice.configuration;


import com.taskmanager.taskservice.configuration.security.SecurityConfiguration;
import org.springframework.context.annotation.Import;

@org.springframework.context.annotation.Configuration
@Import({
        SecurityConfiguration.class
})
public class Configuration {

}
