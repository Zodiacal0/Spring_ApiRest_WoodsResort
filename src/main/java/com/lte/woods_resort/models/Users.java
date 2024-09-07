<<<<<<< HEAD
<<<<<<< HEAD
package com.lte.woods_resort.models;
import java.io.Serializable;
import java.util.List;

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

    @Column(unique = true)
    private String userName; 
        
    private String name;
    
    @Column(name="last_name")
    private String lastName;

    private String phone;

    @Column(name="user_type")
    private TypeOfUsers typeUsers;

    @OneToMany(mappedBy = "id_event") 
    private List<Events> events;

}
=======
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
>>>>>>> bc2968d066ebfe2765cc7f40a230873241564363
=======
package com.lte.woods_resort.models;
import java.io.Serializable;
import java.util.List;

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

    @Column(unique = true)
    private String userName; 
        
    private String name;
    
    @Column(name="last_name")
    private String lastName;

    private String phone;

    @Column(name="user_type")
    private TypeOfUsers typeUsers;

    @OneToMany(mappedBy = "id_event") 
    private List<Events> events;

}
>>>>>>> 3029f4ad9291460690570c3cbd15c1a2d399abdb
