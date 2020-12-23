package com.loveraising.dao;

import com.loveraising.pojo.RaisingInfo;

public interface RaisingInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RaisingInfo record);

    int insertSelective(RaisingInfo record);

    RaisingInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RaisingInfo record);

    int updateByPrimaryKey(RaisingInfo record);
}