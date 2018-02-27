package com.xpfirst.controller;

import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping(value = "hello")
    public String getAllStudent() {
        return "FASDFASDFQWEW";
    }
}
