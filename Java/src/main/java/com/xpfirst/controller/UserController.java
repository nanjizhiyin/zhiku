package com.xpfirst.controller;

import com.mysql.fabric.xmlrpc.base.Data;
import com.xpfirst.model.XfUser;
import com.xpfirst.model.result.ResultBean;
import com.xpfirst.model.result.ResultError;
import com.xpfirst.model.result.ResultSuccess;
import com.xpfirst.service.user.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
            XfUser user = new XfUser();
            Date nowDate = new Date();
            user.setUsername(username);
            user.setPassword(password);
            user.setIsEffective(1);
            user.setCreateDate(nowDate);
            userService.addUser(user);
            return new ResultSuccess("创建成功");
        }
        catch (Exception e){
            log.info("====错误==="+e.toString());
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
            XfUser user = userService.loginByUsernameAndPassword(username,password);
            return new ResultSuccess(user);
        }
        catch (Exception e){
            log.info("====错误==="+e.toString());
            return new ResultError("xf-0001",e.toString());
        }
    }
}
