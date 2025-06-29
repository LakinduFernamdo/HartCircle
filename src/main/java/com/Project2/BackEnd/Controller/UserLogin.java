package com.Project2.BackEnd.Controller;

import com.Project2.BackEnd.Dto.LoginDTO;
import com.Project2.BackEnd.Services.LogingUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/user")

public class UserLogin {

    @Autowired
    private LogingUserServices loginUser;
    @PostMapping("/signIn")
    public ResponseEntity<String> signIn(@RequestBody LoginDTO loginDTO)throws IOException {
        try {
            String jwt=loginUser.ValidateUser(loginDTO);
            return ResponseEntity.ok("Login successfull baby ! "+ jwt);

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Registration failed: " + e.getMessage());

        }

    }





}
