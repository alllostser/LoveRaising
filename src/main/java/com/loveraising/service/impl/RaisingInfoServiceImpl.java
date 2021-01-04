package com.loveraising.service.impl;

import com.auth0.jwt.JWT;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.loveraising.dao.RaisingInfoMapper;


import com.loveraising.dao.UserInfoMapper;
import com.loveraising.pojo.RaisingImageInfo;
import com.loveraising.pojo.RaisingInfo;

import com.loveraising.pojo.dto.RaisingInfoDto;
import com.loveraising.service.RaisingInfoService;
import com.loveraising.util.PageBean;
import com.loveraising.util.Utils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

@Service
public class RaisingInfoServiceImpl extends ServiceImpl<RaisingInfoMapper, RaisingInfo> implements RaisingInfoService {
    @Resource
    RaisingInfoMapper raisingInfoMapper;
    @Resource
    UserInfoMapper userInfoMapper;
    @Override
    public int insertRaising(RaisingInfoDto raisingInfo) {
        raisingInfo.setCreatTime(Utils.getDateTime());
        String raisingImage = UUID.randomUUID().toString();
        raisingInfo.setRaisingId(raisingImage);
        List<String> strings = Arrays.asList(raisingInfo.getImageUrls().split(","));
        if (!StringUtils.isEmpty(strings)){
            strings.forEach((url)->raisingInfoMapper.insretRaisingImage(raisingImage,url));
        }
        return raisingInfoMapper.insertRaising(raisingInfo);
    }

    @Override
    public int updateRaising(RaisingInfo raisingInfo) {
        return raisingInfoMapper.updateRaising(raisingInfo);
    }

    @Override
    public RaisingInfo selectRaisingById(int id) {

        RaisingInfo raisingInfo = raisingInfoMapper.selectRaisingById(id);
        List<RaisingImageInfo> imageUrls = raisingInfoMapper.selectImageInfo(raisingInfo.getRaisingId());
        raisingInfo.setUrls(imageUrls);
        return raisingInfo;

    }

    @Override
    public List<RaisingInfo> selectRaisingByUserId(int id) {
        return raisingInfoMapper.selectRaisingByUserId(id);
    }

    @Override
    public PageBean<RaisingInfo> selectRaisingBefore(int currentPage, int pageSize, String keyword) {
        PageBean<RaisingInfo> pageBean = new PageBean<RaisingInfo>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);

        List<RaisingInfo> list = raisingInfoMapper.selectRaisingBeforeInPage(pageBean,keyword);
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
    public int updateStatus(int id) {
        return raisingInfoMapper.updateStatus(id);
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

    @Override
    public PageBean<RaisingInfo> selectAllInPage(int currentPage, int pageSize) {
        PageBean<RaisingInfo> pageBean = new PageBean<RaisingInfo>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        List<RaisingInfo> list = raisingInfoMapper.selectAllInPage(pageBean);
        int count = raisingInfoMapper.countAll();
        pageBean.setTotalCount(count);
        pageBean.setPageData(list);
        return pageBean;
    }

    @Override
    public int updateFirstUrl(String firstUrl, String raisingId) {
        return raisingInfoMapper.updateFirstUrl(firstUrl,raisingId);
    }

    @Override
    public int insertRaisingImage(String raisingId, String imageUrl) {
        return raisingInfoMapper.insretRaisingImage(raisingId,imageUrl);
    }

    @Override
    public List<RaisingImageInfo> selectImageInfo(String raisingId) {
        List<RaisingImageInfo> imageUrls = raisingInfoMapper.selectImageInfo(raisingId);
        return imageUrls;
    }

    /**
     * 捐款
     * @param id
     * @param add
     * @return
     */
    @Override
    public int updateCurrentAmount(int id, int userId,double add) {
        double userSum = userInfoMapper.selectSum(userId,add);
        if(userSum < 0) {                   //余额不足
            return 2;
        }else {
            if( raisingInfoMapper.updateCurrentAmount(id,add)==1) {
                userInfoMapper.cutRemainSum(userId,add);//用户扣款
                return 1;
            }else {
                return 3;
            }
        }

    }

    /**
     * 检查捐款还差多少金额凑齐
     * @param id
     * @return
     */
    @Override
    public double checkAmount(int id) {
        return raisingInfoMapper.checkAmount(id);
    }
}
