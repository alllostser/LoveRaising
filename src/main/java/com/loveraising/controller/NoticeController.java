package com.loveraising.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.loveraising.pojo.NewsInfo;
import com.loveraising.service.NewsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: LoveRaising
 * @description: 公告控制层
 * @created: 2020/12/24 16:48
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NewsInfoService newsInfoService;

    /**
     * 获取公告列表
     * @param page
     * @param newsInfo
     * @return
     */
    @GetMapping("/list.do")
    public R list(Page<NewsInfo> page, NewsInfo newsInfo){
        IPage<NewsInfo> pageList = newsInfoService.page(page, new QueryWrapper<>(newsInfo));
        List<NewsInfo> records = pageList.getRecords();
        return R.ok(records);
    }

    /**
     * 添加公告
     * @param newsInfo
     * @return
     */
    @PostMapping("/save.do")
    public R save(NewsInfo newsInfo){
        boolean result = newsInfoService.save(newsInfo);
        if (!result){
            return R.failed("添加失败!");
        }
        return R.ok(result);
    }

    /**
     * 更新公告
     * @param newsInfo
     * @return
     */
    @PostMapping("/update.do")
    public R update(NewsInfo newsInfo){
        if (ObjectUtil.isNotNull(newsInfo.getId())){
            boolean result = newsInfoService.updateById(newsInfo);
            if (!result){
                return R.failed("更新失败!");
            }
            return R.ok(result);
        }
        return null;
    }
}
