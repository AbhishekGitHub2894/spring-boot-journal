package com.apress.spring.controllers;

import com.apress.spring.domain.User;
import com.apress.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserRepository userRepository;

//    @GetMapping(value = "/{email}")
//    public User getUser(@PathVariable("email") String email){
//        userRepository.findUserByEmail(email)
//                .orElseThrow(() -> new ResourceNotFoundException("No User found with name="+email));
//
//    }



    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") BigInteger id)
    {

        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No user found with id="+id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public User createUser(@RequestBody User user){

        return userRepository.save(user);

    }

    @PutMapping("/{id}")
    public User updatePost(@PathVariable("id") BigInteger id, @RequestBody User user){
        userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found " + id));
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") BigInteger id){
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User not found: " + id));
        userRepository.deleteById(id);
    }



}
