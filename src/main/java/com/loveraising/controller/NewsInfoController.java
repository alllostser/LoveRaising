package com.loveraising.controller;

import com.loveraising.service.NewsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequestMapping("/newsinfo")
public class NewsInfoController {
    @Autowired
    private NewsInfoService newsInfoService;
}
