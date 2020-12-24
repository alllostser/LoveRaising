package com.loveraising.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.loveraising.pojo.UserInfo;

public interface UserInfoService extends IService<UserInfo> {
    public UserInfo login(UserInfo userInfo);
    public UserInfo findById(UserInfo userInfo);

}
