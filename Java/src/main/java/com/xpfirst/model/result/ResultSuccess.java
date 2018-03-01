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
        this.setErrorcode("0");
        this.setResult(obj);
    }
}
