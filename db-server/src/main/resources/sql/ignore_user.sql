CREATE TABLE `ignore_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
   `age` int(3) NOT NULL  COMMENT '用户年龄',
  `name` char(10) NOT NULL COMMENT '印刷号码通常也叫投保单号',
  PRIMARY KEY (`user_id`),
  KEY `index_name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='用户表';