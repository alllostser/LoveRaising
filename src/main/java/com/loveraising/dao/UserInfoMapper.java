package com.loveraising.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.loveraising.pojo.UserInfo;

public interface UserInfoMapper extends BaseMapper<UserInfo> {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}