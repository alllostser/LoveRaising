package com.loveraising.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("newsinfo")
public class NewsInfo {
    private int id;

    private String newsTitle;

    private String newsDescription;

    private String imageUrl;

    public NewsInfo() {
    }

    public NewsInfo(int id, String newsTitle, String newsDescription, String imageUrl) {
        this.id = id;
        this.newsTitle = newsTitle;
        this.newsDescription = newsDescription;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "NewsInfo{" +
                "id=" + id +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsDescription='" + newsDescription + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
