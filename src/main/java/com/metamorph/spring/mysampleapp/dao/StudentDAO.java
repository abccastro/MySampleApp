package com.metamorph.spring.mysampleapp.dao;

import com.metamorph.spring.mysampleapp.entity.Student;

import java.util.List;

@Deprecated
public interface StudentDAO {

    Student save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

//    void update(Student student);

    void deleteById(int id);


}
