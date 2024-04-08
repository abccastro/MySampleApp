package com.metamorph.spring.mysampleapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    @Column(name="first_name")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    @Column(name="last_name")
    private String lastName;

    @NotNull(message = "is required")
    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "instructor",     // reference to 'instructor' property in Course class
                fetch = FetchType.LAZY,     // override fetch type (LAZY or EAGER) [NOTE:Use JOIN FETCH]
                cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Course> courses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // for bi-directional relationship
    public void add(Course tempCouse) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(tempCouse);
        tempCouse.setInstructor(this);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", courses='" + courses + '\'' +
                '}';
    }
}
