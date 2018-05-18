package com.example.docker.server.dispatch;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecuredPingController {

    @RequestMapping(value = "/secured/ping")
    @ResponseBody
    public String securedPing() {
        return "Authenticated!";
    }
}
