package com.metamorph.spring.mysampleapp.service;

import com.metamorph.spring.mysampleapp.entity.Student;

import java.util.List;
import java.util.Optional;

@Deprecated
public interface StudentService {

    List<Student> findAll();

    Student findById(int id);

    Student save(Student student);

    void deleteById(int id);

//    void update(Student student);
}
