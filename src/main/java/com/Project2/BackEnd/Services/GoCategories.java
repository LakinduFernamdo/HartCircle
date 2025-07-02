package com.Project2.BackEnd.Services;

import com.Project2.BackEnd.Dto.PostData;
import com.Project2.BackEnd.Dto.UserRegisterDTO;
import com.Project2.BackEnd.Entity.Post;
import com.Project2.BackEnd.Entity.User;
import com.Project2.BackEnd.Repo.PostRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GoCategories {

     @Autowired
     private PostRepository postRepository;

    public void goCategoryItems(@NotNull PostData postdataDTO,@NotNull UserRegisterDTO userDTO){




    }
}
