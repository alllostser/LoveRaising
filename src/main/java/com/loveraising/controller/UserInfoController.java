package com.loveraising.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.api.R;
import com.loveraising.pojo.UserInfo;
import com.loveraising.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/list")
    public R getUserList(){
        List<UserInfo> list = userInfoService.list();
        List<UserInfo> userVOs = new ArrayList<>();
        list.forEach((user)->{
           UserInfo userVo = ObjectUtil.cloneByStream(user);
           userVo.setPassword("");
           userVOs.add(userVo);
        });
        return R.ok(userVOs);
    }

}
