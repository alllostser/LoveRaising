package com.loveraising.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.loveraising.pojo.ActivitiesInfo;
import com.loveraising.util.PageBean;

import java.util.List;


public interface ActivitiesService extends IService<ActivitiesInfo> {
    int insertActivities(ActivitiesInfo activitiesInfo);
    int updateActivity(ActivitiesInfo activitiesInfo);
    PageBean<ActivitiesInfo> selectAllActivities(int currentPage,int pageSize);
    PageBean<ActivitiesInfo> selectDoingActivities(int currentPage,int pageSize);
    ActivitiesInfo selectById(int id);
    List<ActivitiesInfo> selectActivitiesByUserId(int id);
    int updateStatus(int statusId);
    PageBean<ActivitiesInfo> selectByKeyWordInPage(String keyword,int currentPage,int pageSize);
}
