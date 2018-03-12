package com.xpfirst.config;

import com.xpfirst.model.XfPermission;
import com.xpfirst.model.XfRole;
import com.xpfirst.model.XfUser;
import com.xpfirst.service.user.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

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
        //获取用户的输入的账号.
        String username = (String) token.getPrincipal();
        XfUser userInfo = userService.selectByUsername(username,null);
        if (userInfo == null) {
            return null;
        }
        if (userInfo.getIsEffective() == 0) { //账户冻结
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.getState()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        XfUser userInfo = (XfUser) principals.getPrimaryPrincipal();
        for (XfRole role : userInfo.getRoleList()) {
            authorizationInfo.addRole(role.getRolename());
            for (XfPermission p : role.getPermissionList()) {
                authorizationInfo.addStringPermission(p.getUrl());
            }
        }
        return authorizationInfo;
    }


}
