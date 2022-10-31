package com.bridgelabz.AddressBookJWTandJMS.service;

import com.bridgelabz.AddressBookJWTandJMS.dto.UserDTO;
import com.bridgelabz.AddressBookJWTandJMS.exception.AddressBookException;
import com.bridgelabz.AddressBookJWTandJMS.model.User;
import com.bridgelabz.AddressBookJWTandJMS.repository.UserRepository;
import com.bridgelabz.AddressBookJWTandJMS.utility.EmailSenderService;
import com.bridgelabz.AddressBookJWTandJMS.utility.UserUtility;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUser{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserUtility userUtility;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public User getByToken(String token) {
        int id = userUtility.decodeJWT(token);
        User user = userRepository.findById(id).orElseThrow(() -> new AddressBookException("User data not found"));
        return user;
    }

    @Override
    public String addUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO,User.class);
        //User user = new User(userDTO);
        userRepository.save(user);
        String token = userUtility.createToken(user.getUserId());
        emailSenderService.sendEmail(user.getEmail(),"UserAdded","hi" + user.getFirstName() + " Thank you for adding with us");
        return token;
    }


    @Override
    public String forgetPassword(String email, String password, String newPassword) {
        return null;
    }

    @Override
    public User updateUserDataByToken(String token, UserDTO userDTO) {
        return null;
    }
}
