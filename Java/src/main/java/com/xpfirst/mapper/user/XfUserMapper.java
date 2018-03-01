package com.xpfirst.mapper.user;

import com.xpfirst.model.XfUser;
import org.apache.ibatis.annotations.Mapper;

public interface XfUserMapper {
    int deleteByPrimaryKey(Long userID);

    int insert(XfUser record);

    int insertSelective(XfUser record);

    XfUser selectByPrimaryKey(Long userID);

    int updateByPrimaryKeySelective(XfUser record);

    int updateByPrimaryKey(XfUser record);

    /**
    * @Author: Gaojindan
    * @Create: 2018/3/1 下午3:41
    * @Des: 通过账号和密码读取一个人的ID,用于登录
     * @Param: username:账号
     * @Return: password:密码
    * @Return: 用户基础资料
    */
    XfUser selectByUsernameAndPassword(String username,String password);
}