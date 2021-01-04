package com.loveraising.token;

import com.auth0.jwt.JWT;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by chang on 2020/10/21.
 * token工具类
 */
public class TokenUtil {
    /**
     * 获取token中id参数
     * @return
     */
    public static String getTokenUserId() {
        HttpServletRequest request = getRequest();
        if (request != null && request.getHeader("token") != null){
            String token = request.getHeader("token");// 从 http 请求头中取出 token
            String userId = JWT.decode(token).getAudience().get(0);
            return userId;
        }
        return "";
    }

    /**
     * 获取request
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }



}