package com.Project2.BackEnd.Controller;

//get user's profile images as uRL instead of base64

import com.Project2.BackEnd.Entity.User;
import com.Project2.BackEnd.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserImageController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/image/{userId}")
    public ResponseEntity<byte[]> getImage(@PathVariable int userId) {
        User usr = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        byte[] imageData = usr.getImage();
        if (imageData == null || imageData.length == 0) {
            return ResponseEntity.notFound().build(); // no image
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); // or detect PNG dynamically if needed
        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
    }




}
