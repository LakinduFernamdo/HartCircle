package com.Project2.BackEnd.Dto;

import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.sql.Time;

public class PostViewDTO {

    private Integer postId;
    private Time startTime;
    private Time endTime;
    private Date startDate;
    private Date endDate;
    private Integer bidLimit;
    private String itemType;
    private String description;
    private String image1Url;
    private String image2Url;

    private UserSummaryDTO user;

    public PostViewDTO(Integer postId, Time startTime, Time endTime, Date startDate, Date endDate, Integer bidLimit, String itemType, String description, String image1Url, String image2Url, UserSummaryDTO user) {
        this.postId = postId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bidLimit = bidLimit;
        this.itemType = itemType;
        this.description = description;
        this.image1Url = image1Url;
        this.image2Url = image2Url;
        this.user = user;
    }

    public PostViewDTO() {

    }

    public Integer getPostId() {
        return postId;
    }


    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage1Url() {
        return image1Url;
    }

    public void setImage1Url(String image1Url) {
        this.image1Url = image1Url;
    }

    public String getImage2Url() {
        return image2Url;
    }

    public void setImage2Url(String image2Url) {
        this.image2Url = image2Url;
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
