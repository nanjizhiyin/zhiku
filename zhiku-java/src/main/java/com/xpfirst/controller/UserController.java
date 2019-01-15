package com.xpfirst.controller;

import com.sun.deploy.net.HttpResponse;
import com.xpfirst.model.XfUser;
import com.xpfirst.model.result.ResultBean;
import com.xpfirst.model.result.ResultError;
import com.xpfirst.model.result.ResultSuccess;
import com.xpfirst.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C) 北京学信科技有限公司
 *
 * @Des:
 * @Author: Gaojindan
 * @Create: 2018/2/27 下午4:16
 **/

@RestController
@RequestMapping("user")
public class UserController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "register")
    public ResultBean register(@RequestParam(required = true) String username,
                               @RequestParam(required = true) String password) {
        try{
            if (username.length() == 0){
                log.info("====GJD===用户名不能为空");
                return new ResultError("xf-1002","用户名不能为空");
            }
            if (password.length() == 0){
                log.info("====GJD===密码不能为空");
                return new ResultError("xf-1003","密码不能为空");
            }
            XfUser tmpUser = userService.selectByUsername(username,null);
            if (tmpUser != null){
                log.info("====GJD===用户名已经存在");
                return new ResultError("xf-1001","用户名已经存在");
            }
            XfUser user = new XfUser();
            Date nowDate = new Date();
            user.setUsername(username);
            user.setPassword(password);
            user.setState(1);
            user.setCreateDate(nowDate);
            userService.registerUser(user);
            return new ResultSuccess("创建成功");
        }
        catch (Exception e){
            log.info("====GJD==="+e.toString());
            return new ResultError("xf-0001",e.toString());
        }
    }
    /**
    * @Author: Gaojindan
    * @Create: 2018/3/1 下午3:12
    * @Des: 用户登录
    * @Param: username:账号
    * @Return: password:密码
    */
    @RequestMapping(value = "login")
    public ResultBean login(@RequestParam(required = true) String username,
                            @RequestParam(required = true) String password) {
        try{
            if (username.length() == 0){
                log.info("====GJD===用户名不能为空");
                return new ResultError("xf-1002","用户名不能为空");
            }
            if (password.length() == 0){
                log.info("====GJD===密码不能为空");
                return new ResultError("xf-1003","密码不能为空");
            }
            try {
                String captcha = "yanzhengma";
                UsernamePasswordToken token = new UsernamePasswordToken(username, password, captcha);
                Subject currentUser = SecurityUtils.getSubject();
                currentUser.login(token);
                XfUser xfUser = userService.selectByUsername(username,1);
                if (xfUser == null) {
                    return new ResultError("xf-1001","认证失败");
                }
                // 返回数据
                Map<String, Object> tmpMap = new HashMap<>(4);
                tmpMap.put("userID",xfUser.getUserID());
                tmpMap.put("username",xfUser.getUsername());
                tmpMap.put("token",xfUser.getUserID());
                return new ResultSuccess(tmpMap);

            } catch (AuthenticationException e){
                log.info("====GJD===认证失败");
                return new ResultError("xf-1001","认证失败");
            }
        }
        catch (Exception e){
            log.info("====错误==="+e.toString());
            return new ResultError("xf-0001",e.toString());
        }
    }
    @RequestMapping("logout")
    public ResultBean logout(){
        SecurityUtils.getSubject().logout();
        return new ResultError("xf-1002","退出成功");
    }
}
