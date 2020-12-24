package com.loveraising.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.loveraising.dao.RaisingInfoMapper;
import com.loveraising.dao.UserInfoMapper;
import com.loveraising.pojo.RaisingInfo;
import com.loveraising.pojo.UserInfo;
import com.loveraising.service.RaisingInfoService;
import org.springframework.stereotype.Service;

@Service
public class RaisingInfoServiceImpl extends ServiceImpl<RaisingInfoMapper, RaisingInfo> implements RaisingInfoService {
}
