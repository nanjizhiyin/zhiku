package com.xpfirst.model.result;

/**
 * Copyright (C) 北京学信科技有限公司
 *
 * @Des:
 * @Author: Gaojindan
 * @Create: 2018/2/28 下午2:48
 **/
public class ResultBean {

    //错误代码 0:没有错误
    private String code;
    //错误信息
    private String msg;
    //返回的数据
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString(){
        String tmpStr = "code = " + code + ",msg = "+msg + ",data = " + String.valueOf(data);
        return tmpStr;
    }
}
