package com.Project2.BackEnd.Controller;


import com.Project2.BackEnd.Dto.PostData;
import com.Project2.BackEnd.Services.CreatePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/user")
public class PostUpload {

    @Autowired
    private CreatePost postcreate;

    @PostMapping("/CreatePost")
    public ResponseEntity<String> createPost(@ModelAttribute PostData postDataDTO, Authentication authentication) {
        try {
            String userNIC = authentication.getName(); // NIC from JWT token
            postcreate.createPost(postDataDTO, userNIC);
            return ResponseEntity.ok("Post created successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Upload failed: " + e.getMessage());
        }
    }






}
