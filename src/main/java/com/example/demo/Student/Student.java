package com.example.demo.Student;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.time.LocalDate;

@Document
public class Student
{
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private Long id;
    private String FirstName;
    private  String LastName;
    private Long Tel;
    private String SchoolName;

    private String Email;
    private LocalDate DateOfBirth;
    private Integer ExpectedGraduatedYear;

    public Student(Long ID) {
        this.id = ID;
    }



    public Student(Long ID, String firstName, String lastName, String schoolName, String email) {
        this.id = ID;
        FirstName = firstName;
        LastName = lastName;
        SchoolName = schoolName;
        Email = email;
    }

    public Student(Long ID, String firstName, String lastName, Long tel, String schoolName, String email, LocalDate dateOfBirth, Integer expectedGraduatedYear) {
        this.id = ID;
        FirstName = firstName;
        LastName = lastName;
        Tel = tel;
        SchoolName = schoolName;
        Email = email;
        DateOfBirth = dateOfBirth;
        ExpectedGraduatedYear = expectedGraduatedYear;
    }

    public Student(String firstName, String lastName, Long tel, String schoolName, String email, LocalDate dateOfBirth, Integer expectedGraduatedYear) {
        FirstName = firstName;
        LastName = lastName;
        Tel = tel;
        SchoolName = schoolName;
        Email = email;
        DateOfBirth = dateOfBirth;
        ExpectedGraduatedYear = expectedGraduatedYear;
    }
    public Student(){

    }

    public Long getID() {
        return id;
    }

    public void setID(Long ID) {
        this.id = ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Long getTel() {
        return Tel;
    }

    public void setTel(Long tel) {
        Tel = tel;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public Integer getExpectedGraduatedYear() {
        return ExpectedGraduatedYear;
    }

    public void setExpectedGraduatedYear(Integer expectedGraduatedYear) {
        ExpectedGraduatedYear = expectedGraduatedYear;
    }
//    public int getAge(){
//        return Period.between(this.DateOfBirth,LocalDate.now()).getYears();
//    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Tel=" + Tel +
                ", SchoolName='" + SchoolName + '\'' +
                ", Email='" + Email + '\'' +
                ", DateOfBirth=" + DateOfBirth +
                ", ExpectedGraduatedYear=" + ExpectedGraduatedYear +
                '}';
    }
}
