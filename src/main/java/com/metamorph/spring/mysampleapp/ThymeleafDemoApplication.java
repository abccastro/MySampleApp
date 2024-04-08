/**
 * SpringBootApplication: combines several annotations to simplify configuration and bootstrap
 * 		process of application (@Configuration, @ComponentScan, @EnableAutoConfiguration)
 */
package com.metamorph.spring.mysampleapp;

import com.metamorph.spring.mysampleapp.dao.AppDAO;
import com.metamorph.spring.mysampleapp.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = {"com.metamorph.spring", "com.metamorph.util"})
@SpringBootApplication
public class ThymeleafDemoApplication {

	public static void main(String[] args) {
		// bootstrap the Spring boot application
		SpringApplication.run(ThymeleafDemoApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}*/

	private void createStudent(AppDAO studentDAO) {

		System.out.println("Creating new student object");
		Student tempStudent = new Student("Aura", "Dee", "auradee@metamorph.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("Student student. Generated ID: " + tempStudent.getId());
	}

	private void readStudent(AppDAO studentDAO) {
		System.out.println("Reading student object");
		Student tempStudent = studentDAO.findById(1);

		System.out.println("Found the student: " + tempStudent);
	}

}
