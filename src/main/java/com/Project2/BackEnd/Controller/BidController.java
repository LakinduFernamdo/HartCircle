package com.Project2.BackEnd.Controller;


import com.Project2.BackEnd.Dto.BidDTO;
import com.Project2.BackEnd.Services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user/")

public class BidController {

    @Autowired
    public BidService bidService;

    @PostMapping("/AddmyBid")
    public ResponseEntity<String> SendMyBid(@RequestBody BidDTO bidDto, Authentication authentication){
        try {
            String UserNIC=authentication.getName();
            bidService.sendMyBidAmount(bidDto,UserNIC);
            return ResponseEntity.ok("Bit uploaded to BD successfully!");

        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Bid data Update failed: " + e.getCause());
        }

    }


}
