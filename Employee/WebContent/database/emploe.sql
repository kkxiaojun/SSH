/*
MySQL Data Transfer
Source Host: localhost
Source Database: test
Target Host: localhost
Target Database: test
Date: 2016-8-15 ���� 01:55:22
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for dept
-- ----------------------------
CREATE TABLE `dept` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `daddr` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `dnumber` int(11) DEFAULT NULL,
  `eid` int(11) DEFAULT NULL,
  `dstatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`did`),
  KEY `dept_eid` (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=5556 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for emploe
-- ----------------------------
CREATE TABLE `emploe` (
  `eid` int(11) NOT NULL DEFAULT '0',
  `ename` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `esex` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `ebir` date DEFAULT NULL,
  `emarry` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `ephone` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `eaddr` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `did` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `eedu` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `esalary` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `epassword` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `ephoto` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `equestion` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `eanswer` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `estatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `emploe_did` (`did`),
  KEY `empoe_pid` (`pid`),
  CONSTRAINT `emploe_did` FOREIGN KEY (`did`) REFERENCES `dept` (`did`),
  CONSTRAINT `empoe_pid` FOREIGN KEY (`pid`) REFERENCES `post` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
CREATE TABLE `manager` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `mname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `mpassword` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `mpower` int(11) DEFAULT NULL,
  `mstatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for message
-- ----------------------------
CREATE TABLE `message` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `mtitle` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `mcontent` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `mtime` date DEFAULT NULL,
  `muser` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `mstatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for post
-- ----------------------------
CREATE TABLE `post` (
  `pid` int(11) NOT NULL DEFAULT '0',
  `pname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `pstatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '市场部', '东门', '100', '1101', '1');
INSERT INTO `dept` VALUES ('2', '技术部', '东门', '80', '1102', '1');
INSERT INTO `dept` VALUES ('3', '财务部', '西门', '50', '1103', '1');
INSERT INTO `dept` VALUES ('4', '人事部', '北门', '20', '1108', '1');
INSERT INTO `dept` VALUES ('5', '搞笑部', '武汉', '1', '1104', '1');
INSERT INTO `dept` VALUES ('7', '音乐部', '墨尔本', '1', '1109', '1');
INSERT INTO `dept` VALUES ('56', 'uasdjkas', 'adsck', '11', '1105', '1');
INSERT INTO `dept` VALUES ('5555', '5555', '5555', '5555', '1108', '1');
INSERT INTO `emploe` VALUES ('1101', 'sdasdw', '男', '2016-08-04', '已婚', '1324357847587', 'sff', '3', '2014', '高中', '0.0', '1101', '../images/photo/photo16.png', 'qq', '123456', '0');
INSERT INTO `emploe` VALUES ('1102', '赵六', '男', '2016-08-05', '已婚', '13266545871', '金融港adong', '2', '2012', '专科', '8000', '1102', '../images/photo/photo8.png', 'tel', '13297939390', '0');
INSERT INTO `emploe` VALUES ('1103', '张三', '男', '2016-08-09', '未婚', '13293939393', '金融港', '4', '2011', '本科', '5000', '1102', '../images/photo/photo12.png', 'qq', '123456', '1');
INSERT INTO `emploe` VALUES ('1104', '陈小小', '女', '2016-08-15', '未婚', '110', '光谷', '1', '2011', '硕士', '8000', '1102', '../images/photo/photo13.png', 'sd', 'sdas', '1');
INSERT INTO `emploe` VALUES ('1105', 'mei', '男', '2016-08-10', '未婚', '00000', '光谷', '3', '2011', '硕士', '1000', '1102', '../images/photo/photo13.png', 'ele', 'dsd', '1');
INSERT INTO `emploe` VALUES ('1107', '陈楚生', '男', '2015-01-01', '已婚', '12121', '深圳', '3', '2016', '本科', '700', '1102', '../images/photo/photo18.png', 'qq', '11111', '1');
INSERT INTO `emploe` VALUES ('1108', '王力宏', '男', '1992-08-09', '未婚', '1211', '北京', '2', '2011', '本科', '70000', '1102', '../images/photo/photo18.png', 'qq', '111', '1');
INSERT INTO `emploe` VALUES ('1109', 'cosplay', '男', '1987-07-06', '已婚', '0000', '英国', '1', '2011', '硕士', '7000000', '1102', '../images/photo/photo18.png', '什么', '鬼', '1');
INSERT INTO `emploe` VALUES ('1110', '123', null, null, null, null, null, null, null, null, null, '123', null, '123', '123', '0');
INSERT INTO `emploe` VALUES ('1152', '姓名', '男', '2016-08-11', '未婚', '13297939390', '武汉金融港', '2', '2013', '本科', '11250', null, null, null, null, '1');
INSERT INTO `emploe` VALUES ('2222', '2222', null, null, null, null, null, null, null, null, null, '2222', null, null, null, '1');
INSERT INTO `emploe` VALUES ('5555', 'woowk ', '男', '2016-08-15', '已婚', '13297939390', 'dasd', '2', '2011', '小学', '13156', null, null, null, null, '0');
INSERT INTO `emploe` VALUES ('11111', '11111', null, null, null, null, null, null, null, null, null, '123', null, null, null, '1');
INSERT INTO `emploe` VALUES ('11112', '11112', null, null, null, null, null, null, null, null, null, '11112', null, null, null, '1');
INSERT INTO `manager` VALUES ('1', 'admin', '110', '7', '1');
INSERT INTO `message` VALUES ('1', '投诉', '举报', '2016-08-08', '张三', '0');
INSERT INTO `message` VALUES ('2', '记得', '还记得我们第一次见面', '2016-07-07', '王五', '0');
INSERT INTO `message` VALUES ('3', 'bangbangbang', '111', '2016-08-09', 'bang', '1');
INSERT INTO `message` VALUES ('4', '发布消息', '通知所有人下午开会！', '2016-08-09', '超级管理员', '1');
INSERT INTO `message` VALUES ('5', '唯一', '你是我触碰的唯一', '2016-08-09', 'wuli', '1');
INSERT INTO `message` VALUES ('6', '哦哦哦', '哦哦哦 哦', '2016-08-09', '哦哦哦', '0');
INSERT INTO `message` VALUES ('7', 'love', '情人节快乐！', '2016-08-09', '主席', '1');
INSERT INTO `message` VALUES ('8', '我的狗粮不见了', '谁偷走了我的狗粮！', '2016-08-09', '狗粮', '1');
INSERT INTO `message` VALUES ('9', '在座各位', '各位都是垃圾！', '2016-08-09', '恕我直言', '1');
INSERT INTO `message` VALUES ('10', 'touch me like you ', 'what are you waiting for!', '2016-08-09', 'like you do', '1');
INSERT INTO `message` VALUES ('11', '1212', '1212', '2016-08-11', '1212', '1');
INSERT INTO `message` VALUES ('12', '111', '111', '2016-08-11', '111', '1');
INSERT INTO `message` VALUES ('13', '各位垃圾', '在座各位', '2016-08-11', '都是哦类；', '1');
INSERT INTO `message` VALUES ('14', '垃圾', '垃圾', '2016-08-11', '垃圾哦', '1');
INSERT INTO `message` VALUES ('15', 'wuwu', 'wuwuwu', '2016-08-11', 'wuwuw', '0');
INSERT INTO `message` VALUES ('16', '123466', '4256446', '2016-08-11', '456789', '0');
INSERT INTO `message` VALUES ('17', 'adasd', 'asdasdsa', '2016-08-15', 'sadasd', '1');
INSERT INTO `message` VALUES ('18', '1111', '1111', '2016-08-15', '1111', '1');
INSERT INTO `post` VALUES ('2011', '项目经理', '1');
INSERT INTO `post` VALUES ('2012', '架构师', '1');
INSERT INTO `post` VALUES ('2013', ' 总经理', '1');
INSERT INTO `post` VALUES ('2014', '设计师', '1');
INSERT INTO `post` VALUES ('2015', '程序员', '1');
INSERT INTO `post` VALUES ('2016', '测试员', '1');
INSERT INTO `post` VALUES ('2017', '市场部主任', '1');
