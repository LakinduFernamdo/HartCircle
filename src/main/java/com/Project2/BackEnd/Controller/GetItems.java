package com.Project2.BackEnd.Controller;


import com.Project2.BackEnd.Dto.PostData;
import com.Project2.BackEnd.Dto.UserRegisterDTO;
import com.Project2.BackEnd.Entity.Post;
import com.Project2.BackEnd.Services.GoCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class GetItems {

    @Autowired
    private GoCategories goCategories;



}





