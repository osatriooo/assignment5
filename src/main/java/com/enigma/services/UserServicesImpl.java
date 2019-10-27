package com.enigma.services;

import com.enigma.entities.Users;
import com.enigma.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    UserRepository userRepository;

    @Override
    public Users save(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users getUserById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<Users> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }
}
