package com.loveraising.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("raisinginfo")
public class RaisingInfo {
    private Integer id;

    private Integer status;

    private String raisingTitle;

    private String raisingName;

    private double targetAmount;

    private double currentAmount;

    private String creatTime;

    private String raisingDescription;

    private String imageUrl;

    public RaisingInfo() {
    }

    public RaisingInfo(Integer id, Integer status, String raisingTitle, String raisingName, double targetAmount, double currentAmount, String creatTime, String raisingDescription, String imageUrl) {
        this.id = id;
        this.status = status;
        this.raisingTitle = raisingTitle;
        this.raisingName = raisingName;
        this.targetAmount = targetAmount;
        this.currentAmount = currentAmount;
        this.creatTime = creatTime;
        this.raisingDescription = raisingDescription;
        this.imageUrl = imageUrl;
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

    public String getRaisingTitle() {
        return raisingTitle;
    }

    public void setRaisingTitle(String raisingTitle) {
        this.raisingTitle = raisingTitle;
    }

    public String getRaisingName() {
        return raisingName;
    }

    public void setRaisingName(String raisingName) {
        this.raisingName = raisingName;
    }


    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public String getRaisingDescription() {
        return raisingDescription;
    }

    public void setRaisingDescription(String raisingDescription) {
        this.raisingDescription = raisingDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }

    @Override
    public String toString() {
        return "RaisingInfo{" +
                "id=" + id +
                ", status=" + status +
                ", raisingTitle='" + raisingTitle + '\'' +
                ", raisingName='" + raisingName + '\'' +
                ", targetAmount=" + targetAmount +
                ", currentAmount=" + currentAmount +
                ", creatTime='" + creatTime + '\'' +
                ", raisingDescription='" + raisingDescription + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
