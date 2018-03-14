package com.xpfirst.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class XfUser implements Serializable {
    private Long userID;

    private String username;

    private String password;

    private Date createDate;

    private String salt;//加密密码的盐
    private Integer state;

    private List<XfRole> roleList;//权限列表

    public List<XfRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<XfRole> roleList) {
        this.roleList = roleList;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}