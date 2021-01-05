package com.loveraising.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.loveraising.common.TableResult;
import com.loveraising.pojo.NewsInfo;
import com.loveraising.service.NewsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
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
    public TableResult list(Page<NewsInfo> page, NewsInfo newsInfo){
        if (StringUtils.isEmpty(newsInfo.getNewsTitle())){
            newsInfo.setNewsTitle(null);
        }
        IPage<NewsInfo> pageList = newsInfoService.page(page, new LambdaQueryWrapper<>(newsInfo).orderByDesc(NewsInfo::getCreatTime));
        List<NewsInfo> records = pageList.getRecords();
        return TableResult.ResponseBySucess("成功", page.getTotal(), records);
    }

    /**
     * 添加公告
     * @param newsInfo
     * @return
     */
    @PostMapping("/save.do")
    public R save(@RequestBody NewsInfo newsInfo){
        newsInfo.setCreatTime(new Date());
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
    public R update(@RequestBody NewsInfo newsInfo){
        if (ObjectUtil.isNotNull(newsInfo.getId())){
            boolean result = newsInfoService.updateById(newsInfo);
            if (!result){
                return R.failed("更新失败!");
            }
            return R.ok(result);
        }
        return null;
    }

    @DeleteMapping("/delete.do")
    public R delete(String ids){
        List<String> strings = Arrays.asList(ids.split(","));
        boolean b = newsInfoService.removeByIds(strings);
        if (!b){
            return R.failed("操作失败");
        }
        return R.ok(b);
    }
}
