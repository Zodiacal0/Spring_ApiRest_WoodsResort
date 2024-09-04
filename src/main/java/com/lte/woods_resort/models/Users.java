package com.lte.woods_resort.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@Table(name = "user")
public class Users  implements Serializable{
    @Id
    @Column(name="id_user")
        private String id_user;

    @Email(messag="Please enter an Email")
    @column(unique = true, name="email")
        private String email;

    @Column(unique = true)
        private String username; 
        
        private String name;
        private String lastname;
        private String phone;
        private TypeOfUsers typeUsers;







}
