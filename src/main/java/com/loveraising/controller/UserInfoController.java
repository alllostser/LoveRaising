package com.loveraising.controller;

import com.loveraising.pojo.UserInfo;
import com.loveraising.service.UserInfoService;

import com.loveraising.util.CommonResult;
import com.loveraising.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/userinfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 用户注册(添加用户)
     * @param userInfo
     * @return
     */
    @PostMapping("/insertUserInfo")
    public CommonResult insertUserInfo(UserInfo userInfo){
        if(userInfoService.checkUserName(userInfo.getUserName())){
            if(userInfoService.insertUserInfo(userInfo)==1){
                return new CommonResult(200,"操作成功！",1);
            }else {
                return new CommonResult(500,"操作失败！",0);
            }
        }else {
            return new CommonResult(500,"当前用户名已存在！",0);
        }
    }

    /**
     * 用户登录接口
     * @param userInfo
     * @return
     */
    @PostMapping("/login")
    public CommonResult login(UserInfo userInfo) {
        if(userInfo != null){
            UserInfo result = userInfoService.login(userInfo);
            if(result != null) {
                if(result.getStatus()==0){
                    return new CommonResult(200,"登录成功！",result);
                }
                    return new CommonResult(500,"当前账户已被禁用！","");
            }
        }
        return new CommonResult(500,"用户名或密码错误!","");
    }

    /**
     * 查询当前用户信息接口
     * @param id
     * @return
     */
    @PostMapping("/selectOne")
    public CommonResult selectOne(Integer id) {
        UserInfo result = userInfoService.selectOne(id);
        if(result != null){
            return new CommonResult(200,"操作成功！",result);
        }else {
            return new CommonResult(500,"操作失败！","");
        }
    }

    /**
     * 关键词分页搜索用户接口
     * @param keyword
     * @param currentPage
     * @param pageSize
     * @return
     */
    @PostMapping("fineByKeyWordInPage")
    public CommonResult findByKeyWordInPage(String keyword, int currentPage, int pageSize) {
        if(keyword != null && currentPage>0 && pageSize>0){
            PageBean<UserInfo> result = userInfoService.findByKeyWordInPage(keyword,currentPage,pageSize);
            return new CommonResult(200,"操作成功！",result);
        }else {
            return new CommonResult(500,"操作失败！","");
        }
    }




}
