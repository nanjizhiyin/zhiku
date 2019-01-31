package com.xpfirst.service.user;

import com.xpfirst.dao.user.UserMapper;
import com.xpfirst.error.ErrorCode;
import com.xpfirst.model.User;
import com.xpfirst.model.result.ResultBean;
import com.xpfirst.model.result.ResultError;
import com.xpfirst.model.result.ResultSuccess;
import com.xpfirst.service.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C) 北京学信科技有限公司
 *
 * @Des:
 * @Author: Gaojindan
 * @Create: 2018/2/28 上午10:29
 **/
@Service
public class UserServiceImpl extends BasicService implements UserService{

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;

    /**
     * @Author: Gaojindan
     * @Create: 2018/2/28 上午10:27
     * @Des: 添加一个用户
     * @Param: 用户资料
     * @Return:
     */
    @Override
    public ResultBean register(String username, String password) throws Exception{
        int ssf = 23/0;
        if (username.length() == 0){
            logger.info("====GJD===用户名不能为空");
            return this.createError(ErrorCode.error1002);
        }
        if (password.length() == 0){
            logger.info("====GJD===密码不能为空");
            return this.createError(ErrorCode.error1003);
        }
        User tmpUser = this.selectByUsername(username,null);
        if (tmpUser != null){
            logger.info("====GJD===用户名已经存在");
            return this.createError(ErrorCode.error1001);
        }
        User user = new User();
        Date nowDate = new Date();
        user.setUsername(username);
        user.setPassword(password);
        user.setState(1);
        user.setCreateDate(nowDate);
        int tmpID = userMapper.insertSelective(user);
        return this.createSuccess(tmpID);
    }

    /**
     * @Author: Gaojindan
     * @Create: 2018/3/1 下午3:41
     * @Des: 通过账号和密码读取一个人的信息
     * @Param: username:账号
     * @Return: state:有效状态
     * @Return: 用户基础资料
     */
    @Override
    public User selectByUsername(String username, Integer state){
        return userMapper.selectByUsername(username,state);
    }

    /**
     * @Author: Gaojindan
     * @Create: 2018/3/1 下午3:41
     * @Des: 通过账号和密码读取一个人的ID,用于登录
     * @Param: username:账号
     * @Return: password:密码
     * @Return: 用户基础资料
     */
    @Override
    public ResultBean login(String username, String password) {
        try{
            if (username.length() == 0){
                logger.info("====GJD===用户名不能为空");
                return this.createError(ErrorCode.error1002);
            }
            if (password.length() == 0){
                logger.info("====GJD===密码不能为空");
                return this.createError(ErrorCode.error1003);
            }
            try {
                User user = userMapper.selectByUsernameAndPassword(username,password);
                if (user == null) {
                    logger.info("====GJD===认证失败");
                    return this.createError(ErrorCode.error1004);
                }
                // 返回数据
                Map<String, Object> tmpMap = new HashMap<>(4);
                tmpMap.put("userID", user.getUserID());
                tmpMap.put("username", user.getUsername());
                tmpMap.put("token", user.getUserID());
                return this.createSuccess(tmpMap);

            } catch (Exception e){
                logger.info("====GJD===认证失败");
                return this.createError(ErrorCode.error1001);
            }
        }
        catch (Exception e){
            logger.info("====错误==="+e.toString());
            return this.createError(ErrorCode.error1001);
        }
    }
}
