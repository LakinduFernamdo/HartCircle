package com.Project2.BackEnd.Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name="BidInformation")
public class BidData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Bid_ID")
    private Integer Bid_ID;

    // Use ManyToOne relationship
    @ManyToOne
    @JoinColumn(name = "PostOwner_ID", referencedColumnName = "UserID")
    private User postOwner_ID;

    @ManyToOne
    @JoinColumn(name = "Post_ID", referencedColumnName = "PostID")
    private Post post_ID;

    @ManyToOne
    @JoinColumn(name = "Bidder_ID", referencedColumnName = "UserID")
    private User bidder_ID;

    @Column(name="Bid Amount")
    private Double BidAmmount ;


    @Column(name="Upload Time")
    private Time UploadTime ;


    @Column(name="Upload Date")
    private Date UploadDate ;

    public Time getUploadTime() {
        return UploadTime;
    }

    public void setUploadTime(Time uploadTime) {
        UploadTime = uploadTime;
    }

    public Date getUploadDate() {
        return UploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        UploadDate = uploadDate;
    }

    public Integer getBid_ID() {
        return Bid_ID;
    }

    public void setBid_ID(Integer bid_ID) {
        Bid_ID = bid_ID;
    }

    public User getPostOwner_ID() {
        return postOwner_ID;
    }

    public void setPostOwner_ID(User postOwner_ID) {
        this.postOwner_ID = postOwner_ID;
    }

    public Post getPost_ID() {
        return post_ID;
    }

    public void setPost_ID(Post post_ID) {
        this.post_ID = post_ID;
    }

    public User getBidder_ID() {
        return bidder_ID;
    }

    public void setBidder_ID(User bidder_ID) {
        this.bidder_ID = bidder_ID;
    }

    public Double getBidAmmount() {
        return BidAmmount;
    }

    public void setBidAmmount(Double bidAmmount) {
        BidAmmount = bidAmmount;
    }
}
