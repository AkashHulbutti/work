/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akashspringcrud.userCrud.services;

import com.akashspringcrud.userCrud.models.User;
import com.akashspringcrud.userCrud.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Akash
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List findAllUsers() {
        return userRepository.findAll();
    }
       
    public User findUserById(int userId){
         return userRepository.findById(userId);
    }
    
    public boolean saveUser(User user){
        User user1=userRepository.save(user);
        if (user!=null) {
            return true;
        } else {
            return false;
        }
    }
}
