package com.Project2.BackEnd.Dto;

import com.Project2.BackEnd.Entity.Post;
import com.Project2.BackEnd.Entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BidDTO {


    private Integer BidID;
    private Integer postID;
    @JsonProperty("BidderID")
    private Integer BidderID;
    @JsonProperty("BidAmount")
    private Double BidAmount;

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

    public Integer getBidderID() {
        return BidderID;
    }

    public void setBidderID(Integer bidderID) {
        BidderID = bidderID;
    }

    public Double getBidAmount() {
        return BidAmount;
    }

    public void setBidAmount(Double bidAmount) {
        BidAmount = bidAmount;
    }
}
