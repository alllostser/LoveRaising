package com.loveraising.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.loveraising.pojo.RaisingInfo;
import com.loveraising.pojo.dto.RaisingInfoDto;
import com.loveraising.util.PageBean;

import java.util.List;
import java.util.Map;


public interface RaisingInfoService extends IService<RaisingInfo> {
    int insertRaising(RaisingInfoDto raisingInfo);
    int updateRaising(RaisingInfo raisingInfo);
    RaisingInfo selectRaisingById(int id);
    List<RaisingInfo> selectRaisingByUserId(int id);
    PageBean<RaisingInfo> selectRaisingBefore(int currentPage,int pageSize,String keyword);
    int passRaising(int id);
    int nopassRaising(int id);
    int updateStatus(int id);
    PageBean<RaisingInfo> selectPassRaising(int currentPage,int pageSize);
    PageBean<RaisingInfo> selectByKeyWord(String keyword,int currentPage,int pageSize);
    PageBean<RaisingInfo> selectAllInPage(int currentPage,int pageSize);
    int updateFirstUrl(String firstUrl,String raisingId);
    int insertRaisingImage(String raisingId,String imageUrl);
    List<Map> selectImageInfo(String raisingId);
    int updateCurrentAmount(int id,int userId,double add);
    double checkAmount(int id);
}
