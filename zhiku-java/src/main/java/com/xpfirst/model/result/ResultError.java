package com.xpfirst.model.result;

/**
 * Copyright (C) 北京学信科技有限公司
 *
 * @Des:
 * @Author: Gaojindan
 * @Create: 2018/2/28 下午2:54
 **/
public class ResultError extends ResultBean {
    public ResultError(String errorcode, String errormsg){
        this.setErrorcode(errorcode);
        this.setErrormsg(errormsg);
    }
}
