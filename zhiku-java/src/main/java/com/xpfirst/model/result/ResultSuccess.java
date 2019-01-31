package com.xpfirst.model.result;

/**
 * Copyright (C) 北京学信科技有限公司
 *
 * @Des:
 * @Author: Gaojindan
 * @Create: 2018/2/28 下午2:51
 **/
public class ResultSuccess extends ResultBean {
    public ResultSuccess(Object obj){
        this.setCode("0");
        this.setMsg("系统正常");
        this.setData(obj);
        System.out.print(this.toString());
    }
}
