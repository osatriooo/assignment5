package com.enigma.controllers;


import com.enigma.entities.Users;
import com.enigma.services.UserServices;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping("/user")
    public Users save(@RequestBody Users user){
        return userServices.save(user);
    }
    @GetMapping("/user/{userId}")
    public Users getUserById(@PathVariable String userId){
        return userServices.getUserById(userId);
    }
    @GetMapping("users")
    public List<Users> getAllUsers(){
        return userServices.getAllUser();
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUserById(@PathVariable String userId){
        userServices.deleteUserById(userId);
    }




}
