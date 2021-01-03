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

    private String creatTime;

    public NewsInfo() {
    }

    public NewsInfo(Integer id, String newsTitle, String newsDescription, String creatTime) {
        this.id = id;
        this.newsTitle = newsTitle;
        this.newsDescription = newsDescription;
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


    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    public String toString() {
        return "NewsInfo{" +
                "id=" + id +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsDescription='" + newsDescription + '\'' +
                ", creatTime='" + creatTime + '\'' +
                '}';
    }
}
