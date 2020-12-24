package com.loveraising.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("enrollinfo")
public class Enrollinfo {
    @TableId(type= IdType.AUTO)
    private int id;
    private int userId;
    private int activityId;
    private String creatTime;

    public Enrollinfo() {
    }

    public Enrollinfo(int id, int userId, int activityId, String creatTime) {
        this.id = id;
        this.userId = userId;
        this.activityId = activityId;
        this.creatTime = creatTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    public String toString() {
        return "Enrollinfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", activityId=" + activityId +
                ", creatTime='" + creatTime + '\'' +
                '}';
    }
}
