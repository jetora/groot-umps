-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: sso
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'admin','admin',1,'2018-05-10 14:42:17','2018-05-28 09:42:37'),(2,'user','user',1,'2018-05-10 14:42:17','2018-05-13 12:30:28'),(3,'anonymous','anonymous',1,'2018-05-10 14:42:17','2018-05-13 12:30:34'),(15,'john','john',1,'2018-05-11 17:37:42','2018-05-13 12:30:40'),(16,'hulk','hulk',1,'2018-05-11 17:37:42','2018-05-13 12:30:44'),(17,'stark','stark',1,'2018-05-11 17:37:42','2018-05-13 12:30:49'),(18,'tom','tom',1,'2018-05-11 17:37:42','2018-05-13 12:30:53'),(19,'jerry','jerry',1,'2018-05-11 17:37:43','2018-06-05 14:08:08'),(20,'boss','boss',2,'2018-05-11 17:37:43','2018-06-05 14:08:08'),(21,'johnsnow','johnsnow',2,'2018-05-16 17:47:05','2018-06-05 14:08:03'),(22,'ronstark','ronstark',1,'2018-05-16 19:24:40','2018-05-16 19:24:40'),(23,'ronstark','ronstark',1,'2018-05-16 19:27:21','2018-05-16 19:27:21'),(24,'addDatastark','addDatastark',1,'2018-05-16 19:29:34','2018-05-16 19:29:34'),(25,'button','button',1,'2018-05-16 19:32:28','2018-05-16 19:32:28'),(26,'farmmer','farmmer',1,'2018-05-16 19:37:01','2018-05-16 19:37:01'),(27,'thunder','thunder',1,'2018-05-16 19:38:28','2018-05-16 19:38:28'),(28,'bora','bora',1,'2018-05-16 19:49:34','2018-05-16 19:49:34'),(29,'dudu','dudu',1,'2018-05-16 21:35:04','2018-05-16 21:35:04'),(30,'dudu','dudu',1,'2018-05-16 21:38:55','2018-05-16 21:38:55'),(31,'dudu','dudu',2,'2018-05-16 21:42:55','2018-05-16 21:42:55'),(32,'dudu','dudu',1,'2018-05-16 21:43:12','2018-05-23 23:31:21'),(33,'asdasda','http://127.0.0.1:8080/home',1,'2018-05-28 09:42:12','2018-05-28 09:42:12'),(34,'asdasdas','asdasdas',2,'2018-05-28 09:42:29','2018-06-05 18:54:03'),(35,'asdasdas','asdasdas',1,'2018-05-28 09:42:55','2018-06-05 18:54:03'),(36,'asdasdas','asdasdas',2,'2018-05-28 09:43:02','2018-06-05 18:53:58'),(37,'asdasdas','asdasdas',2,'2018-05-28 09:43:13','2018-06-05 11:45:51');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_copy`
--

DROP TABLE IF EXISTS `account_copy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_copy`
--

LOCK TABLES `account_copy` WRITE;
/*!40000 ALTER TABLE `account_copy` DISABLE KEYS */;
INSERT INTO `account_copy` VALUES (1,'admin','$2a$10$MTFVrdqbHOi.CCUhkrkZnOBdrZEfk3gzIUyZBdQvLWvdF/0pnkEO2',1,'2018-05-10 14:42:17','2018-05-10 14:42:17'),(2,'user','$2a$10$6KDklkImZgGANWR8pDAwSexf6Bt4Z9I0nDiwdih9Q38HI4eAkWk0u',1,'2018-05-10 14:42:17','2018-05-10 14:42:17'),(3,'anonymous','$2a$10$58UG9Udx7RhCL1.356NyAu0Rp936vbo1vHahj8v0O0XOTSkKY0XyG',1,'2018-05-10 14:42:17','2018-05-10 14:42:17'),(4,'john','$2a$10$SpSCzJ1OU91PBOezF1YMG.P2MJnsLrpAVZGB9xmT3qagvoQ9QP.fa',1,'2018-05-11 17:37:42','2018-06-05 15:49:07'),(5,'hulk','$2a$10$VqLkXeGdFDGvV.d0mtrdD.nYLyGmgkprBpWQ7R4e5XSxCIteMogIO',1,'2018-05-11 17:37:42','2018-06-05 15:49:07'),(6,'stark','$2a$10$l/2bk8MqaVFcBHT4kB5mIudDEr2AUFCKbvur4BzUEZuHK2HwUdQvG',1,'2018-05-11 17:37:42','2018-06-05 15:49:07'),(7,'tom','$2a$10$SpSCzJ1OU91PBOezF1YMG.P2MJnsLrpAVZGB9xmT3qagvoQ9QP.fa',1,'2018-05-11 17:37:42','2018-06-05 15:49:07'),(8,'jerry','$2a$10$cPfk/j38MLeQUlFUG7L7Mew9z59DvqDaqTnLb509UUAPRIY7wme8e',1,'2018-05-11 17:37:43','2018-06-05 15:49:07'),(9,'boss','$2a$10$pN2LjyxIbtp0WHtqBwHRI.BZT43/hsyUbKibzIxS9NodWA/uFgI4u',1,'2018-05-11 17:37:43','2018-06-05 15:49:07');
/*!40000 ALTER TABLE `account_copy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_group_relationship`
--

DROP TABLE IF EXISTS `account_group_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_group_relationship`
--

LOCK TABLES `account_group_relationship` WRITE;
/*!40000 ALTER TABLE `account_group_relationship` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_group_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_role_relationship`
--

DROP TABLE IF EXISTS `account_role_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_role_relationship` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `account_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_account_id` (`account_id`),
  KEY `idx_role_id` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_role_relationship`
--

LOCK TABLES `account_role_relationship` WRITE;
/*!40000 ALTER TABLE `account_role_relationship` DISABLE KEYS */;
INSERT INTO `account_role_relationship` VALUES (1,1,1,'2018-06-05 15:49:51','2018-06-05 15:49:51'),(2,2,2,'2018-06-05 15:49:51','2018-06-05 15:49:51'),(3,3,3,'2018-06-05 15:49:51','2018-06-05 15:49:51'),(4,1,2,'2018-06-05 18:51:17','2018-06-05 18:51:17');
/*!40000 ALTER TABLE `account_role_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organization`
--

DROP TABLE IF EXISTS `organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization`
--

LOCK TABLES `organization` WRITE;
/*!40000 ALTER TABLE `organization` DISABLE KEYS */;
INSERT INTO `organization` VALUES (1,10000,'总部',0,1,'2018-05-11 11:34:27','2018-05-28 15:05:46'),(2,20000,'北京分公司',10000,1,'2018-05-11 11:34:27','2018-05-28 15:10:15'),(3,21000,'北京分公司-海淀支行',20000,1,'2018-05-11 11:34:27','2018-05-28 15:10:22'),(4,21100,'北京分公司-海淀支行-知春路店',21000,1,'2018-05-11 11:34:27','2018-05-28 15:10:29'),(5,21200,'北京分公司-海淀支行-中关村店',21000,1,'2018-05-11 11:34:27','2018-05-28 15:10:35'),(6,22000,'北京分公司-朝阳支行',20000,1,'2018-05-11 11:34:27','2018-05-28 15:10:40'),(7,23000,'北京分公司-大兴支行',20000,1,'2018-05-11 11:34:27','2018-05-28 15:10:45'),(8,23100,'北京分公司-大兴支行-清源路分店',23000,1,'2018-05-11 11:34:27','2018-05-28 15:10:55'),(9,23110,'北京分公司-大兴支行-清源路店1店',23100,1,'2018-05-11 11:34:27','2018-05-28 15:12:28'),(10,23120,'北京分公司-大兴支行-清源路店2店',23100,1,'2018-05-11 11:34:27','2018-05-28 15:12:33'),(11,23130,'北京分公司-大兴支行-清源路店3店',23100,1,'2018-05-11 11:34:27','2018-05-28 15:12:41'),(12,23200,'北京分公司-大兴支行-黄村西大街分店',23000,1,'2018-05-11 11:34:27','2018-05-28 15:12:47'),(13,23210,'北京分公司-大兴支行-黄村西大街1店',23200,1,'2018-05-11 11:34:27','2018-05-28 15:13:13'),(14,23220,'北京分公司-大兴支行-黄村西大街2店',23200,1,'2018-05-11 11:34:27','2018-05-28 15:13:21'),(15,23230,'北京分公司-大兴支行-黄村西大街3店',23200,1,'2018-05-11 11:34:27','2018-05-28 15:13:25'),(16,30000,'天津分公司',10000,1,'2018-05-11 11:34:28','2018-05-28 15:13:34'),(17,31000,'天津分公司-滨海新区支行',30000,1,'2018-05-11 11:34:28','2018-05-28 15:13:45'),(18,31100,'天津分公司-滨海新区支行-塘沽街道分店',31000,1,'2018-05-11 11:34:28','2018-05-28 15:13:53'),(19,31110,'天津分公司-滨海新区支行-塘沽街道1店',31100,1,'2018-05-11 11:34:28','2018-06-04 19:30:30'),(20,31120,'天津分公司-滨海新区支行-塘沽街道2店',31100,1,'2018-05-11 11:34:28','2018-06-04 19:30:30'),(21,31130,'天津分公司-滨海新区支行-胡家园街道分店',31000,1,'2018-05-11 11:34:28','2018-05-28 15:16:32'),(22,31140,'天津分公司-滨海新区支行-胡家园街道1店',31130,1,'2018-05-11 11:34:28','2018-06-04 19:30:30'),(23,31150,'天津分公司-滨海新区支行-胡家园街道2店',31130,1,'2018-05-11 11:34:28','2018-06-04 19:30:30'),(24,40000,'河北分公司',10000,1,'2018-05-11 11:34:28','2018-05-28 15:16:56'),(25,41000,'河北分公司-邢台支行',40000,1,'2018-05-11 11:34:28','2018-05-28 15:17:09'),(26,41100,'河北分公司-邢台支行-宁晋支行',41000,1,'2018-05-11 11:34:28','2018-05-28 15:17:12'),(27,41110,'河北分公司-邢台支行-宁晋支行-世爵公馆1店',41100,1,'2018-05-11 11:34:28','2018-05-28 15:17:18'),(28,41120,'河北分公司-邢台支行-宁晋支行-世爵公馆2店',41100,1,'2018-05-11 11:34:28','2018-05-28 15:17:21'),(29,42000,'河北分公司-石家庄支行',40000,1,'2018-05-11 11:34:28','2018-05-28 15:17:26'),(30,42100,'河北分公司-石家庄支行-机场路支行',42000,1,'2018-05-11 11:34:28','2018-05-28 15:17:47'),(31,42110,'河北分公司-石家庄支行-机场路支行1点',42100,1,'2018-05-11 11:34:28','2018-05-28 15:24:13'),(32,42120,'河北分公司-石家庄支行-机场路支行2店',42100,1,'2018-05-11 11:34:28','2018-05-28 15:24:15');
/*!40000 ALTER TABLE `organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privilege`
--

DROP TABLE IF EXISTS `privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privilege` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(50) NOT NULL COMMENT '权限名称',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `enabled` tinyint(4) NOT NULL COMMENT '是否可用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilege`
--

LOCK TABLES `privilege` WRITE;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
INSERT INTO `privilege` VALUES (1,'PRIVILEGE_ADMIN','privilege_admin',1,'2018-05-11 17:17:36','2018-05-11 17:17:36'),(2,'PRIVILEGE_DBA','privilege_dba',1,'2018-05-11 17:17:36','2018-05-11 17:17:36'),(3,'PRIVILEGE_USER','privilege_user',1,'2018-05-11 17:17:36','2018-05-11 17:17:36'),(4,'PRIVILEGE_ANONYMOUS','privilege_anonymous',1,'2018-05-11 17:17:36','2018-06-05 15:16:27');
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privilege_resource_relationship`
--

DROP TABLE IF EXISTS `privilege_resource_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='权限资源关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilege_resource_relationship`
--

LOCK TABLES `privilege_resource_relationship` WRITE;
/*!40000 ALTER TABLE `privilege_resource_relationship` DISABLE KEYS */;
INSERT INTO `privilege_resource_relationship` VALUES (1,1,10000,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(2,1,11000,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(3,1,20000,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(4,1,21000,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(5,1,21001,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(6,1,21002,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(7,1,21003,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(8,1,21004,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(9,1,30000,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(10,1,31000,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(11,1,31001,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(12,1,31002,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(13,1,31003,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(14,1,31004,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(15,1,32000,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(16,1,32001,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(17,1,32002,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(18,1,32003,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(19,1,32004,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(20,1,40000,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(21,1,41000,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(22,1,41001,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(23,1,41002,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(24,1,41003,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(25,1,41004,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(26,1,42000,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(27,1,42001,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(28,1,42002,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(29,1,42003,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(30,1,42004,1,'2018-06-05 15:08:11','2018-06-05 15:08:11'),(31,3,11000,1,'2018-06-05 15:51:34','2018-06-05 15:51:34'),(32,4,11000,1,'2018-06-05 15:51:34','2018-06-05 15:51:34');
/*!40000 ALTER TABLE `privilege_resource_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource`
--

DROP TABLE IF EXISTS `resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource`
--

LOCK TABLES `resource` WRITE;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
INSERT INTO `resource` VALUES (1,10000,'资源',NULL,NULL,0,NULL,NULL,'',NULL,NULL,NULL,1,'2018-05-11 16:04:49','2018-05-21 16:05:25'),(2,11000,'首页','/home',NULL,10000,NULL,NULL,'_self',NULL,NULL,1,1,'2018-05-28 18:27:54','2018-05-28 18:27:54'),(3,20000,'系统组织管理','#',NULL,10000,NULL,NULL,'_self',NULL,NULL,1,1,'2018-05-21 14:31:04','2018-05-22 13:26:02'),(4,21000,'组织机构管理','/organization',NULL,20000,NULL,'organization:*','_self',NULL,NULL,1,1,'2018-05-11 16:18:44','2018-05-23 12:02:26'),(5,21001,'组织机构增加','#',NULL,21000,NULL,'organization:create','_self',NULL,NULL,2,1,'2018-05-11 16:18:44','2018-05-28 15:42:25'),(6,21002,'组织机构修改','#',NULL,21000,NULL,'organization:update','_self',NULL,NULL,2,1,'2018-05-11 16:18:44','2018-05-28 15:42:26'),(7,21003,'组织机构删除','#',NULL,21000,NULL,'organization:delete','_self',NULL,NULL,2,1,'2018-05-11 16:18:44','2018-05-28 15:42:28'),(8,21004,'组织机构查看','#',NULL,21000,NULL,'organization:view','_self',NULL,NULL,2,1,'2018-05-11 16:21:04','2018-05-28 15:42:29'),(9,30000,'用户角色管理','#',NULL,10000,NULL,NULL,'_self',NULL,NULL,1,1,'2018-05-21 14:31:25','2018-05-28 15:43:08'),(10,31000,'用户管理','/account',NULL,30000,NULL,'account:*','_self',NULL,NULL,1,1,'2018-05-11 16:07:49','2018-05-28 15:45:24'),(11,31001,'用户增加','#',NULL,31000,NULL,'account:create','_self',NULL,NULL,2,1,'2018-05-11 16:12:20','2018-05-28 15:45:25'),(12,31002,'用户修改','#',NULL,31000,NULL,'account:update','_self',NULL,NULL,2,1,'2018-05-11 16:12:20','2018-05-28 15:45:26'),(13,31003,'用户删除','#',NULL,31000,NULL,'account:delete','_self',NULL,NULL,2,1,'2018-05-11 16:12:20','2018-05-28 15:45:28'),(14,31004,'用户查看','#',NULL,31000,NULL,'account:view','_self',NULL,NULL,2,1,'2018-05-11 16:20:48','2018-05-28 15:45:30'),(15,32000,'角色管理','/role',NULL,30000,NULL,'role:*','_self',NULL,NULL,1,1,'2018-05-11 16:16:15','2018-05-23 11:50:54'),(16,32001,'角色增加','#',NULL,32000,NULL,'role:create','_self',NULL,NULL,2,1,'2018-05-11 16:16:29','2018-05-22 13:26:10'),(17,32002,'角色修改','#',NULL,32000,NULL,'role:update','_self',NULL,NULL,2,1,'2018-05-11 16:16:29','2018-05-22 13:26:10'),(18,32003,'角色删除','#',NULL,32000,NULL,'role:delete','_self',NULL,NULL,2,1,'2018-05-11 16:16:29','2018-05-22 13:26:11'),(19,32004,'角色查看','#',NULL,32000,NULL,'role:view','_self',NULL,NULL,2,1,'2018-05-11 16:21:03','2018-05-22 13:26:11'),(20,40000,'权限资源管理','#',NULL,10000,NULL,NULL,'_self',NULL,NULL,1,1,'2018-05-21 14:31:43','2018-05-22 13:26:12'),(21,41000,'资源管理','/resource',NULL,40000,NULL,'resource:*','_self',NULL,NULL,1,1,'2018-05-11 16:22:18','2018-05-23 11:50:56'),(22,41001,'资源增加','#',NULL,41000,NULL,'resource:create','_self',NULL,NULL,2,1,'2018-05-11 16:22:19','2018-05-22 13:26:13'),(23,41002,'资源修改','#',NULL,41000,NULL,'resource:update','_self',NULL,NULL,2,1,'2018-05-11 16:22:19','2018-05-22 13:26:14'),(24,41003,'资源删除','#',NULL,41000,NULL,'resource:delete','_self',NULL,NULL,2,1,'2018-05-11 16:22:19','2018-05-22 13:26:14'),(25,41004,'资源查看','#',NULL,41000,NULL,'resource:view','_self',NULL,NULL,2,1,'2018-05-11 16:22:19','2018-05-22 13:26:15'),(26,42000,'权限管理','/privilege',NULL,40000,NULL,'privilege:*','_self',NULL,NULL,1,1,'2018-05-11 16:42:41','2018-05-23 11:50:58'),(27,42001,'权限增加','#',NULL,42000,NULL,'privilege:create','_self',NULL,NULL,2,1,'2018-05-11 16:42:41','2018-05-22 13:26:16'),(28,42002,'权限修改','#',NULL,42000,NULL,'privilege:update','_self',NULL,NULL,2,1,'2018-05-11 16:42:41','2018-05-22 13:26:23'),(29,42003,'权限删除','#',NULL,42000,NULL,'privilege:delete','_self',NULL,NULL,2,1,'2018-05-11 16:42:41','2018-05-22 13:26:23'),(30,42004,'权限查看','#',NULL,42000,NULL,'privilege:view','_self',NULL,NULL,2,1,'2018-05-11 16:42:41','2018-05-22 13:26:28');
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(50) NOT NULL COMMENT '角色名称',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `enabled` tinyint(4) NOT NULL COMMENT '是否可用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN','admin',1,'2018-05-11 17:09:23','2018-05-11 17:09:23'),(2,'ROLE_DBA','dba',1,'2018-05-11 17:09:24','2018-06-05 15:53:48'),(3,'ROLE_USER','user',1,'2018-05-11 17:09:24','2018-05-11 17:09:24'),(4,'ROLE_ANONYMOUS','anonymous',1,'2018-05-11 17:09:24','2018-05-11 17:09:24'),(5,'ROLE_STAFF','staff',1,'2018-06-05 15:10:26','2018-06-05 15:10:26'),(6,'ROLE_MANAGER','manager',1,'2018-06-05 15:11:40','2018-06-05 15:11:40'),(7,'ROLE_CHIEF','chief',1,'2018-06-05 15:11:40','2018-06-05 15:11:40');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_group_relationship`
--

DROP TABLE IF EXISTS `role_group_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_group_relationship`
--

LOCK TABLES `role_group_relationship` WRITE;
/*!40000 ALTER TABLE `role_group_relationship` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_group_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_privilege_relationshp`
--

DROP TABLE IF EXISTS `role_privilege_relationshp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_privilege_relationshp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `privilege_id` bigint(20) NOT NULL COMMENT '权限ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_role_id` (`role_id`),
  KEY `idx_privilege_id` (`privilege_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='角色权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_privilege_relationshp`
--

LOCK TABLES `role_privilege_relationshp` WRITE;
/*!40000 ALTER TABLE `role_privilege_relationshp` DISABLE KEYS */;
INSERT INTO `role_privilege_relationshp` VALUES (1,1,1,'2018-05-11 17:46:21','2018-05-11 17:46:21'),(2,2,2,'2018-05-11 17:46:21','2018-05-11 17:46:21'),(3,3,3,'2018-05-11 17:46:21','2018-05-11 17:46:21'),(4,4,4,'2018-05-11 17:46:21','2018-05-11 17:46:21'),(6,5,3,'2018-06-05 15:54:48','2018-06-05 15:54:48'),(7,6,3,'2018-06-05 15:54:48','2018-06-05 15:54:48'),(8,7,3,'2018-06-05 15:54:48','2018-06-05 15:54:48');
/*!40000 ALTER TABLE `role_privilege_relationshp` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-05 19:10:47
