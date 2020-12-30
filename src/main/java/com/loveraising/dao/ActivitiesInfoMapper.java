package com.loveraising.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.loveraising.pojo.ActivitiesInfo;
import com.loveraising.util.PageBean;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface ActivitiesInfoMapper extends BaseMapper<ActivitiesInfo> {

    @Insert("insert into activitiesinfo(activity_title,activity_location,activity_description,activity_num,creat_time,user_id) " +
            "values(#{activityTitile},#{activityLocation},#{activityDescription},#{activityNum},#{creatTime},#{userId})")
    int insertActivities(ActivitiesInfo activitiesInfo);
    @Update("update activitiesinfo set activity_title=#{activityTitle},activity_location=#{activityLocation}," +
            "activity_description=#{activityDescription},activity_num=#{activityNum} " +
            "where id=#{id}")
    int updateActivity(ActivitiesInfo activitiesInfo);
    @Select("select a.id,a.activity_title,a.activity_location,a.activity_description,a.activity_num,a.current_num,a.creat_time,a.start_time,a.user_name,a.first_url,s.status " +
            "from activitiesinfo a,statusinfo s where a.status_id=s.id limit #{beginIndex},#{pageSize}")
    List<ActivitiesInfo> selectAllActivities(PageBean<ActivitiesInfo> pageBean);
    @Select("select count(id) from activitiesinfo")
    int countAllActivities();
    @Select("select a.id,a.activity_title,a.activity_location,a.activity_description,a.activity_num,a.current_num,a.creat_time,a.start_time,a.user_name,a.first_url,s.status " +
            "from activitiesinfo a,statusinfo s where a.status_id=s.id and a.status_id=1 limit #{beginIndex},#{pageSize}")
    List<ActivitiesInfo> selectDoingActivities(PageBean<ActivitiesInfo> pageBean);
    @Select("select count(id) from activitiesinfo where status_id=1")
    int countDoingActivities();
    @Select("select * from activitiesinfo where id=#{id}")
    ActivitiesInfo selectById(int id);
    @Select("select a.id,a.activity_title,a.activity_location,a.activity_description,a.activity_num,a.current_num,a.creat_time,a.start_time,a.user_name,a.first_url,s.status " +
            "from activitiesinfo a,enrollinfo e,statusinfo s where a.id=e.activity_id and a.status_id=s.id and e.user_id=#{id}")
    List<ActivitiesInfo> selectActivitiesByUserId(int id);
    @Select("select a.id,a.activity_title,a.activity_location,a.activity_description,a.activity_num,a.current_num,a.creat_time,a.start_time,a.user_name,a.first_url,s.status " +
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
     * @param id
     * @return
     */
    @Update("update activitiesinfo set first_url = #{firstUrl} where id=#{id}")
    int updateFirstUrl(@Param("first_url")String firstUrl, @Param("id")String id);
    /**
     * 添加活动图片地址到活动图片表
     */
    @Insert("insert into activitiesimageinfo(activity_id,image_url) values(#{activityId},#{imageUrl})")
    int insretActivityImage(@Param("activity_id")int activityId,@Param("image_url")String imageUrl);
    /**
     * 获取图片地址信息
     */
    @Select("select i.image_url from activitiesimageinfo i,activitiesinfo a where i.activity_id=a.id and a.id=#{id}")
    ArrayList selectImageInfo(int id);

}