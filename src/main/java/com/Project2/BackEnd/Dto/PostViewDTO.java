package com.Project2.BackEnd.Dto;

import java.sql.Date;
import java.sql.Time;

public class PostViewDTO {

    private Time startTime;
    private Time endTime;
    private Date startDate;
    private Date endDate;
    private Integer bidLimit;
    private String itemType;

    private UserSummaryDTO user;

    public PostViewDTO(Time startTime, Time endTime, Date startDate, Date endDate, Integer bidLimit, String itemType, UserSummaryDTO user) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bidLimit = bidLimit;
        this.itemType = itemType;
        this.user = user;
    }

    public PostViewDTO() {

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

    public UserSummaryDTO getUser() {
        return user;
    }

    public void setUser(UserSummaryDTO user) {
        this.user = user;
    }
}
