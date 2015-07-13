/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : studyjava

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-07-13 12:56:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('8', '张三', '45', '北京');
INSERT INTO `t_user` VALUES ('11', '李四', '24', '上海');
INSERT INTO `t_user` VALUES ('14', '王五', '24', '上海');
INSERT INTO `t_user` VALUES ('15', '李四', '24', '上海');
INSERT INTO `t_user` VALUES ('16', '李四', '24', '上海');
INSERT INTO `t_user` VALUES ('17', '李四2', '24', '上海');
