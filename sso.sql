/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : sso

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-06-04 09:22:19
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
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'admin', 'admin', '1', '2018-05-10 14:42:17', '2018-05-28 09:42:37');
INSERT INTO `account` VALUES ('2', 'user', 'user', '1', '2018-05-10 14:42:17', '2018-05-13 12:30:28');
INSERT INTO `account` VALUES ('3', 'anonymous', 'anonymous', '1', '2018-05-10 14:42:17', '2018-05-13 12:30:34');
INSERT INTO `account` VALUES ('15', 'john', 'john', '1', '2018-05-11 17:37:42', '2018-05-13 12:30:40');
INSERT INTO `account` VALUES ('16', 'hulk', 'hulk', '1', '2018-05-11 17:37:42', '2018-05-13 12:30:44');
INSERT INTO `account` VALUES ('17', 'stark', 'stark', '1', '2018-05-11 17:37:42', '2018-05-13 12:30:49');
INSERT INTO `account` VALUES ('18', 'tom', 'tom', '1', '2018-05-11 17:37:42', '2018-05-13 12:30:53');
INSERT INTO `account` VALUES ('19', 'jerry', 'jerry', '2', '2018-05-11 17:37:43', '2018-05-16 14:04:35');
INSERT INTO `account` VALUES ('20', 'boss', 'boss', '1', '2018-05-11 17:37:43', '2018-05-13 12:31:01');
INSERT INTO `account` VALUES ('21', 'johnsnow', 'johnsnow', '1', '2018-05-16 17:47:05', '2018-05-16 17:47:05');
INSERT INTO `account` VALUES ('22', 'ronstark', 'ronstark', '1', '2018-05-16 19:24:40', '2018-05-16 19:24:40');
INSERT INTO `account` VALUES ('23', 'ronstark', 'ronstark', '1', '2018-05-16 19:27:21', '2018-05-16 19:27:21');
INSERT INTO `account` VALUES ('24', 'addDatastark', 'addDatastark', '1', '2018-05-16 19:29:34', '2018-05-16 19:29:34');
INSERT INTO `account` VALUES ('25', 'button', 'button', '1', '2018-05-16 19:32:28', '2018-05-16 19:32:28');
INSERT INTO `account` VALUES ('26', 'farmmer', 'farmmer', '1', '2018-05-16 19:37:01', '2018-05-16 19:37:01');
INSERT INTO `account` VALUES ('27', 'thunder', 'thunder', '1', '2018-05-16 19:38:28', '2018-05-16 19:38:28');
INSERT INTO `account` VALUES ('28', 'bora', 'bora', '1', '2018-05-16 19:49:34', '2018-05-16 19:49:34');
INSERT INTO `account` VALUES ('29', 'dudu', 'dudu', '1', '2018-05-16 21:35:04', '2018-05-16 21:35:04');
INSERT INTO `account` VALUES ('30', 'dudu', 'dudu', '1', '2018-05-16 21:38:55', '2018-05-16 21:38:55');
INSERT INTO `account` VALUES ('31', 'dudu', 'dudu', '2', '2018-05-16 21:42:55', '2018-05-16 21:42:55');
INSERT INTO `account` VALUES ('32', 'dudu', 'dudu', '1', '2018-05-16 21:43:12', '2018-05-23 23:31:21');
INSERT INTO `account` VALUES ('33', 'asdasda', 'http://127.0.0.1:8080/home', '1', '2018-05-28 09:42:12', '2018-05-28 09:42:12');
INSERT INTO `account` VALUES ('34', 'asdasdas', 'asdasdas', '1', '2018-05-28 09:42:29', '2018-05-28 09:42:29');
INSERT INTO `account` VALUES ('35', 'asdasdas', 'asdasdas', '1', '2018-05-28 09:42:55', '2018-05-28 09:42:55');
INSERT INTO `account` VALUES ('36', 'asdasdas', 'asdasdas', '1', '2018-05-28 09:43:02', '2018-05-28 09:43:02');
INSERT INTO `account` VALUES ('37', 'asdasdas', 'asdasdas', '1', '2018-05-28 09:43:13', '2018-05-28 12:22:29');

-- ----------------------------
-- Table structure for `account_copy`
-- ----------------------------
DROP TABLE IF EXISTS `account_copy`;
CREATE TABLE `account_copy` (
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
-- Records of account_copy
-- ----------------------------
INSERT INTO `account_copy` VALUES ('1', 'admin', '$2a$10$MTFVrdqbHOi.CCUhkrkZnOBdrZEfk3gzIUyZBdQvLWvdF/0pnkEO2', '1', '2018-05-10 14:42:17', '2018-05-10 14:42:17');
INSERT INTO `account_copy` VALUES ('2', 'user', '$2a$10$6KDklkImZgGANWR8pDAwSexf6Bt4Z9I0nDiwdih9Q38HI4eAkWk0u', '1', '2018-05-10 14:42:17', '2018-05-10 14:42:17');
INSERT INTO `account_copy` VALUES ('3', 'anonymous', '$2a$10$58UG9Udx7RhCL1.356NyAu0Rp936vbo1vHahj8v0O0XOTSkKY0XyG', '1', '2018-05-10 14:42:17', '2018-05-10 14:42:17');
INSERT INTO `account_copy` VALUES ('15', 'john', '$2a$10$SpSCzJ1OU91PBOezF1YMG.P2MJnsLrpAVZGB9xmT3qagvoQ9QP.fa', '1', '2018-05-11 17:37:42', '2018-05-11 17:37:42');
INSERT INTO `account_copy` VALUES ('16', 'hulk', '$2a$10$VqLkXeGdFDGvV.d0mtrdD.nYLyGmgkprBpWQ7R4e5XSxCIteMogIO', '1', '2018-05-11 17:37:42', '2018-05-11 17:37:42');
INSERT INTO `account_copy` VALUES ('17', 'stark', '$2a$10$l/2bk8MqaVFcBHT4kB5mIudDEr2AUFCKbvur4BzUEZuHK2HwUdQvG', '1', '2018-05-11 17:37:42', '2018-05-11 17:37:42');
INSERT INTO `account_copy` VALUES ('18', 'tom', '$2a$10$SpSCzJ1OU91PBOezF1YMG.P2MJnsLrpAVZGB9xmT3qagvoQ9QP.fa', '1', '2018-05-11 17:37:42', '2018-05-11 17:37:42');
INSERT INTO `account_copy` VALUES ('19', 'jerry', '$2a$10$cPfk/j38MLeQUlFUG7L7Mew9z59DvqDaqTnLb509UUAPRIY7wme8e', '1', '2018-05-11 17:37:43', '2018-05-11 17:37:43');
INSERT INTO `account_copy` VALUES ('20', 'boss', '$2a$10$pN2LjyxIbtp0WHtqBwHRI.BZT43/hsyUbKibzIxS9NodWA/uFgI4u', '1', '2018-05-11 17:37:43', '2018-05-11 17:37:43');

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
  `organization_id` bigint(20) NOT NULL COMMENT '组织结构ID',
  `name` varchar(100) NOT NULL COMMENT '组织结构名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父组织机构',
  `enabled` tinyint(4) NOT NULL COMMENT '是否可用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_organization_id` (`organization_id`),
  KEY `idx_parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='组织机构表';

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES ('1', '10000', '总部', '0', '1', '2018-05-11 11:34:27', '2018-05-28 15:05:46');
INSERT INTO `organization` VALUES ('2', '20000', '北京分公司', '10000', '1', '2018-05-11 11:34:27', '2018-05-28 15:10:15');
INSERT INTO `organization` VALUES ('3', '21000', '北京分公司-海淀支行', '20000', '1', '2018-05-11 11:34:27', '2018-05-28 15:10:22');
INSERT INTO `organization` VALUES ('4', '21100', '北京分公司-海淀支行-知春路店', '21000', '1', '2018-05-11 11:34:27', '2018-05-28 15:10:29');
INSERT INTO `organization` VALUES ('5', '21200', '北京分公司-海淀支行-中关村店', '21000', '1', '2018-05-11 11:34:27', '2018-05-28 15:10:35');
INSERT INTO `organization` VALUES ('6', '22000', '北京分公司-朝阳支行', '20000', '1', '2018-05-11 11:34:27', '2018-05-28 15:10:40');
INSERT INTO `organization` VALUES ('7', '23000', '北京分公司-大兴支行', '20000', '1', '2018-05-11 11:34:27', '2018-05-28 15:10:45');
INSERT INTO `organization` VALUES ('8', '23100', '北京分公司-大兴支行-清源路分店', '23000', '1', '2018-05-11 11:34:27', '2018-05-28 15:10:55');
INSERT INTO `organization` VALUES ('9', '23110', '北京分公司-大兴支行-清源路店1店', '23100', '1', '2018-05-11 11:34:27', '2018-05-28 15:12:28');
INSERT INTO `organization` VALUES ('10', '23120', '北京分公司-大兴支行-清源路店2店', '23100', '1', '2018-05-11 11:34:27', '2018-05-28 15:12:33');
INSERT INTO `organization` VALUES ('11', '23130', '北京分公司-大兴支行-清源路店3店', '23100', '1', '2018-05-11 11:34:27', '2018-05-28 15:12:41');
INSERT INTO `organization` VALUES ('12', '23200', '北京分公司-大兴支行-黄村西大街分店', '23000', '1', '2018-05-11 11:34:27', '2018-05-28 15:12:47');
INSERT INTO `organization` VALUES ('13', '23210', '北京分公司-大兴支行-黄村西大街1店', '23200', '1', '2018-05-11 11:34:27', '2018-05-28 15:13:13');
INSERT INTO `organization` VALUES ('14', '23220', '北京分公司-大兴支行-黄村西大街2店', '23200', '1', '2018-05-11 11:34:27', '2018-05-28 15:13:21');
INSERT INTO `organization` VALUES ('15', '23230', '北京分公司-大兴支行-黄村西大街3店', '23200', '1', '2018-05-11 11:34:27', '2018-05-28 15:13:25');
INSERT INTO `organization` VALUES ('16', '30000', '天津分公司', '10000', '1', '2018-05-11 11:34:28', '2018-05-28 15:13:34');
INSERT INTO `organization` VALUES ('17', '31000', '天津分公司-滨海新区支行', '30000', '1', '2018-05-11 11:34:28', '2018-05-28 15:13:45');
INSERT INTO `organization` VALUES ('18', '31100', '天津分公司-滨海新区支行-塘沽街道分店', '31000', '1', '2018-05-11 11:34:28', '2018-05-28 15:13:53');
INSERT INTO `organization` VALUES ('19', '31110', '天津分公司-滨海新区支行-塘沽街道1店', '31000', '1', '2018-05-11 11:34:28', '2018-05-28 15:14:47');
INSERT INTO `organization` VALUES ('20', '31120', '天津分公司-滨海新区支行-塘沽街道2店', '31000', '1', '2018-05-11 11:34:28', '2018-05-28 15:14:51');
INSERT INTO `organization` VALUES ('21', '31130', '天津分公司-滨海新区支行-胡家园街道分店', '31000', '1', '2018-05-11 11:34:28', '2018-05-28 15:16:32');
INSERT INTO `organization` VALUES ('22', '31140', '天津分公司-滨海新区支行-胡家园街道1店', '31000', '1', '2018-05-11 11:34:28', '2018-05-28 15:16:44');
INSERT INTO `organization` VALUES ('23', '31150', '天津分公司-滨海新区支行-胡家园街道2店', '31000', '1', '2018-05-11 11:34:28', '2018-05-28 15:16:50');
INSERT INTO `organization` VALUES ('24', '40000', '河北分公司', '10000', '1', '2018-05-11 11:34:28', '2018-05-28 15:16:56');
INSERT INTO `organization` VALUES ('25', '41000', '河北分公司-邢台支行', '40000', '1', '2018-05-11 11:34:28', '2018-05-28 15:17:09');
INSERT INTO `organization` VALUES ('26', '41100', '河北分公司-邢台支行-宁晋支行', '41000', '1', '2018-05-11 11:34:28', '2018-05-28 15:17:12');
INSERT INTO `organization` VALUES ('27', '41110', '河北分公司-邢台支行-宁晋支行-世爵公馆1店', '41100', '1', '2018-05-11 11:34:28', '2018-05-28 15:17:18');
INSERT INTO `organization` VALUES ('28', '41120', '河北分公司-邢台支行-宁晋支行-世爵公馆2店', '41100', '1', '2018-05-11 11:34:28', '2018-05-28 15:17:21');
INSERT INTO `organization` VALUES ('29', '42000', '河北分公司-石家庄支行', '40000', '1', '2018-05-11 11:34:28', '2018-05-28 15:17:26');
INSERT INTO `organization` VALUES ('30', '42100', '河北分公司-石家庄支行-机场路支行', '42000', '1', '2018-05-11 11:34:28', '2018-05-28 15:17:47');
INSERT INTO `organization` VALUES ('31', '42110', '河北分公司-石家庄支行-机场路支行1点', '42100', '1', '2018-05-11 11:34:28', '2018-05-28 15:24:13');
INSERT INTO `organization` VALUES ('32', '42120', '河北分公司-石家庄支行-机场路支行2店', '42100', '1', '2018-05-11 11:34:28', '2018-05-28 15:24:15');

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
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `resource_id` bigint(20) NOT NULL COMMENT '资源ID',
  `name` varchar(100) NOT NULL COMMENT '资源名称资源名称',
  `url` varchar(255) DEFAULT NULL COMMENT '资源url',
  `method` varchar(50) DEFAULT NULL COMMENT '请求方法',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父资源',
  `parent_ids` varchar(100) DEFAULT NULL COMMENT '父资源列表',
  `permission` varchar(100) DEFAULT NULL COMMENT '资源权限标识',
  `data_target` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '_self' COMMENT '菜单打开方式：_self,_blank',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `component` varchar(100) DEFAULT NULL COMMENT '前端页面',
  `type` tinyint(4) DEFAULT NULL COMMENT '资源类型，1-menu 2-button',
  `enabled` tinyint(4) NOT NULL COMMENT '是否可用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_parent_id` (`parent_id`),
  KEY `idx_type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '10000', '资源', null, null, '0', null, null, '', null, null, null, '1', '2018-05-11 16:04:49', '2018-05-21 16:05:25');
INSERT INTO `resource` VALUES ('2', '11000', '首页', '/home', null, '10000', null, null, '_self', null, null, '1', '1', '2018-05-28 18:27:54', '2018-05-28 18:27:54');
INSERT INTO `resource` VALUES ('3', '20000', '系统组织管理', '#', null, '10000', null, null, '_self', null, null, '1', '1', '2018-05-21 14:31:04', '2018-05-22 13:26:02');
INSERT INTO `resource` VALUES ('4', '21000', '组织机构管理', '/organization', null, '20000', null, 'organization:*', '_self', null, null, '1', '1', '2018-05-11 16:18:44', '2018-05-23 12:02:26');
INSERT INTO `resource` VALUES ('5', '21001', '组织机构增加', '#', null, '21000', null, 'organization:create', '_self', null, null, '2', '1', '2018-05-11 16:18:44', '2018-05-28 15:42:25');
INSERT INTO `resource` VALUES ('6', '21002', '组织机构修改', '#', null, '21000', null, 'organization:update', '_self', null, null, '2', '1', '2018-05-11 16:18:44', '2018-05-28 15:42:26');
INSERT INTO `resource` VALUES ('7', '21003', '组织机构删除', '#', null, '21000', null, 'organization:delete', '_self', null, null, '2', '1', '2018-05-11 16:18:44', '2018-05-28 15:42:28');
INSERT INTO `resource` VALUES ('8', '21004', '组织机构查看', '#', null, '21000', null, 'organization:view', '_self', null, null, '2', '1', '2018-05-11 16:21:04', '2018-05-28 15:42:29');
INSERT INTO `resource` VALUES ('9', '30000', '用户角色管理', '#', null, '10000', null, null, '_self', null, null, '1', '1', '2018-05-21 14:31:25', '2018-05-28 15:43:08');
INSERT INTO `resource` VALUES ('10', '31000', '用户管理', '/account', null, '30000', null, 'account:*', '_self', null, null, '1', '1', '2018-05-11 16:07:49', '2018-05-28 15:45:24');
INSERT INTO `resource` VALUES ('11', '31001', '用户增加', '#', null, '31000', null, 'account:create', '_self', null, null, '2', '1', '2018-05-11 16:12:20', '2018-05-28 15:45:25');
INSERT INTO `resource` VALUES ('12', '31002', '用户修改', '#', null, '31000', null, 'account:update', '_self', null, null, '2', '1', '2018-05-11 16:12:20', '2018-05-28 15:45:26');
INSERT INTO `resource` VALUES ('13', '31003', '用户删除', '#', null, '31000', null, 'account:delete', '_self', null, null, '2', '1', '2018-05-11 16:12:20', '2018-05-28 15:45:28');
INSERT INTO `resource` VALUES ('14', '31004', '用户查看', '#', null, '31000', null, 'account:view', '_self', null, null, '2', '1', '2018-05-11 16:20:48', '2018-05-28 15:45:30');
INSERT INTO `resource` VALUES ('15', '32000', '角色管理', '/role', null, '30000', null, 'role:*', '_self', null, null, '1', '1', '2018-05-11 16:16:15', '2018-05-23 11:50:54');
INSERT INTO `resource` VALUES ('16', '32001', '角色增加', '#', null, '32000', null, 'role:create', '_self', null, null, '2', '1', '2018-05-11 16:16:29', '2018-05-22 13:26:10');
INSERT INTO `resource` VALUES ('17', '32002', '角色修改', '#', null, '32000', null, 'role:update', '_self', null, null, '2', '1', '2018-05-11 16:16:29', '2018-05-22 13:26:10');
INSERT INTO `resource` VALUES ('18', '32003', '角色删除', '#', null, '32000', null, 'role:delete', '_self', null, null, '2', '1', '2018-05-11 16:16:29', '2018-05-22 13:26:11');
INSERT INTO `resource` VALUES ('19', '32004', '角色查看', '#', null, '32000', null, 'role:view', '_self', null, null, '2', '1', '2018-05-11 16:21:03', '2018-05-22 13:26:11');
INSERT INTO `resource` VALUES ('20', '40000', '权限资源管理', '#', null, '10000', null, null, '_self', null, null, '1', '1', '2018-05-21 14:31:43', '2018-05-22 13:26:12');
INSERT INTO `resource` VALUES ('21', '41000', '资源管理', '/resource', null, '40000', null, 'resource:*', '_self', null, null, '1', '1', '2018-05-11 16:22:18', '2018-05-23 11:50:56');
INSERT INTO `resource` VALUES ('22', '41001', '资源增加', '#', null, '41000', null, 'resource:create', '_self', null, null, '2', '1', '2018-05-11 16:22:19', '2018-05-22 13:26:13');
INSERT INTO `resource` VALUES ('23', '41002', '资源修改', '#', null, '41000', null, 'resource:update', '_self', null, null, '2', '1', '2018-05-11 16:22:19', '2018-05-22 13:26:14');
INSERT INTO `resource` VALUES ('24', '41003', '资源删除', '#', null, '41000', null, 'resource:delete', '_self', null, null, '2', '1', '2018-05-11 16:22:19', '2018-05-22 13:26:14');
INSERT INTO `resource` VALUES ('25', '41004', '资源查看', '#', null, '41000', null, 'resource:view', '_self', null, null, '2', '1', '2018-05-11 16:22:19', '2018-05-22 13:26:15');
INSERT INTO `resource` VALUES ('26', '42000', '权限管理', '/privilege', null, '40000', null, 'privilege:*', '_self', null, null, '1', '1', '2018-05-11 16:42:41', '2018-05-23 11:50:58');
INSERT INTO `resource` VALUES ('27', '42001', '权限增加', '#', null, '42000', null, 'privilege:create', '_self', null, null, '2', '1', '2018-05-11 16:42:41', '2018-05-22 13:26:16');
INSERT INTO `resource` VALUES ('28', '42002', '权限修改', '#', null, '42000', null, 'privilege:update', '_self', null, null, '2', '1', '2018-05-11 16:42:41', '2018-05-22 13:26:23');
INSERT INTO `resource` VALUES ('29', '42003', '权限删除', '#', null, '42000', null, 'privilege:delete', '_self', null, null, '2', '1', '2018-05-11 16:42:41', '2018-05-22 13:26:23');
INSERT INTO `resource` VALUES ('30', '42004', '权限查看', '#', null, '42000', null, 'privilege:view', '_self', null, null, '2', '1', '2018-05-11 16:42:41', '2018-05-22 13:26:28');
INSERT INTO `resource` VALUES ('31', '50000', '会话管理', '#', null, '10000', null, '', '_self', null, null, '1', '1', '2018-05-28 22:20:34', '2018-05-28 22:21:26');
INSERT INTO `resource` VALUES ('32', '51000', '会话管理', 'session', null, '50000', null, 'session:*', '_self', null, null, '1', '1', '2018-05-28 22:21:25', '2018-05-28 22:21:25');
INSERT INTO `resource` VALUES ('33', '52000', '会话增加', '#', null, '51000', null, 'session:create', '_self', null, null, '2', '1', '2018-05-28 22:22:27', '2018-05-28 22:22:27');
INSERT INTO `resource` VALUES ('34', '53000', '会话修改', '#', null, '51000', null, 'session:update', '_self', null, null, '2', '1', '2018-05-28 22:22:53', '2018-05-28 22:22:53');
INSERT INTO `resource` VALUES ('35', '54000', '会话删除', '#', null, '51000', null, 'session:delete', '_self', null, null, '2', '1', '2018-05-28 22:23:21', '2018-05-28 22:23:21');
INSERT INTO `resource` VALUES ('36', '55000', '会话查看', '#', null, '51000', null, 'session:view', '_self', null, null, '2', '1', '2018-05-28 22:24:01', '2018-05-28 22:24:01');

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
