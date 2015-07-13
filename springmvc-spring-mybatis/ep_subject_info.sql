/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : studyjava

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-07-13 09:22:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ep_subject_info`
-- ----------------------------
DROP TABLE IF EXISTS `ep_subject_info`;
CREATE TABLE `ep_subject_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subjectName` varchar(128) DEFAULT NULL COMMENT '学科名称',
  `subjectDesc` text COMMENT '学科描述',
  `isEnable` int(11) DEFAULT NULL COMMENT '学科状态，1启用0不启用',
  `created` varchar(25) DEFAULT NULL COMMENT '创建时间',
  `modified` varchar(26) DEFAULT NULL COMMENT '更新时间',
  `gradestageId` int(11) DEFAULT NULL COMMENT '年级ID: 有问题如果加年级ID那得存所有年级的语文',
  `version` int(11) DEFAULT NULL COMMENT '修改版本',
  `isDelete` int(11) DEFAULT NULL COMMENT '是否删除：0没有被删除，1已经删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 COMMENT='学科维护表';

-- ----------------------------
-- Records of ep_subject_info
-- ----------------------------
INSERT INTO `ep_subject_info` VALUES ('57', '语文', '小学一年级语文', '1', '2015-06-14 21:37:04', '2015-06-14 21:37:04', '28', '1', '0');
INSERT INTO `ep_subject_info` VALUES ('58', '语文', '小学一年级语文', '1', '2015-06-14 21:37:04', '2015-06-14 21:37:04', '28', '1', '0');
INSERT INTO `ep_subject_info` VALUES ('59', '语文', '小学一年级语文', '1', '2015-06-14 21:37:04', '2015-06-14 21:37:04', '28', '1', '0');
INSERT INTO `ep_subject_info` VALUES ('60', '语文', '小学一年级语文', '1', '2015-06-14 21:37:04', '2015-06-14 21:37:04', '28', '1', '0');
