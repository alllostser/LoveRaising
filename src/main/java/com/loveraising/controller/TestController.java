package com.loveraising.controller;

import com.loveraising.dao.UserInfoMapper;
import com.loveraising.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @program: biyesheji
 */
@RestController
public class TestController {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @RequestMapping("/test")
    public UserInfo test(){
        return userInfoMapper.selectByPrimaryKey(1);
    }
}
