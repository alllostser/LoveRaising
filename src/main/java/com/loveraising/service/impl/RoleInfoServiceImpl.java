package com.loveraising.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.loveraising.dao.RoleInfoMapper;
import com.loveraising.dao.UserInfoMapper;
import com.loveraising.pojo.RoleInfo;
import com.loveraising.pojo.UserInfo;
import com.loveraising.service.RoleInfoService;
import org.springframework.stereotype.Service;

@Service
public class RoleInfoServiceImpl extends ServiceImpl<RoleInfoMapper, RoleInfo> implements RoleInfoService {
}
