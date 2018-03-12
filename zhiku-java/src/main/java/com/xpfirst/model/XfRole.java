package com.xpfirst.model;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright (C) 北京学信科技有限公司
 *
 * @Des:
 * @Author: Gaojindan
 * @Create: 2018/3/7 上午10:03
 **/
public class XfRole implements Serializable {
    private Long roleID;
    private String rolename;//角色名称
    private String type;//角色类型
    private List<XfPermission> permissionList;//权限列表

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<XfPermission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<XfPermission> permissionList) {
        this.permissionList = permissionList;
    }

}
