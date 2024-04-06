/**
 * RepositoryRestResource[path]: customize the URL path for accessing
 *      the repo data
 */
package com.metamorph.spring.mysampleapp.dao;

import com.metamorph.spring.mysampleapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path="student")
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // NOTE: spring data JPA parse the method name, look for format and pattern,
    // then create appropriate query behind the scene
    public List<Student> findAllByOrderByLastNameAsc();
}
