package com.loveraising.controller;


import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.loveraising.common.TableResult;
import com.loveraising.pojo.UserInfo;
import com.loveraising.service.UserInfoService;
import com.loveraising.util.CommonResult;
import com.loveraising.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 添加管理员(在管理员界面添加，需要新的用户名和密码)
     * */
    @PostMapping("/insertAdmin.do")
    public CommonResult insertUserInfo(UserInfo userInfo){
        if(userInfo != null){
            userInfo.setRoleId(1);
            if(userInfoService.checkUserName(userInfo.getUserName())){
                if(userInfoService.insertAdmin(userInfo) == 1){
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
    @PostMapping("/login.do")
    public CommonResult login(UserInfo userInfo) {
        if(userInfo!=null){
            UserInfo result = userInfoService.adminLogin(userInfo);
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
    @GetMapping("/list.do")
    @CrossOrigin
    public TableResult getUserList(Page<UserInfo> page, UserInfo userInfo){
        if(StringUtils.isEmpty(userInfo.getUserName())){
            userInfo.setUserName(null);
        }
        if(StringUtils.isEmpty(userInfo.getSex())){
            userInfo.setSex(null);
        }
        if(StringUtils.isEmpty(userInfo.getEmail())){
            userInfo.setEmail(null);
        }
        IPage<UserInfo> infoIpage = userInfoService.page(page,new QueryWrapper<UserInfo>(userInfo));
        List<UserInfo> list = infoIpage.getRecords();
        List<UserInfo> userVos = new ArrayList<>();
        list.forEach((user)->{
            UserInfo userVo = ObjectUtil.cloneByStream(user);
            userVo.setPassword("");
            userVos.add(userVo);
        });
        infoIpage.setRecords(userVos);
        return TableResult.ResponseBySucess("",infoIpage.getTotal(),userVos);
    }

    /**
     * 查询一个用户byid
     * @param id
     * @return
     */
    @GetMapping("/getOneById.do")
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
    @PostMapping("/update.do")
    public R update(@RequestBody UserInfo userInfo){
        boolean result = userInfoService.updateById(userInfo);
        if (!result){
            return R.failed("更新失败");
        }
        return R.ok("更新成功");
    }

    /**
     * 添加用户
     * @param userInfo
     * @return
     */
    @PostMapping("/insert.do")
    public R insert(@RequestBody UserInfo userInfo){
        userInfo.setCreatTime(Utils.getDateTime());
        userInfo.setStatus(0);
        if(StringUtils.isEmpty(userInfo.getPassword())){
            userInfo.setPassword("123456");
        }
        boolean save = userInfoService.save(userInfo);
        return R.ok(save);
    }
    /**
     * 禁用启用用户
     */
    @GetMapping("/updateStatus/{userId}.do")
    public CommonResult updateStatus(@PathVariable Integer userId) {
        UserInfo userInfo = userInfoService.selectOne(userId);
        if (userInfo.getStatus()==0){
            userInfo.setStatus(1);
        }else {
            userInfo.setStatus(0);
        }
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
    @PostMapping("/selectUserInfo.do")
    public CommonResult selectUserInfo(String keyword) {
        if(keyword!=null||!keyword.trim().equals("")){
            List<UserInfo> list = userInfoService.selectUserInfo(keyword);
            return new CommonResult(200,"操作成功！",list);
        }else {
            return new CommonResult(200,"操作成功",null);
        }
    }

    /**
     * 批量删除通过id
     * @param ids
     * @return
     */
    @DeleteMapping("/delete.do")
    public R deleteByids(String ids){
        List<String> strings = Arrays.asList(ids.split(","));
        boolean result = userInfoService.removeByIds(strings);
        return R.ok(result);
    }
}
