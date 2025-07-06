package com.Project2.BackEnd.Controller;

import com.Project2.BackEnd.Entity.Post;
import com.Project2.BackEnd.Repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//get item images as url instead base64

@RestController
@RequestMapping("/api/v1/user")
public class PostImageController {

    @Autowired
    private PostRepository postRepository;
    @GetMapping("/image/{postId}/{slot}")
    public ResponseEntity<byte[]>getImage(@PathVariable int postId,@PathVariable int slot){
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        byte[] imageData = (slot == 1) ? post.getImage1() : post.getImage2();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);

    }
}
