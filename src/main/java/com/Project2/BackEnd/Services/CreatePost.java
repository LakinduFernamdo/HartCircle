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

    public void createPost(@NotNull PostData postdataDTO) throws IOException {
        Post postcreate = new Post();

        // fetch user entity
        User user = userRepository.findById(postdataDTO.getUserID())
                .orElseThrow(() -> new RuntimeException("User not found"));

        postcreate.setUserID(user); // not setUserID()

        postcreate.setStartTime(postdataDTO.getStartTime());
        postcreate.setEndTime(postdataDTO.getEndTime());
        postcreate.setStartDate(postdataDTO.getStartDate());
        postcreate.setEndDate(postdataDTO.getEndDate());
        postcreate.setBidLimit(postdataDTO.getBidLimit());
        postcreate.setItemType(postdataDTO.getItemType());
        postcreate.setDescription(postdataDTO.getDescription());
        postcreate.setImage1(postdataDTO.getImage1().getBytes());
        postcreate.setImage2(postdataDTO.getImage2().getBytes());

        postRepo.save(postcreate);
    }


}
