package com.example.repository;


import com.example.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    // findByUsername method for Spring Boot Security
    User findByUsername(String username);
    User findById(int id);

}