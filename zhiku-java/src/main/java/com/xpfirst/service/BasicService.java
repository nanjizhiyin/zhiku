package com.xpfirst.service;

import com.xpfirst.error.ErrorCode;
import com.xpfirst.model.result.ResultError;
import com.xpfirst.model.result.ResultSuccess;

/**
 * @Description
 * @Author 郜金丹
 * @Date 2019/1/31 10:52
 **/
public class BasicService {

    protected ResultError createError(ErrorCode exceptionCode){
        return new ResultError(exceptionCode.getCode(),exceptionCode.getMsg());
    }

    protected ResultSuccess createSuccess(Object obj) {
        return new ResultSuccess(obj);
    }
}
