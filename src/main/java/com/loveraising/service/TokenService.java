package com.loveraising.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

import java.util.Map;

/***
 * 下发token
 * @date 2019年5月27日 下午5:40:25
 * @version V1.0
 */
@Service("TokenService")
public class TokenService {

    @Autowired
    UserInfoService userInfoService;

    /**
     * 登录系统获取token
     * @param userMap
     * @return
     */
    public String getToken(Map<String,Object> userMap) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60 * 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";
        //提取用户id
        String id = String.valueOf((int)userMap.get("id"));
        //提取用户加密密码
        String password = (String)userMap.get("password");
        //提取用户上次登录时间
        String lastLogin = (String)userMap.get("last_login");
        //提取用户名
        String userName = (String)userMap.get("user_name");
        //生成token
        token = JWT.create().withAudience(id).withClaim("userName",userName).withClaim("lastLogin",lastLogin).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(password));
        return token;
    }

}