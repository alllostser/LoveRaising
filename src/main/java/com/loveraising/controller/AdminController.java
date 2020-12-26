package com.loveraising.controller;


import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.loveraising.pojo.UserInfo;
import com.loveraising.service.UserInfoService;
import com.loveraising.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理员操作接口
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 添加管理员(在管理员界面添加，需要新的用户名和密码)
     * */
    @PostMapping("/insertAdmin")
    public CommonResult insertUserInfo(UserInfo userInfo){
        if(userInfo != null){
            userInfo.setRoleId(1);
            if(userInfoService.checkUserName(userInfo.getUserName())){
                if(userInfoService.insertUserInfo(userInfo)==1){
                    return new CommonResult(200,"操作成功！",1);
                }else {
                    return new CommonResult(500,"操作失败！",0);
                }
            }else {
                return new CommonResult(500,"当前用户名已存在！",0);
            }
        }else{
            return new CommonResult(500,"操作失败！",0);
        }


    }
    /**
     * 管理员登录接口
     */
    @PostMapping("/login")
    public CommonResult login(UserInfo userInfo) {
        if(userInfo!=null){
            UserInfo result = userInfoService.login(userInfo);
            if(result != null) {
                if(result.getRoleId() == 1){   //如果是管理员
                    return new CommonResult(200,"管理员登录成功！",result);
                }else {
                    return new CommonResult(500,"登录失败！您没有管理员权限！",result);
                }

            }
        }
        return new CommonResult(500,"用户名或密码错误!","");
    }
    /**
     * 查看用户列表
     * @return
     */
    @GetMapping("/list")
    public R getUserList(Page<UserInfo> page, UserInfo userInfo){
        IPage<UserInfo> infoIpage = userInfoService.page(page,new QueryWrapper<UserInfo>(userInfo));
        List<UserInfo> list = infoIpage.getRecords();
        List<UserInfo> userVos = new ArrayList<>();
        list.forEach((user)->{
           UserInfo userVo = ObjectUtil.cloneByStream(user);
           userVo.setPassword("");
           userVos.add(userVo);
        });
        infoIpage.setRecords(userVos);
        return R.ok(infoIpage);
    }

    /**
     * 查询一个用户byid
     * @param id
     * @return
     */
    @GetMapping("/getOneById")
    public R getUserById(Integer id){
        UserInfo userInfo = userInfoService.getById(id);
       // boolean result = ObjectUtil.isNotNull(userInfo);
        return R.ok(userInfo);
    }

    /**
     * 根据id更新用户信息
     * @param userInfo
     * @return
     */
    @PutMapping("/update")
    public R update(UserInfo userInfo){
        boolean result = userInfoService.updateById(userInfo);
        if (!result){
            return R.failed("更新失败");
        }
        return R.ok("更新成功");
    }

    /**
     * 禁用启用用户
     */
    @PostMapping("/updateStatus")
    public CommonResult updateStatus(UserInfo userInfo) {
        int result = userInfoService.updateStatus(userInfo);
        if(result == 1){
            return new CommonResult(200,"修改成功！",1);
        }else {
            return new CommonResult(500,"修改失败！",0);
        }

    }

    /**
     * 搜索用户接口
     */
    @PostMapping("/selectUserInfo")
    public CommonResult selectUserInfo(String keyword) {
        if(keyword!=null||!keyword.trim().equals("")){
            List<UserInfo> list = userInfoService.selectUserInfo(keyword);
            return new CommonResult(200,"操作成功！",list);
        }else {
            return new CommonResult(200,"操作成功",null);
        }



    }
}