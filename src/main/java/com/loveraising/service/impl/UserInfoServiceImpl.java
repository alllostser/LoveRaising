package com.loveraising.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.loveraising.dao.UserInfoMapper;
import com.loveraising.pojo.UserInfo;
import com.loveraising.service.UserInfoService;
import org.springframework.stereotype.Service;


@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper,UserInfo> implements UserInfoService {


    @Override
    public UserInfo login(UserInfo userInfo) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        //根据用户名查询 用户对象
        wrapper.eq("user_name",userInfo.getUserName());
        UserInfo queryUser = this.getOne(wrapper);
        if(queryUser!=null){
            //如果用户名存在则验证密码
            //如果密码一致则认为登录成功
            if(userInfo.getPassword().equals(queryUser.getPassword())){
                //将用户信息生成token数据返回给前端

                return queryUser;
            }
        }

        return null;
    }

    @Override
    public UserInfo findById(UserInfo userInfo) {
        return null;
    }
}
