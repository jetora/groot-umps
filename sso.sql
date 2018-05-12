/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : sso

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-05-11 17:47:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `enabled` tinyint(4) NOT NULL COMMENT '是否可用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'admin', '$2a$10$MTFVrdqbHOi.CCUhkrkZnOBdrZEfk3gzIUyZBdQvLWvdF/0pnkEO2', '1', '2018-05-10 14:42:17', '2018-05-10 14:42:17');
INSERT INTO `account` VALUES ('2', 'user', '$2a$10$6KDklkImZgGANWR8pDAwSexf6Bt4Z9I0nDiwdih9Q38HI4eAkWk0u', '1', '2018-05-10 14:42:17', '2018-05-10 14:42:17');
INSERT INTO `account` VALUES ('3', 'anonymous', '$2a$10$58UG9Udx7RhCL1.356NyAu0Rp936vbo1vHahj8v0O0XOTSkKY0XyG', '1', '2018-05-10 14:42:17', '2018-05-10 14:42:17');
INSERT INTO `account` VALUES ('15', 'john', '$2a$10$SpSCzJ1OU91PBOezF1YMG.P2MJnsLrpAVZGB9xmT3qagvoQ9QP.fa', '1', '2018-05-11 17:37:42', '2018-05-11 17:37:42');
INSERT INTO `account` VALUES ('16', 'hulk', '$2a$10$VqLkXeGdFDGvV.d0mtrdD.nYLyGmgkprBpWQ7R4e5XSxCIteMogIO', '1', '2018-05-11 17:37:42', '2018-05-11 17:37:42');
INSERT INTO `account` VALUES ('17', 'stark', '$2a$10$l/2bk8MqaVFcBHT4kB5mIudDEr2AUFCKbvur4BzUEZuHK2HwUdQvG', '1', '2018-05-11 17:37:42', '2018-05-11 17:37:42');
INSERT INTO `account` VALUES ('18', 'tom', '$2a$10$SpSCzJ1OU91PBOezF1YMG.P2MJnsLrpAVZGB9xmT3qagvoQ9QP.fa', '1', '2018-05-11 17:37:42', '2018-05-11 17:37:42');
INSERT INTO `account` VALUES ('19', 'jerry', '$2a$10$cPfk/j38MLeQUlFUG7L7Mew9z59DvqDaqTnLb509UUAPRIY7wme8e', '1', '2018-05-11 17:37:43', '2018-05-11 17:37:43');
INSERT INTO `account` VALUES ('20', 'boss', '$2a$10$pN2LjyxIbtp0WHtqBwHRI.BZT43/hsyUbKibzIxS9NodWA/uFgI4u', '1', '2018-05-11 17:37:43', '2018-05-11 17:37:43');

-- ----------------------------
-- Table structure for `account_group_relationship`
-- ----------------------------
DROP TABLE IF EXISTS `account_group_relationship`;
CREATE TABLE `account_group_relationship` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` bigint(20) NOT NULL COMMENT '用户组ID',
  `account_id` bigint(20) NOT NULL COMMENT '用户ID',
  `enabled` tinyint(4) NOT NULL COMMENT '是否可用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_group_id` (`group_id`),
  KEY `idx_account_id` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组与用户关系表';

-- ----------------------------
-- Records of account_group_relationship
-- ----------------------------

-- ----------------------------
-- Table structure for `account_role_relationship`
-- ----------------------------
DROP TABLE IF EXISTS `account_role_relationship`;
CREATE TABLE `account_role_relationship` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `account_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_account_id` (`account_id`),
  KEY `idx_role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

-- ----------------------------
-- Records of account_role_relationship
-- ----------------------------

-- ----------------------------
-- Table structure for `organization`
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(100) NOT NULL COMMENT '组织结构名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父组织机构',
  `enabled` tinyint(4) NOT NULL COMMENT '是否可用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='组织机构表';

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES ('1', '总部', '0', '1', '2018-05-11 11:34:27', '2018-05-11 11:34:27');
INSERT INTO `organization` VALUES ('2', '北京分公司', '1', '1', '2018-05-11 11:34:27', '2018-05-11 11:34:27');
INSERT INTO `organization` VALUES ('3', '北京分公司-海淀支行', '2', '1', '2018-05-11 11:34:27', '2018-05-11 11:34:27');
INSERT INTO `organization` VALUES ('4', '北京分公司-海淀支行-知春路店', '3', '1', '2018-05-11 11:34:27', '2018-05-11 11:34:27');
INSERT INTO `organization` VALUES ('5', '北京分公司-海淀支行-中关村店', '3', '1', '2018-05-11 11:34:27', '2018-05-11 11:34:27');
INSERT INTO `organization` VALUES ('6', '北京分公司-朝阳支行', '2', '1', '2018-05-11 11:34:27', '2018-05-11 11:34:27');
INSERT INTO `organization` VALUES ('7', '北京分公司-大兴支行', '2', '1', '2018-05-11 11:34:27', '2018-05-11 11:34:27');
INSERT INTO `organization` VALUES ('8', '北京分公司-大兴支行-清源路分店', '7', '1', '2018-05-11 11:34:27', '2018-05-11 11:34:27');
INSERT INTO `organization` VALUES ('9', '北京分公司-大兴支行-清源路店1店', '8', '1', '2018-05-11 11:34:27', '2018-05-11 11:34:27');
INSERT INTO `organization` VALUES ('10', '北京分公司-大兴支行-清源路店2店', '8', '1', '2018-05-11 11:34:27', '2018-05-11 11:34:27');
INSERT INTO `organization` VALUES ('11', '北京分公司-大兴支行-清源路店3店', '8', '1', '2018-05-11 11:34:27', '2018-05-11 11:34:27');
INSERT INTO `organization` VALUES ('12', '北京分公司-大兴支行-黄村西大街分店', '7', '1', '2018-05-11 11:34:27', '2018-05-11 11:34:27');
INSERT INTO `organization` VALUES ('13', '北京分公司-大兴支行-黄村西大街1店', '12', '1', '2018-05-11 11:34:27', '2018-05-11 11:34:27');
INSERT INTO `organization` VALUES ('14', '北京分公司-大兴支行-黄村西大街2店', '12', '1', '2018-05-11 11:34:27', '2018-05-11 11:34:27');
INSERT INTO `organization` VALUES ('15', '北京分公司-大兴支行-黄村西大街3店', '12', '1', '2018-05-11 11:34:27', '2018-05-11 11:34:27');
INSERT INTO `organization` VALUES ('16', '天津分公司', '1', '1', '2018-05-11 11:34:28', '2018-05-11 11:34:28');
INSERT INTO `organization` VALUES ('17', '天津分公司-滨海新区支行', '16', '1', '2018-05-11 11:34:28', '2018-05-11 11:34:28');
INSERT INTO `organization` VALUES ('18', '天津分公司-滨海新区支行-塘沽街道分店', '17', '1', '2018-05-11 11:34:28', '2018-05-11 11:34:28');
INSERT INTO `organization` VALUES ('19', '天津分公司-滨海新区支行-塘沽街道1店', '17', '1', '2018-05-11 11:34:28', '2018-05-11 11:34:28');
INSERT INTO `organization` VALUES ('20', '天津分公司-滨海新区支行-塘沽街道2店', '17', '1', '2018-05-11 11:34:28', '2018-05-11 11:34:28');
INSERT INTO `organization` VALUES ('21', '天津分公司-滨海新区支行-胡家园街道分店', '17', '1', '2018-05-11 11:34:28', '2018-05-11 11:34:28');
INSERT INTO `organization` VALUES ('22', '天津分公司-滨海新区支行-胡家园街道1店', '21', '1', '2018-05-11 11:34:28', '2018-05-11 11:34:28');
INSERT INTO `organization` VALUES ('23', '天津分公司-滨海新区支行-胡家园街道2店', '21', '1', '2018-05-11 11:34:28', '2018-05-11 11:34:28');
INSERT INTO `organization` VALUES ('24', '河北分公司', '1', '1', '2018-05-11 11:34:28', '2018-05-11 11:34:28');
INSERT INTO `organization` VALUES ('25', '河北分公司-邢台支行', '24', '1', '2018-05-11 11:34:28', '2018-05-11 11:34:28');
INSERT INTO `organization` VALUES ('26', '河北分公司-邢台支行-宁晋支行', '25', '1', '2018-05-11 11:34:28', '2018-05-11 11:34:28');
INSERT INTO `organization` VALUES ('27', '河北分公司-邢台支行-宁晋支行-世爵公馆1店', '26', '1', '2018-05-11 11:34:28', '2018-05-11 11:34:28');
INSERT INTO `organization` VALUES ('28', '河北分公司-邢台支行-宁晋支行-世爵公馆2店', '26', '1', '2018-05-11 11:34:28', '2018-05-11 11:34:28');
INSERT INTO `organization` VALUES ('29', '河北分公司-石家庄支行', '24', '1', '2018-05-11 11:34:28', '2018-05-11 11:34:28');
INSERT INTO `organization` VALUES ('30', '河北分公司-石家庄支行-机场路支行', '29', '1', '2018-05-11 11:34:28', '2018-05-11 11:34:28');
INSERT INTO `organization` VALUES ('31', '河北分公司-石家庄支行-机场路支行1点', '30', '1', '2018-05-11 11:34:28', '2018-05-11 11:34:28');
INSERT INTO `organization` VALUES ('32', '河北分公司-石家庄支行-机场路支行2店', '30', '1', '2018-05-11 11:34:28', '2018-05-11 11:34:28');

-- ----------------------------
-- Table structure for `privilege`
-- ----------------------------
DROP TABLE IF EXISTS `privilege`;
CREATE TABLE `privilege` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(50) NOT NULL COMMENT '权限名称',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `enabled` tinyint(4) NOT NULL COMMENT '是否可用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of privilege
-- ----------------------------
INSERT INTO `privilege` VALUES ('1', 'PRIVILEGE_ADMIN', 'privilege_admin', '1', '2018-05-11 17:17:36', '2018-05-11 17:17:36');
INSERT INTO `privilege` VALUES ('2', 'PRIVILEGE_DBA', 'privilege_dba', '1', '2018-05-11 17:17:36', '2018-05-11 17:17:36');
INSERT INTO `privilege` VALUES ('3', 'PRIVILEGE_USER', 'privilege_user', '1', '2018-05-11 17:17:36', '2018-05-11 17:17:36');
INSERT INTO `privilege` VALUES ('4', 'PRIVILEGE_ANONYMOUS', 'privilege_anonymous', '1', '2018-05-11 17:17:36', '2018-05-11 17:17:36');

-- ----------------------------
-- Table structure for `privilege_resource_relationship`
-- ----------------------------
DROP TABLE IF EXISTS `privilege_resource_relationship`;
CREATE TABLE `privilege_resource_relationship` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `privilege_id` bigint(20) NOT NULL COMMENT '权限ID',
  `resource_id` bigint(20) NOT NULL COMMENT '菜单ID',
  `enabled` tinyint(4) NOT NULL COMMENT '是否可用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_privilege_id` (`privilege_id`),
  KEY `idx_menu_id` (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限资源关系表';

-- ----------------------------
-- Records of privilege_resource_relationship
-- ----------------------------

-- ----------------------------
-- Table structure for `resource`
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(100) NOT NULL COMMENT '资源名称资源名称',
  `url` varchar(255) DEFAULT NULL COMMENT '资源url',
  `method` varchar(50) DEFAULT NULL COMMENT '请求方法',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父资源',
  `parent_ids` varchar(100) DEFAULT NULL COMMENT '父资源列表',
  `permission` varchar(100) DEFAULT NULL COMMENT '资源权限标识',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `component` varchar(100) DEFAULT NULL COMMENT '前端页面',
  `type` tinyint(4) DEFAULT NULL COMMENT '资源类型，1-menu 2-button',
  `enabled` tinyint(4) NOT NULL COMMENT '是否可用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_parent_id` (`parent_id`),
  KEY `idx_type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '资源', null, null, '0', null, null, null, null, null, '1', '2018-05-11 16:04:49', '2018-05-11 16:04:49');
INSERT INTO `resource` VALUES ('11', '用户管理', '/account', null, '1', null, 'account:*', null, null, '1', '1', '2018-05-11 16:07:49', '2018-05-11 16:12:47');
INSERT INTO `resource` VALUES ('12', '用户增加', '', null, '11', null, 'account:create', null, null, '2', '1', '2018-05-11 16:12:20', '2018-05-11 16:12:56');
INSERT INTO `resource` VALUES ('13', '用户修改', '', null, '11', null, 'account:update', null, null, '2', '1', '2018-05-11 16:12:20', '2018-05-11 16:12:58');
INSERT INTO `resource` VALUES ('14', '用户删除', '', null, '11', null, 'account:delete', null, null, '2', '1', '2018-05-11 16:12:20', '2018-05-11 16:13:02');
INSERT INTO `resource` VALUES ('15', '用户查看', '', null, '11', null, 'account:view', null, null, '2', '1', '2018-05-11 16:20:48', '2018-05-11 16:20:48');
INSERT INTO `resource` VALUES ('21', '角色管理', '/role', null, '1', null, 'role:*', null, null, '1', '1', '2018-05-11 16:16:15', '2018-05-11 16:16:55');
INSERT INTO `resource` VALUES ('22', '角色增加', '', null, '21', null, 'role:create', null, null, '2', '1', '2018-05-11 16:16:29', '2018-05-11 16:16:29');
INSERT INTO `resource` VALUES ('23', '角色修改', '', null, '21', null, 'role:update', null, null, '2', '1', '2018-05-11 16:16:29', '2018-05-11 16:16:29');
INSERT INTO `resource` VALUES ('24', '角色删除', '', null, '21', null, 'role:delete', null, null, '2', '1', '2018-05-11 16:16:29', '2018-05-11 16:16:29');
INSERT INTO `resource` VALUES ('25', '角色查看', '', null, '21', null, 'role:view', null, null, '2', '1', '2018-05-11 16:21:03', '2018-05-11 16:21:03');
INSERT INTO `resource` VALUES ('31', '组织机构管理', '/organization', null, '1', null, 'organization:*', null, null, '1', '1', '2018-05-11 16:18:44', '2018-05-11 16:18:44');
INSERT INTO `resource` VALUES ('32', '组织机构增加', '', null, '31', null, 'organization:create', null, null, '2', '1', '2018-05-11 16:18:44', '2018-05-11 16:19:15');
INSERT INTO `resource` VALUES ('33', '组织机构修改', '', null, '31', null, 'organization:update', null, null, '2', '1', '2018-05-11 16:18:44', '2018-05-11 16:19:17');
INSERT INTO `resource` VALUES ('34', '组织机构删除', '', null, '31', null, 'organization:delete', null, null, '2', '1', '2018-05-11 16:18:44', '2018-05-11 16:19:20');
INSERT INTO `resource` VALUES ('35', '组织机构查看', '', null, '31', null, 'organization:view', null, null, '2', '1', '2018-05-11 16:21:04', '2018-05-11 16:21:04');
INSERT INTO `resource` VALUES ('41', '资源管理', '/resource', null, '1', null, 'resource:*', null, null, '1', '1', '2018-05-11 16:22:18', '2018-05-11 16:22:18');
INSERT INTO `resource` VALUES ('42', '资源增加', '', null, '41', null, 'resource:create', null, null, '2', '1', '2018-05-11 16:22:19', '2018-05-11 16:22:19');
INSERT INTO `resource` VALUES ('43', '资源修改', '', null, '41', null, 'resource:update', null, null, '2', '1', '2018-05-11 16:22:19', '2018-05-11 16:22:19');
INSERT INTO `resource` VALUES ('44', '资源删除', '', null, '41', null, 'resource:delete', null, null, '2', '1', '2018-05-11 16:22:19', '2018-05-11 16:22:19');
INSERT INTO `resource` VALUES ('45', '资源查看', '', null, '41', null, 'resource:view', null, null, '2', '1', '2018-05-11 16:22:19', '2018-05-11 16:22:19');
INSERT INTO `resource` VALUES ('51', '权限管理', '/privilege', null, '1', null, 'privilege:*', null, null, '1', '1', '2018-05-11 16:42:41', '2018-05-11 16:42:41');
INSERT INTO `resource` VALUES ('52', '权限增加', '', null, '51', null, 'privilege:create', null, null, '2', '1', '2018-05-11 16:42:41', '2018-05-11 16:42:41');
INSERT INTO `resource` VALUES ('53', '权限修改', '', null, '51', null, 'privilege:update', null, null, '2', '1', '2018-05-11 16:42:41', '2018-05-11 16:42:41');
INSERT INTO `resource` VALUES ('54', '权限删除', '', null, '51', null, 'privilege:delete', null, null, '2', '1', '2018-05-11 16:42:41', '2018-05-11 16:42:41');
INSERT INTO `resource` VALUES ('55', '权限查看', '', null, '51', null, 'privilege:view', null, null, '2', '1', '2018-05-11 16:42:41', '2018-05-11 16:42:41');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(50) NOT NULL COMMENT '角色名称',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `enabled` tinyint(4) NOT NULL COMMENT '是否可用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_ADMIN', 'admin', '1', '2018-05-11 17:09:23', '2018-05-11 17:09:23');
INSERT INTO `role` VALUES ('2', 'ROLE_DBA', 'dbs', '1', '2018-05-11 17:09:24', '2018-05-11 17:09:24');
INSERT INTO `role` VALUES ('3', 'ROLE_USER', 'user', '1', '2018-05-11 17:09:24', '2018-05-11 17:09:24');
INSERT INTO `role` VALUES ('4', 'ROLE_ANONYMOUS', 'anonymous', '1', '2018-05-11 17:09:24', '2018-05-11 17:09:24');

-- ----------------------------
-- Table structure for `role_group_relationship`
-- ----------------------------
DROP TABLE IF EXISTS `role_group_relationship`;
CREATE TABLE `role_group_relationship` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` bigint(20) NOT NULL COMMENT '用户组ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `enabled` tinyint(4) NOT NULL COMMENT '是否可用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_group_id` (`group_id`),
  KEY `idx_role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组角色关系表';

-- ----------------------------
-- Records of role_group_relationship
-- ----------------------------

-- ----------------------------
-- Table structure for `role_privilege_relationshp`
-- ----------------------------
DROP TABLE IF EXISTS `role_privilege_relationshp`;
CREATE TABLE `role_privilege_relationshp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `privilege_id` bigint(20) NOT NULL COMMENT '权限ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_role_id` (`role_id`),
  KEY `idx_privilege_id` (`privilege_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Records of role_privilege_relationshp
-- ----------------------------
INSERT INTO `role_privilege_relationshp` VALUES ('1', '1', '1', '2018-05-11 17:46:21', '2018-05-11 17:46:21');
INSERT INTO `role_privilege_relationshp` VALUES ('2', '2', '2', '2018-05-11 17:46:21', '2018-05-11 17:46:21');
INSERT INTO `role_privilege_relationshp` VALUES ('3', '3', '3', '2018-05-11 17:46:21', '2018-05-11 17:46:21');
INSERT INTO `role_privilege_relationshp` VALUES ('4', '4', '4', '2018-05-11 17:46:21', '2018-05-11 17:46:21');
