package com.loveraising.controller;

import com.loveraising.pojo.UserInfo;
import com.loveraising.service.UserInfoService;

import com.loveraising.util.CommonResult;
import com.loveraising.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@CrossOrigin
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
    @PostMapping("/insertUserInfo.do")
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
     *
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/login.do")
    public Map login(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getHeader("userName");
        String password = request.getHeader("password");
        if(!userName.trim().equals("") && !userName.trim().equals("")){
            Map<String,Object> result = userInfoService.login(userName,password,response);
            return result;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",500);
        map.put("message","用户名或密码不能为空！");
        return map;
    }

    /**
     * 查询当前用户信息接口
     * @param id
     * @return
     */
    @PostMapping("/selectOne.do")
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
    @PostMapping("fineByKeyWordInPage.do")
    public CommonResult findByKeyWordInPage(String keyword, int currentPage, int pageSize) {
        if(keyword != null && currentPage>0 && pageSize>0){
            PageBean<UserInfo> result = userInfoService.findByKeyWordInPage(keyword,currentPage,pageSize);
            return new CommonResult(200,"操作成功！",result);
        }else {
            return new CommonResult(500,"操作失败！","");
        }
    }

    @PostMapping("checkUserName.do")
    public CommonResult checkUserName(String userName) {
        boolean result = userInfoService.checkUserName(userName);
        return new CommonResult(200,"操作成功",result);
    }

    @PostMapping("selectUserWallet.do")
    public CommonResult selectUserWallet(Integer id) {
        UserInfo userInfo = userInfoService.selectUserWallet(id);
        if(userInfo!=null){
            return new CommonResult(200,"查询成功",userInfo);
        }else {
            return new CommonResult(500,"查询失败！","");
        }
    }
    @PostMapping("addRemainingSum.do")
    public CommonResult addRemainingSum(Integer id,Double add) {
        int result = userInfoService.addRemainingSum(id,add);
        if(result==1){
            return new CommonResult(200,"添加"+add+"元成功！",1);
        }else{
            return new CommonResult(500,"添加失败",0);
        }

    }


}
