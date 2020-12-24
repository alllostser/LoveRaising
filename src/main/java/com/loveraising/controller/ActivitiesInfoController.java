package com.loveraising.controller;

import com.loveraising.pojo.ActivitiesInfo;
import com.loveraising.service.ActivitiesService;
import com.loveraising.service.EnrollInfoService;
import com.loveraising.util.CommonResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



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
    @PostMapping("insertActivity")
    public CommonResult insertActicity(ActivitiesInfo activitiesInfo) {
        if(activitiesService.insertActivities(activitiesInfo)==1){
            return new CommonResult(200,"操作成功",1);
        }else {
            return new CommonResult(500,"操作失败",0);
        }
    }
    /**
     * 编辑活动信息
     */
    @PostMapping("updateActivity")
    public CommonResult updateActivity(ActivitiesInfo activitiesInfo) {
        if(activitiesService.updateActivity(activitiesInfo)==1){
            return new CommonResult(200,"操作成功",1);
        }else {
            return new CommonResult(500,"操作失败",0);
        }
    }
    /**
     * 分页查看所有活动接口（管理员查看，包括已禁用的）
     */
    @PostMapping("selectAllActivities")
    public CommonResult selectAllInPage(int currentPage,int pageSize) {

        return new CommonResult(200,"操作成功",activitiesService.selectAllActivities(currentPage,pageSize));
    }
    /**
     * 分页查看所有待进行活动接口（用户查看）
     * */
    @PostMapping("selectDoingActicities")
    public CommonResult selectDoingActivities(int currentPage,int pageSize) {
        return new CommonResult(200,"操作成功",activitiesService.selectDoingActivities(currentPage,pageSize));
    }
    /**
     * 根据id查看活动信息详情
     * */
    @PostMapping("selectActivityById")
    public CommonResult selectActivityById(Integer id) {
        return new CommonResult(200,"操作成功",activitiesService.selectById(id));
    }
    /**
     * 根据用户id查看该用户报名的活动列表（对应enrollinfo表中的user_id）
     * */
    @PostMapping("selectActivitiesByUserId")
    public CommonResult selectActivitiesByUserId(Integer id){
        return new CommonResult(200,"操作成功",activitiesService.selectActivitiesByUserId(id));
    }
    /**
     * 禁用恢复当前活动信息
     */
    @PostMapping("updateActivityStatus")
    public CommonResult updateActicityStatus(Integer statusId) {
        return new CommonResult(200,"操作成功",activitiesService.updateStatus(statusId));
    }
    /**
     *分页关键字查询相关活动信息列表
     * */
    @PostMapping("selectActivitiesByKeyWordInPage")
    public CommonResult selectActivitiesByKeyWordInPage(String keyword,int currentPage,int pageSize) {
        return new CommonResult(200,"操作成功",activitiesService.selectByKeyWordInPage(keyword,currentPage,pageSize));
    }
    /**
     * 根据活动id和用户id报名活动接口，报名人数+1，注意和前端区分好两个id名字
     */
    @PostMapping("joinActivity")
    public CommonResult joinActivity(Integer userId, Integer activityId) {
        int result = enrollInfoService.insertEnrollInfo(userId,activityId);

        return new CommonResult(200,"操作成功",result);
    }
    /**
     * 根据活动id和用户id取消报名活动接口报名人数-1
     * */
    @PostMapping("unjoinActivity")
    public CommonResult unjoinActivity(Integer userId, Integer activityId) {
        int result = enrollInfoService.deleteEnrollInfo(userId,activityId);
        return new CommonResult(200,"操作成功",result);
    }
}
