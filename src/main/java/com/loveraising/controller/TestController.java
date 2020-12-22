package com.loveraising.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @program: biyesheji
 */
@RestController
public class TestController {
    @Autowired
    private com.loveraising.service.aaa aaa;
    @RequestMapping("/test")
    public List<Map<String, String> >test(){
        return aaa.aa();
    }
}
