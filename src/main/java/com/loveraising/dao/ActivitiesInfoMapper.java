package com.loveraising.dao;

import com.loveraising.pojo.ActivitiesInfo;

public interface ActivitiesInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ActivitiesInfo record);

    int insertSelective(ActivitiesInfo record);

    ActivitiesInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ActivitiesInfo record);

    int updateByPrimaryKey(ActivitiesInfo record);
}