/*
 Navicat Premium Data Transfer

 Source Server         : 本地MySQL
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : adminserver

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 17/07/2021 14:52:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `t_dictionary`;
CREATE TABLE `t_dictionary`  (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `table_name` varchar(20)  NULL DEFAULT NULL COMMENT '表名',
  `field_name` varchar(20)  NULL DEFAULT NULL COMMENT '字段名',
  `field_value` int(2) NULL DEFAULT NULL COMMENT '字段值',
  `field_label` varchar(20)  NULL DEFAULT NULL COMMENT '字段标签',
  `des` varchar(100)  NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  COMMENT = '字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `menu_name` varchar(32)  NULL DEFAULT NULL COMMENT '菜单名称',
  `menu_desc` varchar(32)  NULL DEFAULT NULL COMMENT '菜单描述',
  `menu_icon` varchar(32)  NULL DEFAULT NULL COMMENT '菜单图标样式',
  `menu_cls` varchar(32)  NULL DEFAULT NULL COMMENT '菜单样式',
  `route_name` varchar(32)  NULL DEFAULT NULL COMMENT '路由名称',
  `pid` bigint(20) NULL DEFAULT NULL COMMENT '父级菜单ID',
  `menu_level` int(2) NULL DEFAULT NULL COMMENT '菜单级别',
  `status` int(2) NULL DEFAULT NULL COMMENT '菜单状态',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  COMMENT = '资源表（菜单表）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `role_name` varchar(10)  NULL DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(100)  NULL DEFAULT NULL COMMENT '角色描述',
  `status` int(2) NULL DEFAULT NULL COMMENT '角色状态',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu`  (
  `id` bigint(20) NOT NULL COMMENT '主键Id',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色id',
  `menu_Id` bigint(20) NULL DEFAULT NULL COMMENT '菜单Id',
  `create_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  COMMENT = '角色资源关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `open_id` varchar(32)  NULL DEFAULT NULL COMMENT 'openId',
  `user_name` varchar(20)  NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(32)  NULL DEFAULT NULL COMMENT '密码',
  `full_name` varchar(32)  NULL DEFAULT NULL COMMENT '全名',
  `qq` varchar(32)  NULL DEFAULT NULL COMMENT 'QQ号',
  `user_sign` varchar(100)  NULL DEFAULT NULL COMMENT '个人签名',
  `head_url` varchar(32)  NULL DEFAULT NULL COMMENT '头像',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `sex` int(2) NULL DEFAULT NULL COMMENT '性别',
  `school` varchar(32)  NULL DEFAULT NULL COMMENT '毕业学校',
  `user_info` varchar(200)  NULL DEFAULT NULL COMMENT '个人说明',
  `email` varchar(32)  NULL DEFAULT NULL COMMENT '邮箱',
  `phone_number` varchar(32)  NULL DEFAULT NULL COMMENT '手机号码',
  `tel` varchar(32)  NULL DEFAULT NULL COMMENT '座机号',
  `address` varchar(32)  NULL DEFAULT NULL COMMENT '详细地址',
  `province` int(10) NULL DEFAULT NULL COMMENT '省',
  `city` int(10) NULL DEFAULT NULL COMMENT '市',
  `area` int(10) NULL DEFAULT NULL COMMENT '区',
  `status` int(2) NULL DEFAULT NULL COMMENT '状态',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` bigint(20) NOT NULL COMMENT '主键Id',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色id',
  `create_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
