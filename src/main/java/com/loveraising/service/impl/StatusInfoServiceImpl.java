package com.loveraising.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.loveraising.dao.StatusInfoMapper;
import com.loveraising.dao.UserInfoMapper;
import com.loveraising.pojo.StatusInfo;
import com.loveraising.pojo.UserInfo;
import com.loveraising.service.StatusInfoService;
import org.springframework.stereotype.Service;

@Service
public class StatusInfoServiceImpl extends ServiceImpl<StatusInfoMapper, StatusInfo> implements StatusInfoService {
}
