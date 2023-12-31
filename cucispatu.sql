/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.1.9-MariaDB : Database - cucispatu
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cucispatu` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `cucispatu`;

/*Table structure for table `dt_cuci` */

DROP TABLE IF EXISTS `dt_cuci`;

CREATE TABLE `dt_cuci` (
  `idcuci` varchar(10) NOT NULL,
  `merk` varchar(30) DEFAULT NULL,
  `pemilik` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idcuci`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `dt_cuci` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
