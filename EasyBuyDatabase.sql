/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.40 : Database - ebuy
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ebuy` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ebuy`;

/*Table structure for table `easybuy_news` */

DROP TABLE IF EXISTS `easybuy_news`;

CREATE TABLE `easybuy_news` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `tile` varchar(255) NOT NULL COMMENT '标题',
  `content` varchar(1024) NOT NULL COMMENT '内容',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '录入时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `easybuy_news` */

/*Table structure for table `easybuy_order` */

DROP TABLE IF EXISTS `easybuy_order`;

CREATE TABLE `easybuy_order` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `userId` int(10) NOT NULL COMMENT '用户名ID',
  `loginName` varchar(20) NOT NULL COMMENT '登陆用户名',
  `userAddress` varchar(200) NOT NULL COMMENT '用户地址',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `cost` double NOT NULL COMMENT '金额',
  `status` int(1) NOT NULL COMMENT '状态',
  `type` int(1) NOT NULL COMMENT '类型',
  `serialNumber` varchar(64) NOT NULL COMMENT '订单号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `easybuy_order` */

/*Table structure for table `easybuy_order_detail` */

DROP TABLE IF EXISTS `easybuy_order_detail`;

CREATE TABLE `easybuy_order_detail` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `orderId` int(10) NOT NULL COMMENT '订单ID',
  `productId` int(10) NOT NULL COMMENT '商品ID',
  `quantity` int(11) NOT NULL COMMENT '数量',
  `cost` double NOT NULL COMMENT '金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `easybuy_order_detail` */

/*Table structure for table `easybuy_product` */

DROP TABLE IF EXISTS `easybuy_product`;

CREATE TABLE `easybuy_product` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `name` varchar(20) NOT NULL COMMENT '商品名称',
  `description` varchar(100) DEFAULT NULL COMMENT '商品描述',
  `price` double NOT NULL COMMENT '商品价格',
  `stock` int(10) NOT NULL COMMENT '商品库存',
  `categoryLevel1` int(10) NOT NULL COMMENT '所属分类ID',
  `categoryLevel2` int(10) DEFAULT NULL COMMENT '所属二级分类ID',
  `categoryLevel3` int(10) DEFAULT NULL COMMENT '所属三级分类ID',
  `fileName` varchar(200) NOT NULL COMMENT '上传的文件名',
  `isDelete` int(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `easybuy_product` */

/*Table structure for table `easybuy_product_category` */

DROP TABLE IF EXISTS `easybuy_product_category`;

CREATE TABLE `easybuy_product_category` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(20) NOT NULL COMMENT '名字',
  `parentId` int(10) DEFAULT NULL COMMENT '父分类',
  `type` int(1) NOT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `easybuy_product_category` */

/*Table structure for table `easybuy_user` */

DROP TABLE IF EXISTS `easybuy_user`;

CREATE TABLE `easybuy_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `userName` varchar(20) NOT NULL COMMENT '用户真实姓名',
  `loginName` varchar(20) NOT NULL COMMENT '用户登录名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `sex` int(1) NOT NULL COMMENT '性别',
  `identityCode` varchar(18) DEFAULT NULL COMMENT '身份证',
  `email` varchar(80) DEFAULT NULL COMMENT '电子邮箱',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机',
  `type` int(1) NOT NULL COMMENT '用户类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `easybuy_user` */

/*Table structure for table `easybuy_user_address` */

DROP TABLE IF EXISTS `easybuy_user_address`;

CREATE TABLE `easybuy_user_address` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键，地址id',
  `address` varchar(20) NOT NULL COMMENT '地址',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userId` int(10) NOT NULL COMMENT '用户主键',
  `idDefault` int(1) NOT NULL COMMENT '是否是默认地址',
  `remark` varchar(18) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `easybuy_user_address` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
