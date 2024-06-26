package com.metamorph.spring.mysampleapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String showHome() {
//        return "home";
        return "redirect:/students/list";
    }

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "login";
    }

    @GetMapping("/accessDenied")
    public String showAccessDenied() {
        return "access-denied";
    }

}
