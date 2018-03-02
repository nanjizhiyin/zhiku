package com.xpfirst.service.user;

import com.xpfirst.mapper.user.XfUserMapper;
import com.xpfirst.model.XfUser;
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
    private XfUserMapper xfUserMapper;
    /**
     * @Author: Gaojindan
     * @Create: 2018/2/28 上午10:27
     * @Des: 添加一个用户
     * @Param: 用户资料
     * @Return:
     */
    public void registerUser(XfUser user){
        xfUserMapper.insertSelective(user);
    }


    /**
     * @Author: Gaojindan
     * @Create: 2018/3/1 下午3:41
     * @Des: 通过账号和密码读取一个人的信息
     * @Param: username:账号
     * @Return: isEffective:有效状态
     * @Return: 用户基础资料
     */
    public XfUser selectByUsername(String username,Integer isEffective){
        return xfUserMapper.selectByUsername(username,isEffective);
    }
    /**
     * @Author: Gaojindan
     * @Create: 2018/3/1 下午3:41
     * @Des: 通过账号和密码读取一个人的ID,用于登录
     * @Param: username:账号
     * @Return: password:密码
     * @Return: 用户基础资料
     */
    public XfUser selectByUsernameAndPassword(String username,String password){
        return xfUserMapper.selectByUsernameAndPassword(username,password);
    }
}
