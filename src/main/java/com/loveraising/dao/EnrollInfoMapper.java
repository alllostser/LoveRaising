package com.loveraising.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.loveraising.pojo.Enrollinfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EnrollInfoMapper extends BaseMapper<Enrollinfo> {
    @Insert("insert into enrollinfo(user_id,activity_id,creat_time) values(#{userId},#{activityId},#{creatTime})")
    int insertEnrollInfo(int userId,int activityId,String creatTime);
    @Delete("delete from enrollinfo where user_id=#{userId} and activity_id = #{activityId}")
    int deleteEnrollInfo(int userId,int activityId);
}
