package com.example.docker.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AppContextListener {


    @EventListener
    public void onContextRefreshedEvent(ContextRefreshedEvent event){
    }
}
