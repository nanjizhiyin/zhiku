package com.xpfirst.service.user;

import com.xpfirst.dao.user.UserMapper;
import com.xpfirst.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright (C) 北京学信科技有限公司
 *
 * @Des:
 * @Author: Gaojindan
 * @Create: 2018/2/28 上午10:29
 **/
@Service
public class UserServiceImpl implements UserService{

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
    public void registerUser(User user){
        userMapper.insertSelective(user);
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
    public User selectByUsernameAndPassword(String username, String password){
        return userMapper.selectByUsernameAndPassword(username,password);
    }
}
