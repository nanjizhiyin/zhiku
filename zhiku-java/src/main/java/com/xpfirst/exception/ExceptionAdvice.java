package com.xpfirst.exception;

import com.sun.org.apache.bcel.internal.classfile.Constant;
import com.xpfirst.error.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author 郜金丹
 * @Date 2019/1/31 11:49
 **/

@ControllerAdvice
public class ExceptionAdvice {
    private static Logger logger = LoggerFactory.getLogger(Exception.class);

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map<String, Object> errorHandler(Exception ex) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", ErrorCode.error0001.getCode());
        map.put("msg", ErrorCode.error0001.getMsg());
        logger.error("捕捉到全局异常(Exception),msg:{}", map.get("msg"), ex);
        return map;
    }
}
