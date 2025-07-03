package com.Project2.BackEnd.Controller;


import com.Project2.BackEnd.Dto.PostData;
import com.Project2.BackEnd.Dto.PostViewDTO;
import com.Project2.BackEnd.Dto.UserRegisterDTO;
import com.Project2.BackEnd.Entity.Post;
import com.Project2.BackEnd.Services.GoCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class GetItems {

    @Autowired
    private GoCategories goCategories;
    @GetMapping("/item_type")
    public ResponseEntity<?> sortPosts(@RequestParam String type){
        try {
            List<PostViewDTO>filteredPost=goCategories.goCategoryItems(type);
            return ResponseEntity.ok(filteredPost);

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());

        }
    }



}





