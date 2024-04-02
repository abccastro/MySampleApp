/**
 * Service: marks the class as service provider
 */
package com.metamorph.spring.mysampleapp.service;

import com.metamorph.spring.mysampleapp.controller.StudentNotFoundException;
import com.metamorph.spring.mysampleapp.dao.StudentRepository;
import com.metamorph.spring.mysampleapp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Deprecated
@Service
public class StudentServiceImpl implements StudentService{

//    private StudentDAO studentDAO;
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        Optional<Student> result = studentRepository.findById(id);
        Student student = null;
        if(result.isPresent()) {
            student = result.get();
        } else {
            throw new StudentNotFoundException("Student ID not found - " + id);
        }
        return student;
    }

    @Override
//    @Transactional    // can be removed since methods are provided by spring data jpa
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
//    @Transactional
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

/*    @Override
//    @Transactional
    public void update(Student student) {
        studentDAO.update(student);
    }*/
}
