package com.loveraising.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: biyesheji
 * @description:
 */
@Service
public class aaa {
    @Autowired


private com.loveraising.dao.test test;
    public List<Map<String, String>> aa (){
        return test.stringStringMap();
    }
}
