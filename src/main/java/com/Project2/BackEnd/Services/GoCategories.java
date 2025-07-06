package com.Project2.BackEnd.Services;

import com.Project2.BackEnd.Dto.PostData;
import com.Project2.BackEnd.Dto.PostViewDTO;
import com.Project2.BackEnd.Dto.UserRegisterDTO;
import com.Project2.BackEnd.Dto.UserSummaryDTO;
import com.Project2.BackEnd.Entity.Post;
import com.Project2.BackEnd.Entity.User;
import com.Project2.BackEnd.Repo.PostRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoCategories {

    @Autowired
    private PostRepository postRepository;

    public List<PostViewDTO> goCategoryItems(String itemType) {
        List<Post> posts = postRepository.findByItemTypeIgnoreCase(itemType);
        return posts.stream().map(post -> {

            PostViewDTO dto = new PostViewDTO();

            dto.setPostId(post.getPostID());
            dto.setStartTime(post.getStartTime());
            dto.setEndTime(post.getEndTime());
            dto.setStartDate(post.getStartDate());
            dto.setEndDate(post.getEndDate());
            dto.setBidLimit(post.getBidLimit());
            dto.setItemType(post.getItemType());
            dto.setDescription(post.getDescription());

            dto.setImage1Url("http://localhost:8080/api/v1/user/image/" + post.getPostID() + "/1");
            dto.setImage2Url("http://localhost:8080/api/v1/user/image/" + post.getPostID() + "/2");


            UserSummaryDTO usrDto = new UserSummaryDTO();

            usrDto.setFirstName(post.getUserID().getFirstName());
            usrDto.setLastName(post.getUserID().getLastName());
            usrDto.setAddress(post.getUserID().getAddress());
            usrDto.setTpNumber(post.getUserID().getTpNumber());

            dto.setUser(usrDto);
            return dto;
        }).collect(Collectors.toList());


    }
}
