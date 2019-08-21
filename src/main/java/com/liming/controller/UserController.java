package com.liming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping({"/user/info"})
    public String setInfo(){
        return "thymeleaf/user/info";
    }

    @RequestMapping({"/user/password"})
    public String setPassword(){
        return "thymeleaf/user/password";
    }

}
