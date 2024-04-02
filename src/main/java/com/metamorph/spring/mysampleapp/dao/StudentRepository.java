/**
 * RepositoryRestResource[path]: customize the URL path for accessing
 *      the repo data
 */
package com.metamorph.spring.mysampleapp.dao;

import com.metamorph.spring.mysampleapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="student")
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
