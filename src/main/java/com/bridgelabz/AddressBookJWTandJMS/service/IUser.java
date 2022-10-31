package com.bridgelabz.AddressBookJWTandJMS.service;

import com.bridgelabz.AddressBookJWTandJMS.dto.UserDTO;
import com.bridgelabz.AddressBookJWTandJMS.model.User;

public interface IUser {

    User getByToken(String token);
    String addUser(UserDTO userDTO);
    String forgetPassword(String email, String password,String newPassword);
    User updateUserDataByToken(String token, UserDTO userDTO);
}
