package com.taskmanager.boardservice.configuration;


import com.taskmanager.boardservice.configuration.security.SecurityConfiguration;
import org.springframework.context.annotation.Import;

@org.springframework.context.annotation.Configuration
@Import({
        SecurityConfiguration.class
})
public class Configuration {

}
