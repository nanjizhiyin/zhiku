package com.xpfirst.model.result;

/**
 * Copyright (C) 北京学信科技有限公司
 *
 * @Des:
 * @Author: Gaojindan
 * @Create: 2018/2/28 下午2:54
 **/
public class ResultError extends ResultBean {
    public ResultError(String code, String msg){
        this.setCode(code);
        this.setMsg(msg);
        System.out.print("返回结果:" + this.toString());
    }
}
