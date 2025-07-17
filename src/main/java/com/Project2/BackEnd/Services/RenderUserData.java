package com.Project2.BackEnd.Services;

import com.Project2.BackEnd.Dto.UserInfoDTO;
import com.Project2.BackEnd.Entity.User;
import com.Project2.BackEnd.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RenderUserData {

    @Autowired
    private UserRepository userRepository;

    public UserInfoDTO getUserdata(String userNIC) {
        // find user from DB using username or email
        User user = userRepository.findByNic(userNIC)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));


        // Map entity to DTO
        UserInfoDTO dto = new UserInfoDTO();

        dto.setUserID(user.getUserId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setAddress(user.getAddress());
        dto.setDOB(user.getDOB());
        dto.setTpNumber(user.getTpNumber());
        dto.setNic(user.getNic());
        dto.setImage("http://localhost:8080/api/v1/user/image/"+ user.getUserId());

        return dto;
    }

}
