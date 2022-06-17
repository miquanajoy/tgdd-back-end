-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: electronicwebstore
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `bill_detail`
--

DROP TABLE IF EXISTS `bill_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill_detail` (
  `BillID` int NOT NULL,
  `ProductID` char(15) NOT NULL,
  `Quantity` mediumint unsigned NOT NULL,
  PRIMARY KEY (`BillID`),
  UNIQUE KEY `BillID_UNIQUE` (`BillID`),
  KEY `ProductID FK1_idx` (`ProductID`),
  CONSTRAINT `BillID FK` FOREIGN KEY (`BillID`) REFERENCES `shopping_bill` (`BillID`) ON UPDATE CASCADE,
  CONSTRAINT `ProductID FK1` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_detail`
--

LOCK TABLES `bill_detail` WRITE;
/*!40000 ALTER TABLE `bill_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_items`
--

DROP TABLE IF EXISTS `cart_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_items` (
  `CartID` int unsigned NOT NULL,
  `ProductID` char(15) NOT NULL,
  `Quantity` mediumint unsigned NOT NULL,
  PRIMARY KEY (`CartID`),
  KEY `ProductID FK_idx` (`ProductID`),
  CONSTRAINT `CartID FK` FOREIGN KEY (`CartID`) REFERENCES `shopping_cart` (`CartID`) ON UPDATE CASCADE,
  CONSTRAINT `ProductID FK` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_items`
--

LOCK TABLES `cart_items` WRITE;
/*!40000 ALTER TABLE `cart_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `CategoryID` int unsigned NOT NULL AUTO_INCREMENT,
  `CategoryName` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `ParentID` int unsigned NOT NULL,
  PRIMARY KEY (`CategoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'General',0),(2,'MobilePhone',1);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `CityID` int unsigned NOT NULL AUTO_INCREMENT,
  `CityName` varchar(100) NOT NULL,
  PRIMARY KEY (`CityID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color`
--

DROP TABLE IF EXISTS `color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `color` (
  `ColorID` char(20) NOT NULL,
  `ColorName` varchar(50) NOT NULL,
  PRIMARY KEY (`ColorID`),
  UNIQUE KEY `ColorID_UNIQUE` (`ColorID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `CustomerID` int unsigned NOT NULL AUTO_INCREMENT,
  `FullName` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `PhoneNumber` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `Gender` char(10) NOT NULL,
  `Address` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `CIty` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `District` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `Ward` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `Active` tinyint NOT NULL,
  PRIMARY KEY (`CustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `district`
--

DROP TABLE IF EXISTS `district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `district` (
  `DistrictID` int unsigned NOT NULL AUTO_INCREMENT,
  `DistrictName` varchar(100) NOT NULL,
  PRIMARY KEY (`DistrictID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district`
--

LOCK TABLES `district` WRITE;
/*!40000 ALTER TABLE `district` DISABLE KEYS */;
/*!40000 ALTER TABLE `district` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manufacturer`
--

DROP TABLE IF EXISTS `manufacturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manufacturer` (
  `ManufacturerID` char(10) NOT NULL,
  `ManufacturerName` varchar(50) NOT NULL,
  PRIMARY KEY (`ManufacturerID`),
  UNIQUE KEY `ManufacturerName_UNIQUE` (`ManufacturerName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufacturer`
--

LOCK TABLES `manufacturer` WRITE;
/*!40000 ALTER TABLE `manufacturer` DISABLE KEYS */;
INSERT INTO `manufacturer` VALUES ('SS5945','SamSung');
/*!40000 ALTER TABLE `manufacturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `ProductID` char(15) NOT NULL,
  `ProductName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `Price` decimal(15,3) unsigned DEFAULT NULL,
  `ManufacturerID` char(10) NOT NULL,
  `CategoryID` int unsigned NOT NULL,
  `ProductWarranty` int NOT NULL,
  `Image` varchar(300) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `InterestRate` decimal(3,3) unsigned NOT NULL,
  `Exclusive` tinyint unsigned NOT NULL,
  `AccessoriesIncluded` varchar(200) NOT NULL,
  PRIMARY KEY (`ProductID`),
  UNIQUE KEY `ProductID_UNIQUE` (`ProductID`),
  KEY `CategoryID FK_idx` (`CategoryID`),
  KEY `BrandID FK_idx` (`ManufacturerID`),
  CONSTRAINT `CategoryID FK` FOREIGN KEY (`CategoryID`) REFERENCES `category` (`CategoryID`) ON UPDATE CASCADE,
  CONSTRAINT `ManufacturerID FK` FOREIGN KEY (`ManufacturerID`) REFERENCES `manufacturer` (`ManufacturerID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('SSGA4824','SamSung Galaxy A48',560.000,'SS5945',2,12,'sadfasfasfasfasdfasfsa',0.000,1,'');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_article`
--

DROP TABLE IF EXISTS `product_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_article` (
  `ArticleID` int unsigned NOT NULL AUTO_INCREMENT,
  `ProductID` char(15) NOT NULL,
  `ArticleURL` varchar(300) NOT NULL,
  PRIMARY KEY (`ArticleID`),
  UNIQUE KEY `ProductID_UNIQUE` (`ProductID`),
  CONSTRAINT `ProductID FK2` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_article`
--

LOCK TABLES `product_article` WRITE;
/*!40000 ALTER TABLE `product_article` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_camera_shots`
--

DROP TABLE IF EXISTS `product_camera_shots`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_camera_shots` (
  `ID` int unsigned NOT NULL AUTO_INCREMENT,
  `ProductID` char(15) NOT NULL,
  `ImageGalleryPath` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ProductID_UNIQUE` (`ProductID`),
  CONSTRAINT `ProductIDENTIFIER FK` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_camera_shots`
--

LOCK TABLES `product_camera_shots` WRITE;
/*!40000 ALTER TABLE `product_camera_shots` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_camera_shots` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_color_variant`
--

DROP TABLE IF EXISTS `product_color_variant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_color_variant` (
  `ID` int unsigned NOT NULL AUTO_INCREMENT,
  `ProductID` char(15) NOT NULL,
  `ColorID` char(20) NOT NULL,
  `ImageGalleryPath` varchar(300) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ProductID FK 3_idx` (`ProductID`),
  KEY `ColorID FK_idx` (`ColorID`),
  CONSTRAINT `ColorID FK` FOREIGN KEY (`ColorID`) REFERENCES `color` (`ColorID`) ON UPDATE CASCADE,
  CONSTRAINT `ProductID FK 3` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_color_variant`
--

LOCK TABLES `product_color_variant` WRITE;
/*!40000 ALTER TABLE `product_color_variant` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_color_variant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_discount`
--

DROP TABLE IF EXISTS `product_discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_discount` (
  `DiscountID` int unsigned NOT NULL AUTO_INCREMENT,
  `ProductID` char(15) NOT NULL,
  `DiscountedPrice` decimal(15,3) unsigned NOT NULL,
  `DiscountPercent` int unsigned NOT NULL,
  `StartDate` datetime NOT NULL,
  `EndDate` datetime NOT NULL,
  PRIMARY KEY (`DiscountID`),
  UNIQUE KEY `ProductID_UNIQUE` (`ProductID`),
  CONSTRAINT `ProductDiscount FK` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_discount`
--

LOCK TABLES `product_discount` WRITE;
/*!40000 ALTER TABLE `product_discount` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_feature`
--

DROP TABLE IF EXISTS `product_feature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_feature` (
  `ID` int unsigned NOT NULL AUTO_INCREMENT,
  `ProductID` char(15) NOT NULL,
  `FeaturesVideoLink` varchar(300) DEFAULT NULL,
  `FeaturesGalleryPath` varchar(300) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ProductID_UNIQUE` (`ProductID`),
  CONSTRAINT `FK ProductID ` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_feature`
--

LOCK TABLES `product_feature` WRITE;
/*!40000 ALTER TABLE `product_feature` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_feature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_offers`
--

DROP TABLE IF EXISTS `product_offers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_offers` (
  `OfferID` int unsigned NOT NULL AUTO_INCREMENT,
  `ProductID` char(15) NOT NULL,
  `OfferDescription` varchar(400) DEFAULT NULL,
  `StarDate` datetime NOT NULL,
  `EndDate` datetime NOT NULL,
  PRIMARY KEY (`OfferID`),
  UNIQUE KEY `ProductID_UNIQUE` (`ProductID`),
  CONSTRAINT `ProductDealID FK` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_offers`
--

LOCK TABLES `product_offers` WRITE;
/*!40000 ALTER TABLE `product_offers` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_offers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_specification`
--

DROP TABLE IF EXISTS `product_specification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_specification` (
  `ID` int unsigned NOT NULL AUTO_INCREMENT,
  `ProductID` char(15) NOT NULL,
  `ProductSpecifications` text,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ProductID_UNIQUE` (`ProductID`),
  CONSTRAINT `FK1 ProductID` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_specification`
--

LOCK TABLES `product_specification` WRITE;
/*!40000 ALTER TABLE `product_specification` DISABLE KEYS */;
INSERT INTO `product_specification` VALUES (1,'SSGA4824','{\n	\"random\": \"36\",\n	\"random float\": \"2.553\",\n	\"bool\": \"false\",\n	\"date\": \"1983-06-11\",\n	\"regEx\": \"helloooooooooooooooooooooooooooooooooooooooooooooooooooooooo world\",\n	\"enum\": \"generator\",\n	\"firstname\": \"Deedee\",\n	\"lastname\": \"Allys\",\n	\"city\": \"Ho Chi Minh City\",\n	\"country\": \"Heard Island and Mcdonald Islands\",\n	\"countryCode\": \"PW\",\n	\"email uses current data\": \"Deedee.Allys@gmail.com\",\n	\"email from expression\": \"Deedee.Allys@yopmail.com\",\n	\"array\": [\n		\"Shannah\",\n		\"Marline\",\n		\"Maryellen\",\n		\"Tatiania\",\n		\"Consuela\"\n	],\n	\"array of objects\": [\n		{\n			\"index\": \"0\",\n			\"index start at 5\": \"5\"\n		},\n		{\n			\"index\": \"1\",\n			\"index start at 5\": \"6\"\n		},\n		{\n			\"index\": \"2\",\n			\"index start at 5\": \"7\"\n		}\n	],\n	\"Cherilyn\": {\n		\"age\": \"71\"\n	}\n}');
/*!40000 ALTER TABLE `product_specification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_unboxing_review`
--

DROP TABLE IF EXISTS `product_unboxing_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_unboxing_review` (
  `ID` int unsigned NOT NULL AUTO_INCREMENT,
  `ProductID` char(15) NOT NULL,
  `ImageGalleryPath` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ProductID_UNIQUE` (`ProductID`),
  CONSTRAINT `Product Identifier FK` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_unboxing_review`
--

LOCK TABLES `product_unboxing_review` WRITE;
/*!40000 ALTER TABLE `product_unboxing_review` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_unboxing_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotecode`
--

DROP TABLE IF EXISTS `promotecode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `promotecode` (
  `PromoteCodeID` int unsigned NOT NULL AUTO_INCREMENT,
  `PromoteCodeName` char(50) DEFAULT NULL,
  `PromoteCodeDescription` varchar(400) DEFAULT NULL,
  `PromotionType` enum('Percent','Amount') NOT NULL,
  `Discount` decimal(10,3) unsigned NOT NULL,
  `StartDate` datetime NOT NULL,
  `EndDate` datetime NOT NULL,
  PRIMARY KEY (`PromoteCodeID`),
  UNIQUE KEY `PromoteCode_UNIQUE` (`PromoteCodeName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotecode`
--

LOCK TABLES `promotecode` WRITE;
/*!40000 ALTER TABLE `promotecode` DISABLE KEYS */;
/*!40000 ALTER TABLE `promotecode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `RoleID` char(10) NOT NULL,
  `RoleName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`RoleID`),
  UNIQUE KEY `RoleID_UNIQUE` (`RoleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_bill`
--

DROP TABLE IF EXISTS `shopping_bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopping_bill` (
  `BillID` int NOT NULL,
  `CustomerID` int NOT NULL,
  `TimeCreated` datetime NOT NULL,
  `PromoteCode` char(50) DEFAULT 'No Promote Code',
  PRIMARY KEY (`BillID`),
  UNIQUE KEY `BillID_UNIQUE` (`BillID`),
  UNIQUE KEY `PromoteCode_UNIQUE` (`PromoteCode`),
  KEY `PromoteCode FK_idx` (`PromoteCode`),
  KEY `PromoteCode FK index` (`PromoteCode`),
  CONSTRAINT `PromoteCode FK` FOREIGN KEY (`PromoteCode`) REFERENCES `promotecode` (`PromoteCodeName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_bill`
--

LOCK TABLES `shopping_bill` WRITE;
/*!40000 ALTER TABLE `shopping_bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopping_bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_cart`
--

DROP TABLE IF EXISTS `shopping_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopping_cart` (
  `CartID` int unsigned NOT NULL AUTO_INCREMENT,
  `CustomerID` int unsigned NOT NULL,
  `Active` tinyint NOT NULL,
  `PromoteCode` char(50) DEFAULT 'No promote code',
  PRIMARY KEY (`CartID`),
  UNIQUE KEY `PromoteCode_UNIQUE` (`PromoteCode`),
  KEY `CustomerID FK_idx` (`CustomerID`),
  CONSTRAINT `CustomerID FK` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`CustomerID`) ON UPDATE CASCADE,
  CONSTRAINT `PromoteCode FK1` FOREIGN KEY (`PromoteCode`) REFERENCES `promotecode` (`PromoteCodeName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_cart`
--

LOCK TABLES `shopping_cart` WRITE;
/*!40000 ALTER TABLE `shopping_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopping_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store` (
  `StoreID` int unsigned NOT NULL AUTO_INCREMENT,
  `StoreName` varchar(100) DEFAULT NULL,
  `Address` varchar(300) NOT NULL,
  `OpeningHours` varchar(200) NOT NULL,
  `ImageGalleryPath` varchar(300) DEFAULT NULL,
  `CityID` int unsigned NOT NULL,
  `DistrictID` int unsigned NOT NULL,
  `WardID` int unsigned NOT NULL,
  PRIMARY KEY (`StoreID`),
  KEY `CItyID FK_idx` (`CityID`),
  KEY `WardID FK_idx` (`WardID`),
  KEY `DistrictID FK_idx` (`DistrictID`),
  CONSTRAINT `CityID FK` FOREIGN KEY (`CityID`) REFERENCES `city` (`CityID`) ON UPDATE CASCADE,
  CONSTRAINT `DistrictID FK` FOREIGN KEY (`DistrictID`) REFERENCES `district` (`DistrictID`) ON UPDATE CASCADE,
  CONSTRAINT `WardID FK` FOREIGN KEY (`WardID`) REFERENCES `ward` (`WardID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store_products_in_stock`
--

DROP TABLE IF EXISTS `store_products_in_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store_products_in_stock` (
  `ProductID` char(15) NOT NULL,
  `StoreID` int unsigned NOT NULL,
  `Quantity` int unsigned NOT NULL,
  PRIMARY KEY (`ProductID`),
  KEY `StoreID FK_idx` (`StoreID`),
  CONSTRAINT `ProductID FKK` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON UPDATE CASCADE,
  CONSTRAINT `StoreID FK` FOREIGN KEY (`StoreID`) REFERENCES `store` (`StoreID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store_products_in_stock`
--

LOCK TABLES `store_products_in_stock` WRITE;
/*!40000 ALTER TABLE `store_products_in_stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `store_products_in_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `UserID` char(10) NOT NULL,
  `FirstName` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `LastName` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `UserName` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `PassWord` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `RoleID` char(10) NOT NULL,
  `Enabled` tinyint DEFAULT NULL,
  `Status` tinyint DEFAULT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `UserID_UNIQUE` (`UserID`),
  UNIQUE KEY `UserName_UNIQUE` (`UserName`),
  UNIQUE KEY `PassWord_UNIQUE` (`PassWord`),
  KEY `RoleID FK_idx` (`RoleID`),
  CONSTRAINT `RoleID FK` FOREIGN KEY (`RoleID`) REFERENCES `role` (`RoleID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ward`
--

DROP TABLE IF EXISTS `ward`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ward` (
  `WardID` int unsigned NOT NULL AUTO_INCREMENT,
  `WardName` varchar(100) NOT NULL,
  PRIMARY KEY (`WardID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ward`
--

LOCK TABLES `ward` WRITE;
/*!40000 ALTER TABLE `ward` DISABLE KEYS */;
/*!40000 ALTER TABLE `ward` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-17  9:46:46
