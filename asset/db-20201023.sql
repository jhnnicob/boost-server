-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: boost
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `parent_category_id` int DEFAULT NULL,
  `created_by` int DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `modified_by` int DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (10,'166a6f92-471e-4ead-b6f6-3891122f6599','Frappe c','Frappe c',NULL,NULL,NULL,NULL,NULL),(11,'467726ef-36cc-43c5-be6e-ed5868da2757','Oreo','Oreo',NULL,NULL,NULL,NULL,NULL),(12,'04c209ee-e72a-44ae-8d26-ec8d48028e9b','Original','Original',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid` varchar(45) DEFAULT NULL,
  `parent_company_id` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL COMMENT 'Enum: [Owned, Rebrand,Franchise]',
  `business_line` varchar(45) DEFAULT NULL COMMENT 'Sample: Food, Cosmetics, IT',
  `base_product` varchar(45) DEFAULT NULL COMMENT 'Sample: Milktea, Somai',
  `created_by` int DEFAULT NULL,
  `modified_by` int DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (4,NULL,NULL,'Company with TX',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,NULL,NULL,'Company Generic',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,NULL,NULL,'Company new',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'9caa9dc0-6293-475d-b7a2-4753cb93f857',NULL,'Nico Company update',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'912411c0-1f80-4e16-a489-d6e8e93d78be',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_person`
--

DROP TABLE IF EXISTS `company_person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company_person` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company_id` int DEFAULT NULL,
  `person_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_person`
--

LOCK TABLES `company_person` WRITE;
/*!40000 ALTER TABLE `company_person` DISABLE KEYS */;
/*!40000 ALTER TABLE `company_person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid` varchar(45) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `default_material_id` int DEFAULT NULL,
  `customizable` tinyint DEFAULT '0',
  `created_by` int DEFAULT NULL,
  `modified_by` int DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_default_material_id_idx` (`default_material_id`),
  CONSTRAINT `fk_default_material_id` FOREIGN KEY (`default_material_id`) REFERENCES `material` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredient`
--

LOCK TABLES `ingredient` WRITE;
/*!40000 ALTER TABLE `ingredient` DISABLE KEYS */;
INSERT INTO `ingredient` VALUES (4,NULL,'Milk',NULL,0,NULL,NULL,NULL,NULL),(5,NULL,'Soda Update',2,0,NULL,NULL,NULL,NULL),(6,NULL,'Ingregient1 - Update',2,0,NULL,NULL,NULL,NULL),(7,NULL,'Ingregient2 - Update',2,0,NULL,NULL,NULL,NULL),(8,NULL,'Ingregient1',2,0,NULL,NULL,NULL,NULL),(9,NULL,'Ingregient1',2,0,NULL,NULL,NULL,NULL),(10,NULL,'Ingregient1',2,0,NULL,NULL,NULL,NULL),(11,'ed07d74b-67b7-4b5e-b7c9-31c9cbff8cca','Ingregient1',2,0,NULL,NULL,NULL,NULL),(12,'47a9105d-1437-48ca-8602-9e07cf34f084','Ingregient1',2,0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredient_material`
--

DROP TABLE IF EXISTS `ingredient_material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredient_material` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ingredient_id` int DEFAULT NULL,
  `material_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredient_material`
--

LOCK TABLES `ingredient_material` WRITE;
/*!40000 ALTER TABLE `ingredient_material` DISABLE KEYS */;
INSERT INTO `ingredient_material` VALUES (2,4,2),(4,5,2),(6,7,2),(32,8,2),(34,9,2),(35,10,2),(37,11,2),(38,6,2),(39,12,2);
/*!40000 ALTER TABLE `ingredient_material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid` varchar(45) DEFAULT NULL,
  `sku` varchar(45) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `company_id` int DEFAULT NULL,
  `created_by` int DEFAULT NULL,
  `modified_by` int DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (2,'asdfasdfasdfasdf','sku2','material 2','material 2 description update ',10,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid` varchar(45) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `company_id` int DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  `created_by` int DEFAULT NULL,
  `modified_by` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'uuid_test','First','Person','MALE','test@yahoo.com','username','password','ADMINISTRATIOR',4,NULL,NULL,NULL,NULL),(2,'uuid_test','Second','Person','MALE','test@yahoo.com','username','password','ADMINISTRATIOR',7,NULL,NULL,NULL,NULL),(3,'381caf7e-3f7e-470c-ac80-6a891e0330d8','Third','Person','MALE','test@yahoo.com','username','password','ADMINISTRATIOR',7,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid` varchar(45) DEFAULT NULL,
  `parent_product_id` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `sku` varchar(45) DEFAULT NULL,
  `inventory` double DEFAULT '0',
  `active` tinyint DEFAULT '0',
  `available` tinyint DEFAULT '0',
  `is_variation` tinyint DEFAULT '0',
  `company_id` int DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  `created_by` int DEFAULT NULL,
  `modified_by` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,NULL,NULL,'product 1','product 1 description','SIMPLE',NULL,0,0,0,0,NULL,NULL,NULL,NULL,NULL),(4,'24962081-a16a-43ad-9566-2b86b8a44ee0',NULL,'With Ingredient','With ingredient save from rest','SIMPLE',NULL,0,0,0,0,NULL,NULL,NULL,NULL,NULL),(5,'4955de49-e8b4-432c-aec2-c8154f8fd846',NULL,'With Category','Product with category','SIMPLE',NULL,0,0,0,0,NULL,NULL,NULL,NULL,NULL),(6,'4779aa2a-3b24-427a-9bab-4c4df59473c6',NULL,'With Category 2','Product with category','SIMPLE',NULL,0,0,0,0,NULL,NULL,NULL,NULL,NULL),(7,'5dbc1d28-a275-49b4-a43c-376820060613',NULL,'With Category 3','Product with category','SIMPLE',NULL,0,0,0,0,NULL,NULL,NULL,NULL,NULL),(8,'f9c09c63-23cc-4ca8-aa61-a17cebf4d078',NULL,'UUID Product','Product with category','SIMPLE',NULL,0,0,0,0,NULL,NULL,NULL,NULL,NULL),(9,'3c3fa824-c912-4d97-9cc2-d3cd7b5fb15e',NULL,'Date Created Product','Product with category','SIMPLE',NULL,0,0,0,0,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_attribute`
--

DROP TABLE IF EXISTS `product_attribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_attribute` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid` varchar(45) DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `attribute` varchar(45) NOT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  `created_by` int DEFAULT NULL,
  `modified_by` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_attribute`
--

LOCK TABLES `product_attribute` WRITE;
/*!40000 ALTER TABLE `product_attribute` DISABLE KEYS */;
INSERT INTO `product_attribute` VALUES (1,NULL,1,'size',NULL,NULL,NULL,NULL),(2,NULL,1,'flavor',NULL,NULL,NULL,NULL),(5,NULL,4,'size-update',NULL,NULL,NULL,NULL),(6,NULL,NULL,'color',NULL,NULL,NULL,NULL),(7,NULL,NULL,'size-new',NULL,NULL,NULL,NULL),(8,NULL,4,'size-new-3',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `product_attribute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_attribute_value`
--

DROP TABLE IF EXISTS `product_attribute_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_attribute_value` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid` varchar(45) DEFAULT NULL,
  `product_attribute_id` int DEFAULT NULL,
  `value` varchar(45) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  `created_by` int DEFAULT NULL,
  `modified_by` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_attribute_value`
--

LOCK TABLES `product_attribute_value` WRITE;
/*!40000 ALTER TABLE `product_attribute_value` DISABLE KEYS */;
INSERT INTO `product_attribute_value` VALUES (1,NULL,1,'small',NULL,NULL,NULL,NULL),(2,NULL,1,'medium',NULL,NULL,NULL,NULL),(3,NULL,2,'flavor 1',NULL,NULL,NULL,NULL),(4,NULL,2,'flavor 2',NULL,NULL,NULL,NULL),(5,NULL,5,'small',NULL,NULL,NULL,NULL),(6,NULL,NULL,'mid',NULL,NULL,NULL,NULL),(7,NULL,8,'small-',NULL,NULL,NULL,NULL),(8,NULL,8,'mid-3 -update',NULL,NULL,NULL,NULL),(9,NULL,8,'mid-3-new',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `product_attribute_value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_attribute_variation`
--

DROP TABLE IF EXISTS `product_attribute_variation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_attribute_variation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int DEFAULT NULL,
  `product_attribute_id` int DEFAULT NULL,
  `product_attribute_value_id` int DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  `created_by` int DEFAULT NULL,
  `modified_by` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_attribute_variation`
--

LOCK TABLES `product_attribute_variation` WRITE;
/*!40000 ALTER TABLE `product_attribute_variation` DISABLE KEYS */;
INSERT INTO `product_attribute_variation` VALUES (1,1,1,1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `product_attribute_variation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_category`
--

DROP TABLE IF EXISTS `product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category`
--

LOCK TABLES `product_category` WRITE;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
INSERT INTO `product_category` VALUES (2,7,10),(3,8,10),(4,9,10);
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_ingredient`
--

DROP TABLE IF EXISTS `product_ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_ingredient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid` varchar(45) DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `ingredient_id` int DEFAULT NULL,
  `quantity` double DEFAULT '0',
  `default_material_id` int DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  `created_by` int DEFAULT NULL,
  `modified_by` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_ingredient`
--

LOCK TABLES `product_ingredient` WRITE;
/*!40000 ALTER TABLE `product_ingredient` DISABLE KEYS */;
INSERT INTO `product_ingredient` VALUES (1,NULL,1,5,0,NULL,NULL,NULL,NULL,NULL),(3,NULL,4,6,10,NULL,NULL,NULL,NULL,NULL),(5,NULL,NULL,7,20,NULL,NULL,NULL,NULL,NULL),(6,NULL,5,8,10,NULL,NULL,NULL,NULL,NULL),(7,NULL,6,9,10,NULL,NULL,NULL,NULL,NULL),(8,NULL,7,10,10,NULL,NULL,NULL,NULL,NULL),(9,'510f46c3-d5da-4386-a538-0fefeb161fbf',8,11,10,NULL,NULL,NULL,NULL,NULL),(10,'71e86b99-7fe6-4443-903a-6d86b133166b',9,12,10,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `product_ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid` varchar(45) DEFAULT NULL,
  `company_id` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `location_type` varchar(45) DEFAULT NULL,
  `created_by` int DEFAULT NULL,
  `modified_by` int DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` VALUES (1,'uuid_manual',4,'Store of 4 - Update','address','SHOP',NULL,NULL,NULL,NULL),(2,'9e599d4f-fbaa-490d-9560-ae39fb91334d',7,'Store 1 of Company 7','address','SHOP',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-23  0:08:13
