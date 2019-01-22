package com.xpfirst.controller;

import com.xpfirst.model.ZkProject;
import com.xpfirst.model.result.ResultBean;
import com.xpfirst.model.result.ResultError;
import com.xpfirst.model.result.ResultSuccess;
import com.xpfirst.service.project.ZkProjectService;
import com.xpfirst.service.user.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Copyright (C) 北京学信科技有限公司
 *
 * @Des:
 * @Author: Gaojindan
 * @Create: 2018/3/2 上午10:54
 **/

@RestController
@RequestMapping("project")
public class ProjectController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private ZkProjectService zkProjectService;

    /**
    * @Author: Gaojindan
    * @Create: 2018/3/2 上午11:00
    * @Des: 获取项目列表
     * @Param: page:页码
     * @Param: pageSize:每页的数量
    * @Return:
    */
    @RequestMapping(value = "list")
    public ResultBean projectlist(@RequestParam(required = true) Integer page,
                                  @RequestParam(required = true) Integer pageSize,
                                  @RequestParam(required = true) Long userID
                                  ) {
        try{
            List<ZkProject> tmpList = zkProjectService.selectListByCreateUserID(userID,(page - 1)*pageSize,pageSize);
            return new ResultSuccess(tmpList);
        }
        catch (Exception e){
            log.info("====GJD==="+e.toString());
            return new ResultError("xf-0001",e.toString());
        }
    }
    /**
    * @Author: Gaojindan
    * @Create: 2018/3/13 下午4:44
    * @Des: 获取一个项目的详情
    * @Param: projectID: 项目ID
    * @Return:
    */
    @RequestMapping(value = "{projectID}/info")
    public ResultBean projectinfo(@PathVariable("projectID") Long projectID) {
        try{
            String userID = "111111";
            ZkProject zkProject = zkProjectService.selectInfoByProjectID(projectID);
            return new ResultSuccess(zkProject);
        }
        catch (Exception e){
            log.info("====GJD==="+e.toString());
            return new ResultError("xf-0001",e.toString());
        }
    }
    @RequestMapping(value = "{projectID}/save" , method = RequestMethod.PUT)
    public ResultBean save(@PathVariable("projectID") Long projectID) {
        try{
            log.info("====projectID="+projectID);
            String userID = "111111";
            return new ResultSuccess(userID);
        }
        catch (Exception e){
            log.info("====GJD==="+e.toString());
            return new ResultError("xf-0001",e.toString());
        }
    }
}
