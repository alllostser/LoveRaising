package com.loveraising.controller;


import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    /**
     * 查看用户列表
     * @return
     */
    @GetMapping("/list")
    public R getUserList(Page<UserInfo> page, UserInfo userInfo){
        IPage<UserInfo> infoIPage = userInfoService.page(page,new QueryWrapper<UserInfo>(userInfo));
        List<UserInfo> list = infoIPage.getRecords();
        List<UserInfo> userVOs = new ArrayList<>();
        list.forEach((user)->{
           UserInfo userVo = ObjectUtil.cloneByStream(user);
           userVo.setPassword("");
           userVOs.add(userVo);
        });
        infoIPage.setRecords(userVOs);
        return R.ok(infoIPage);
    }



}
