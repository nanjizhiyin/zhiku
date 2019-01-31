package com.xpfirst.dao.user;

import com.xpfirst.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Long userID);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userID);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * @Author: Gaojindan
     * @Create: 2018/3/1 下午3:41
     * @Des: 通过账号和密码读取一个人的信息
     * @Param: username:账号
     * @Return: state:有效状态
     * @Return: 用户基础资料
     */
    User selectByUsername(@Param("username") String username, @Param("state") Integer state);

    /**
    * @Author: Gaojindan
    * @Create: 2018/3/1 下午3:41
     * @Des: 通过账号和密码读取一个人的信息,用于登录
     * @Param: username:账号
     * @Return: password:密码
    * @Return: 用户基础资料
    */
    User selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}