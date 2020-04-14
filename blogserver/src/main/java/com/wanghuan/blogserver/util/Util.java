package com.wanghuan.blogserver.util;

import com.wanghuan.blogserver.entity.User;

public class Util {
    public static User user = null;
    public static User getCurrentUser(){
        return user;
    }
    public static void setCurrentUser(User user1){
        user = user1;
    }
}
