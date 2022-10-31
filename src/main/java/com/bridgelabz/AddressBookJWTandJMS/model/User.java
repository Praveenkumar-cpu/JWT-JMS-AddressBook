package com.bridgelabz.AddressBookJWTandJMS.model;

import com.bridgelabz.AddressBookJWTandJMS.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String firstName;
    private String lastName;
    private String Email;
    private String number;
    private String password;
    private String address;


    //using modelmapper so dont need to instantiate all variable with dto

//    public User(UserDTO userDTO) {
//        this.firstName = userDTO.getFirstName();
//        this.lastName = userDTO.getLastName();
//        this.Email = userDTO.getEmail();
//        this.number = userDTO.getNumber();
//        this.password = userDTO.getPassword();
//        this.address = userDTO.getAddress();
//    }
}
