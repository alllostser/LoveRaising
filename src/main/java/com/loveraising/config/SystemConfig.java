package com.loveraising.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shao on 2020/10/18.
 * 服务配置信息类
 */
@Configuration
public class SystemConfig {

    /*token有效期（单位：分钟）*/
    @Value("${TIMEOUT}")
    public int TIMEOUT;
    /**
     * 存储已登录信息
     * */
    @Bean
    public Map<String,String> getMap(){
        return new HashMap<>();
    }
}
