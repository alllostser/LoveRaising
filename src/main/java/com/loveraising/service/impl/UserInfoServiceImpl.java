package com.loveraising.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.loveraising.dao.UserInfoMapper;
import com.loveraising.pojo.UserInfo;
import com.loveraising.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * @program: LoveRaising
 * @created: 2020/12/23 14:54
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper,UserInfo> implements UserInfoService {
}
