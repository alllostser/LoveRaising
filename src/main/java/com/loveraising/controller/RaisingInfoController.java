package com.loveraising.controller;

import com.loveraising.pojo.RaisingInfo;
import com.loveraising.service.RaisingInfoService;
import com.loveraising.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping("/raisinginfo")
public class RaisingInfoController {
    @Autowired
    private RaisingInfoService raisingInfoService;

    /**
     * 添加筹款信息
     * */
    @PostMapping("insertRaising.do")
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
    @PostMapping("updateRaising.do")
    public CommonResult updateRaising(RaisingInfo raisingInfo) {
        if(raisingInfo!=null && raisingInfoService.updateRaising(raisingInfo)==1){
            return new CommonResult(200,"操作成功",1);
        }else {
            return new CommonResult(500,"操作失败",0);
        }
    }
    /**
     * 根据id查看筹款信息详情
     * */
    @PostMapping("selectRaisingById.do")
    public CommonResult selectRaisingById(Integer id) {
        if(id > 0){
            return new CommonResult(200,"操作成功",raisingInfoService.selectRaisingById(id));
        }else {
            return new CommonResult(500,"查询失败！参数大小错误","");
        }

    }
    /**
     * 根据用户id查看该用户发起的筹款(对应数据库中user_id)
     * */
    @PostMapping("selectRaisingByUserId.do")
    public CommonResult selectRaisingByUserId(int id) {
        if(id > 0) {
            return new CommonResult(200,"操作成功",raisingInfoService.selectRaisingByUserId(id));
        }else {
            return new CommonResult(500,"查询失败","");
        }

    }

    /**
     * 分页查看所有待审核筹款信息
     * @return
     */
    @PostMapping("selectRaisingBefore.do")
    public CommonResult selectRaisingBefore(int currentPage,int pageSize) {
        if(currentPage>0 && pageSize>0) {
            return new CommonResult(200,"操作成功",raisingInfoService.selectRaisingBefore(currentPage,pageSize));
        }else {
            return new CommonResult(500,"操作失败！","");
        }

    }

    /**
     * 筹款通过审核接口
     * @param id
     * @return
     */
    @PostMapping("pass.do")
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
    @PostMapping("nopass.do")
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
    @PostMapping("updateRaisingStatus.do")
    public CommonResult updateRaisingStatus(Integer id) {
        if(id > 0){
            return new CommonResult(200,"操作成功",raisingInfoService.updateStatus(id));
        }else {
            return new CommonResult(500,"操作失败",0);
        }

    }
    /**
     *分页查看所有已通过筹款信息（主页显示以及筹款页显示列表）
     * */
    @PostMapping("selectPassRaisingInPage.do")
    public CommonResult selectPassRaisingInPage(int currentPage,int pageSize) {
        if(currentPage > 0 && pageSize > 0) {
            return new CommonResult(200,"操作成功",raisingInfoService.selectPassRaising(currentPage,pageSize));
        }else {
            return new CommonResult(500,"操作失败",0);
        }

    }
    /**
     *关键词分页搜索筹款信息
     */
    @PostMapping("selectRaisingByKeyWordInPage.do")
    public CommonResult selectRaisingByKeyWordInPage(String keyword,int currentPage,int pageSize) {
        if(!keyword.trim().equals("")) {
            return new CommonResult(200,"搜索成功",raisingInfoService.selectByKeyWord(keyword,currentPage,pageSize));
        }else {
            return new CommonResult(200,"关键字为空！已搜索全部",raisingInfoService.selectAllInPage(currentPage,pageSize));
        }

    }
    @GetMapping("getRaisingId.do")
    public CommonResult getRaisingId() {

        return new CommonResult(200,"操作成功", UUID.randomUUID().toString());
    }

    /**
     * 查询筹款照片地址列表
     * @param raisingId
     * @return
     */
    @PostMapping("selectImageInfos.do")
    public CommonResult selectImageInfos(String raisingId) {
        return new CommonResult(200,"操作成功",raisingInfoService.selectImageInfo(raisingId));
    }
}
