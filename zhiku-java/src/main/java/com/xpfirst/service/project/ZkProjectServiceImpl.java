package com.xpfirst.service.project;

import com.xpfirst.mapper.project.ZkProjectMapper;
import com.xpfirst.model.ZkProject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (C) 北京学信科技有限公司
 *
 * @Des:
 * @Author: Gaojindan
 * @Create: 2018/3/2 下午2:32
 **/

@Service
public class ZkProjectServiceImpl implements ZkProjectService {

    @Autowired
    private ZkProjectMapper zkProjectMapper;
    /**
     * @Author: Gaojindan
     * @Create: 2018/3/2 下午2:23
     * @Des: 读取一个人的项目列表
     * @Param: createUserID:创建者
     * @Param: stateIndex:开始条数
     * @Param: pageSize:每页的数量
     * @Return: 项目列表
     */
    public List<ZkProject> selectListByCreateUserID(@Param("createUserID") String createUserID,
                                             @Param("stateIndex") Integer stateIndex,
                                             @Param("pageSize") Integer pageSize){
        return zkProjectMapper.selectListByCreateUserID(createUserID,stateIndex,pageSize);
    }
}
