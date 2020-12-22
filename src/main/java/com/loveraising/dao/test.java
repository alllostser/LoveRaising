package com.loveraising.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @program: biyesheji
 * @description:
 * @author: Guxinyu
 * @created: 2020/12/22 16:09
 */
public interface test {
    @Select("select * from sys_user")
    List<Map<String, String> >stringStringMap();
}
