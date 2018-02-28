package com.xpfirst.controller;

import com.mysql.fabric.xmlrpc.base.Data;
import com.xpfirst.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "register")
    public String register(@RequestParam(required = true) String username,
                           @RequestParam(required = true) String password) {
        User user = new User();
        Data nowData = new Data();
        user.setUsername(username);
        user.setPassword(password);
        user.setIsEffective(1);
        user.setCreateData(nowData);
        return "FASDFASDFQWEW";
    }
}
