package com.loveraising.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.loveraising.dao.UserInfoMapper;
import com.loveraising.pojo.UserInfo;
import com.loveraising.service.UserInfoService;
import com.loveraising.service.TokenService;
import com.loveraising.util.PageBean;

import com.loveraising.util.Utils;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper,UserInfo> implements UserInfoService {

    @Resource
    UserInfoMapper userInfoMapper;
    @Resource
    TokenService tokenService;
    @Override
    public Map login(String userName,String password,HttpServletResponse response) {
        Map map = new HashMap();
        Map<String, Object> userMap = userInfoMapper.selectUserInfoByUserNameAndPassword(userName,password);
        System.out.println(userMap);
        if (userMap == null || userMap.size()==0){
            map.put("code",500);
            map.put("message","账号或密码错误");
        }else if(Integer.parseInt(userMap.get("status").toString())==1){
            map.put("code",500);
            map.put("message","当前账户已禁用!");
        }else {
            //Map<String, String> usersMap = systemConfig.getMap();//用来存放已登录用户的信息，类似redis
            String lastLogin = Utils.getDateTime();
            userInfoMapper.updateLastLogin(Integer.parseInt(userMap.get("id").toString()),lastLogin);   //在数据库更新最后登录时间
            //usersMap.put(name,lastLogin);
            userMap.put("last_login",lastLogin);
            String token = tokenService.getToken(userMap);
            map.put("code", 200);
            map.put("message","登录成功！");
            map.put("token",token);
            map.put("roleId",Integer.parseInt(userMap.get("role_id").toString()));
            map.put("userName",userMap.get("user_name"));
            map.put("lastLogin",lastLogin);

            //systemConfig.getMap().put(name,lastlogin);//向全局的map中存放用户和上次登录时间，如果有则替换value

            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
            response.addCookie(cookie);

        }
        return map;
    }

    @Override
    public UserInfo adminLogin(UserInfo userInfo) {
        UserInfo result = userInfoMapper.adminLogin(userInfo.getUserName(),userInfo.getPassword());
        if(result!=null) {
            userInfoMapper.updateLastLogin(result.getId(),Utils.getDateTime());
        }
        return result;
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
            String birthday = userInfo.getBirthday();
            userInfo.setBirthday(birthday);
            userInfo.setCreatTime(Utils.getDateTime());

                return userInfoMapper.insertUserInfo(userInfo);
        }else {
            return 0;
        }

    }

    @Override
    public int insertAdmin(UserInfo userInfo) {

        return userInfoMapper.insertAdmin(userInfo);

    }

    @Override
    public int updateStatus(UserInfo userInfo) {
        return userInfoMapper.updateStatus(userInfo);
    }

    @Override
    public UserInfo selectOne(int id) {
        if(id>0){
            return userInfoMapper.selectUserInfo(id);
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
        return userInfoMapper.selectUserInfos(userName);
    }

    @Override
    public UserInfo selectUserWallet(int id) {
        return userInfoMapper.selectUserWallet(id);
    }

    @Override
    public int addRemainingSum(Integer id,Double add) {
        return userInfoMapper.addRemainingSum(id,add);
    }

    @Override
    public UserInfo findById(int id) {
        return userInfoMapper.findById(id);
    }


}
