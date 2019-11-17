package com.example.repository;
import com.example.model.Person;
import org.springframework.data.repository.CrudRepository;


public interface PersonRepository extends CrudRepository<Person, Integer> {}
