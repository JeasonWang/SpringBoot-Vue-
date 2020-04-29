package com.wanghuan.blogserver.util;

import com.wanghuan.blogserver.entity.User;

import java.util.UUID;

public class Util {
    private static User user = null;
    public static User getCurrentUser(){
        return user;
    }
    public static void setCurrentUser(User newuser){
        user = newuser;
    }

    public static String getUUid(){
        return UUID.randomUUID().toString();
    }
}
