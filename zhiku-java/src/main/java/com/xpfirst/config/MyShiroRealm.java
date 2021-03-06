package com.xpfirst.config;

import com.xpfirst.model.Permission;
import com.xpfirst.model.Role;
import com.xpfirst.model.User;
import com.xpfirst.service.user.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * Copyright (C) 北京学信科技有限公司
 *
 * @Des: 自定义权限匹配和账号密码匹配
 * @Author: Gaojindan
 * @Create: 2018/3/7 上午9:38
 **/

public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {

        //实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的
        //获取用户的输入的账号.
        String username = (String) token.getPrincipal();
        User userInfo = userService.selectByUsername(username,null);
        if (userInfo == null) {
            throw new AuthenticationException("不存在");
        }
        if (userInfo.getState() == 0) { //账户冻结
            throw new AuthenticationException("账户冻结");
        }
        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(
                userInfo.getUsername(),
                userInfo.getPassword(),
                this.getName());
        //保存用户ID
        SessionManager.setSession(SessionManager.currentUser, userInfo.getUsername());

        return authcInfo;
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User userInfo = (User) principals.getPrimaryPrincipal();
        for (Role role : userInfo.getRoleList()) {
            authorizationInfo.addRole(role.getRolename());
            for (Permission p : role.getPermissionList()) {
                authorizationInfo.addStringPermission(p.getUrl());
            }
        }
        return authorizationInfo;
    }


}
