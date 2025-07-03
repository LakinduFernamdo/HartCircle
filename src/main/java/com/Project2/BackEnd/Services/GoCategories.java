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
            PostViewDTO pvdto = new PostViewDTO();

            pvdto.setItemType(post.getItemType());
            pvdto.setStartDate(post.getStartDate());
            pvdto.setEndDate(post.getEndDate());
            pvdto.setBidLimit(post.getBidLimit());
            pvdto.setStartTime(post.getStartTime());
            pvdto.setEndTime(post.getEndTime());

            UserSummaryDTO usrDto = new UserSummaryDTO();
            usrDto.setFirstName(usrDto.getFirstName());
            usrDto.setLastName(usrDto.getLastName());
            usrDto.setAddress(usrDto.getAddress());
            usrDto.setTpNumber(usrDto.getTpNumber());

            pvdto.setUser(usrDto);
            return pvdto;
        }).collect(Collectors.toList());


    }
}
