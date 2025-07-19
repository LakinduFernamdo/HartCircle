package com.Project2.BackEnd.Controller;

import com.Project2.BackEnd.Dto.PostViewDTO;
import com.Project2.BackEnd.Services.DeletePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class PostDelete {

    @Autowired
    private DeletePost deletePost;

    @DeleteMapping("/delete-post/{postId}")
    public ResponseEntity<String> deleteUserPost(@PathVariable Integer postId) {
        try {
            deletePost.DeleteUserPostService(postId);
            return ResponseEntity.ok("Post deleted successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Delete failed: " + e.getMessage());
        }
    }



}
