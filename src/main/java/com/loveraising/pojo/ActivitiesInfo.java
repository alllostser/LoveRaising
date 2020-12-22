package com.loveraising.pojo;

public class ActivitiesInfo {
    private int id;

    private int status;

    private String activityTitle;

    private String activityLocation;

    private String activityDescription;

    private int activityNum;

    private int currentNum;

    private String imageUrl;

    public ActivitiesInfo() {
    }

    public ActivitiesInfo(int id, int status, String activityTitle, String activityLocation, String activityDescription, int activityNum, int currentNum, String imageUrl) {
        this.id = id;
        this.status = status;
        this.activityTitle = activityTitle;
        this.activityLocation = activityLocation;
        this.activityDescription = activityDescription;
        this.activityNum = activityNum;
        this.currentNum = currentNum;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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

    public int getActivityNum() {
        return activityNum;
    }

    public void setActivityNum(int activityNum) {
        this.activityNum = activityNum;
    }

    public int getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(int currentNum) {
        this.currentNum = currentNum;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

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
}
