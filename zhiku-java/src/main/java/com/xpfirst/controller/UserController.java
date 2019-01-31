package com.xpfirst.controller;

import com.xpfirst.model.*;
import com.xpfirst.model.result.*;
import com.xpfirst.service.user.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "register")
    public ResultBean register(@RequestParam(required = true) String username,
                               @RequestParam(required = true) String password) throws Exception{

        return userService.register(username,password);
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
        return userService.login(username,password);
    }
    @RequestMapping("logout")
    public ResultBean logout(){
        return new ResultError("xf-1002","退出成功");
    }
}
