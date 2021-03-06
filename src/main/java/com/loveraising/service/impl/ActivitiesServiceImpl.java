package com.loveraising.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.loveraising.dao.ActivitiesInfoMapper;

import com.loveraising.pojo.ActivitiesImageInfo;
import com.loveraising.pojo.ActivitiesInfo;
import com.loveraising.pojo.vo.ActivitiesInfoVo;
import com.loveraising.service.ActivitiesService;
import com.loveraising.util.PageBean;
import com.loveraising.util.Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class ActivitiesServiceImpl extends ServiceImpl<ActivitiesInfoMapper, ActivitiesInfo> implements ActivitiesService {
    @Resource
    ActivitiesInfoMapper activitiesInfoMapper;
    @Override
    public int insertActivities(ActivitiesInfo activitiesInfo) {
        activitiesInfo.setCreatTime(Utils.getDateTime());
        activitiesInfo.setActivityId(UUID.randomUUID().toString());
        return activitiesInfoMapper.insertActivities(activitiesInfo);
    }

    @Override
    public int updateActivity(ActivitiesInfo activitiesInfo) {
        return activitiesInfoMapper.updateActivity(activitiesInfo);
    }

    @Override
    public PageBean<ActivitiesInfoVo> selectAllActivities(int currentPage, int pageSize, ActivitiesInfoVo activitiesInfoVo) {
        PageBean<ActivitiesInfoVo> pageBean = new PageBean<ActivitiesInfoVo>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);

        List<ActivitiesInfoVo> list = activitiesInfoMapper.selectAllActivities(pageBean,activitiesInfoVo);
        int count = activitiesInfoMapper.countAllActivities();
        pageBean.setTotalCount(count);
        pageBean.setPageData(list);
        return pageBean;
    }

    @Override
    public PageBean<ActivitiesInfo> selectDoingActivities(int currentPage, int pageSize) {
        PageBean<ActivitiesInfo> pageBean = new PageBean<ActivitiesInfo>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        List<ActivitiesInfo> list = activitiesInfoMapper.selectDoingActivities(pageBean);
        int count = activitiesInfoMapper.countDoingActivities();
        pageBean.setTotalCount(count);
        pageBean.setPageData(list);
        return pageBean;
    }

    @Override
    public ActivitiesInfo selectById(int id) {

        ActivitiesInfo activitiesInfo = activitiesInfoMapper.selectById(id);
        List<ActivitiesImageInfo> urls = activitiesInfoMapper.selectImageInfo(activitiesInfo.getActivityId());
        activitiesInfo.setUrls(urls);
        return activitiesInfo;
    }

    @Override
    public List<ActivitiesInfo> selectActivitiesByUserId(int id) {
        return activitiesInfoMapper.selectActivitiesByUserId(id);
    }

    @Override
    public List<ActivitiesInfo> selectCreateActivitiesByUserId(int id) {
        return activitiesInfoMapper.selectCreateActivitiesByUserId(id);
    }

    @Override
    public int updateStatus(int id,int statusId) {
        return activitiesInfoMapper.updateStatus(id,statusId);
    }

    @Override
    public PageBean<ActivitiesInfo> selectByKeyWordInPage(String keyword,int currentPage, int pageSize) {
        PageBean<ActivitiesInfo> pageBean = new PageBean<ActivitiesInfo>();
        pageBean.setKeyword(keyword);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        List<ActivitiesInfo> list = activitiesInfoMapper.selectActivitiesByKeyWordInPage(pageBean);
        int count = activitiesInfoMapper.countSelectByKeyWord(keyword);
        pageBean.setTotalCount(count);
        pageBean.setPageData(list);
        return pageBean;
    }

    @Override
    public int updateFirstUrl(String firstUrl, String activityId) {
        return activitiesInfoMapper.updateFirstUrl(firstUrl,activityId);
    }

    @Override
    public int insertActivityImage(String activityId, String imageUrl) {
        return activitiesInfoMapper.insretActivityImage(activityId,imageUrl);
    }

    @Override
    public List<ActivitiesImageInfo> selectImageInfo(String activityId) {
        List<ActivitiesImageInfo> imageUrls = activitiesInfoMapper.selectImageInfo(activityId);
        return imageUrls;
    }


}
