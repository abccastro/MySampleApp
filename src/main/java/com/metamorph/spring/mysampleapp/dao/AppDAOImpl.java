/**
 * Repository: specialized annotation for repository; translates JDBC exceptions
 * Transactional: indicates that the method should be executed within a database transaction
 *      > transaction committed: SUCCESS
 *      > transaction rolled back: EXCEPTION
 */
package com.metamorph.spring.mysampleapp.dao;

import com.metamorph.spring.mysampleapp.entity.Course;
import com.metamorph.spring.mysampleapp.entity.Instructor;
import com.metamorph.spring.mysampleapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Deprecated
@Repository
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
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

    // Use JOIN FETCH to simulate EAGER fetch type of the data
    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i JOIN FETCH i.courses where i.id = :id", Instructor.class);
        query.setParameter("id", id);

        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    // delete the instructor but not the associated courses
    @Override
    public void deleteInstructorById(int id) {

        Instructor instructor = entityManager.find(Instructor.class, id);

        // break association of all the courses for the instructor
        List<Course> courses = instructor.getCourses();
        for(Course course: courses) {
            instructor.setCourses(null);
        }

        entityManager.remove(instructor);
    }

}
