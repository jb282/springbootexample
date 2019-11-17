package com.example.model;

import javax.persistence.*;
import org.springframework.beans.factory.annotation.Value;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;
    private String emailId;

    //getters and setters

    public Person() {
    }

    public Person(String name, int age, String emailId) {
        this.name = name;
        this.age = age;
        this.emailId = emailId;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}