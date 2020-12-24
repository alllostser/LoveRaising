package com.loveraising.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.loveraising.dao.NewsInfoMapper;

import com.loveraising.pojo.NewsInfo;

import com.loveraising.service.NewsInfoService;
import org.springframework.stereotype.Service;

@Service
public class NewsInfoServiceImpl extends ServiceImpl<NewsInfoMapper, NewsInfo> implements NewsInfoService {
}
