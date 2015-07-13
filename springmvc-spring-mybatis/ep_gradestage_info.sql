/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : studyjava

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-07-13 11:31:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ep_gradestage_info`
-- ----------------------------
DROP TABLE IF EXISTS `ep_gradestage_info`;
CREATE TABLE `ep_gradestage_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gName` varchar(128) DEFAULT NULL COMMENT '名称',
  `description` text COMMENT '描述',
  `isEnable` int(11) DEFAULT NULL COMMENT '是否启用:0不启用，1启用',
  `parentId` int(11) DEFAULT NULL COMMENT '父ID',
  `createDate` varchar(26) DEFAULT NULL COMMENT '创建时间',
  `updateDate` varchar(26) DEFAULT NULL COMMENT '更新时间',
  `isDelete` int(11) DEFAULT NULL COMMENT '是否删除：0没有被删除，1已经删除',
  `version` int(11) DEFAULT NULL COMMENT '修改版本',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='学段年级表';

-- ----------------------------
-- Records of ep_gradestage_info
-- ----------------------------
INSERT INTO `ep_gradestage_info` VALUES ('1', '小学', '小学学段', '1', '0', '2015-06-14 21:27:28', '2015-06-14 21:27:28', '0', '1');
INSERT INTO `ep_gradestage_info` VALUES ('2', '初中', '初中学段', '1', '0', '2015-06-14 21:27:49', '2015-06-14 21:27:49', '0', '1');
INSERT INTO `ep_gradestage_info` VALUES ('3', '高中', '高中学段', '1', '0', '2015-06-14 21:28:23', '2015-06-14 21:28:23', '0', '1');
INSERT INTO `ep_gradestage_info` VALUES ('28', '一年级', '小学一年级', '1', '1', '2015-06-14 21:29:06', '2015-06-14 21:29:06', '0', '1');
INSERT INTO `ep_gradestage_info` VALUES ('29', '二年级', '小学二年级', '1', '1', '2015-06-14 21:29:23', '2015-06-14 21:31:51', '1', '2');
INSERT INTO `ep_gradestage_info` VALUES ('30', '三年级', '小学三年级', '1', '1', '2015-06-14 21:29:40', '2015-06-14 21:31:40', '0', '2');
INSERT INTO `ep_gradestage_info` VALUES ('31', '四年级', '小学四年级', '1', '1', '2015-06-14 21:29:58', '2015-06-14 21:29:58', '0', '1');
INSERT INTO `ep_gradestage_info` VALUES ('32', '五年级', '小学五年级', '1', '1', '2015-06-14 21:30:19', '2015-06-14 21:30:19', '0', '1');
INSERT INTO `ep_gradestage_info` VALUES ('33', '六年级', '小学六年级', '1', '1', '2015-06-14 21:30:37', '2015-06-14 21:30:37', '0', '1');
INSERT INTO `ep_gradestage_info` VALUES ('34', '初一', '初中初一', '1', '2', '2015-06-14 21:30:59', '2015-06-14 21:31:59', '0', '2');
INSERT INTO `ep_gradestage_info` VALUES ('35', '初二', '初中初二', '1', '2', '2015-06-14 21:31:13', '2015-06-14 21:32:06', '0', '2');
INSERT INTO `ep_gradestage_info` VALUES ('36', '初三', '初中初三', '1', '2', '2015-06-14 21:31:31', '2015-06-14 21:31:31', '0', '1');
INSERT INTO `ep_gradestage_info` VALUES ('37', '高一', '高中高一', '1', '3', '2015-06-14 21:32:54', '2015-06-14 21:33:36', '0', '2');
INSERT INTO `ep_gradestage_info` VALUES ('38', '高二', '高中高二', '1', '3', '2015-06-14 21:33:11', '2015-06-14 21:33:41', '0', '2');
INSERT INTO `ep_gradestage_info` VALUES ('39', '高三', '高中高三', '1', '3', '2015-06-14 21:33:32', '2015-06-14 21:33:32', '0', '1');
INSERT INTO `ep_gradestage_info` VALUES ('41', '高中111111111111111111', '小学阶段学段', '1', '0', '2015-05-26', '2015-05-26', '0', '1');
