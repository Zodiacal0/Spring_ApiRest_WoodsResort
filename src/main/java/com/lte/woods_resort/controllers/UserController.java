package com.lte.woods_resort.controllers;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lte.woods_resort.models.Users;
import com.lte.woods_resort.services.IUserService;
import com.lte.woods_resort.services.UserService;

@RestController
@RequestMapping("wdr/v1/User")
public class UserController implements Serializable {
    private static final Logger logger = 
        LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

     @GetMapping("/list-user")
    public List<Users> listUsers(){
        var user = 
            IUserService.listUsers();
        user.forEach((user2 -> logger.info(user.toString())));
        return user;
    }
}
