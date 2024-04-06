package com.metamorph.spring.mysampleapp.controller;

import com.metamorph.spring.mysampleapp.entity.Student;
import com.metamorph.spring.mysampleapp.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Value("${countries}")
    private List<String> countries;

    @Value("${sex}")
    private List<String> sexes;

    @Value("${banks}")
    private List<String> banks;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String listStudents(Model model) {
        // get students from DB
        List<Student> studentList = studentService.findAll();

        // add to spring model
        model.addAttribute("students", studentList);
        return "students/list-students";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "students/student-form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        // save the student
        studentService.save(student);

        // use redirect to prevent duplicate submissions
        return "redirect:/students/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int studentId, Model model) {
        // get student from the service
        Student student = studentService.findById(studentId);

        // set employee in model to prepopulate the form
        model.addAttribute("student", student);

        // send over to the form
        return "students/student-form";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("studentId") int studentId) {
        // delete the student
        studentService.deleteById(studentId);

        // use redirect to prevent duplicate submissions
        return "redirect:/students/list";
    }

/*    @GetMapping("/showStudentForm")
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
    }*/

}
