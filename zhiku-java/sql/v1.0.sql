/*表结构插入*/
DROP TABLE IF EXISTS `xf_u_permission`;

CREATE TABLE `xf_permission` (
  `permissionID` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(256) DEFAULT NULL COMMENT 'url地址',
  `des` varchar(64) DEFAULT NULL COMMENT 'url描述',
  PRIMARY KEY (`permissionID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Table structure for table `u_role` */

DROP TABLE IF EXISTS `xf_role`;

CREATE TABLE `xf_role` (
  `roleID` bigint(20) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `type` varchar(10) DEFAULT NULL COMMENT '角色类型',
  PRIMARY KEY (`roleID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `u_role_permission` */

DROP TABLE IF EXISTS `xf_role_permission`;

CREATE TABLE `xf_role_permission` (
  `roleID` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `permissionID` bigint(20) DEFAULT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `u_user_role` */

DROP TABLE IF EXISTS `xf_user_role`;

CREATE TABLE `xf_user_role` (
  `userID` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `roleID` bigint(20) DEFAULT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 用户列表
DROP TABLE IF EXISTS `xf_user`;
CREATE TABLE `xf_user` (
  `userID`      bigint(32) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username`    VARCHAR(32) NOT NULL COMMENT '用户名',
  `password`    VARCHAR(256) NOT NULL COMMENT '密码,MD5加密',
  `nickname` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱|登录帐号',
  `createDate`  datetime NOT NULL COMMENT '创建时间',
  `state` int(3) NOT NULL DEFAULT '1' COMMENT '状态值1:有效 0:无效',
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='注册用户';

# 项目列表
DROP TABLE IF EXISTS `zk_project`;
CREATE TABLE `zk_project` (
  `projectID`   bigint(32) NOT NULL AUTO_INCREMENT COMMENT '项目ID',
  `projectName` VARCHAR(256) NOT NULL COMMENT '项目名称',
  `createUserID`      bigint(32) NOT NULL COMMENT '创建者的ID',
  `createDate`  datetime NOT NULL COMMENT '创建时间',
  `state` int(3) NOT NULL DEFAULT '1' COMMENT '状态值1:有效 0:无效',
  PRIMARY KEY (`projectID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='智库项目列表';

# 数据表信息
DROP TABLE IF EXISTS `zk_table`;
CREATE TABLE `zk_table` (
  `tableID`   bigint(32) NOT NULL AUTO_INCREMENT COMMENT '项目ID',
  `projectID`   bigint(32) NOT NULL COMMENT '项目ID',
  `field`   VARCHAR(256) NOT NULL COMMENT '字段',
  `type`   VARCHAR(256) NOT NULL COMMENT '字段类型',
  `createDate`  datetime NOT NULL COMMENT '创建时间',
  `state` int(3) NOT NULL DEFAULT '1' COMMENT '状态值1:有效 0:无效',
  PRIMARY KEY (`tableID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='数据表';

# 数据表的字段
DROP TABLE IF EXISTS `zk_table_field`;
CREATE TABLE `zk_table_field` (
  `fieldID`   bigint(32) NOT NULL AUTO_INCREMENT COMMENT '字段ID',
  `tableID`   bigint(32) NOT NULL COMMENT '表ID',
  `fieldName`   VARCHAR(256) NOT NULL COMMENT '字段',
  `dataType`   VARCHAR(256) NOT NULL COMMENT '数据类型',
  `length`   bigint(3) NOT NULL COMMENT '数据长度',
  `p`   TINYINT(1) NOT NULL COMMENT 'primary key 主键',
  `f`   TINYINT(1) NOT NULL COMMENT 'foreign key 外键',
  `m`   TINYINT(1) NOT NULL COMMENT 'mandatory 非空',
  `createDate`  datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`fieldID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='数据表的字段';