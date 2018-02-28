DROP TABLE IF EXISTS `xf_user`;
CREATE TABLE `xf_user` (
  `userID`      bigint(32) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username`    VARCHAR(32) NOT NULL COMMENT '用户名,支持中文',
  `password`    VARCHAR(256) NOT NULL COMMENT '密码,MD5加密',
  `createDate`  datetime NOT NULL COMMENT '创建时间',
  `isEffective` int(1) NOT NULL DEFAULT '1' COMMENT '是否有效1:有效 0:无效',
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='注册用户';