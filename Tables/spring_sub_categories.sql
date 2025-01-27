-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: spring
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sub_categories`
--

DROP TABLE IF EXISTS `sub_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sub_categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_id` int DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `deleted_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `modified_at` datetime(6) DEFAULT NULL,
  `parent_category_id` int DEFAULT NULL,
  `sub_category_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_categories`
--

LOCK TABLES `sub_categories` WRITE;
/*!40000 ALTER TABLE `sub_categories` DISABLE KEYS */;
INSERT INTO `sub_categories` VALUES (1,2,'2025-01-23 18:04:59.887577',NULL,'Women\'s Clothing',NULL,0,'Women\'s Clothing'),(2,2,'2025-01-23 18:06:13.694688',NULL,'Men\'s Clothing',NULL,0,'Men\'s Clothing'),(3,2,'2025-01-23 18:06:43.076249',NULL,'Kids\' Clothing',NULL,0,'Kids\' Clothing'),(4,2,'2025-01-23 18:09:31.798541',NULL,'mens Shirts',NULL,2,'Shirts'),(5,2,'2025-01-23 18:10:58.574094',NULL,'mens Pants',NULL,2,'Pants'),(6,2,'2025-01-23 18:11:10.292624',NULL,'mens Jackets',NULL,2,'Jackets'),(7,2,'2025-01-23 18:11:18.853908',NULL,'mens Shoes',NULL,2,'Shoes'),(8,2,'2025-01-23 18:12:34.317223',NULL,'womens mens Dresses',NULL,1,'Dresses'),(9,2,'2025-01-23 18:13:19.965172',NULL,'womens mens Skirts',NULL,1,'Skirts'),(10,2,'2025-01-23 18:13:27.657476',NULL,'womens mens Tops',NULL,1,'Tops'),(11,2,'2025-01-23 18:13:36.245989',NULL,'womens mens Accessories',NULL,1,'Accessories'),(12,2,'2025-01-23 18:14:42.304431',NULL,'womens mens Outfits',NULL,3,'Outfits'),(13,2,'2025-01-23 18:14:59.485687',NULL,'kids Shoes',NULL,3,'Shoes'),(14,2,'2025-01-23 18:15:09.490492',NULL,'kids Accessories',NULL,3,'Accessories'),(15,1,'2025-01-23 18:16:25.045492',NULL,'Smartphones',NULL,0,'Smartphones'),(16,1,'2025-01-23 18:16:39.189374',NULL,'Laptops',NULL,0,'Laptops'),(17,1,'2025-01-23 18:16:48.154107',NULL,'Tablets',NULL,0,'Tablets'),(18,1,'2025-01-23 18:16:55.863913',NULL,'Headphones',NULL,0,'Headphones'),(19,1,'2025-01-23 18:17:04.674342',NULL,'Smartwatches',NULL,0,'Smartwatches'),(20,1,'2025-01-23 18:17:16.485787',NULL,'Cameras',NULL,0,'Cameras'),(21,1,'2025-01-23 18:17:32.720344',NULL,'Gaming Consoles',NULL,0,'Gaming Consoles');
/*!40000 ALTER TABLE `sub_categories` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-27 10:42:18
