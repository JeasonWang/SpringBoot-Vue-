package com.wanghuan.blogserver.util;

import com.wanghuan.blogserver.entity.User;

import java.util.UUID;

public class Util {
    public static User user = null;
    public static User getCurrentUser(){
        return user;
    }
    public static void setCurrentUser(User user1){
        user = user1;
    }

    public static String getUUid(){
        return UUID.randomUUID().toString();
    }
}
