package com.loveraising.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.loveraising.pojo.ActivitiesImageInfo;
import com.loveraising.pojo.ActivitiesInfo;
import com.loveraising.util.PageBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public interface ActivitiesService extends IService<ActivitiesInfo> {
    int insertActivities(ActivitiesInfo activitiesInfo);
    int updateActivity(ActivitiesInfo activitiesInfo);
    PageBean<ActivitiesInfo> selectAllActivities(int currentPage,int pageSize);
    PageBean<ActivitiesInfo> selectDoingActivities(int currentPage,int pageSize);
    ActivitiesInfo selectById(int id);
    List<ActivitiesInfo> selectActivitiesByUserId(int id);
    List<ActivitiesInfo> selectCreateActivitiesByUserId(int id);
    int updateStatus(int id,int statusId);
    PageBean<ActivitiesInfo> selectByKeyWordInPage(String keyword,int currentPage,int pageSize);
    int updateFirstUrl(String firstUrl,String activityId);
    int insertActivityImage(String activityId,String imageUrl);
    List<ActivitiesImageInfo> selectImageInfo(String activityId);
}
