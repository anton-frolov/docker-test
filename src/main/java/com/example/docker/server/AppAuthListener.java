package com.example.docker.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class AppAuthListener  {

    private static final Logger logger = LoggerFactory.getLogger(AppAuthListener.class);

    @EventListener
    public void onApplicationEvent(AbstractAuthenticationEvent event) {

        final StringBuilder builder = new StringBuilder();
        builder.append("=== Authentication event ");
        builder.append(event.getClass().getSimpleName());
        builder.append(": ");
        builder.append(event.getAuthentication().getName());
        builder.append("; details: ");
        builder.append(event.getAuthentication().getDetails());
        if (event instanceof AbstractAuthenticationFailureEvent) {
            builder.append("; exception: ");
            builder.append(((AbstractAuthenticationFailureEvent) event).getException().getMessage());
        }
        logger.error(builder.toString()+" ====");
        String ip = "";
        if(event.getAuthentication().getDetails() instanceof WebAuthenticationDetails){
            ip = ((WebAuthenticationDetails) event.getAuthentication().getDetails()).getRemoteAddress();
        }
    }
}
