package com.metamorph.spring.mysampleapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
public class FunRestController {

    @Value("${app.name}")
    private String appName;

    // expose "/" that return "Hello World"
    @GetMapping("/hello")
    public String sayHello(Model theModel){
        theModel.addAttribute("theDate", java.time.LocalDateTime.now());
        return "helloworld";
    }

    @GetMapping("/appName")
    public String sayName(){
        return "Application Name: " + appName;
    }
}
