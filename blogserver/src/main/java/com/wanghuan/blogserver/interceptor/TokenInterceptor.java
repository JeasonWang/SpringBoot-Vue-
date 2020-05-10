package com.wanghuan.blogserver.interceptor;

import com.wanghuan.blogserver.annotation.PassToken;
import com.wanghuan.blogserver.annotation.UserLoginToken;
import com.wanghuan.blogserver.service.UserService;
import com.wanghuan.blogserver.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

@Slf4j
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Autowired
    TokenUtil tokenUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
        log.info("进入拦截器:" + request.getRequestURI());
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        //去掉Bearer
        String BearerToken = request.getHeader("Authorization");
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Annotation annoAuth = handlerMethod.getBean().getClass().getAnnotation(UserLoginToken.class);
        Annotation annoPass = handlerMethod.getMethodAnnotation(PassToken.class);

        //检查是否有passtoken注释，有则跳过认证
        if (annoPass != null){
            PassToken passToken = handlerMethod.getMethodAnnotation(PassToken.class);
            if (passToken.required()){
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (annoAuth == null) {
            return true;
        }
        if (annoAuth != null) {
            UserLoginToken userLoginToken = handlerMethod.getBean().getClass().getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (BearerToken == null || BearerToken.length() == 0) {
                    throw new RuntimeException("无token，请重新登录");
                }
                return tokenUtil.checkToken(BearerToken);
            }
        }
        return true;
    }

}