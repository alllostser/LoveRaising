package com.loveraising.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.loveraising.pojo.RaisingInfo;
import com.loveraising.util.PageBean;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper
public interface RaisingInfoMapper extends BaseMapper<RaisingInfo> {
    @Insert("insert into raisinginfo(raising_id,raising_title,raising_name,first_url,target_amount,current_amount,creat_time,raising_description,bank_num,user_name) " +
            "values(#{raisingId},#{raisingTitle},#{raisingName},#{firstUrl},#{targetAmount},#{currentAmount},#{creatTime},#{raisingDescription},#{bankNum},#{userName})")
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
    /**
     * 更新筹款的第一个图片
     * @param firstUrl
     * @param
     * @return
     */
    @Update("update raisinginfo set first_url = #{firstUrl} where raising_id=#{raisingId}")
    int updateFirstUrl(@Param("first_url")String firstUrl, @Param("id")String raisingId);
    /**
     * 添加活动图片地址到活动图片表
     */
    @Insert("insert into raisingimageinfo(raising_id,image_url) values(#{raisingId},#{imageUrl})")
    int insretRaisingImage(@Param("raisingId")String raisingId,@Param("imageUrl")String imageUrl);
    /**
     * 获取图片地址信息
     */
    @Select("select image_url from raisingimageinfo where raising_id=#{raisingId}")
    List<Map> selectImageInfo(String raisingId);
    @Update("update raisinginfo set current_amount = current_amount+${add} where id=#{id}")
    int updateCurrentAmount(@Param("id")int id, @Param("add")double add);
    @Select("select target_amount-current_amount from raisinginfo where id=#{id}")
    double checkAmount(int id);
}