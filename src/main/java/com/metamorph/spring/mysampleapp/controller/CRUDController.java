/**
 * Autowired: inject dependencies into a Spring bean, facilitating the wiring of
 *      components within an application (optional if only one constructor)
 *  * RestController: define a class as RESTful web service controller; each method in class
 *  *      returns a domain object rather than a view
 *  * GetMapping: map HTTP GET requests to a specific method in a controller
 */
/*

package com.metamorph.spring.mysampleapp.controller;

import com.metamorph.spring.mysampleapp.dao.StudentDAO;
import com.metamorph.spring.mysampleapp.entity.Student;
import com.metamorph.spring.mysampleapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api")
public class CRUDController {

    private StudentService studentService;

    @Autowired
    public CRUDController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        Student student = studentService.findById(studentId);
        return student;
    }

    @GetMapping("/students")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    // NOTE: CSRF error when saving, updating and deleting record

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        // set ID to 0 to force a save of new student (instead of update)
        student.setId(0);
        Student dbStudent = studentService.save(student);
        return dbStudent;
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        Student dbStudent = studentService.save(student);
        return dbStudent;
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {
        Student student = studentService.findById(studentId);
        if(student == null) {
            throw new StudentNotFoundException("Student ID not found - " + studentId);
        }
        studentService.deleteById(studentId);
        return "Deleted employee ID - " + studentId;
    }

}
*/
