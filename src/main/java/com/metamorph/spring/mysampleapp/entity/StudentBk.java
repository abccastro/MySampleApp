package com.metamorph.spring.mysampleapp.entity;

import com.metamorph.spring.mysampleapp.validation.BankCode;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Table(name="student")
public class StudentBk {

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

    @NotNull(message = "is required")
    private String country;

    @NotNull(message = "is required")
    private String sex;

    @NotNull(message = "is required")
    @Min(value=18, message="must be greater than or equal to 18")
    @Max(value=65, message="must be less than or equal to 65")
    private Integer age;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 characters / digits")
    private String postalCode;

    private List<String> banks;

    @BankCode(value="ABC", message="must start with ABC")
    private String bankCode;

    public StudentBk(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public StudentBk() {
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<String> getBanks() {
        return banks;
    }

    public void setBanks(List<String> banks) {
        this.banks = banks;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", sex='" + sex + '\'' +
                ", banks='" + banks + '\'' +
                '}';
    }
}
