package com.Project2.BackEnd.Dto;

import com.Project2.BackEnd.Entity.Post;
import com.Project2.BackEnd.Entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BidDTO {


    private Integer BidID;

    @JsonProperty("postID")
    private Integer postID;

    @JsonProperty("bidAmount")
    private Double bidAmount;

    public Integer getBidID() {
        return BidID;
    }

    public void setBidID(Integer bidID) {
        BidID = bidID;
    }

    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }


    public Double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Double bidAmount) {
        this.bidAmount = bidAmount;
    }
}
