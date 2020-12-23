package com.loveraising.dao;

import com.loveraising.pojo.NewsInfo;

public interface NewsInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NewsInfo record);

    int insertSelective(NewsInfo record);

    NewsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewsInfo record);

    int updateByPrimaryKey(NewsInfo record);
}