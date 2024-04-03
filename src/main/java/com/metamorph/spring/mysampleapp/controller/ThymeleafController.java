/**
 * Controller: mark Java class as a web application controller, which acts as entry points
 *      for handling incoming HTTP requests in the application
 */
package com.metamorph.spring.mysampleapp.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @PostMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    /*@RequestMapping("/processFormVesionTwo")
    public String processFormVersionTwo(HttpServletRequest request, Model model) {
        String theName = request.getParameter("studentName");
        theName = theName.toUpperCase();

        String result = "Yo! " + theName;
        model.addAttribute("message", result);
        model.addAttribute("theDate", java.time.LocalDateTime.now());

        return "helloworld";
    }*/

    @PostMapping("/processFormVesionTwo")
    public String processFormVersionTwo(@RequestParam("studentName") String theName, Model model) {

        String result = "Yo! " + theName.toUpperCase();
        model.addAttribute("message", result);
        model.addAttribute("theDate", java.time.LocalDateTime.now());

        return "helloworld";
    }

}
