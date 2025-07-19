package com.Project2.BackEnd.Services;


import com.Project2.BackEnd.Dto.PostData;
import com.Project2.BackEnd.Dto.UserRegisterDTO;
import com.Project2.BackEnd.Entity.Post;
import com.Project2.BackEnd.Entity.User;
import com.Project2.BackEnd.Repo.PostRepository;
import com.Project2.BackEnd.Repo.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class CreatePost {

    @Autowired
    private PostRepository postRepo;

    @Autowired
    private UserRepository userRepository;

    public void createPost(@NotNull PostData postdataDTO, String userNIC) throws IOException {

        //  Find the logged-in user using NIC(Extract jwt)
        User user = userRepository.findByNic(userNIC)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = new Post();
        post.setUserID(user); // Always set user from token

        post.setStartTime(postdataDTO.getStartTime());
        post.setEndTime(postdataDTO.getEndTime());
        post.setStartDate(postdataDTO.getStartDate());
        post.setEndDate(postdataDTO.getEndDate());
        post.setBidLimit(postdataDTO.getBidLimit());
        post.setItemType(postdataDTO.getItemType());
        post.setDescription(postdataDTO.getDescription());

        if (postdataDTO.getImage1() != null && !postdataDTO.getImage1().isEmpty()) {
            post.setImage1(postdataDTO.getImage1().getBytes());
        }
        if (postdataDTO.getImage2() != null && !postdataDTO.getImage2().isEmpty()) {
            post.setImage2(postdataDTO.getImage2().getBytes());
        }

        postRepo.save(post);
    }



}
