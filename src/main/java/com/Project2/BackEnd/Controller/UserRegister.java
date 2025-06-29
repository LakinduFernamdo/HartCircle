package com.Project2.BackEnd.Controller;

import com.Project2.BackEnd.Dto.UserRegisterDTO;
import com.Project2.BackEnd.Services.UserRegisterServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/user")

public class UserRegister {

    @Autowired
    private UserRegisterServise userService;
    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@ModelAttribute UserRegisterDTO userDTO) throws IOException {
       try{
           userService.registerUser(userDTO);
           return ResponseEntity.ok("User registered successfully");

       }catch(Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Registration failed: " + e.getMessage());

       }
    }

}
