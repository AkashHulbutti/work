/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akashspringcrud.userCrud.services;

import com.akashspringcrud.userCrud.models.Department;
import com.akashspringcrud.userCrud.repositories.DepartmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Akash
 */
@Service
public class DepartmentService {
    @Autowired DepartmentRepository departmentRepository;
    
    public List getAllDepartments(){
       return departmentRepository.findAll();
    }
    
    public Department findById(int id){
        Department dept=departmentRepository.findById(id);
        if(dept==null)
            dept = departmentRepository.findById(5);
        
        return dept;
    }
}
