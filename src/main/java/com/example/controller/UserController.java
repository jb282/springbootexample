package com.example.controller;


import com.example.model.Role;
import com.example.model.User;
import com.example.model.UserToDo;
import com.example.repository.UserRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepo userRepo;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    @RequestMapping(method = RequestMethod.POST, value = "/newUser")
    private ResponseEntity newUser(@RequestBody UserToDo newUser) {

        Iterable<User> allUsers = userRepo.findAll();

        if (newUser.getUsername().matches("[\\w- ]+") && newUser.getUsername().length() >= 5) {
            if (newUser.getPassword().equals(newUser.getPassword2()) && newUser.getPassword().length() >= 5) {
                User user = new User();
                user.setUsername(newUser.getUsername());
                user.setPassword(passwordEncoder.encode(newUser.getPassword()));
                if (allUsers.iterator().hasNext()) {
                    user.setRole(Role.USER);
                } else {
                    user.setRole(Role.ADMIN);
                }
                user.setEnabled(true);
                userRepo.save(user);
            } else {
                return ResponseEntity.badRequest().body(1);
            }
        } else {
            return ResponseEntity.badRequest().body(2);
        }
        return ResponseEntity.ok().body(null);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAllUsers")
    private ResponseEntity getAllUsers() {
        Iterable<User> allUsers = userRepo.findAll();
        return ResponseEntity.ok().body(allUsers);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/delUser/{id}")
    private ResponseEntity delUser(@PathVariable long id) {
        userRepo.deleteById(id);
        return ResponseEntity.ok().body(null);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/changeStatus/{id}")
    private ResponseEntity changeStatus(@PathVariable long id) {

        Optional<User> currentUser = userRepo.findById(id);
        User user;

        if (currentUser.isPresent()) {
            user = currentUser.orElse(null);
            if (user.isEnabled()) {
                user.setEnabled(false);
                userRepo.save(user);
            } else {
                user.setEnabled(true);
                userRepo.save(user);
            }
        }
        return ResponseEntity.ok().body(null);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/changeRole/{id}")
    private ResponseEntity changeRole(@PathVariable long id) {

        Optional<User> currentUser = userRepo.findById(id);
        User user;

        if (currentUser.isPresent()) {
            user = currentUser.orElse(null);
            if (user.getRole().equals(Role.USER)) {
                user.setRole(Role.ADMIN);
                userRepo.save(user);
            } else {
                user.setRole(Role.USER);
                userRepo.save(user);
            }
        }
        return ResponseEntity.ok().body(null);
    }
}