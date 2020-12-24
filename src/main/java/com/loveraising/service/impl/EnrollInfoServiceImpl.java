package com.loveraising.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.loveraising.dao.ActivitiesInfoMapper;
import com.loveraising.dao.EnrollInfoMapper;
import com.loveraising.pojo.Enrollinfo;
import com.loveraising.service.EnrollInfoService;
import com.loveraising.util.Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EnrollInfoServiceImpl extends ServiceImpl<EnrollInfoMapper, Enrollinfo> implements EnrollInfoService {
    @Resource
    EnrollInfoMapper enrollInfoMapper;
    @Resource
    ActivitiesInfoMapper activitiesInfoMapper;
    @Override
    public int insertEnrollInfo(int userId,int activityId) {
        String creatTime = Utils.getDateTime();
        activitiesInfoMapper.addCurrentAmount(activityId);//公益活动当前人数+1
        return enrollInfoMapper.insertEnrollInfo(userId,activityId,creatTime);//添加到报名流水表中
    }

    @Override
    public int deleteEnrollInfo(int userId, int activityId) {
        activitiesInfoMapper.lessCurrentAmount(activityId);
        return enrollInfoMapper.deleteEnrollInfo(userId,activityId);
    }
}
