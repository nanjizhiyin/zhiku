package com.xpfirst.service.project;

import com.xpfirst.model.ZkProject;

import java.util.List;

/**
 * Copyright (C) 北京学信科技有限公司
 *
 * @Des:
 * @Author: Gaojindan
 * @Create: 2018/3/2 下午2:32
 **/
public interface ZkProjectService {

    /**
     * @Author: Gaojindan
     * @Create: 2018/3/2 下午2:23
     * @Des: 读取一个人的项目列表
     * @Param: createUserID:创建者
     * @Param: stateIndex:开始条数
     * @Param: pageSize:每页的数量
     * @Return: 项目列表
     */
    public List<ZkProject> selectListByCreateUserID(Long createUserID,Integer stateIndex,Integer pageSize);

    /**
     * @Author: Gaojindan
     * @Create: 2018/3/13 下午4:44
     * @Des: 获取一个项目的详情
     * @Param: projectID: 项目ID
     * @Return: 项目资料
     */
    public ZkProject selectInfoByProjectID(Long projectID);
}
