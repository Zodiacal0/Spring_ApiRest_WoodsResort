package com.lte.woods_resort.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lte.woods_resort.services.IUserService;
import com.lte.woods_resort.utils.PasswordEncrypt;
import com.lte.woods_resort.models.Users;

import jakarta.validation.Valid;

@RestController
@RequestMapping("wdr/v1/User")
public class AuthUserController {

    private static final Logger logger = LoggerFactory.getLogger(AuthUserController.class);

    @Autowired
    private IUserService iUserService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@Valid @RequestBody Users user, BindingResult result) {

        Map<String, Object> res = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
            res.put("Errores", errors);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        try {
            Users existingUser = iUserService.login(user.getUserName());
            if (existingUser == null) {
                res.put("message", "User not found");
                return new ResponseEntity<>(res, HttpStatus.UNAUTHORIZED);
            }

            // Log para verificar usuario
            logger.info("user entered: {}", user.getUserName());
            logger.info("user in DB: {}", existingUser.getUserName());
            // Log para verificar la contraseña
            logger.info("Password entered: {}", user.getPassword());
            logger.info("Password in DB: {}", existingUser.getPassword());

            // Verifica la contraseña
            boolean isPasswordValid = PasswordEncrypt.verifyPassword(user.getPassword(), existingUser.getPassword());
            if (!isPasswordValid) {
                res.put("message", "User or password is wrong");
                return new ResponseEntity<>(res, HttpStatus.UNAUTHORIZED);
            }

            res.put("Message", "Welcome " + existingUser.getUserName());
            res.put("Usuario", existingUser);
            return new ResponseEntity<>(res, HttpStatus.OK); 
        } catch (DataAccessException e) {
            logger.error("Error al conectar a la base de datos", e);
            res.put("Mensaje", "Error al conectar a la base de datos");
            res.put("Error", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.SERVICE_UNAVAILABLE);
        } catch (Exception e) {
            logger.error("Error inesperado", e);
            res.put("Mensaje", "Error inesperado");
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
