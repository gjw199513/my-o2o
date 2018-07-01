/*
 Navicat Premium Data Transfer

 Source Server         : gjw-mysql
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : localhost:3306
 Source Schema         : my-o2o

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 01/07/2018 19:00:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_area
-- ----------------------------
DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area`  (
  `area_id` int(5) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `priority` int(2) NOT NULL DEFAULT 0,
  `create_time` datetime(0) DEFAULT NULL,
  `last_edit_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`area_id`) USING BTREE,
  UNIQUE INDEX `UK_AREA`(`area_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_area
-- ----------------------------
INSERT INTO `tb_area` VALUES (1, '东苑', 12, '2017-06-04 19:12:58', '2017-06-04 19:12:58');
INSERT INTO `tb_area` VALUES (2, '南苑', 10, '2017-06-04 19:13:09', '2017-06-04 19:13:09');
INSERT INTO `tb_area` VALUES (3, '西苑', 9, '2017-06-04 19:13:18', '2017-06-04 19:13:18');
INSERT INTO `tb_area` VALUES (4, '北苑', 7, '2017-06-04 19:13:29', '2017-06-04 19:13:29');

-- ----------------------------
-- Table structure for tb_head_line
-- ----------------------------
DROP TABLE IF EXISTS `tb_head_line`;
CREATE TABLE `tb_head_line`  (
  `line_id` int(100) NOT NULL AUTO_INCREMENT,
  `line_name` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `line_link` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `line_img` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `priority` int(2) DEFAULT NULL,
  `enable_status` int(2) NOT NULL DEFAULT 0,
  `create_time` datetime(0) DEFAULT NULL,
  `last_edit_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`line_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_head_line
-- ----------------------------
INSERT INTO `tb_head_line` VALUES (1, '头条1', '头条1', '\\upload\\item\\shop\\1\\2018062917554354408.jpg', 1, 1, '2018-06-30 21:38:19', '2018-06-30 21:38:19');
INSERT INTO `tb_head_line` VALUES (2, '头条1', '头条1', '\\upload\\item\\shop\\1\\2018062917554197838.jpg', 1, 1, '2018-06-30 21:38:39', '2018-06-30 21:38:39');

-- ----------------------------
-- Table structure for tb_local_auth
-- ----------------------------
DROP TABLE IF EXISTS `tb_local_auth`;
CREATE TABLE `tb_local_auth`  (
  `local_auth_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL,
  `user_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `create_time` datetime(0) DEFAULT NULL,
  `last_edit_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`local_auth_id`) USING BTREE,
  UNIQUE INDEX `uk_local_profile`(`user_name`) USING BTREE,
  INDEX `fk_local_profile`(`user_id`) USING BTREE,
  CONSTRAINT `fk_localauth_profile` FOREIGN KEY (`user_id`) REFERENCES `tb_person_info` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_person_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_person_info`;
CREATE TABLE `tb_person_info`  (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `profile_img` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `enable_status` int(2) NOT NULL DEFAULT 0 COMMENT '0:禁止使用本商城，1:允许使用本商城',
  `user_type` int(2) NOT NULL DEFAULT 1 COMMENT '1:顾客,2:店家,3:超级管理员',
  `create_time` datetime(0) DEFAULT NULL,
  `last_edit_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_person_info
-- ----------------------------
INSERT INTO `tb_person_info` VALUES (1, 'test', 'n', '1', '1', 0, 1, NULL, NULL);

-- ----------------------------
-- Table structure for tb_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product`  (
  `product_id` int(100) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_desc` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `img_addr` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `normal_price` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `promotion_price` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `priority` int(2) NOT NULL DEFAULT 0,
  `create_time` datetime(0) DEFAULT NULL,
  `last_edit_time` datetime(0) DEFAULT NULL,
  `enable_status` int(2) NOT NULL DEFAULT 0,
  `product_category_id` int(11) DEFAULT NULL,
  `shop_id` int(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`product_id`) USING BTREE,
  INDEX `fk_product_procate`(`product_category_id`) USING BTREE,
  INDEX `fk_product_shop`(`shop_id`) USING BTREE,
  CONSTRAINT `fk_product_procate` FOREIGN KEY (`product_category_id`) REFERENCES `tb_product_category` (`product_category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_product_shop` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`shop_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_product
-- ----------------------------
INSERT INTO `tb_product` VALUES (1, '正式商品1sdfsdf', '正式商品1111', '\\upload\\item\\shop\\1\\2018063016104260534.png', '201', '141', 111, '2018-06-29 23:12:02', '2018-06-30 20:07:07', 1, 1, 1);
INSERT INTO `tb_product` VALUES (2, 'rewewrrwe', 'asfdsd', '\\upload\\item\\shop\\1\\2018062923204581949.png', '2222', '1211', 4, '2018-06-29 23:20:46', '2018-06-29 23:20:46', 1, 4, 1);
INSERT INTO `tb_product` VALUES (3, '测试1', '测试Desc1', 'test1', NULL, NULL, 0, '2018-06-30 16:41:24', '2018-06-30 16:41:24', 1, NULL, 1);
INSERT INTO `tb_product` VALUES (4, '测试2', '测试Desc2', 'test2', NULL, NULL, 0, '2018-06-30 16:41:24', '2018-06-30 16:41:24', 0, 3, 1);
INSERT INTO `tb_product` VALUES (5, '测试3', '测试Desc3', 'test3', NULL, NULL, 0, '2018-06-30 16:41:24', '2018-06-30 16:41:24', 1, 4, 2);

-- ----------------------------
-- Table structure for tb_product_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_category`;
CREATE TABLE `tb_product_category`  (
  `product_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_category_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `priority` int(2) DEFAULT 0,
  `create_time` datetime(0) DEFAULT NULL,
  `last_edit_time` datetime(0) DEFAULT NULL,
  `shop_id` int(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`product_category_id`) USING BTREE,
  INDEX `fk_procate_shop`(`shop_id`) USING BTREE,
  CONSTRAINT `fk_procate_shop` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`shop_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_product_category
-- ----------------------------
INSERT INTO `tb_product_category` VALUES (1, '测试1', 0, NULL, NULL, 1);
INSERT INTO `tb_product_category` VALUES (2, '测试2', 0, NULL, NULL, 1);
INSERT INTO `tb_product_category` VALUES (3, '测试3', 0, NULL, NULL, 1);
INSERT INTO `tb_product_category` VALUES (4, '商品类别1', 1, '2018-06-29 00:00:43', NULL, 1);
INSERT INTO `tb_product_category` VALUES (6, '商品类别1', 1, '2018-06-29 00:03:01', NULL, 1);

-- ----------------------------
-- Table structure for tb_product_img
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_img`;
CREATE TABLE `tb_product_img`  (
  `product_img_id` int(20) NOT NULL AUTO_INCREMENT,
  `img_addr` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `img_desc` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `priority` int(2) DEFAULT 0,
  `create_time` datetime(0) DEFAULT NULL,
  `product_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`product_img_id`) USING BTREE,
  INDEX `fk_proimg_product`(`product_id`) USING BTREE,
  CONSTRAINT `fk_proimg_product` FOREIGN KEY (`product_id`) REFERENCES `tb_product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_product_img
-- ----------------------------
INSERT INTO `tb_product_img` VALUES (3, '\\upload\\item\\shop\\1\\2018062923204578174.png', NULL, NULL, '2018-06-29 23:20:46', 2);
INSERT INTO `tb_product_img` VALUES (4, '\\upload\\item\\shop\\1\\2018062923204556545.png', NULL, NULL, '2018-06-29 23:20:46', 2);
INSERT INTO `tb_product_img` VALUES (16, '\\upload\\item\\shop\\1\\2018063016104265064.png', NULL, NULL, '2018-06-30 16:10:43', 1);

-- ----------------------------
-- Table structure for tb_shop
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop`;
CREATE TABLE `tb_shop`  (
  `shop_id` int(10) NOT NULL AUTO_INCREMENT,
  `owner_id` int(10) NOT NULL COMMENT '店铺创建人',
  `area_id` int(5) DEFAULT NULL,
  `shop_category_id` int(11) DEFAULT NULL,
  `shop_name` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `shop_desc` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `shop_addr` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `shop_img` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `priority` int(3) DEFAULT 0,
  `create_time` datetime(0) DEFAULT NULL,
  `last_edit_time` datetime(0) DEFAULT NULL,
  `enable_status` int(2) NOT NULL DEFAULT 0,
  `advice` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`shop_id`) USING BTREE,
  INDEX `fk_shop_area`(`area_id`) USING BTREE,
  INDEX `fk_shop_profile`(`owner_id`) USING BTREE,
  INDEX `fk_shop_shopcate`(`shop_category_id`) USING BTREE,
  CONSTRAINT `fk_shop_area` FOREIGN KEY (`area_id`) REFERENCES `tb_area` (`area_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_shop_profile` FOREIGN KEY (`owner_id`) REFERENCES `tb_person_info` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_shop_shopcate` FOREIGN KEY (`shop_category_id`) REFERENCES `tb_shop_category` (`shop_category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_shop
-- ----------------------------
INSERT INTO `tb_shop` VALUES (1, 1, 1, 3, '修改后的店铺名称', 'testdesc', 'testaddr', 'testphone', '\\upload\\item\\shop\\1\\2018062900030166844.jpg', 0, NULL, '2018-06-29 00:03:02', 1, NULL);
INSERT INTO `tb_shop` VALUES (2, 1, 2, 1, '测试', 'test', 'test', 'test', 'test', NULL, '2018-06-23 20:21:46', NULL, 1, '审核中');
INSERT INTO `tb_shop` VALUES (3, 1, 2, 1, '测试12', 'test12', 'test12', 'test12', '\\upload\\item\\shop\\3\\2018062412550930603.jpg', NULL, '2018-06-24 12:55:09', '2018-06-24 12:55:09', 0, '审核中');
INSERT INTO `tb_shop` VALUES (4, 1, 2, 1, '测试1211', 'test1211', 'test1211', 'test12', '\\upload\\item\\shop\\4\\2018062413330650760.jpg', NULL, '2018-06-24 13:33:06', '2018-06-24 13:33:06', 0, '审核中');
INSERT INTO `tb_shop` VALUES (5, 1, 2, 3, '测试121www1', 'test1211', 'test1211', 'test12', '\\upload\\item\\shop\\5\\2018062413351471307.jpg', NULL, '2018-06-24 13:35:14', '2018-06-24 13:35:14', 1, '审核中');
INSERT INTO `tb_shop` VALUES (6, 1, 2, 3, '测试121www1', 'test1211', 'test1211', 'test12', '\\upload\\item\\shop\\6\\2018062413355760830.jpg', NULL, '2018-06-24 13:35:57', '2018-06-24 13:35:57', 1, '审核中');
INSERT INTO `tb_shop` VALUES (7, 1, 2, 2, '测试w', 'tests1211', 'test1211', 'test12s', '\\upload\\item\\shop\\7\\2018062413383528708.jpg', NULL, '2018-06-24 13:38:35', '2018-06-24 13:38:35', 1, '审核中');
INSERT INTO `tb_shop` VALUES (8, 1, 1, 2, '奶茶', '奶茶', '奶茶店', '12345654', '\\upload\\item\\shop\\8\\2018062422294495790.jpg', NULL, '2018-06-24 22:29:44', '2018-06-24 22:29:44', 1, '审核中');
INSERT INTO `tb_shop` VALUES (9, 1, 1, 2, '奶茶', '奶茶', '奶茶店', '12345654', '\\upload\\item\\shop\\9\\2018062422324456444.jpg', NULL, '2018-06-24 22:32:44', '2018-06-24 22:32:44', 1, '审核中');
INSERT INTO `tb_shop` VALUES (10, 1, 1, 2, 'afaf', 'sfaf', 'asfa', 'adfasdf', '\\upload\\item\\shop\\10\\2018062423031256283.jpg', NULL, '2018-06-24 23:03:13', '2018-06-24 23:03:13', 1, '审核中');
INSERT INTO `tb_shop` VALUES (11, 1, 2, 1, '测试', 'test', 'test', 'test', 'test', NULL, '2018-06-29 00:03:01', NULL, 1, '审核中');

-- ----------------------------
-- Table structure for tb_shop_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop_category`;
CREATE TABLE `tb_shop_category`  (
  `shop_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_category_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `shop_category_desc` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `shop_category_img` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `priority` int(2) NOT NULL DEFAULT 0,
  `create_time` datetime(0) DEFAULT NULL,
  `last_edit_time` datetime(0) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`shop_category_id`) USING BTREE,
  INDEX `fk_shop_category_self`(`parent_id`) USING BTREE,
  CONSTRAINT `fk_shop_category_self` FOREIGN KEY (`parent_id`) REFERENCES `tb_shop_category` (`shop_category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_shop_category
-- ----------------------------
INSERT INTO `tb_shop_category` VALUES (1, '咖啡', '咖啡', '\\upload\\item\\shop\\1\\2018062900030166844.jpg', 0, NULL, NULL, NULL);
INSERT INTO `tb_shop_category` VALUES (2, '奶茶', '奶茶', 'tstee', 0, NULL, NULL, 1);
INSERT INTO `tb_shop_category` VALUES (3, '果汁', '奶茶', 'tstee', 0, NULL, NULL, 1);

-- ----------------------------
-- Table structure for tb_wechat_auth
-- ----------------------------
DROP TABLE IF EXISTS `tb_wechat_auth`;
CREATE TABLE `tb_wechat_auth`  (
  `wechat_auth_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `open_id` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `create_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`wechat_auth_id`) USING BTREE,
  INDEX `fk_wechatauth_profile`(`user_id`) USING BTREE,
  CONSTRAINT `fk_wechatauth_profile` FOREIGN KEY (`user_id`) REFERENCES `tb_person_info` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
