package com.enigma.services;


import com.enigma.entities.Users;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserServices {

    public Users save(Users user); //save
    public Users getUserById(String id); // tampilin user dari id
    public List<Users> getAllUser();
    public void deleteUserById(String id);

}
