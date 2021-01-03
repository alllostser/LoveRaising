package com.loveraising.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.enums.ApiErrorCode;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.loveraising.common.TableResult;
import com.loveraising.pojo.RaisingInfo;
import com.loveraising.pojo.dto.RaisingInfoDto;
import com.loveraising.service.RaisingInfoService;
import com.loveraising.util.CommonResult;
import com.loveraising.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping("/raisinginfo")
public class RaisingInfoController {
    @Autowired
    private RaisingInfoService raisingInfoService;

    @GetMapping("/list.do")
    public TableResult list(Page<RaisingInfo> page, RaisingInfo raisingInfo){
        if (StringUtils.isEmpty(raisingInfo.getRaisingName())){
            raisingInfo.setRaisingName(null);
        }
        IPage raisingInfoIPage = raisingInfoService.page(page, new QueryWrapper<>(raisingInfo));
        return TableResult.ResponseBySucess("成功",raisingInfoIPage.getTotal(), raisingInfoIPage.getRecords());
    }

    /**
     * 添加筹款信息
     * */
    @PostMapping("insertRaising.do")
    public CommonResult insertRaising(RaisingInfoDto raisingInfo) {
        raisingInfo.setCurrentAmount(0.0);
        List<String> strings = Arrays.asList(raisingInfo.getImageUrls().split(","));
         if(raisingInfoService.insertRaising(raisingInfo)==1){
             return new CommonResult(200,"操作成功",1);
         }else {
             return new CommonResult(500,"操作失败",0);
         }
    }

    /**
     * 编辑筹款信息
     * */
    @PostMapping("/updateRaising.do")
    public CommonResult updateRaising(RaisingInfo raisingInfo) {
        if(raisingInfo!=null && raisingInfoService.updateRaising(raisingInfo)==1){
            return new CommonResult(200,"操作成功",1);
        }else {
            return new CommonResult(500,"操作失败",0);
        }
    }
    @PostMapping("/update.do")
    public R update(@RequestBody RaisingInfo raisingInfo) {
        boolean result = raisingInfoService.updateById(raisingInfo);
        return R.restResult(result, ApiErrorCode.fromCode(200));
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
    public TableResult selectRaisingBefore(int currentPage,int pageSize,String keyword) {
        if(currentPage>0 && pageSize>0) {
            PageBean<RaisingInfo> raisingInfoPageBean = raisingInfoService.selectRaisingBefore(currentPage, pageSize,keyword);
            return TableResult.ResponseBySucess("成功", (long) raisingInfoPageBean.getTotalCount(),raisingInfoPageBean.getPageData());
        }else {
            return TableResult.ResponseByFail(500,"操作失败！");
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
    @PostMapping("selectAmount.do")
    public CommonResult selectAmount(int id) {
        return new CommonResult(200,"操作成功",raisingInfoService.checkAmount(id));
    }
    @PostMapping("addAmount.do")
    public CommonResult addAmount(int id,int userId,double add) {
        int result = raisingInfoService.updateCurrentAmount(id,userId,add);
        if (result == 1) {
            return new CommonResult(200,"成功捐款"+add+"元",1);
        }else if(result == 2) {
            return new CommonResult(500,"用户余额不足，请联系管理员充值！","");
        }else {
            return new CommonResult(500,"操作失败，请重试！","");
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
        boolean result = raisingInfoService.removeByIds(strings);
        return R.ok(result);
    }
}
