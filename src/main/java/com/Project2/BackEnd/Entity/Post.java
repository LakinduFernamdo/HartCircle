package com.Project2.BackEnd.Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;



@Entity
@Table(name = "postdata")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PostID")
    private Integer postID;

    // Use ManyToOne relationship
    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private User userID;

    @Column(name = "StartTime")
    private Time startTime;

    @Column(name = "EndTime")
    private Time endTime;

    @Column(name = "StartDate")
    private Date startDate;

    @Column(name = "EndDate")
    private Date endDate;

    @Column(name = "BidLimit")
    private Integer bidLimit;

    @Column(name = "ItemType")
    private String itemType;

    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getBidLimit() {
        return bidLimit;
    }

    public void setBidLimit(Integer bidLimit) {
        this.bidLimit = bidLimit;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
}
