/*
SQLyog Community v13.1.2 (32 bit)
MySQL - 5.5.41 : Database - itinerary
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`itinerary` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `itinerary`;

/*Table structure for table `hotels` */

DROP TABLE IF EXISTS `hotels`;

CREATE TABLE `hotels` (
  `hotel_id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_name` varchar(100) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`hotel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `hotels` */

insert  into `hotels`(`hotel_id`,`hotel_name`,`address`,`price`,`location`) values 
(1,'Evolve Back, Coorg','Karadigodu Post, Siddapura, Coorg, Karnataka 571253',22000.00,'Coorg'),
(2,'Old Kent Estates & Spa','Bikkapathimangala, Kakkabe Post, Siddapura, Coorg, Karnataka 571212',17000.00,'Coorg'),
(3,'Coorg Wilderness Resort','Survey No. 21/1, Monnangeri Village, Galibeedu Post, Madikeri, Coorg, Karnataka 571201',14000.00,'Coorg'),
(4,'Taj Madikeri Resort & Spa','1st Monnangeri Galibeedu, Madikeri, Coorg, Karnataka 571201',15000.00,'Coorg'),
(5,'The Tamara Coorg','Kabbinakad Estate, Napoklu Nad, Yavakapadi Village, Madikeri, Karnataka 571212',20000.00,'Coorg'),
(6,'The Ibnii Spa Resort','Coorg Karadigodu Post, 571234, Madikeri, Karnataka',18000.00,'Coorg');

/*Table structure for table `places` */

DROP TABLE IF EXISTS `places`;

CREATE TABLE `places` (
  `place_name` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `places` */

insert  into `places`(`place_name`,`location`) values 
('Abbey Falls','Coorg'),
('Madikeri Fort','Coorg'),
('Raja\'s Seat','Coorg'),
('Namdroling Monastery (Golden Temple)','Coorg'),
('Talakaveri','Coorg'),
('Dubare Elephant Camp','Coorg'),
('Coffee Plantations','Coorg'),
('Trekking','Coorg'),
('Raja\'s Tomb','Coorg'),
('Iruppu Falls','Coorg');

/*Table structure for table `user_itinerary` */

DROP TABLE IF EXISTS `user_itinerary`;

CREATE TABLE `user_itinerary` (
  `itinerary_id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_name` varchar(100) NOT NULL,
  `num_guests` int(11) NOT NULL,
  `check_in_date` date NOT NULL,
  `check_out_date` date NOT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `bname` varchar(100) DEFAULT NULL,
  `phno` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`itinerary_id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=latin1;

/*Data for the table `user_itinerary` */

insert  into `user_itinerary`(`itinerary_id`,`hotel_name`,`num_guests`,`check_in_date`,`check_out_date`,`price`,`bname`,`phno`) values 
(1,'hotel8',4,'2010-10-10','2010-10-12',4099.00,NULL,NULL),
(2,'hotel10',4,'2010-10-10','2010-10-12',3900.00,NULL,NULL),
(3,'hotel2',4,'2024-02-16','2024-02-17',4988.00,NULL,NULL),
(4,'hotel2',4,'2024-02-16','2024-02-17',4888.00,NULL,NULL),
(5,'Evolve Back, Coorg',1,'2024-02-22','2024-02-24',44000.00,NULL,NULL),
(6,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(7,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(8,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(9,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(10,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(11,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(12,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(13,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(14,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(15,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(16,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(17,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(18,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(19,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(20,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(21,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(22,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(23,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(24,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(25,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(26,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(27,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(28,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(29,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(30,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(31,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(32,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(33,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(34,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(35,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(36,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(37,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(38,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(39,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(40,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(41,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(42,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(43,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(44,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(45,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(46,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(47,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(48,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(49,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(50,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(51,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(52,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(53,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(54,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(55,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(56,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(57,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(58,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(59,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(60,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(61,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(62,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(63,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(64,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(65,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(66,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(67,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(68,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(69,'Old Kent Estates & Spa',4,'2024-02-24','2024-02-29',85000.00,NULL,NULL),
(70,'Evolve Back, Coorg',1,'2024-02-24','2024-02-25',22000.00,NULL,NULL),
(71,'Evolve Back, Coorg',1,'2024-02-24','2024-02-25',22000.00,NULL,NULL);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `users` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
