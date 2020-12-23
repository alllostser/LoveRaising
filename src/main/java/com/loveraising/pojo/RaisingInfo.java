package com.loveraising.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("raisinginfo")
public class RaisingInfo {
    private Integer id;

    private Integer status;

    private String raisingTitle;

    private String raisingName;

    private String targetAmount;

    private String creatTime;

    private String raisingDescription;

    private String imageUrl;

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
