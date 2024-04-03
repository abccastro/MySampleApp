package com.metamorph.spring.mysampleapp.controller;

import com.metamorph.spring.mysampleapp.entity.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${sex}")
    private List<String> sexes;

    @Value("${banks}")
    private List<String> banks;

    @GetMapping("/showStudentForm")
    public String showStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("countries", countries);
        model.addAttribute("sexes", sexes);
        model.addAttribute("banks", banks);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@Valid @ModelAttribute("student") Student student,
                                     BindingResult bindingResult,
                                     Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("countries", countries);
            model.addAttribute("sexes", sexes);
            model.addAttribute("banks", banks);

            return "student-form";
        }
        return "student-confirmation";
    }

}
