package com.Project2.BackEnd.Services;

import com.Project2.BackEnd.Dto.UserRegisterDTO;
import com.Project2.BackEnd.Entity.User;
import com.Project2.BackEnd.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserRegisterServise {

    @Autowired
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserRegisterServise(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(@org.jetbrains.annotations.NotNull UserRegisterDTO userDTO) throws IOException {
        User user=new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setAddress(userDTO.getAddress());
        user.setTpNumber(userDTO.getTpNumber());
        user.setNic(userDTO.getNic());
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        user.setPassword(encodedPassword);

        if (userDTO.getImage() != null && !userDTO.getImage().isEmpty()) {
            user.setImage(userDTO.getImage().getBytes());
        }

        userRepository.save(user);
    }
}
