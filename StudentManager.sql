/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - ssm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ssm` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ssm`;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `courseId` int(11) NOT NULL,
  `courseName` varchar(32) NOT NULL,
  `courseTeacher` varchar(32) NOT NULL,
  `courseSite` varchar(32) NOT NULL,
  `courseTime` varchar(32) NOT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`courseId`,`courseName`,`courseTeacher`,`courseSite`,`courseTime`) values (3,'Java程序设计','王五','三教203','周三1~2节'),(4,'C语言基础','谭浩强','二教102','周二1~2节'),(5,'PHP基础','赵六','二教301','周四5~6节'),(6,'计算机网络','谢希仁','三教201','周一5~6节'),(7,'MySQL数据库应用','李辉','二教208','周三7~8节'),(8,'数据结构','罗福强','一教216','周三1~2节'),(9,'Hadoop大数据开发基础','余明辉','二教213','周一7~8节'),(10,'管理学','赵明','三教103','周二3~4节');

/*Table structure for table `stu_course` */

DROP TABLE IF EXISTS `stu_course`;

CREATE TABLE `stu_course` (
  `sid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  `score` double DEFAULT NULL,
  KEY `sid` (`sid`),
  KEY `cid` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stu_course` */

insert  into `stu_course`(`sid`,`cid`,`score`) values (2,2,NULL),(2,3,NULL),(2,4,NULL),(6,2,NULL),(6,3,NULL),(6,4,NULL),(9,2,87),(9,5,NULL),(10,8,NULL),(10,5,NULL),(11,2,NULL),(11,5,NULL),(11,7,NULL),(11,4,88),(11,9,NULL),(12,2,NULL),(12,3,NULL),(12,7,NULL),(12,9,NULL),(12,10,NULL),(13,2,NULL),(13,3,NULL),(13,5,NULL),(13,6,NULL),(13,7,NULL),(14,2,NULL),(14,9,NULL),(14,3,NULL),(52,3,NULL),(52,4,NULL),(52,5,NULL);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `sid` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  `age` int(11) NOT NULL,
  `cls` varchar(32) NOT NULL,
  `birthday` varchar(32) NOT NULL,
  `sex` varchar(32) NOT NULL,
  `num` int(11) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`sid`,`name`,`age`,`cls`,`birthday`,`sex`,`num`) values (6,'bbbb',32,'2','2000-08-27','女',12),(7,'cccc',22,'1','2000-08-27','男',11),(9,'伊凡',22,'1','2000-08-27','n',2),(10,'苏通',12,'2','2000-08-27','a',3),(11,'赵玉',12,'2','2000-08-27','a',2),(12,'张亚',22,'3','2000-08-27','a',4),(13,'王野',22,'1','2000-08-27','b',6),(14,'欧阳离境',15,'2','2000-08-27','c',9);

/*Table structure for table `tea_course` */

DROP TABLE IF EXISTS `tea_course`;

CREATE TABLE `tea_course` (
  `tid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  PRIMARY KEY (`tid`),
  KEY `cid` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tea_course` */

insert  into `tea_course`(`tid`,`cid`) values (15,1),(16,2),(17,3),(18,4),(19,5),(20,6),(21,7),(22,8),(23,9),(24,10);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `tid` int(11) NOT NULL,
  `tname` varchar(32) NOT NULL,
  `age` int(11) NOT NULL,
  `birthday` varchar(32) NOT NULL,
  `sex` varchar(32) NOT NULL,
  `course` varchar(32) NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`tid`,`tname`,`age`,`birthday`,`sex`,`course`) values (15,'张三',32,'2000-08-27','男','高等数学'),(16,'李四',32,'2000-08-27','男','大学英语'),(17,'王五',22,'2000-08-27','男','Java程序设计'),(18,'谭浩强',32,'2000-08-27','男','C语言基础'),(19,'赵六',32,'2000-08-27','女','PHP基础'),(20,'谢希仁',32,'2000-08-27','女','计算机网络'),(21,'李辉',32,'2000-08-27','男','MySQL数据库应用'),(22,'罗福强',32,'2000-08-27','男','数据结构'),(23,'余明辉',32,'2000-08-27','男','Hadoop大数据开发基础'),(24,'赵明',32,'2000-08-27','女','管理学'),(25,'李晓峰',32,'2000-08-27','女','Linux操作系统');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `type` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`email`,`name`,`type`) values (1,'moveon','moveon','609997347@qq.com','moveon','admin'),(2,'aaaa','aaaa','609997347@qq.com','aaaa','student'),(6,'bbbb','bbbb','609997347@qq.com','bbbb','student'),(7,'cccc','cccc','609997347@qq.com','cccc','teacher'),(8,'hzh','aaaaaa','609997347@qq.com','hzh','admin'),(9,'aa01','aa01','609997347@qq.com','伊凡','student'),(10,'aa02','aa02','609997347@qq.com','苏通','student'),(11,'aa03','aa03','609997347@qq.com','赵玉','student'),(12,'aa04','aa04','609997347@qq.com','张亚','student'),(13,'aa05','aa05','609997347@qq.com','王野','student'),(14,'aa06','aa06','609997347@qq.com','欧阳离境','student'),(15,'bb01','bb01','609997347@qq.com','张三','teacher'),(16,'bb02','bb02','609997347@qq.com','李四','teacher'),(17,'bb03','bb03','609997347@qq.com','王五','teacher'),(18,'bb04','bb04','609997347@qq.com','谭浩强','teacher'),(19,'bb05','bb05','609997347@qq.com','赵六','teacher'),(20,'bb06','bb06','609997347@qq.com','谢希仁','teacher'),(21,'bb07','bb07','609997347@qq.com','李辉','teacher'),(22,'bb08','bb08','609997347@qq.com','罗福强','teacher'),(23,'bb09','bb09','609997347@qq.com','余明辉','teacher'),(24,'bb10','bb10','609997347@qq.com','赵明','teacher'),(25,'bb11','bb11','609997347@qq.com','李晓峰','teacher'),(26,'abcd','abcd','609997347@qq.com','abcd','student'),(27,'abcde','abcde','609997347@qq.com','abcde','teacher');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
