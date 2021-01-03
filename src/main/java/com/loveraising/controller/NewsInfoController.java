package com.loveraising.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.loveraising.pojo.NewsInfo;
import com.loveraising.service.NewsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/newsinfo")
public class NewsInfoController {
    @Autowired
    private NewsInfoService newsInfoService;

    public R insert(NewsInfo newsInfo){
        boolean save = newsInfoService.save(newsInfo);
        return R.ok("");
    }
}
