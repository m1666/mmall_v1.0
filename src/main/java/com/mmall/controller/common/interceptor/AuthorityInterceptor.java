package com.mmall.controller.common.interceptor;

import com.mmall.pojo.User;
import com.mmall.util.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/**
 * User: mann
 * DateTime: 2018/7/27 16:12
 */
@Slf4j
public class AuthorityInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle");
        // 请求中Controller中的方法名
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 解析 HandlerMethod
        String methodName = handlerMethod.getMethod().getName();
        String ClassName = handlerMethod.getBean().getClass().getSimpleName();

        // 解析参数，具体的参数key以及value是什么，打印日志
        StringBuffer requestParamBuffer = new StringBuffer();
        Map paramMap = request.getParameterMap();
        Iterator it = paramMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String mapKey = (String) entry.getKey();

            String mapValue = StringUtils.EMPTY;

            // request 这个参数的map，里面的value返回的是一个String[]
            Object obj = entry.getValue();
            if (obj instanceof String[]){
                String[] strs = (String[]) obj;
                mapValue = Arrays.toString(strs);
            }
            requestParamBuffer.append(mapKey).append("=").append(mapValue);
        }
        User user = null ;
        String loginToken = CookieUtil.readLoginToken(request);
        if (StringUtils.isEmpty(loginToken)){
            
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {
        log.info("afterCompletion");
    }
}
