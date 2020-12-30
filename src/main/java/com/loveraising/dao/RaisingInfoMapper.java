package com.loveraising.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.loveraising.pojo.RaisingInfo;
import com.loveraising.util.PageBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface RaisingInfoMapper extends BaseMapper<RaisingInfo> {
    @Insert("insert into raisinginfo(raising_title,raising_name,target_amount,current_amount,creat_time,raising_description,bank_num,user_name) " +
            "values(#{raisingTitle},#{raisingName},#{targetAmount},#{currentAmount},#{creatTime},#{raisingDescription},#{bankNum},#{userName})")
    int insertRaising(RaisingInfo raisingInfo);
    @Update("update raisinginfo set raising_title=#{raisingTitle},raising_name=#{raisingName},target_amount=#{targetAmount}," +
            "current_amount=#{currentAmount},raising_description=#{raisingDescription},bank_num=#{bankNum} where id=#{id})")
    int updateRaising(RaisingInfo raisingInfo);
    @Select("select * from raisinginfo where id=#{id}")
    RaisingInfo selectRaisingById(int id);
    @Select("select r.* from raisinginfo r,userinfo u where r.user_name=u.user_name and u.id=#{id}")
    List<RaisingInfo> selectRaisingByUserId(int id);
    @Select("select * from raisinginfo where status_id =2")
    List<RaisingInfo> selectRaisingBeforeInPage(PageBean<RaisingInfo> pageBean);
    @Select("select count(id) from raisinginfo where status_id=2")
    int countRaisingBefore();
    @Update("update raisinginfo set status_id=5 where id=#{id}")
    int passRaising(int id);
    @Update("update raisinginfo set status_id=6 where id=#{id}")
    int nopassRaising(int id);
    @Update("update raisinginfo set status_id=2 where id=#{id}")
    int updateStatus(int id);
    @Select("select * from raisinginfo where status_id=5 limit #{beginIndex},#{pageSize}")
    List<RaisingInfo> selectPassRaising(PageBean<RaisingInfo> pageBean);
    @Select("select count(id) from raisinginfo where status_id=5")
    int countPassRaising();
    @Select(value = "select * from raisinginfo where locate(#{keyword},raising_title)>0 OR " +
            "locate(#{keyword},raising_name)>0 OR locate(#{keyword},creat_time)>0 OR " +
            "locate(#{keyword},raising_description)>0 OR locate(#{keyword},user_name)>0 " +
            "limit #{beginIndex},#{pageSize} orderby creat_time desc")
    List<RaisingInfo> selectByKeyWord(PageBean<RaisingInfo> pageBean);
    @Select(value = "select count(id) from raisinginfo where locate(#{keyword},raising_title)>0 OR " +
            "locate(#{keyword},raising_name)>0 OR locate(#{keyword},creat_time)>0 OR " +
            "locate(#{keyword},raising_description)>0 OR locate(#{keyword},user_name)>0 ")
    int countByKeyWord(String keyword);
    @Select("select * from raisinginfo limit #{beginIndex},#{pageSize} orderby creat_time desc")
    List<RaisingInfo> selectAllInPage(PageBean<RaisingInfo> pageBean);
    @Select("select count(id) from raisinginfo")
    int countAll();
}