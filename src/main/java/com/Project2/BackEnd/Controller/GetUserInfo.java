package com.Project2.BackEnd.Controller;


import com.Project2.BackEnd.Dto.UserInfoDTO;
import com.Project2.BackEnd.Services.RenderUserData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class GetUserInfo {

    @Autowired
    private RenderUserData renderUserData;

    @GetMapping("/me")
    public ResponseEntity<?> getUserData(Authentication authentication) {
        try {
            String userNIC = authentication.getName();
            System.out.println("NIC from Auth = " + userNIC);
            UserInfoDTO userInfo = renderUserData.getUserdata(userNIC);
            return ResponseEntity.ok(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Render failed: " + e.getMessage());
        }
    }
}
