/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akashspringcrud.userCrud.repositories;

import com.akashspringcrud.userCrud.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Akash
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
    public User findById(@Param("id") int id);
}
