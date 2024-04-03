/**
 * Controller: mark Java class as a web application controller, which acts as entry points
 *      for handling incoming HTTP requests in the application
 */
package com.metamorph.spring.mysampleapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @Value("${app.name}")
    private String appName;

    // expose "/" that return "Hello World"
    @GetMapping("/hello")
    public String sayHello(Model theModel) {
        theModel.addAttribute("theDate", java.time.LocalDateTime.now());
        return "helloworld";
    }

    @GetMapping("/appName")
    public String sayName(){
        return "Application Name: " + appName;
    }
}
