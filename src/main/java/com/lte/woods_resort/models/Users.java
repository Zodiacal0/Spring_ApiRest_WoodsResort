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
        private String iduser;

    @Email(messag="Please enter an Email")
    @column(unique = true, name="email")
    private String email;

    @Column(unique = true)
    private String userName; 
        
    private String name;
    
    @Column(name="last_name")
    private String lastName;

    private String phone;

    @Column(name="user_type")
    private TypeOfUsers typeUsers;







}
