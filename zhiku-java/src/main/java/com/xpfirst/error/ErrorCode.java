package com.xpfirst.error;

/**
 * @Description
 * @Author 郜金丹
 * @Date 2019/1/31 10:09
 **/
public enum ErrorCode {

    error("0","系统正常"),
    error0001("0001","系统错误"),
    error1001("1001","用户名已经存在"),
    error1002("1002","用户名不能为空"),
    error1003("1003","密码不能为空"),
    error1004("1004","用户不存在"),
    ;
    // 出错编码
    private String code="0";
    // 出错消息
    private String msg="系统正常";

    private ErrorCode(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
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
}
