package com.loveraising.controller;

import com.loveraising.pojo.RaisingInfo;
import com.loveraising.service.RaisingInfoService;
import com.loveraising.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/raisinginfo")
public class RaisingInfoController {
    @Autowired
    private RaisingInfoService raisingInfoService;

    /**
     * 添加筹款信息
     * */
    @PostMapping("insertRaising")
    public CommonResult insertRaising(RaisingInfo raisingInfo) {
         if(raisingInfoService.insertRaising(raisingInfo)==1){
             return new CommonResult(200,"操作成功",1);
         }else {
             return new CommonResult(500,"操作失败",0);
         }
    }

    /**
     * 编辑筹款信息
     * */
    @PostMapping("updateRaising")
    public CommonResult updateRaising(RaisingInfo raisingInfo) {
        if(raisingInfoService.updateRaising(raisingInfo)==1){
            return new CommonResult(200,"操作成功",1);
        }else {
            return new CommonResult(500,"操作失败",0);
        }
    }
    /**
     * 根据id查看筹款信息详情
     * */
    @PostMapping("selectRaisingById")
    public CommonResult selectRaisingById(Integer id) {
        return new CommonResult(200,"操作成功",raisingInfoService.selectRaisingById(id));
    }
    /**
     * 根据用户id查看该用户发起的筹款(对应数据库中user_id)
     * */
    @PostMapping("selectRaisingByUserName")
    public CommonResult selectRaisingByUserId(int id) {
        return new CommonResult(200,"操作成功",raisingInfoService.selectRaisingByUserId(id));
    }

    /**
     * 分页查看所有待审核筹款信息
     * @return
     */
    @PostMapping("selectRaisingBefore")
    public CommonResult selectRaisingBefore(int currentPage,int pageSize) {
        return new CommonResult(200,"操作成功",raisingInfoService.selectRaisingBefore(currentPage,pageSize));
    }

    /**
     * 筹款通过审核接口
     * @param id
     * @return
     */
    @PostMapping("pass")
    public CommonResult passRaising(Integer id) {
        if(raisingInfoService.passRaising(id)==1){
            return new CommonResult(200,"操作成功",1);
        }else {
            return new CommonResult(500,"操作失败",0);
        }
    }

    /**
     * 筹款未通过接口
     * @param id
     * @return
     */
    @PostMapping("nopass")
    public CommonResult noPass(Integer id) {
        if(raisingInfoService.nopassRaising(id)==1){
            return new CommonResult(200,"操作成功",1);
        }else {
            return new CommonResult(500,"操作失败",0);
        }
    }

    /**
     * 禁用当前筹款（已通过的筹款才会禁用）
     * */
    @PostMapping("updateRaisingStatus")
    public CommonResult updateRaisingStatus(Integer id,Integer statusId) {
        return new CommonResult(200,"操作成功",raisingInfoService.updateStatus(id,statusId));
    }
    /**
     *分页查看所有已通过筹款信息
     * */
    @PostMapping("selectPassRaisingInPage")
    public CommonResult selectPassRaisingInPage(int currentPage,int pageSize) {
        return new CommonResult(200,"操作成功",raisingInfoService.selectPassRaising(currentPage,pageSize));
    }
    /**
     *关键词分页搜索筹款信息
     */
    @PostMapping("selectRaisingByKeyWordInPage")
    public CommonResult selectRaisingByKeyWordInPage(String keyword,int currentPage,int pageSize) {
        return new CommonResult(200,"操作成功",raisingInfoService.selectByKeyWord(keyword,currentPage,pageSize));
    }
}
