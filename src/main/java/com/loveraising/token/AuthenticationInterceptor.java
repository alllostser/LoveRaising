package com.loveraising.token;


import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.api.R;
import com.loveraising.pojo.UserInfo;
import com.loveraising.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * token认证过程实现类
 */

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    /**
     * 检查token是否有效
     * @param httpServletRequest
     * @param httpServletResponse
     * @param object
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) {
        httpServletResponse.setCharacterEncoding("UTF-8");
        Map<String,String> map = new HashMap<>();
        Map<String,String> responseMap = new HashMap<>();
//        HandlerMethod handlerMethod=(HandlerMethod)object;
//        Method method=handlerMethod.getMethod();

        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        if (StringUtils.isEmpty(token)){
            try {
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().write(JSONObject.toJSONString(R.failed("请先登录")));
                return false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String lastLogin = "";
        String userName = "";
        try {
            lastLogin = JWT.decode(token).getClaim("lastLogin").asString();
            userName = JWT.decode(token).getClaim("userName").asString();
        }catch (NullPointerException e) {
            System.out.println("=============用户登录=================");
        }catch (JWTVerificationException e){
            try {
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().write(JSONObject.toJSONString(R.failed("请先登录")));
                return false;
            } catch (IOException p) {
                p.printStackTrace();
            }
        }



        httpServletRequest.setAttribute("userName",userName);

        return true;
    }

}