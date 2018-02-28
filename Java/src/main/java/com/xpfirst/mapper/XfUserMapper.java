package com.xpfirst.mapper;

import com.xpfirst.model.XfUser;

public interface XfUserMapper {
    int deleteByPrimaryKey(Long userID);

    int insert(XfUser record);

    int insertSelective(XfUser record);

    XfUser selectByPrimaryKey(Long userID);

    int updateByPrimaryKeySelective(XfUser record);

    int updateByPrimaryKey(XfUser record);
}