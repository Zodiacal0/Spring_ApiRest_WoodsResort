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
import com.lte.woods_resort.utils.PasswordEncrypt;

@RestController
@RequestMapping("wdr/v1/User")
public class UserController implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService iUserService;

    @GetMapping("/list-user")
    public List<Users> listUsers() {
        var users = iUserService.listUsers();
        users.forEach(user -> logger.info(user.toString()));
        return users;
    }

    @PostMapping("add-user")
    public Users addUsers(@RequestBody Users users) {
        
        // Cifrar la contraseña antes de guardar
        String encryptedPassword = PasswordEncrypt.encryptPassword(users.getPassword());
        users.setPassword(encryptedPassword);

        logger.info("Usuario agregado: {}", users.getUserName());
        return iUserService.saveUsers(users);
    }

    @GetMapping("/choose-users/{email}")
    public ResponseEntity<Users> chooseUser(@PathVariable("email") String email) {
        Users user = iUserService.chooseUsers(email);
        if (user == null) {
            throw new UserException("No se encontró el usuario");
        }
        return ResponseEntity.ok(user);
    }

    @PutMapping("/edit-users/{email}")
    public ResponseEntity<Users> editUser(@PathVariable("email") String email, @RequestBody Users editUsers) {
        Users user = iUserService.chooseUsers(email);
        if (user == null) {
            throw new UserException("El id no existe");
        }

        user.setPhone(editUsers.getPhone());
        user.setName(editUsers.getName());
        user.setLastName(editUsers.getLastName());
        user.setEmail(editUsers.getEmail());
        user.setUserName(editUsers.getUserName());

        // Cifrar la nueva contraseña solo si se está cambiando
        if (editUsers.getPassword() != null && !editUsers.getPassword().isEmpty()) {
            String encryptedPassword = PasswordEncrypt.encryptPassword(editUsers.getPassword());
            user.setPassword(encryptedPassword);
        }

        iUserService.saveUsers(user);
        return ResponseEntity.ok(user);
    }
}
