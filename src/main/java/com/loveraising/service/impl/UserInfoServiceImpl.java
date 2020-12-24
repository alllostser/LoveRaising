package com.loveraising.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.loveraising.dao.UserInfoMapper;
import com.loveraising.pojo.UserInfo;
import com.loveraising.service.UserInfoService;
import com.loveraising.util.PageBean;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper,UserInfo> implements UserInfoService {

    @Resource
    UserInfoMapper userInfoMapper;
    @Override
    public UserInfo login(UserInfo userInfo) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        //根据用户名查询 用户对象
        wrapper.eq("user_name",userInfo.getUserName());
        UserInfo queryUser = this.getOne(wrapper);
        if(queryUser!=null){
            //如果用户名存在则验证密码
            //如果密码一致则认为登录成功
            if(userInfo.getPassword().equals(queryUser.getPassword())){
                //将用户信息生成token数据返回给前端
                return queryUser;
            }
        }

        return null;
    }

    @Override
    public UserInfo findById(UserInfo userInfo) {
        return null;
    }

    @Override
    public List<UserInfo> findAll() {
        return null;
    }

    @Override
    public int insertUserInfo(UserInfo userInfo) {

        if(userInfo != null) {
            if(userInfo.getRoleId() != 1){
                return userInfoMapper.insertUserInfo(userInfo);
            }else {
                return userInfoMapper.insertAdmin(userInfo);
            }

        }else {
            return 0;
        }

    }

    @Override
    public int updateStatus(UserInfo userInfo) {
        return userInfoMapper.updateStatus(userInfo);
    }

    @Override
    public UserInfo selectOne(int id) {
        if(id>0){
            return userInfoMapper.selectOne(id);
        }else {
            return null;
        }

    }

    @Override
    public PageBean<UserInfo> findByKeyWordInPage(String keyword, int currentPage, int pageSize) {
        PageBean<UserInfo> pageBean = new PageBean<UserInfo>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        pageBean.setKeyword(keyword);
        List<UserInfo> userInfos = userInfoMapper.findByKeyWord(pageBean);
        int count = userInfoMapper.countByKeyWord(keyword);
        pageBean.setTotalCount(count);
        pageBean.setPageData(userInfos);
        return pageBean;
    }

    @Override
    public boolean checkUserName(String userName) {
        List<UserInfo> list = userInfoMapper.checkUserName(userName);
        if(list.size()>0){
            return false;
        }else {
            return true;
        }

    }

    @Override
    public List<UserInfo> selectUserInfo(String keyword) {
        String userName = keyword;
        return userInfoMapper.selectUserInfo(userName);
    }


}
