package com.wanghuan.blogserver.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.wanghuan.blogserver.entity.User;
import com.wanghuan.blogserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Component
public class TokenUtil {
    private static final long EXPIRE_TIME= 60*60*1000; //有效期60min

    @Autowired
    UserService userService;
    @Autowired
    RedisUtil redisUtil;

    /**
     * token生成
     * @param user
     * @return token
     */
    public String getToken(User user){
        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create().withAudience(user.getId().toString())
                    .withExpiresAt(expiresAt)
                    // 使用了HMAC256加密算法。
                    .sign(Algorithm.HMAC256(user.getPassword()));
        } catch (Exception e){
            e.printStackTrace();
        }
        return token;
    }
    public boolean checkToken(String token) throws UnsupportedEncodingException {
        if (token == null || token.length() == 0)
            return false;
        // 获取 token 中的 user id
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new RuntimeException("401");
        }
        User tokenuser = userService.queryById(Integer.parseInt(userId));
        if (tokenuser == null) {
            throw new RuntimeException("用户不存在，请重新登录");
        }
        if(!checkRidisToken(tokenuser.getUsername(),token)){
            return false;
        }
        // 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(tokenuser.getPassword())).build();
        try {
            DecodedJWT jwt = jwtVerifier.verify(token);
            System.out.println("认证通过：");
            System.out.println("username: " + tokenuser.getNickname());
            System.out.println("过期时间：      " + jwt.getExpiresAt());
        } catch (JWTVerificationException e) {
            throw new RuntimeException("401");
        }
        return true;
    }
    public boolean checkRidisToken(String username,String token){
        if (!redisUtil.hasKey(username)){
            return false;
        }
        if(redisUtil.getExpire(username) <= 0)
            return false;
        if (!token.equals(redisUtil.get(username)))
            return false;
        return true;
    }

}