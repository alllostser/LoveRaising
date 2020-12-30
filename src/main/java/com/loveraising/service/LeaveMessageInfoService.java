package com.loveraising.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.loveraising.pojo.LeaveMessageInfo;
import com.loveraising.util.PageBean;


import java.util.List;

public interface LeaveMessageInfoService extends IService<LeaveMessageInfo> {
    int insertLeaveMessage(LeaveMessageInfo leaveMessageInfo);

    PageBean<LeaveMessageInfo> selectMessageInPage(int currentPage,int pageSize);
}
