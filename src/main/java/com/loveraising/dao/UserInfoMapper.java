package com.loveraising.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.loveraising.pojo.UserInfo;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserInfoMapper extends BaseMapper<UserInfo> {
    @Select("select * from userinfo")
    public List<UserInfo> findAll();
}