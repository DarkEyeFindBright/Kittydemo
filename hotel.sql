/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : hotel

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2020-09-05 15:07:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for appinfo
-- ----------------------------
DROP TABLE IF EXISTS `appinfo`;
CREATE TABLE `appinfo` (
  `appId` int(3) NOT NULL,
  `guestId` int(6) NOT NULL,
  `guestName` varchar(255) NOT NULL,
  `roomId` int(3) NOT NULL,
  `appDate` date NOT NULL,
  PRIMARY KEY (`appId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appinfo
-- ----------------------------
INSERT INTO `appinfo` VALUES ('1', '1', '1', '1', '2020-09-05');
INSERT INTO `appinfo` VALUES ('9', '9', '9', '4', '2020-09-12');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `manageId` int(6) NOT NULL,
  `manageName` varchar(255) NOT NULL,
  `managePass` varchar(32) NOT NULL,
  PRIMARY KEY (`manageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('111', '111', '111');

-- ----------------------------
-- Table structure for roominfo
-- ----------------------------
DROP TABLE IF EXISTS `roominfo`;
CREATE TABLE `roominfo` (
  `roomId` int(3) NOT NULL,
  `status` int(1) NOT NULL,
  `roomdate` date DEFAULT NULL,
  PRIMARY KEY (`roomId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roominfo
-- ----------------------------
INSERT INTO `roominfo` VALUES ('1', '0', '2020-09-05');
INSERT INTO `roominfo` VALUES ('4', '0', '2020-09-12');

-- ----------------------------
-- Table structure for staffinfo
-- ----------------------------
DROP TABLE IF EXISTS `staffinfo`;
CREATE TABLE `staffinfo` (
  `staffId` int(6) NOT NULL AUTO_INCREMENT,
  `staffName` varchar(255) NOT NULL,
  `birthday` date NOT NULL,
  `phone` int(11) NOT NULL,
  PRIMARY KEY (`staffId`)
) ENGINE=InnoDB AUTO_INCREMENT=111113 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staffinfo
-- ----------------------------
INSERT INTO `staffinfo` VALUES ('111', 'ss', '2020-09-01', '1110');
INSERT INTO `staffinfo` VALUES ('100001', 'dog', '2020-09-02', '1111111111');
INSERT INTO `staffinfo` VALUES ('111112', 'kitty', '2020-09-03', '111');
