package com.loveraising.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.loveraising.pojo.RaisingInfo;
import com.loveraising.util.PageBean;

import java.util.List;


public interface RaisingInfoService extends IService<RaisingInfo> {
    int insertRaising(RaisingInfo raisingInfo);
    int updateRaising(RaisingInfo raisingInfo);
    RaisingInfo selectRaisingById(int id);
    List<RaisingInfo> selectRaisingByUserId(int id);
    PageBean<RaisingInfo> selectRaisingBefore(int currentPage,int pageSize);
    int passRaising(int id);
    int nopassRaising(int id);
    int updateStatus(int id,int statusId);
    PageBean<RaisingInfo> selectPassRaising(int currentPage,int pageSize);
    PageBean<RaisingInfo> selectByKeyWord(String keyword,int currentPage,int pageSize);
}
