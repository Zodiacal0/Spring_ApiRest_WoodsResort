package com.lte.woods_resort.controllers;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lte.woods_resort.exceptions.UserException;
import com.lte.woods_resort.models.Users;
import com.lte.woods_resort.services.IUserService;

@RestController
@RequestMapping("wdr/v1/User")
public class UserController implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService iUserService;

     @GetMapping("/list-user")
    public List<Users> listUsers(){
        var user = iUserService.listUsers();
        user.forEach((user2 -> logger.info(user.toString())));
        return user;
    }

    @PostMapping("add-user")
    public Users addUsers(@RequestBody Users users) {
        logger.info("Usuario agregado");
        return iUserService.saveUsers(users);
    }

    @GetMapping("/choose-users/{id}")
    public ResponseEntity<Users> chooseUser(@PathVariable String iduser){
        Users users = iUserService.chooseUsers(iduser);
        if(users == null)
            throw new UserException("no se encontro el usuario");
        return ResponseEntity.ok(users);
    }

    @PutMapping("/edit-users/{id}")
    public ResponseEntity<Users> editUser(@PathVariable String iduser, @RequestBody Users editUsers) {
        Users users = iUserService.chooseUsers(iduser);
        if (users == null)
            throw new UserException("El id no existe");
            users.setPhone(editUsers.getPhone());
            users.setName(editUsers.getName());
            users.setLastName(editUsers.getLastName());
            users.setEmail(editUsers.getEmail());
            users.setUserName(editUsers.getUserName());
            users.setPassword(editUsers.getPassword());
        iUserService.saveUsers(users);
        return ResponseEntity.ok(users);
    }
    
}
