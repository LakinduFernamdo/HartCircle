package com.Project2.BackEnd.Dto;


import com.Project2.BackEnd.Entity.User;

import java.sql.Time;
import java.sql.Date;

public class PostData {


    private Long userID;
    private Time startTime;
    private Time endTime;
    private Date startDate;
    private Date endDate;
    private Integer bidLimit;
    private String itemType;

    public PostData( Long userID, Time startTime, Time endTime, Date startDate, Date endDate, Integer bidLimit, String itemType) {

        this.userID = userID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bidLimit = bidLimit;
        this.itemType = itemType;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
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
