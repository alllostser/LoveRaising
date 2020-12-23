package com.loveraising.dao;

import com.loveraising.pojo.StatusInfo;

public interface StatusInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StatusInfo record);

    int insertSelective(StatusInfo record);

    StatusInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StatusInfo record);

    int updateByPrimaryKey(StatusInfo record);
}