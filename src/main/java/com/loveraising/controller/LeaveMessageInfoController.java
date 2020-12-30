package com.loveraising.controller;

import com.loveraising.pojo.LeaveMessageInfo;
import com.loveraising.service.LeaveMessageInfoService;
import com.loveraising.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
@CrossOrigin
public class LeaveMessageInfoController {
    @Autowired
    private LeaveMessageInfoService leaveMessageInfoService;
    @PostMapping("/insertMessage.do")
    public CommonResult insertMessage(LeaveMessageInfo leaveMessageInfo){
        if(leaveMessageInfo!=null) {
            int result = leaveMessageInfoService.insertLeaveMessage(leaveMessageInfo);
            if(result == 1) {
                return new CommonResult(200,"添加成功！",result);
            }else {
                return new CommonResult(500,"添加失败！请检查参数是否规范",result);
            }

        }else {
            return new CommonResult(500,"添加失败","");
        }

    }
    @PostMapping("/selectMessageInPage.do")
    public CommonResult selectMessageInPage(int currentPage,int pageSize) {
        if(currentPage>0 && pageSize>0) {
            return new CommonResult(200,"查询成功",leaveMessageInfoService.selectMessageInPage(currentPage,pageSize));
        }else {
            return new CommonResult(500,"查询失败","");
        }
    }
}
