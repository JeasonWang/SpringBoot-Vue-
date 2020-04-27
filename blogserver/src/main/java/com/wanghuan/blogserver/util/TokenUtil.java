package com.wanghuan.blogserver.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.wanghuan.blogserver.entity.User;

import java.util.Date;

public class TokenUtil {

    private static final long EXPIRE_TIME= 60*60*1000; //有效期60min

    /**
     * 签名生成
     * @param user
     * @return
     */
    public static String getToken(User user){
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

}