/**
 * Repository: specialized annotation for repository; translates JDBC exceptions
 * Transactional: indicates that the method should be executed within a database transaction
 *      > transaction committed: SUCCESS
 *      > transaction rolled back: EXCEPTION
 */
package com.metamorph.spring.mysampleapp.dao;

import com.metamorph.spring.mysampleapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Deprecated
@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Student save(Student student) {
//        entityManager.persist(student);
        Student dbStudent = entityManager.merge(student);
        return dbStudent;
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName = :inputLastName ORDER BY firstName", Student.class);
        theQuery.setParameter("inputLastName", lastName);
        return theQuery.getResultList();
    }

    /*@Override
    public void update(Student student) {
        entityManager.merge((student));
    }*/

    @Override
    public void deleteById(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

}
