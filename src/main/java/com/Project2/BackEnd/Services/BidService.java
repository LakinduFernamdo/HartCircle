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
        System.out.println("postID = " + bidDto.getPostID());
        System.out.println("bidderID = " + bidDto.getBidderID());


        // 1. Check if post exists
        Post postID = postRepository.findById(bidDto.getPostID())
                .orElseThrow(() -> new RuntimeException("Post not found"));


        // 2. Check if bidder exists
        User bidderID = userRepository.findById(bidDto.getBidderID())
                .orElseThrow(() -> new RuntimeException("Bidder not found. Unregistered bidder"));

        // 3. Get post owner from the post
        User postOwnerID = postID.getUserID();
        if (postOwnerID == null) {
            throw new RuntimeException("Post owner not found in database!");
        }
        System.out.println("OwnerID = " + postOwnerID);

        // 4. Set Date and Time
        Date currentDate = Date.valueOf(LocalDate.now());
        Time currentTime = Time.valueOf(LocalTime.now());

        // 5. Set values in BidData
        bidData.setPost_ID(postID);
        bidData.setPostOwner_ID(postOwnerID);
        bidData.setBidder_ID(bidderID);
        bidData.setBidAmmount(bidDto.getBidAmount());
        bidData.setUploadDate(currentDate);
        bidData.setUploadTime(currentTime);

        // 6. Save to DB
        bidRepository.save(bidData);
    }
}
