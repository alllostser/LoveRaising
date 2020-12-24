package com.loveraising.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.loveraising.pojo.UserInfo;
import com.loveraising.util.PageBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserInfoService extends IService<UserInfo> {
    UserInfo login(UserInfo userInfo);
    UserInfo findById(UserInfo userInfo);
    List<UserInfo> findAll();
    int insertUserInfo(UserInfo userInfo);
    int updateStatus(UserInfo userInfo);
    UserInfo selectOne(@Param("id")int id);
    PageBean<UserInfo> findByKeyWordInPage(String keyword, int currentPage, int pageSize);
    boolean checkUserName(String userName);
    List<UserInfo> selectUserInfo(String keyword);
}
