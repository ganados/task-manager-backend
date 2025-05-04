package com.taskmanager.userservice.configuration;


import com.taskmanager.userservice.configuration.security.SecurityConfiguration;
import org.springframework.context.annotation.Import;

@org.springframework.context.annotation.Configuration
@Import({
        SecurityConfiguration.class
})
public class Configuration {

}
