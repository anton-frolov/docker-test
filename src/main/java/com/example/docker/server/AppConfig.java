package com.example.docker.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.docker.server"})
public class AppConfig {

    @Bean
    AppContextListener appContextEvents(){
        return new AppContextListener();
    }
}
