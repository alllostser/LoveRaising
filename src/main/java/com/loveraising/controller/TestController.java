package com.loveraising.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.LambdaUpdateChainWrapper;
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
    public List<UserInfo> test(){
        return userInfoMapper.selectList(new LambdaQueryWrapper<UserInfo>());
    }
}
