package com.demo.others;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 孙小云
 * @version 1.0
 * @date 2019/11/12 13:41
 * Spring拦截器
 **/
public class MainInterceptor extends HandlerInterceptorAdapter {

  private static final ThreadLocal<Long> mainLogThreadLocal = new ThreadLocal<>();

    //前置拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       if(!(handler instanceof HandlerMethod)){
           return super.preHandle(request, response, handler);
       }
        mainLogThreadLocal.set(System.currentTimeMillis());
        return super.preHandle(request, response, handler);
    }

    //后置拦截
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(!(handler instanceof HandlerMethod)){
            super.preHandle(request, response, handler);
            return;
        }
        HandlerMethod method = (HandlerMethod) handler;
        MainAnnotation mainLog = method.getMethodAnnotation(MainAnnotation.class);
        if(mainLog != null){
             int maintype = mainLog.maintype();
             String type = mainLog.type();
             String tables = mainLog.tables();
             String desc = mainLog.desc();
             String username = (String) request.getSession().getAttribute("username");
             long costtime = (int) (System.currentTimeMillis());

        }
    }
}
