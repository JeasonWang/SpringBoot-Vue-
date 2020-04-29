package com.wanghuan.blogserver.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.wanghuan.blogserver.entity.User;
import com.wanghuan.blogserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
@Slf4j
@Component
public class TokenUtil {
    @Autowired
    TokenConfig tokenConfig;
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
            Date expiresAt = new Date(System.currentTimeMillis() + tokenConfig.getExpiration());
            token = JWT.create().withAudience(user.getId().toString())
                    .withIssuer(tokenConfig.getIss())
                    .withSubject(user.getUsername())
                    .withExpiresAt(expiresAt)
                    // 使用了HMAC256加密算法。
                    .sign(Algorithm.HMAC256(tokenConfig.getSecret()));
        } catch (Exception e){
            e.printStackTrace();
        }
        return token;
    }

    public User getTokenUser(String token){
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new RuntimeException("401");
        }
        User tokenUser = userService.queryById(Integer.parseInt(userId));
        if (tokenUser == null) {
            throw new RuntimeException("用户不存在，请重新登录");
        }
        return tokenUser;
    }

    public boolean checkToken(String token) throws UnsupportedEncodingException {
        if (token == null || token.length() == 0)
            return false;
        String userName;
        try {
            userName = JWT.decode(token).getSubject();
        } catch (JWTDecodeException j) {
            throw new RuntimeException("401");
        }
        if (userName == null) {
            throw new RuntimeException("用户不存在，请重新登录");
        }
        if(!checkRedisToken(userName,token)){
            return false;
        }
        // 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(tokenConfig.getSecret())).build();
        try {
            DecodedJWT jwt = jwtVerifier.verify(token);
            System.out.println("认证通过：");
            System.out.println("username: " + userName);
            System.out.println("过期时间：" + jwt.getExpiresAt());
        } catch (JWTVerificationException e) {
            throw new RuntimeException("401");
        }
        Util.setCurrentUser(this.getTokenUser(token));
        return true;
    }
    public boolean checkRedisToken(String username,String token){
        if (!redisUtil.hasKey(username)){
            return false;
        }
        if(redisUtil.getExpire(username) <= 0){
            log.error("token过期");
            return false;
        }

        if (!token.equals(redisUtil.get(username)))
            return false;
        return true;
    }

}