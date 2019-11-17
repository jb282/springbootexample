package com.example.repository;
import com.example.model.Beitrag;
import org.springframework.data.repository.CrudRepository;


public interface BeitragRepository extends CrudRepository<Beitrag, Integer> {}
