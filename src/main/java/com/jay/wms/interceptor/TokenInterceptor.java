package com.jay.wms.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.jay.wms.annotation.Auth;
import com.jay.wms.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisUtil redis;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HandlerMethod method = (HandlerMethod)handler;
        Auth auth = method.getMethod().getAnnotation(Auth.class);
        if(null == auth){
            return true;
        }
        if(true == auth.check()){
            JSONObject json = JSONObject.parseObject(getContent(request));
            String token = redis.get(json.getString("userId"));
            if(null == token || "".equals(token)){
                return false;
            }
            if(token.equals(json.getString("token"))){
                return true;
            }
        }else {
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }

    public String getContent(HttpServletRequest request) throws IOException {
        int len = request.getContentLength();
        byte bytes[] = new byte[len];
        InputStream inputStream = request.getInputStream();
        while(inputStream.read(bytes) != -1){
        }
        return new String(bytes,"UTF-8");
    }

}