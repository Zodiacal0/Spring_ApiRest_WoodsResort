package com.lte.woods_resort.models;
import java.io.Serializable;
import java.util.List;

import com.lte.woods_resort.DTOs.AuthUser;
import com.lte.woods_resort.utils.PasswordEncrypt;
import com.lte.woods_resort.utils.TypeOfUsers;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@Table(name = "users")
public class Users  implements Serializable{

    @Id
    @Column(name="id_user")
        private String iduser;

    @Email(message ="Please enter an Email")
    @Column(unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(unique = true)
    private String userName; 
        
    private String name;
    
    @Column(name="last_name")
    private String lastName;

    private String phone;

    @Column(name="user_type")
    private TypeOfUsers typeUsers;

    @OneToMany(mappedBy = "user") 
    private List<Events> events;

    public Users(AuthUser userDTO){
        this.email = userDTO.getEmail();
        this.userName = userDTO.getUserName();
        this.password = PasswordEncrypt.encryptPassword(userDTO.getPassword());
        this.name = userDTO.getName();
        this.lastName = userDTO.getLastName();
    }

}
