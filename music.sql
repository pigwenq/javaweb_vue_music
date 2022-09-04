/*
SQLyog Ultimate v12.4.3 (64 bit)
MySQL - 5.7.36-log : Database - music
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`music` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `music`;

/*Table structure for table `collect` */

DROP TABLE IF EXISTS `collect`;

CREATE TABLE `collect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `songid` int(11) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;

/*Data for the table `collect` */

insert  into `collect`(`id`,`username`,`songid`,`time`) values 
(48,'朱文强',52,'2021-12-27 11:15:14'),
(49,'朱文强',45,'2021-12-27 11:15:20'),
(52,'朱文强',51,'2021-12-27 11:18:08'),
(53,'朱文强',48,'2021-12-27 11:18:11'),
(54,'朱文强',46,'2021-12-27 11:19:20'),
(55,'朱文强',64,'2021-12-27 11:19:29'),
(56,'朱文强',30,'2021-12-27 11:19:52'),
(78,'zhu',26,'2021-12-28 08:13:59'),
(79,'zhu',25,'2021-12-28 08:13:59'),
(80,'zhu',24,'2021-12-28 08:14:00'),
(92,'zhu',61,'2021-12-29 15:15:13'),
(93,'zhu',19,'2021-12-29 15:15:20'),
(94,'zhu',23,'2021-12-29 15:15:21'),
(95,'zhu',40,'2021-12-29 15:23:50'),
(96,'zhu',39,'2021-12-29 15:23:50'),
(97,'zhu',38,'2021-12-29 15:23:51');

/*Table structure for table `song` */

DROP TABLE IF EXISTS `song`;

CREATE TABLE `song` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `songname` varchar(255) NOT NULL,
  `singer` varchar(20) DEFAULT NULL,
  `fileurl` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `typename` varchar(50) DEFAULT NULL,
  `uploadtime` datetime DEFAULT NULL,
  `clicknum` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;

/*Data for the table `song` */

insert  into `song`(`id`,`songname`,`singer`,`fileurl`,`username`,`typename`,`uploadtime`,`clicknum`) values 
(14,'BEYOND - 光辉岁月','BEYOND ','1640423183045.mp3','zhu','经典老歌','2021-12-25 17:06:23',3),
(15,'BEYOND - 海阔天空','BEYOND ','1640423193243.mp3','zhu','经典老歌','2021-12-25 17:06:33',2),
(16,'陈奕迅 - 富士山下','陈奕迅 ','1640423205120.mp3','zhu','经典老歌','2021-12-25 17:06:45',4),
(17,'陈奕迅 _ 韩红 - 十年 (Live)','陈奕迅 _ 韩红 ','1640423224052.mp3','zhu','经典老歌','2021-12-25 17:07:04',1),
(18,'刀郎 - 西海情歌','刀郎 ','1640423233892.mp3','zhu','经典老歌','2021-12-25 17:07:14',2),
(19,'凤凰传奇 - 郎的诱惑','凤凰传奇 ','1640423247940.mp3','zhu','经典老歌','2021-12-25 17:07:28',4),
(20,'古巨基 _ 徐佳莹 - 情歌王 (Live)','古巨基 _ 徐佳莹 ','1640423260980.mp3','zhu','经典老歌','2021-12-25 17:07:41',3),
(21,'韩磊 - 向天再借五百年 (Live)','韩磊 ','1640423277179.mp3','zhu','经典老歌','2021-12-25 17:07:57',21),
(22,'冷漠 _ 云菲菲 - 伤心城市','冷漠 _ 云菲菲 ','1640423290011.mp3','zhu','经典老歌','2021-12-25 17:08:10',10),
(23,'李克勤 - 月半小夜曲','李克勤 ','1640423301838.mp3','zhu','经典老歌','2021-12-25 17:08:22',15),
(24,'李丽芬 - 爱江山更爱美人 (Live)','李丽芬 ','1640423724644.mp3','zhu','影视金曲','2021-12-25 17:15:25',1),
(25,'梁静茹 - 暖暖 (Live)','梁静茹 ','1640423729439.mp3','zhu','影视金曲','2021-12-25 17:15:29',6),
(26,'梁静茹 - 勇气','梁静茹 ','1640423736920.mp3','zhu','影视金曲','2021-12-25 17:15:37',1),
(27,'林俊杰 - 江南 (DJ白鹤版)','林俊杰 ','1640423741914.mp3','zhu','影视金曲','2021-12-25 17:15:42',2),
(28,'林俊杰 - 美人鱼 (Live)','林俊杰 ','1640423747716.mp3','zhu','影视金曲','2021-12-25 17:15:48',1),
(29,'刘德华 - 暗里着迷 (Radio Edit)','刘德华 ','1640423752847.mp3','zhu','影视金曲','2021-12-25 17:15:53',1),
(30,'刘德华 - 冰雨 (Live)','刘德华 ','1640423759474.mp3','zhu','影视金曲','2021-12-25 17:15:59',0),
(31,'刘德华 - 练习 (Live)','刘德华 ','1640423764351.mp3','zhu','影视金曲','2021-12-25 17:16:04',2),
(32,'刘德华 - 忘情水 (Live)','刘德华 ','1640423769933.mp3','zhu','影视金曲','2021-12-25 17:16:10',2),
(33,'刘若英 - 后来','刘若英 ','1640423775237.mp3','zhu','影视金曲','2021-12-25 17:16:15',9),
(34,'卢冠廷 - 一生所爱 (Live)','卢冠廷 ','1640423879540.mp3','zhu','新歌上架','2021-12-25 17:18:00',3),
(35,'罗文 _ 甄妮 - 铁血丹心','罗文 _ 甄妮 ','1640423885970.mp3','zhu','新歌上架','2021-12-25 17:18:06',4),
(36,'那英 - 默','那英 ','1640423890759.mp3','zhu','新歌上架','2021-12-25 17:18:11',4),
(37,'朴树 - 平凡之路 (Live)','朴树 ','1640423895922.mp3','zhu','新歌上架','2021-12-25 17:18:16',3),
(38,'青鸟飞鱼 - 此生不换','青鸟飞鱼 ','1640423901218.mp3','zhu','新歌上架','2021-12-25 17:18:21',2),
(39,'孙燕姿 - 遇见','孙燕姿 ','1640423905807.mp3','zhu','新歌上架','2021-12-25 17:18:26',4),
(40,'谭咏麟 - 讲不出再见 (Live)','谭咏麟 ','1640423910653.mp3','zhu','新歌上架','2021-12-25 17:18:31',2),
(41,'谭咏麟 - 一生中最爱','谭咏麟 ','1640423915830.mp3','zhu','新歌上架','2021-12-25 17:18:36',1),
(42,'陶喆 - 就是爱你 (Live)','陶喆 ','1640423923797.mp3','zhu','新歌上架','2021-12-25 17:18:44',3),
(43,'田馥甄 - 小幸运 (Live)','田馥甄 ','1640423929232.mp3','zhu','新歌上架','2021-12-25 17:18:49',16),
(44,'王杰 - 忘了你忘了我 (单曲)','王杰 ','1640423976060.mp3','zhu','华语金曲','2021-12-25 17:19:36',1),
(45,'许嵩 - 有何不可 (纯音乐)','许嵩 ','1640423983132.mp3','zhu','华语金曲','2021-12-25 17:19:43',7),
(46,'许巍 - 曾经的你 (Live)','许巍 ','1640423987733.mp3','zhu','华语金曲','2021-12-25 17:19:48',5),
(47,'许巍 - 蓝莲花 (Live)','许巍 ','1640423992205.mp3','zhu','华语金曲','2021-12-25 17:19:52',2),
(48,'于文文 - 体面 (Live)','于文文 ','1640423996832.mp3','zhu','华语金曲','2021-12-25 17:19:57',3),
(49,'张学友 - 吻别 (Live)','张学友 ','1640424003826.mp3','zhu','华语金曲','2021-12-25 17:20:04',4),
(50,'张学友 - 遥远的她 (Live)','张学友 ','1640424008997.mp3','zhu','华语金曲','2021-12-25 17:20:09',1),
(51,'张雨生 - 大海','张雨生 ','1640424021811.mp3','zhu','华语金曲','2021-12-25 17:20:22',7),
(52,'郑智化 - 水手','郑智化 ','1640424030134.mp3','zhu','华语金曲','2021-12-25 17:20:30',4),
(53,'周杰伦 - 搁浅 (Live)','周杰伦 ','1640424042256.mp3','zhu','华语金曲','2021-12-25 17:20:42',4),
(61,'陈奕迅 _ 韩红 - 十年 (Live)','陈奕迅 _ 韩红 ','1640507503510.mp3','zhu','经典老歌','2021-12-26 16:31:44',12),
(62,'梁静茹 - 勇气','梁静茹 ','1640528331468.mp3','zhu','新歌上架','2021-12-26 22:18:51',31),
(63,'林俊杰 - 美人鱼 (Live)','林俊杰 ','1640568434910.mp3','zhu','华语金曲','2021-12-27 09:27:15',8),
(64,'刘德华 - 暗里着迷 (Radio Edit)','刘德华 ','1640568522580.mp3','zhu','华语金曲','2021-12-27 09:28:43',2),
(65,'刘德华 - 暗里着迷 (Radio Edit)','刘德华 ','1640576842294.mp3','zhu','影视金曲','2021-12-27 11:47:22',3),
(66,'梁静茹 - 勇气','梁静茹 ','1640612943824.mp3','zhu','经典老歌','2021-12-27 21:49:04',3);

/*Table structure for table `songtype` */

DROP TABLE IF EXISTS `songtype`;

CREATE TABLE `songtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `songtype` */

insert  into `songtype`(`id`,`typename`) values 
(1,'经典老歌'),
(2,'影视金曲'),
(3,'新歌上架'),
(4,'华语金曲');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `createtime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`createtime`) values 
(20,'5','1','2021-12-24 17:29:55'),
(21,'1','1','2021-12-24 17:30:18'),
(22,'2','1','2021-12-24 17:30:23'),
(23,'zhu','zhu','2021-12-24 23:25:03'),
(24,'12','12','2021-12-24 23:25:42'),
(25,'123','123','2021-12-24 23:32:26'),
(26,'121','12','2021-12-24 23:33:21'),
(27,'q','q','2021-12-24 23:34:46'),
(28,'朱文强','123','2021-12-27 10:59:04');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;