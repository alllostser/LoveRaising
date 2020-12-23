package com.loveraising.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("raisinginfo")
public class RaisingInfo {
    private int id;

    private int status;

    private String raisingTitle;

    private String raisingName;

    private String targetAmount;

    private String creatTime;

    private String raisingDescription;

    private String imageUrl;

    public RaisingInfo() {
    }

    public RaisingInfo(int id, int status, String raisingTitle, String raisingName, String targetAmount, String creatTime, String raisingDescription, String imageUrl) {
        this.id = id;
        this.status = status;
        this.raisingTitle = raisingTitle;
        this.raisingName = raisingName;
        this.targetAmount = targetAmount;
        this.creatTime = creatTime;
        this.raisingDescription = raisingDescription;
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

    public String getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(String targetAmount) {
        this.targetAmount = targetAmount;
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

    @Override
    public String toString() {
        return "RaisingInfo{" +
                "id=" + id +
                ", status=" + status +
                ", raisingTitle='" + raisingTitle + '\'' +
                ", raisingName='" + raisingName + '\'' +
                ", targetAmount='" + targetAmount + '\'' +
                ", creatTime='" + creatTime + '\'' +
                ", raisingDescription='" + raisingDescription + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
