/*
Navicat MySQL Data Transfer

Source Server         : testTy
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : webdb

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-01-05 17:38:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `AdminID` int(11) NOT NULL AUTO_INCREMENT,
  `AdminName` varchar(32) CHARACTER SET gbk DEFAULT NULL,
  `AdminPwd` varchar(64) CHARACTER SET gbk DEFAULT NULL,
  `AdminType` smallint(6) DEFAULT NULL,
  `LastLoginTime` varchar(50) CHARACTER SET gbk DEFAULT NULL,
  PRIMARY KEY (`AdminID`)
) ENGINE=InnoDB AUTO_INCREMENT=1205022503 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'ty', 'tysoft', '0', '2017-01-01');
INSERT INTO `admin` VALUES ('20170001', '20170001', '123456', '1', null);
INSERT INTO `admin` VALUES ('20170002', '1205022533', '092608', '1', null);
INSERT INTO `admin` VALUES ('1205022502', 'tyfans1', '123456', '2', null);

-- ----------------------------
-- Table structure for `bandrelation`
-- ----------------------------
DROP TABLE IF EXISTS `bandrelation`;
CREATE TABLE `bandrelation` (
  `bandId` int(11) NOT NULL AUTO_INCREMENT,
  `leader` varchar(32) DEFAULT NULL,
  `bandName` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL,
  `slogan` longtext CHARACTER SET utf8mb4,
  `createTime` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`bandId`)
) ENGINE=InnoDB AUTO_INCREMENT=20170007 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of bandrelation
-- ----------------------------
INSERT INTO `bandrelation` VALUES ('20170001', '陶宇', 'SuperSuperHandsome', 'we are changing the world', null);
INSERT INTO `bandrelation` VALUES ('20170002', '马哲燚', 'BuleBuleSky', 'happy! happy!', null);
INSERT INTO `bandrelation` VALUES ('20170003', '杜鹏儿子', 'DP', 'handsome', '2018-01-03 14:04');

-- ----------------------------
-- Table structure for `fans`
-- ----------------------------
DROP TABLE IF EXISTS `fans`;
CREATE TABLE `fans` (
  `fansId` int(11) NOT NULL,
  `fansName` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8mb4 DEFAULT NULL,
  `loveBand` int(11) DEFAULT NULL,
  `loveMember` longtext CHARACTER SET utf8mb4,
  PRIMARY KEY (`fansId`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of fans
-- ----------------------------
INSERT INTO `fans` VALUES ('1205022501', '周杰伦的脑残粉1号', '男', '20170001', '1562410221');
INSERT INTO `fans` VALUES ('1205022502', '特特', '男', '20170001', '1562410222');

-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `memberPicture` varchar(50) CHARACTER SET utf8mb4 DEFAULT 'img/c1.jpg',
  `MemberName` varchar(32) DEFAULT NULL,
  `MemberId` int(11) NOT NULL,
  `BandBelong` int(11) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `Workshare` longtext,
  `JoinTime` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL,
  `LeaveTime` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`MemberId`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('img/c2.jpg', '西瓜', '156241000', '20170003', '女', '钢琴师', '2017-02-03', null);
INSERT INTO `member` VALUES ('img/c1.jpg', 'taoyu', '1562410221', '20170001', '男', '吉他手', '2017-01-01', '2017-02-01');
INSERT INTO `member` VALUES ('img/c1.jpg', '苗益毓', '1562410222', '20170002', '男', '贝斯手', '2017-02-03', null);
