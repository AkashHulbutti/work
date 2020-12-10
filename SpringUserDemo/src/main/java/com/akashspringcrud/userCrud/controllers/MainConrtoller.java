/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akashspringcrud.userCrud.controllers;

import com.akashspringcrud.userCrud.models.User;
import com.akashspringcrud.userCrud.services.DepartmentService;
import com.akashspringcrud.userCrud.services.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Akash
 */
@Controller
public class MainConrtoller {

    @Autowired
    UserService userService;

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public String returnHomePage(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        System.out.println("Index Page Called");
        return "index";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("formType", "Add User Data");
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/saveUser")
    public String saveUserData(@RequestParam("department") int deptid, @Valid User user, BindingResult result, Model model) {
        user.setDepartment(departmentService.findById(deptid));
        if (userService.saveUser(user)) {
            model.addAttribute("msg", "User " + user.getFirstname() + " " + user.getLastname() + " Added Successully");
        } else {
            model.addAttribute("msg", "Error While Adding " + user.getFirstname() + " " + user.getLastname() + ". Try Again..");
        }
        model.addAttribute("users", userService.findAllUsers());
        return "index";
    }

    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("id") int userid, Model model) {
        User user = userService.findUserById(userid);
        if (user != null) {
            model.addAttribute("formType", "Update User Data");
            model.addAttribute("departments", departmentService.getAllDepartments());
            model.addAttribute("user", user);
            return "updateUser";
        } else {
            model.addAttribute("msg", "User Not Found");
            model.addAttribute("users", userService.findAllUsers());
        }
        return "index";

    }

    @PostMapping("/updateUserData")
    public String updateUserData(@RequestParam("department") int deptid, @Valid User user, BindingResult result, Model model) {
        user.setDepartment(departmentService.findById(deptid));
        System.out.println(" Value deptid: " + deptid);
        if (userService.saveUser(user)) {
            model.addAttribute("msg", "User " + user.getFirstname() + " " + user.getLastname() + " Updated Successully");
        } else {
            model.addAttribute("msg", "Error While Adding " + user.getFirstname() + " " + user.getLastname() + ". Try Again..");
        }
        model.addAttribute("users", userService.findAllUsers());
        return "index";
    }

}
