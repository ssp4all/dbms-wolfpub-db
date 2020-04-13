-- MariaDB dump 10.17  Distrib 10.4.11-MariaDB, for osx10.14 (x86_64)
--
-- Host: localhost    Database: wolfpubdb
-- ------------------------------------------------------
-- Server version	10.4.11-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Article`
--

DROP TABLE IF EXISTS `Article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Article` (
  `article_id` int(11) NOT NULL DEFAULT 0,
  `date_of_creation` date NOT NULL,
  `content` varchar(128) NOT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Article`
--

LOCK TABLES `Article` WRITE;
/*!40000 ALTER TABLE `Article` DISABLE KEYS */;
INSERT INTO `Article` VALUES (1,'2020-02-24','ABC'),(2,'2010-02-21','CCC');
/*!40000 ALTER TABLE `Article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Book`
--

DROP TABLE IF EXISTS `Book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Book` (
  `isbn` varchar(128) NOT NULL DEFAULT '',
  `publication_id` int(11) NOT NULL,
  `date_of_creation` date NOT NULL,
  `publication_date` date NOT NULL,
  `edition_no` varchar(128) NOT NULL,
  PRIMARY KEY (`isbn`),
  UNIQUE KEY `publication_id` (`publication_id`,`edition_no`),
  CONSTRAINT `Book_ibfk_1` FOREIGN KEY (`publication_id`) REFERENCES `Publication` (`publication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Book`
--

LOCK TABLES `Book` WRITE;
/*!40000 ALTER TABLE `Book` DISABLE KEYS */;
INSERT INTO `Book` VALUES ('12345',1001,'2018-10-10','2018-10-10','2ed');
/*!40000 ALTER TABLE `Book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Chapter`
--

DROP TABLE IF EXISTS `Chapter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Chapter` (
  `chapter_id` int(11) NOT NULL,
  `chapter_no` int(11) NOT NULL,
  `chapter_name` varchar(128) NOT NULL,
  `content` varchar(128) NOT NULL,
  `isbn` varchar(128) NOT NULL,
  PRIMARY KEY (`chapter_id`),
  UNIQUE KEY `chapter_no` (`chapter_no`,`isbn`),
  KEY `isbn` (`isbn`),
  CONSTRAINT `Chapter_ibfk_1` FOREIGN KEY (`isbn`) REFERENCES `Book` (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Chapter`
--

LOCK TABLES `Chapter` WRITE;
/*!40000 ALTER TABLE `Chapter` DISABLE KEYS */;
/*!40000 ALTER TABLE `Chapter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Contributor`
--

DROP TABLE IF EXISTS `Contributor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Contributor` (
  `contributor_id` int(11) NOT NULL DEFAULT 0,
  `name` varchar(128) NOT NULL,
  `designation` varchar(128) NOT NULL,
  `job_type` varchar(128) NOT NULL,
  `salary` int(11) DEFAULT NULL,
  `payment_frequency` varchar(128) NOT NULL,
  `age` int(5) DEFAULT NULL,
  `Gender` char(2) DEFAULT NULL,
  `phone` int(12) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`contributor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Contributor`
--

LOCK TABLES `Contributor` WRITE;
/*!40000 ALTER TABLE `Contributor` DISABLE KEYS */;
INSERT INTO `Contributor` VALUES (3001,'John','staff editor','Permanent',1000,'monthly',36,'M',2147483647,'3001@gmail.com','21 ABC St, NC 27'),(3002,'Ethen','staff editor','Permanent',1000,'monthly',30,'M',2147483647,'3002@gmail.com','21 ABC St, NC 27606'),(3003,'Cathy','invited author','Temporary',1200,'Once',28,'F',2147483647,'3003@gmail.com','2300 AAA St, NC 27606');
/*!40000 ALTER TABLE `Contributor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Distributor`
--

DROP TABLE IF EXISTS `Distributor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Distributor` (
  `distributor_id` int(11) NOT NULL DEFAULT 0,
  `name` varchar(128) NOT NULL,
  `dist_type` varchar(128) DEFAULT NULL,
  `address` varchar(128) NOT NULL,
  `city` varchar(128) NOT NULL,
  `contact_person` varchar(128) NOT NULL,
  `balance` int(11) NOT NULL,
  `phone_number` varchar(128) NOT NULL,
  PRIMARY KEY (`distributor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Distributor`
--

LOCK TABLES `Distributor` WRITE;
/*!40000 ALTER TABLE `Distributor` DISABLE KEYS */;
INSERT INTO `Distributor` VALUES (2001,'BookSell','bookstore','2200, A Street, NC','charlotte','Jason',215,'9191234567'),(2002,'BookDist','wholesaler','2200, B Street, NC','Raleigh','Alex',0,'9291234567');
/*!40000 ALTER TABLE `Distributor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Issue`
--

DROP TABLE IF EXISTS `Issue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Issue` (
  `issue_id` int(11) NOT NULL DEFAULT 0,
  `date_of_issue` date NOT NULL,
  `publication_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `publication_id` (`publication_id`),
  CONSTRAINT `Issue_ibfk_1` FOREIGN KEY (`publication_id`) REFERENCES `Publication` (`publication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Issue`
--

LOCK TABLES `Issue` WRITE;
/*!40000 ALTER TABLE `Issue` DISABLE KEYS */;
INSERT INTO `Issue` VALUES (1,'2020-02-24',1002),(2,'2020-03-01',1003),(12,'2020-02-01',1220);
/*!40000 ALTER TABLE `Issue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Order`
--

DROP TABLE IF EXISTS `Order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Order` (
  `order_id` int(11) NOT NULL,
  `shipping_cost` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `order_date` date NOT NULL,
  `no_of_copies` int(11) NOT NULL,
  `book_id` varchar(128) DEFAULT NULL,
  `issue_id` int(11) DEFAULT NULL,
  `payment_status` varchar(128) NOT NULL,
  `distributor_id` int(11) NOT NULL,
  `publication_id` int(11) DEFAULT NULL,
  `delivery_date` date DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `distributor_id` (`distributor_id`),
  KEY `book_id` (`book_id`),
  KEY `issue_id` (`issue_id`),
  KEY `priceIndex` (`price`),
  KEY `priceI` (`price`),
  KEY `shippingCostIndex` (`shipping_cost`),
  CONSTRAINT `Order_ibfk_1` FOREIGN KEY (`distributor_id`) REFERENCES `Distributor` (`distributor_id`),
  CONSTRAINT `Order_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `Book` (`isbn`),
  CONSTRAINT `Order_ibfk_3` FOREIGN KEY (`issue_id`) REFERENCES `Issue` (`issue_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Order`
--

LOCK TABLES `Order` WRITE;
/*!40000 ALTER TABLE `Order` DISABLE KEYS */;
INSERT INTO `Order` VALUES (4001,30,20,'2020-01-02',30,'12345',NULL,'paid',2001,1001,'2020-01-15'),(4002,15,20,'2020-02-05',10,'12345',NULL,'pending',2001,1001,'2020-02-15'),(4003,15,10,'2020-02-10',10,NULL,2,'paid',2002,1003,'2020-02-25');
/*!40000 ALTER TABLE `Order` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`atiwari4`@`%`*/ /*!50003 Trigger `checkIfBookOrIssuePresent` BEFORE INSERT ON `Order`
for each row
begin
    DECLARE totalPrice INT;
    SET totalPrice= NEW.shipping_cost + NEW.price*NEW.no_of_copies;
    IF NEW.book_id is NULL THEN
        IF NEW.issue_id is NULL THEN
            signal sqlstate '45000' set message_text = 'Only one of book_id or issue_id must be null';
        END IF;
    END IF;
    IF NEW.book_id is NOT NULL THEN
        IF NEW.issue_id is NOT NULL THEN
            signal sqlstate '45000' set message_text = 'Only one of book_id or issue_id must be null';
        END IF;
    END IF;
    IF NEW.payment_status = "PENDING" THEN
        update `Distributor` set balance = balance + totalPrice where distributor_id = NEW.distributor_id;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`atiwari4`@`%`*/ /*!50003 Trigger `checkIfBookOrIssuePresentUpdate` BEFORE UPDATE ON `Order`
for each row
begin
    DECLARE totalPrice INT;
    SET totalPrice= NEW.shipping_cost + NEW.price*NEW.no_of_copies;
    IF NEW.book_id is NULL THEN
        IF NEW.issue_id is NULL THEN
            signal sqlstate '45000' set message_text = 'Only one of book_id or issue_id must be null';
        END IF;
    END IF;
    IF NEW.book_id is NOT NULL THEN
        IF NEW.issue_id is NOT NULL THEN
            signal sqlstate '45000' set message_text = 'Only one of book_id or issue_id must be null';
        END IF;
    END IF;
    
    IF NEW.payment_status = "PAID" THEN
        update `Distributor` set balance = balance - totalPrice where distributor_id = NEW.distributor_id;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `Pays`
--

DROP TABLE IF EXISTS `Pays`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Pays` (
  `contributor_id` int(11) NOT NULL DEFAULT 0,
  `amount` int(11) NOT NULL,
  `payment_date` date NOT NULL,
  `payment_id` int(11) NOT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `contributorIndex` (`contributor_id`),
  CONSTRAINT `Pays_ibfk_2` FOREIGN KEY (`contributor_id`) REFERENCES `Contributor` (`contributor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pays`
--

LOCK TABLES `Pays` WRITE;
/*!40000 ALTER TABLE `Pays` DISABLE KEYS */;
INSERT INTO `Pays` VALUES (3001,1000,'2020-04-01',1),(3002,1000,'2020-04-01',2),(3003,1200,'2020-04-01',3),(3003,1000,'2002-02-02',6);
/*!40000 ALTER TABLE `Pays` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Publication`
--

DROP TABLE IF EXISTS `Publication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Publication` (
  `publication_id` int(11) NOT NULL DEFAULT 0,
  `title` varchar(128) NOT NULL,
  `typical_topics` varchar(128) DEFAULT NULL,
  `type` varchar(128) NOT NULL,
  `periodicity` varchar(128) NOT NULL,
  PRIMARY KEY (`publication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Publication`
--

LOCK TABLES `Publication` WRITE;
/*!40000 ALTER TABLE `Publication` DISABLE KEYS */;
INSERT INTO `Publication` VALUES (1001,'introduction to database','technology','book','Once'),(1002,'Healthy Diet','health','magazine','monthly'),(1003,'Animal Science','science','journal','monthly'),(1004,'Ankit Rocks','hacking','issue','monthly'),(1220,'Testing','sjdh','hdjf','fhdj');
/*!40000 ALTER TABLE `Publication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articleAuthor`
--

DROP TABLE IF EXISTS `articleAuthor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articleAuthor` (
  `article_id` int(11) NOT NULL DEFAULT 0,
  `author_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`article_id`,`author_id`),
  KEY `author_id` (`author_id`),
  CONSTRAINT `articleAuthor_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `Article` (`article_id`),
  CONSTRAINT `articleAuthor_ibfk_2` FOREIGN KEY (`author_id`) REFERENCES `Contributor` (`contributor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articleAuthor`
--

LOCK TABLES `articleAuthor` WRITE;
/*!40000 ALTER TABLE `articleAuthor` DISABLE KEYS */;
INSERT INTO `articleAuthor` VALUES (1,3002);
/*!40000 ALTER TABLE `articleAuthor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookAuthor`
--

DROP TABLE IF EXISTS `bookAuthor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookAuthor` (
  `isbn` varchar(128) NOT NULL DEFAULT '',
  `author_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`isbn`,`author_id`),
  KEY `author_id` (`author_id`),
  CONSTRAINT `bookAuthor_ibfk_1` FOREIGN KEY (`isbn`) REFERENCES `Book` (`isbn`),
  CONSTRAINT `bookAuthor_ibfk_2` FOREIGN KEY (`author_id`) REFERENCES `Contributor` (`contributor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookAuthor`
--

LOCK TABLES `bookAuthor` WRITE;
/*!40000 ALTER TABLE `bookAuthor` DISABLE KEYS */;
INSERT INTO `bookAuthor` VALUES ('12345',3001);
/*!40000 ALTER TABLE `bookAuthor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consistOf`
--

DROP TABLE IF EXISTS `consistOf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consistOf` (
  `issue_id` int(11) NOT NULL DEFAULT 0,
  `article_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`issue_id`,`article_id`),
  KEY `article_id` (`article_id`),
  CONSTRAINT `consistOf_ibfk_1` FOREIGN KEY (`issue_id`) REFERENCES `Issue` (`issue_id`),
  CONSTRAINT `consistOf_ibfk_2` FOREIGN KEY (`article_id`) REFERENCES `Article` (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consistOf`
--

LOCK TABLES `consistOf` WRITE;
/*!40000 ALTER TABLE `consistOf` DISABLE KEYS */;
INSERT INTO `consistOf` VALUES (1,1),(1,2),(2,2);
/*!40000 ALTER TABLE `consistOf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worksFor`
--

DROP TABLE IF EXISTS `worksFor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `worksFor` (
  `contributor_id` int(11) NOT NULL DEFAULT 0,
  `publication_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`contributor_id`,`publication_id`),
  KEY `publication_id` (`publication_id`),
  CONSTRAINT `worksFor_ibfk_1` FOREIGN KEY (`contributor_id`) REFERENCES `Contributor` (`contributor_id`),
  CONSTRAINT `worksFor_ibfk_2` FOREIGN KEY (`publication_id`) REFERENCES `Publication` (`publication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worksFor`
--

LOCK TABLES `worksFor` WRITE;
/*!40000 ALTER TABLE `worksFor` DISABLE KEYS */;
INSERT INTO `worksFor` VALUES (3001,1001),(3002,1002),(3003,1004),(3003,1220);
/*!40000 ALTER TABLE `worksFor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-13 13:57:17
