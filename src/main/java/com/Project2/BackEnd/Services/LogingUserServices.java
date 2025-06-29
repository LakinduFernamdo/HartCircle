package com.Project2.BackEnd.Services;

import com.Project2.BackEnd.Dto.LoginDTO;
import com.Project2.BackEnd.Entity.User;
import com.Project2.BackEnd.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service

public class LogingUserServices {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordValidate;
    private final JwtService jwtService;

    @Autowired
    public LogingUserServices(UserRepository userRepository, PasswordEncoder passwordValidate, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordValidate = passwordValidate;
        this.jwtService = jwtService;
    }

    public String ValidateUser(LoginDTO loginDTO) {
        // 1. Check if user exists by NIC
        User user = userRepository.findByNic(loginDTO.getNic())
                .orElseThrow(() -> new RuntimeException("User not found with NIC: " + loginDTO.getNic()));

        // 2. Validate password
        if (!passwordValidate.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // ✅ Generate and return JWT
        return jwtService.generateToken(user.getNic());

    }


}
