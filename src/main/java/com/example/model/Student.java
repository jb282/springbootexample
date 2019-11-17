package com.example.model;
import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String passportNumber;
}