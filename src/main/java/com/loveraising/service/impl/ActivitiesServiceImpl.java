package com.loveraising.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.loveraising.dao.ActivitiesInfoMapper;

import com.loveraising.pojo.ActivitiesInfo;
import com.loveraising.service.ActivitiesService;
import com.loveraising.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActivitiesServiceImpl extends ServiceImpl<ActivitiesInfoMapper, ActivitiesInfo> implements ActivitiesService {
    @Resource
    ActivitiesInfoMapper activitiesInfoMapper;
    @Override
    public int insertActivities(ActivitiesInfo activitiesInfo) {
        return activitiesInfoMapper.insertActivities(activitiesInfo);
    }

    @Override
    public int updateActivity(ActivitiesInfo activitiesInfo) {
        return activitiesInfoMapper.updateActivity(activitiesInfo);
    }

    @Override
    public PageBean<ActivitiesInfo> selectAllActivities(int currentPage,int pageSize) {
        PageBean<ActivitiesInfo> pageBean = new PageBean<ActivitiesInfo>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);

        List<ActivitiesInfo> list = activitiesInfoMapper.selectAllActivities(pageBean);
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
        return activitiesInfoMapper.selectById(id);
    }

    @Override
    public List<ActivitiesInfo> selectActivitiesByUserId(int id) {
        return activitiesInfoMapper.selectActivitiesByUserId(id);
    }

    @Override
    public int updateStatus(int statusId) {
        return activitiesInfoMapper.updateStatus(statusId);
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
}
