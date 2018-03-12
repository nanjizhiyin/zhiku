package com.xpfirst.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * Copyright (C) 北京学信科技有限公司
 *
 * @Des: 自定义sessionId获取
 * @Author: Gaojindan
 * @Create: 2018/3/7 上午9:33
 **/

public class SessionManager{

    //当前用户
    public static String currentUser = "currentUser";
    /**
    * @Author: Gaojindan
    * @Create: 2018/3/12 下午2:54
    * @Des: 获取session对象
    * @Param:
    * @Return:
    */
    public static Session getShiroSession(){
        try{
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession(false);
            if (session == null){
                session = subject.getSession();
            }
            if (session != null){
                return session;
            }
        }catch (InvalidSessionException e){

        }
        return null;
    }
    /**
    * @Author: Gaojindan
    * @Create: 2018/3/12 下午2:55
    * @Des: 保存一个值
    * @Param:
    * @Return:
    */
    public static void setSession(Object key, Object value){
        Session session = getShiroSession();
        System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
        if(null != session){
            session.setAttribute(key, value);
            Object obj = session.getAttribute(key);
            if (null != obj){
            }
        }
    }
    /**
    * @Author: Gaojindan
    * @Create: 2018/3/12 下午2:56
    * @Des: 读取一个session
    * @Param:
    * @Return:
    */
//    public static String getSession(Object key){
//        Session session = getShiroSession();
//        if(null != session){
//            Object obj = session.getAttribute(key);
//            if (null != obj){
//                return obj.toString();
//            }
//        }
//        return null;
//    }
}

