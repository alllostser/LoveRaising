package com.loveraising.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("statusinfo")
public class StatusInfo {
    private Integer id;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}