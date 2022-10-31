package com.bridgelabz.AddressBookJWTandJMS.controller;

import com.bridgelabz.AddressBookJWTandJMS.dto.ResponseDTO;
import com.bridgelabz.AddressBookJWTandJMS.dto.UserDTO;
import com.bridgelabz.AddressBookJWTandJMS.model.User;
import com.bridgelabz.AddressBookJWTandJMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> userRegistration(@RequestBody UserDTO userDTO) {
        String token = userService.addUser(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("User registration successful.", token);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getuserbytoken")
    public ResponseEntity<ResponseDTO> getAllUserById(@RequestHeader String token) {
        User user = userService.getByToken(token);
        ResponseDTO responseDTO = new ResponseDTO("User data retrieved successfully", user);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
