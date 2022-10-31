package com.bridgelabz.AddressBookJWTandJMS.dto;

import lombok.Data;

@Data
public class UserDTO {

    private String firstName;
    private String lastName;
    private String Email;
    private String number;
    private String password;
    private String address;
}
