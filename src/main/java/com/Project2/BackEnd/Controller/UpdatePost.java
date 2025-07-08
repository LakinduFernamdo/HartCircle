package com.Project2.BackEnd.Controller;

import com.Project2.BackEnd.Dto.PostData;
import com.Project2.BackEnd.Dto.PostViewDTO;
import com.Project2.BackEnd.Services.UpdatePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UpdatePost {

    @Autowired
    private UpdatePostService updatePostService;
    @PutMapping("/UpdatePost")
    public ResponseEntity<String> Updateposts(@ModelAttribute PostViewDTO postDataDto){
        try{
            updatePostService.UpdatePost(postDataDto);
            return ResponseEntity.ok("Post Updated successfully !");

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Post update faild: "+e.getMessage());
        }

    }


}
