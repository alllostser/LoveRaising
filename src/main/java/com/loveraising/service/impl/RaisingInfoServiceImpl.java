package com.loveraising.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.loveraising.dao.RaisingInfoMapper;


import com.loveraising.pojo.RaisingInfo;

import com.loveraising.service.RaisingInfoService;
import com.loveraising.util.PageBean;
import com.loveraising.util.Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RaisingInfoServiceImpl extends ServiceImpl<RaisingInfoMapper, RaisingInfo> implements RaisingInfoService {
    @Resource
    RaisingInfoMapper raisingInfoMapper;
    @Override
    public int insertRaising(RaisingInfo raisingInfo) {
        raisingInfo.setCreatTime(Utils.getDateTime());
        return raisingInfoMapper.insertRaising(raisingInfo);
    }

    @Override
    public int updateRaising(RaisingInfo raisingInfo) {
        return raisingInfoMapper.updateRaising(raisingInfo);
    }

    @Override
    public RaisingInfo selectRaisingById(int id) {
        return raisingInfoMapper.selectRaisingById(id);
    }

    @Override
    public List<RaisingInfo> selectRaisingByUserId(int id) {
        return raisingInfoMapper.selectRaisingByUserId(id);
    }

    @Override
    public PageBean<RaisingInfo> selectRaisingBefore(int currentPage, int pageSize) {
        PageBean<RaisingInfo> pageBean = new PageBean<RaisingInfo>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);

        List<RaisingInfo> list = raisingInfoMapper.selectRaisingBeforeInPage(pageBean);
        int count = raisingInfoMapper.countRaisingBefore();
        pageBean.setTotalCount(count);
        pageBean.setPageData(list);
        return pageBean;
    }

    @Override
    public int passRaising(int id) {
        return raisingInfoMapper.passRaising(id);
    }

    @Override
    public int nopassRaising(int id) {
        return raisingInfoMapper.nopassRaising(id);
    }

    @Override
    public int updateStatus(int id, int statusId) {
        return raisingInfoMapper.updateStatus(id,statusId);
    }

    @Override
    public PageBean<RaisingInfo> selectPassRaising(int currentPage, int pageSize) {
        PageBean<RaisingInfo> pageBean = new PageBean<RaisingInfo>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);

        List<RaisingInfo> list = raisingInfoMapper.selectPassRaising(pageBean);
        int count = raisingInfoMapper.countPassRaising();
        pageBean.setTotalCount(count);
        pageBean.setPageData(list);
        return pageBean;
    }

    @Override
    public PageBean<RaisingInfo> selectByKeyWord(String keyword, int currentPage, int pageSize) {
        PageBean<RaisingInfo> pageBean = new PageBean<RaisingInfo>();
        pageBean.setKeyword(keyword);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        List<RaisingInfo> list = raisingInfoMapper.selectByKeyWord(pageBean);
        int count = raisingInfoMapper.countByKeyWord(keyword);
        pageBean.setTotalCount(count);
        pageBean.setPageData(list);
        return pageBean;
    }
}
