package com.lte.woods_resort.DTOs;

import com.lte.woods_resort.utils.TypeOfUsers;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthUser {

    private String iduser;

    @NotBlank(message = "This field is required")
    @Email(message = "Enter a valid email address")
    private String email;

    @NotBlank(message = "The password is required")
    private String password;

    @NotBlank(message = "The user name is required")
    private String userName;

    private String name;
    private String lastName;
    private String phone;
    private TypeOfUsers typeUsers;

}
