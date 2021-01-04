package com.loveraising.controller;

import com.loveraising.dao.ActivitiesInfoMapper;
import com.loveraising.pojo.ActivitiesInfo;
import com.loveraising.util.Utils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    ActivitiesInfoMapper activitiesInfoMapper;
    @GetMapping("/addActivities.do")
    public int insertActivities() {
        ActivitiesInfo activitiesInfo = new ActivitiesInfo();
        for(int i=1;i<101;i++) {
            activitiesInfo.setActivityLocation("慈善中心");
            activitiesInfo.setActivityTitle("爱心活动"+i);
            activitiesInfo.setActivityDescription("慈善活动，帮助他人，快乐自己！");
            activitiesInfo.setActivityId(UUID.randomUUID().toString());
            activitiesInfo.setActivityNum(10);
            activitiesInfo.setCreatTime(Utils.getDateTime());
            activitiesInfo.setFirstUrl("image/image"+(i+10)+".jpg");
            activitiesInfo.setStartTime(Utils.getDateTime());
            activitiesInfo.setUserName("admin");
            activitiesInfoMapper.insertActivities(activitiesInfo);
        }

        return 1;
    }
}
