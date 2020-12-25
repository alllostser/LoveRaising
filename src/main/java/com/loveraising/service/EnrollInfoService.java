package com.loveraising.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.loveraising.pojo.Enrollinfo;

public interface EnrollInfoService extends IService<Enrollinfo> {
    int insertEnrollInfo(int userId,int activityId);
    int deleteEnrollInfo(int userId,int activityId);
    boolean checkActivityByUserId(int userId,int activityId);
}
