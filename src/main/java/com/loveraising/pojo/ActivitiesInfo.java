package com.loveraising.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("activitiesinfo")
public class ActivitiesInfo {
    private Integer id;

    private Integer status;

    private String activityTitle;

    private String activityLocation;

    private String activityDescription;

    private Integer activityNum;

    private Integer currentNum;

    private String imageUrl;

    @Override
    public String toString() {
        return "ActivitiesInfo{" +
                "id=" + id +
                ", status=" + status +
                ", activityTitle='" + activityTitle + '\'' +
                ", activityLocation='" + activityLocation + '\'' +
                ", activityDescription='" + activityDescription + '\'' +
                ", activityNum=" + activityNum +
                ", currentNum=" + currentNum +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public String getActivityLocation() {
        return activityLocation;
    }

    public void setActivityLocation(String activityLocation) {
        this.activityLocation = activityLocation;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public Integer getActivityNum() {
        return activityNum;
    }

    public void setActivityNum(Integer activityNum) {
        this.activityNum = activityNum;
    }

    public Integer getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(Integer currentNum) {
        this.currentNum = currentNum;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
