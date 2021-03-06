package com.loveraising.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.loveraising.common.TableResult;
import com.loveraising.pojo.ActivitiesInfo;
import com.loveraising.pojo.vo.ActivitiesInfoVo;
import com.loveraising.service.ActivitiesService;
import com.loveraising.service.EnrollInfoService;
import com.loveraising.util.CommonResult;

import com.loveraising.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/activitiesinfo")
public class ActivitiesInfoController {
    @Autowired
    private ActivitiesService activitiesService;
    @Autowired
    private EnrollInfoService enrollInfoService;
    /**
     *添加活动信息
     **/
    @PostMapping("insertActivity.do")
    public CommonResult insertActicity(ActivitiesInfo activitiesInfo, HttpServletRequest request) {
        String loginName = (String) request.getAttribute("userName");
        activitiesInfo.setUserName(loginName);
        if(activitiesService.insertActivities(activitiesInfo)==1){
            return new CommonResult(200,"操作成功",1);
        }else {
            return new CommonResult(500,"操作失败",0);
        }
    }
    /**
     * 编辑活动信息
     */
    @PostMapping("updateActivity.do")
    public CommonResult updateActivity(ActivitiesInfo activitiesInfo) {
        if(activitiesService.updateActivity(activitiesInfo)==1){
            return new CommonResult(200,"操作成功",1);
        }else {
            return new CommonResult(500,"操作失败",0);
        }
    }

    /**
     * 编辑活动信息
     */
    @PostMapping("update.do")
    public R update(ActivitiesInfo activitiesInfo) {
        if(activitiesService.updateById(activitiesInfo)){
            return R.ok("操作成功");
        }else {
            return R.failed("操作失败");
        }
    }
    /**
     * 分页查看所有活动接口（管理员查看，包括已禁用的）
     */
    @PostMapping("selectAllActivities.do")
    public TableResult selectAllInPage(int currentPage, int pageSize,ActivitiesInfoVo activitiesInfoVo) {
        PageBean<ActivitiesInfoVo> activitiesInfoPageBean = activitiesService.selectAllActivities(currentPage, pageSize,activitiesInfoVo);
        return TableResult.ResponseBySucess("成功", (long) activitiesInfoPageBean.getTotalCount(),activitiesInfoPageBean.getPageData());
    }
    /**
     * 分页查看所有待进行活动接口（用户查看）
     * */
    @PostMapping("selectDoingActivities.do")
    public CommonResult selectDoingActivities(int currentPage,int pageSize) {
        return new CommonResult(200,"操作成功",activitiesService.selectDoingActivities(currentPage,pageSize));
    }
    /**
     * 根据id查看活动信息详情
     * */
    @PostMapping("selectActivityById.do")
    public CommonResult selectActivityById(Integer id) {
        return new CommonResult(200,"操作成功",activitiesService.selectById(id));
    }
    /**
     * 根据用户id查看该用户发起报名的活动列表
     */
    @PostMapping("selectCreateActivitiesByUserId.do")
    public CommonResult selectCreateActivitiesByUserId(Integer id) {
        return new CommonResult(200,"操作成功",activitiesService.selectCreateActivitiesByUserId(id));
    }
    /**
     * 根据用户id查看该用户报名的活动列表（对应enrollinfo表中的user_id）
     * */
    @PostMapping("selectJoinActivitiesByUserId.do")
    public CommonResult selectJoinActivitiesByUserId(Integer id){
        return new CommonResult(200,"操作成功",activitiesService.selectActivitiesByUserId(id));
    }

    /**
     * 禁用恢复当前活动信息
     */
    @PostMapping("updateActivityStatus.do")
    public CommonResult updateActicityStatus(Integer id,Integer statusId) {
        return new CommonResult(200,"操作成功",activitiesService.updateStatus(id,statusId));
    }
    /**
     *分页关键字查询相关活动信息列表
     * */
    @PostMapping("selectActivitiesByKeyWordInPage.do")
    public CommonResult selectActivitiesByKeyWordInPage(String keyword,int currentPage,int pageSize) {
        return new CommonResult(200,"操作成功",activitiesService.selectByKeyWordInPage(keyword,currentPage,pageSize));
    }
    /**
     * 根据活动id和用户id报名活动接口，报名人数+1，注意和前端区分好两个id名字
     */
    @PostMapping("joinActivity.do")
    public CommonResult joinActivity(Integer userId, Integer activityId) {
        int result = enrollInfoService.insertEnrollInfo(userId,activityId);

        return new CommonResult(200,"操作成功",result);
    }
    /**
     * 根据活动id和用户id取消报名活动接口报名人数-1
     * */
    @PostMapping("unjoinActivity.do")
    public CommonResult unjoinActivity(Integer userId, Integer activityId) {
        int result = enrollInfoService.deleteEnrollInfo(userId,activityId);
        return new CommonResult(200,"操作成功",result);
    }
    /**
     * 根据用户id查看用户是否报名此活动
     */
    @PostMapping("checkActivityByUserId.do")
    public CommonResult checkActivityByUserId(Integer userId,Integer activityId){
        boolean result = enrollInfoService.checkActivityByUserId(userId,activityId);
        return new CommonResult(200,"操作成功",result);
    }
    @GetMapping("getActivityId.do")
    public CommonResult getActivityId() {

        return new CommonResult(200,"操作成功",UUID.randomUUID().toString());
    }
    @PostMapping("selectImageInfos.do")
    public CommonResult selectImageInfos(String activityId) {
        return new CommonResult(200,"操作成功",activitiesService.selectImageInfo(activityId));
    }

    @DeleteMapping("/delete.do")
    public R deleteByids(String ids){
        String[] split = ids.split(",");
        List<String> strings = Arrays.asList(split);
        boolean result = activitiesService.removeByIds(strings);
        if (!result){
            return R.failed("操作失败");
        }
        return R.ok(result);
    }
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
    }
}
