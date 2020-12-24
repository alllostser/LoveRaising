package com.loveraising.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.loveraising.pojo.ActivitiesInfo;
import com.loveraising.util.PageBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    @Select("select a.id,a.activity_title,a.activity_location,a.activity_description,a.activity_num,a.current_num,a.creat_time,a.start_time,a.user_name,s.status " +
            "from activitiesinfo a,statusinfo s where a.status_id=s.id limit #{beginIndex},#{pageSize}")
    List<ActivitiesInfo> selectAllActivities(PageBean<ActivitiesInfo> pageBean);
    @Select("select count(id) from activitiesinfo")
    int countAllActivities();
    @Select("select a.id,a.activity_title,a.activity_location,a.activity_description,a.activity_num,a.current_num,a.creat_time,a.start_time,a.user_name,s.status " +
            "from activitiesinfo a,statusinfo s where a.status_id=s.id and a.status_id=1 limit #{beginIndex},#{pageSize}")
    List<ActivitiesInfo> selectDoingActivities(PageBean<ActivitiesInfo> pageBean);
    @Select("select count(id) from activitiesinfo where status_id=1")
    int countDoingActivities();
    @Select("select * from activitiesinfo where id=#{id}")
    ActivitiesInfo selectById(int id);
    @Select("select a.id,a.activity_title,a.activity_location,a.activity_description,a.activity_num,a.current_num,a.creat_time,a.start_time,a.user_name,s.status " +
            "from activitiesinfo a,enrollinfo e,statusinfo s where a.id=e.activity_id and a.status_id=s.id and e.user_id=#{id}")
    List<ActivitiesInfo> selectActivitiesByUserId(int id);
    @Update("update activitiesinfo set status_id=#{statusId}")
    int updateStatus(int statusId);
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
}