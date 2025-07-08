package com.Project2.BackEnd.Services;

import com.Project2.BackEnd.Dto.PostData;
import com.Project2.BackEnd.Dto.PostViewDTO;
import com.Project2.BackEnd.Entity.Post;
import com.Project2.BackEnd.Repo.PostRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UpdatePostService {

    @Autowired
    private PostRepository postRepository;


    public void UpdatePost(@NotNull PostViewDTO postdataDTO) throws IOException {
        Post post = postRepository.findById(postdataDTO.getPostId())
                .orElseThrow(() -> new RuntimeException("Post not found"));
        post.setStartTime(postdataDTO.getStartTime());
        post.setEndTime(postdataDTO.getEndTime());
        post.setStartDate(postdataDTO.getStartDate());
        post.setEndDate(postdataDTO.getEndDate());
        post.setBidLimit(postdataDTO.getBidLimit());
        post.setItemType(postdataDTO.getItemType());
        post.setDescription(postdataDTO.getDescription());
        //this is  put request.so check request has update image and new images
        if(postdataDTO.getImage1Url()!=null && !postdataDTO.getImage2Url().isEmpty()){
            post.setImage1(postdataDTO.getImage1Url().getBytes()); //add new images instead old images
        }
        if(postdataDTO.getImage2Url()!=null && !postdataDTO.getImage2Url().isEmpty()){
            post.setImage2(postdataDTO.getImage2Url().getBytes());
        }
        postRepository.save(post);


    }

}
