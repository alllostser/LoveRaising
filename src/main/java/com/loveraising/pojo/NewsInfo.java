package com.loveraising.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("newsinfo")
public class NewsInfo {
    @TableId(type= IdType.AUTO)
    private Integer id;

    private String newsTitle;

    private String newsDescription;

    private Integer type;

    private Integer status;

    private String imageUrl;

    private String creatTime;

    public NewsInfo() {
    }

    public NewsInfo(Integer id, String newsTitle, String newsDescription, String imageUrl, String creatTime) {
        this.id = id;
        this.newsTitle = newsTitle;
        this.newsDescription = newsDescription;
        this.imageUrl = imageUrl;
        this.creatTime = creatTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public void setNewsDescription(String newsDescription) {
        this.newsDescription = newsDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "NewsInfo{" +
                "id=" + id +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsDescription='" + newsDescription + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", creatTime='" + creatTime + '\'' +
                '}';
    }
}
