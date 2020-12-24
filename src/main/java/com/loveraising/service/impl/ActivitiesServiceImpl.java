package com.loveraising.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.loveraising.dao.ActivitiesInfoMapper;
import com.loveraising.dao.UserInfoMapper;
import com.loveraising.pojo.ActivitiesInfo;
import com.loveraising.pojo.UserInfo;
import com.loveraising.service.ActivitiesService;
import org.springframework.stereotype.Service;

@Service
public class ActivitiesServiceImpl extends ServiceImpl<ActivitiesInfoMapper, ActivitiesInfo> implements ActivitiesService {
}
