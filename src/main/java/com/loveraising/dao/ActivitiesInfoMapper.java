package com.loveraising.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.loveraising.pojo.ActivitiesImageInfo;
import com.loveraising.pojo.ActivitiesInfo;
import com.loveraising.pojo.vo.ActivitiesInfoVo;
import com.loveraising.util.PageBean;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper
public interface ActivitiesInfoMapper extends BaseMapper<ActivitiesInfo> {

    @Insert("insert into activitiesinfo(activity_id,activity_title,activity_location,first_url,activity_description,activity_num,creat_time,start_time,user_name) " +
            "values(#{activityId},#{activityTitle},#{activityLocation},#{firstUrl},#{activityDescription},#{activityNum},#{creatTime},#{startTime},#{userName})")
    int insertActivities(ActivitiesInfo activitiesInfo);
    @Update("update activitiesinfo set activity_title=#{activityTitle},activity_location=#{activityLocation}," +
            "activity_description=#{activityDescription},activity_num=#{activityNum} " +
            "where id=#{id}")
    int updateActivity(ActivitiesInfo activitiesInfo);
    List<ActivitiesInfoVo> selectAllActivities(@Param("pageBean") PageBean<ActivitiesInfoVo> pageBean,@Param("activitiesInfoVo") ActivitiesInfoVo activitiesInfoVo);
    @Select("select count(id) from activitiesinfo")
    int countAllActivities();
    @Select("select a.id,a.activity_id,a.activity_title,a.first_url,a.activity_location,a.activity_description,a.activity_num,a.current_num,a.creat_time,a.start_time,a.user_name,a.first_url,s.status " +
            "from activitiesinfo a,statusinfo s where a.status_id=s.id and a.status_id=1 order by creat_time limit #{beginIndex},#{pageSize}")
    List<ActivitiesInfo> selectDoingActivities(PageBean<ActivitiesInfo> pageBean);
    @Select("select count(id) from activitiesinfo where status_id=1")
    int countDoingActivities();
    @Select("select * from activitiesinfo where id=#{id}")
    ActivitiesInfo selectById(int id);
    @Select("select a.id,a.activity_id,a.activity_title,a.first_url,a.activity_location,a.activity_description,a.activity_num,a.current_num,a.creat_time,a.start_time,a.user_name,a.first_url,s.status " +
            "from activitiesinfo a,enrollinfo e,statusinfo s where a.id=e.activity_id and a.status_id=s.id and e.user_id=#{id}")
    List<ActivitiesInfo> selectActivitiesByUserId(int id);
    @Select("select a.id,a.activity_id,a.activity_title,a.first_url,a.activity_location,a.activity_description,a.activity_num,a.current_num,a.creat_time,a.start_time,a.user_name,a.first_url,s.status " +
            "from activitiesinfo a,statusinfo s,userinfo u where a.status_id=s.id and a.user_name=u.user_name and u.id=#{id}")
    List<ActivitiesInfo> selectCreateActivitiesByUserId(int id);
    @Update("update activitiesinfo set status_id=#{statusId} where id=#{id}")
    int updateStatus(int statusId,int id);
    @Select(value = "select a.* from activitiesinfo a,statusinfo s where a.status_id=s.id and(locate(#{keyword},a.activity_title)>0 OR " +
            "locate(#{keyword},a.activity_location)>0 OR locate(#{keyword},a.activity_description)>0 OR " +
            "locate(#{keyword},a.user_name)>0 OR locate(#{keyword},a.start_time)>0 OR locate(#{keyword},s.status)>0) " +
            "limit #{beginIndex},#{pageSize}")
    List<ActivitiesInfo> selectActivitiesByKeyWordInPage(PageBean<ActivitiesInfo> pageBean);
    @Select("select count(id) from activitiesinfo where locate(#{keyword},activity_title)>0 OR " +
            "locate(#{keyword},activity_location)>0 OR locate(#{keyword},activity_description)>0 OR " +
            "locate(#{keyword},user_name)>0 OR locate(#{keyword},start_time)>0 OR locate(#{keyword},status_id)>0")
    int countSelectByKeyWord(String keyword);
    @Update("update activitiesinfo set current_num=current_num+1 where id=#{id}")
    int addCurrentAmount(int id);
    @Update("update activitiesinfo set current_num=current_num-1 where id=#{id}")
    int lessCurrentAmount(int id);

    /**
     * 更新活动的第一个图片
     * @param firstUrl
     * @param activityId
     * @return
     */
    @Update("update activitiesinfo set first_url = #{firstUrl} where activity_id=#{activityId}")
    int updateFirstUrl(@Param("firstUrl")String firstUrl, @Param("activityId")String activityId);
    /**
     * 添加活动图片地址到活动图片表
     */
    @Insert("insert into activitiesimageinfo(activity_id,image_url) values(#{activityId},#{imageUrl})")
    int insretActivityImage(@Param("activityId")String activityId,@Param("imageUrl")String imageUrl);
    /**
     * 获取图片地址信息
     */
    @Select("select image_url from activitiesimageinfo where activity_id=#{activityId}")
    List<ActivitiesImageInfo> selectImageInfo(String activityId);

    int updateFirstImageUrl(String firstUrl);

}