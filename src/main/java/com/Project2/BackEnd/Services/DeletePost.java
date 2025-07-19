package com.Project2.BackEnd.Services;

import com.Project2.BackEnd.Dto.PostViewDTO;
import com.Project2.BackEnd.Entity.Post;
import com.Project2.BackEnd.Repo.PostRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class DeletePost {

    @Autowired
    private PostRepository postRepository;

    public void DeleteUserPostService(@PathVariable Integer postId) {
        //check post exist
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        postRepository.delete(post);
    }
}



