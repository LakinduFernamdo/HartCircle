package com.Project2.BackEnd.Services;

import com.Project2.BackEnd.Dto.BidDTO;
import com.Project2.BackEnd.Dto.PostData;
import com.Project2.BackEnd.Dto.PostViewDTO;
import com.Project2.BackEnd.Dto.UserSummaryDTO;
import com.Project2.BackEnd.Entity.BidData;
import com.Project2.BackEnd.Entity.Post;
import com.Project2.BackEnd.Entity.User;
import com.Project2.BackEnd.Repo.BidRepository;
import com.Project2.BackEnd.Repo.PostRepository;
import com.Project2.BackEnd.Repo.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;


@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public void sendMyBidAmount(@NotNull BidDTO bidDto) {
        BidData bidData = new BidData();

        // 1. Validate post exists
        Post post = postRepository.findById(bidDto.getPostID())
                .orElseThrow(() -> new RuntimeException("Post not found"));

        // 2. Get currently logged-in user's NIC from JWT
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userNic = auth.getName();
        System.out.println("Authentication = " + auth);
        System.out.println("Name (NIC from JWT) = " + auth.getName());

        // 3. Fetch bidder(login user currently) from DB using NIC
        User bidder = userRepository.findByNic(userNic)
                .orElseThrow(() -> new RuntimeException("your NIC not found. Invalid NIC."));

        // 4. Get post owner
        User postOwner = post.getUserID();
        if (postOwner == null) {
            throw new RuntimeException("Post owner not found in database!");
        }

        // 5. Set date and time
        Date currentDate = Date.valueOf(LocalDate.now());
        Time currentTime = Time.valueOf(LocalTime.now());

        // 6. Fill and save BidData
        bidData.setPost_ID(post);
        bidData.setPostOwner_ID(postOwner);
        bidData.setBidder_ID(bidder); // extract bidder from jwt
        bidData.setBidAmmount(bidDto.getBidAmount());
        bidData.setUploadDate(currentDate);
        bidData.setUploadTime(currentTime);

        bidRepository.save(bidData);
    }
}
