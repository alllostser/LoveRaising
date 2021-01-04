package com.loveraising.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.loveraising.pojo.UserInfo;
import com.loveraising.util.PageBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface UserInfoService extends IService<UserInfo> {
    Map login(String userName,String password,HttpServletResponse response);
    UserInfo adminLogin(UserInfo userInfo);
    UserInfo findById(UserInfo userInfo);
    List<UserInfo> findAll();
    int insertUserInfo(UserInfo userInfo);
    int insertAdmin(UserInfo userInfo);
    int updateStatus(UserInfo userInfo);
    UserInfo selectOne(int id);
    PageBean<UserInfo> findByKeyWordInPage(String keyword, int currentPage, int pageSize);
    boolean checkUserName(String userName);
    List<UserInfo> selectUserInfo(String keyword);
    UserInfo selectUserWallet(int id);
    int addRemainingSum(Integer id,Double add);
    UserInfo findById(int id);

}
