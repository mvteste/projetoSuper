-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: mercadosenac2
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `cidade`
--

DROP TABLE IF EXISTS `cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cidade` (
  `ID_Cidade` int NOT NULL AUTO_INCREMENT,
  `NM_Cidade` varchar(100) NOT NULL,
  `CEP` char(8) DEFAULT NULL,
  `ID_UF` int NOT NULL,
  `ID_Pais` int NOT NULL,
  PRIMARY KEY (`ID_Cidade`),
  KEY `ID_UF` (`ID_UF`),
  KEY `ID_Pais` (`ID_Pais`),
  CONSTRAINT `cidade_ibfk_1` FOREIGN KEY (`ID_UF`) REFERENCES `uf` (`ID_UF`),
  CONSTRAINT `cidade_ibfk_2` FOREIGN KEY (`ID_Pais`) REFERENCES `pais` (`ID_Pais`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidade`
--

LOCK TABLES `cidade` WRITE;
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
INSERT INTO `cidade` VALUES (1,'Rio Branco','69900000',1,1),(2,'Cruzeiro do Sul','69980000',1,1),(3,'Maceió','57000000',2,1),(4,'Arapiraca','57300000',2,1),(5,'Manaus','69000000',3,1),(6,'Parintins','69150000',3,1),(7,'Salvador','40000000',4,1),(8,'Feira de Santana','44000000',4,1),(9,'Fortaleza','60000000',5,1),(10,'Juazeiro do Norte','63000000',5,1),(11,'Brasília','70000000',6,1),(12,'Vitória','29000000',7,1),(13,'Vila Velha','29100000',7,1),(14,'Goiânia','74000000',8,1),(15,'Anápolis','75000000',8,1),(16,'São Luís','65000000',9,1),(17,'Belo Horizonte','30000000',10,1),(18,'Uberlândia','38400000',10,1),(19,'Campo Grande','79000000',11,1),(20,'Cuiabá','78000000',12,1),(21,'Belém','66000000',13,1),(22,'João Pessoa','58000000',14,1),(23,'Curitiba','80000000',15,1),(24,'Londrina','86000000',15,1),(25,'Recife','50000000',16,1),(26,'Teresina','64000000',17,1),(27,'Rio de Janeiro','20000000',18,1),(28,'Niterói','24000000',18,1),(29,'Natal','59000000',19,1),(30,'Porto Alegre','90000000',20,1),(31,'Caxias do Sul','95000000',20,1),(32,'Santa Maria','97000000',20,1),(33,'Santa Rosa','98780000',20,1),(34,'Ijuí','98700000',20,1),(35,'Cruz Alta','98000000',20,1),(36,'Santo Ângelo','98800000',20,1),(37,'Três Passos','98750000',20,1),(38,'Panambi','98740000',20,1),(39,'Nonoai','98830000',20,1),(40,'Horizontina','98900000',20,1),(41,'Três de Maio','98920000',20,1),(42,'Santa Bárbara do Sul','98890000',20,1),(43,'Florianópolis','88000000',21,1),(44,'Joinville','89200000',21,1),(45,'Rio Branco','69900000',1,1),(46,'Cruzeiro do Sul','69980000',1,1),(47,'Maceió','57000000',2,1),(48,'Arapiraca','57300000',2,1),(49,'Manaus','69000000',3,1),(50,'Parintins','69150000',3,1),(51,'Salvador','40000000',4,1),(52,'Feira de Santana','44000000',4,1),(53,'Fortaleza','60000000',5,1),(54,'Juazeiro do Norte','63000000',5,1),(55,'Brasília','70000000',6,1),(56,'Vitória','29000000',7,1),(57,'Vila Velha','29100000',7,1),(58,'Goiânia','74000000',8,1),(59,'Anápolis','75000000',8,1),(60,'São Luís','65000000',9,1),(61,'Belo Horizonte','30000000',10,1),(62,'Uberlândia','38400000',10,1),(63,'Campo Grande','79000000',11,1),(64,'Cuiabá','78000000',12,1),(65,'Belém','66000000',13,1),(66,'João Pessoa','58000000',14,1),(67,'Curitiba','80000000',15,1),(68,'Londrina','86000000',15,1),(69,'Recife','50000000',16,1),(70,'Teresina','64000000',17,1),(71,'Rio de Janeiro','20000000',18,1),(72,'Niterói','24000000',18,1),(73,'Natal','59000000',19,1),(74,'Porto Alegre','90000000',20,1),(75,'Caxias do Sul','95000000',20,1),(76,'Santa Maria','97000000',20,1),(77,'Santa Rosa','98780000',20,1),(78,'Ijuí','98700000',20,1),(79,'Cruz Alta','98000000',20,1),(80,'Santo Ângelo','98800000',20,1),(81,'Três Passos','98750000',20,1),(82,'Panambi','98740000',20,1),(83,'Nonoai','98830000',20,1),(84,'Horizontina','98900000',20,1),(85,'Três de Maio','98920000',20,1),(86,'Santa Bárbara do Sul','98890000',20,1),(87,'Florianópolis','88000000',21,1),(88,'Joinville','89200000',21,1),(89,'Rio Branco','69900000',1,1),(90,'Cruzeiro do Sul','69980000',1,1),(91,'Maceió','57000000',2,1),(92,'Arapiraca','57300000',2,1),(93,'Manaus','69000000',3,1),(94,'Parintins','69150000',3,1),(95,'Salvador','40000000',4,1),(96,'Feira de Santana','44000000',4,1),(97,'Fortaleza','60000000',5,1),(98,'Juazeiro do Norte','63000000',5,1),(99,'Brasília','70000000',6,1),(100,'Vitória','29000000',7,1),(101,'Vila Velha','29100000',7,1),(102,'Goiânia','74000000',8,1),(103,'Anápolis','75000000',8,1),(104,'São Luís','65000000',9,1),(105,'Belo Horizonte','30000000',10,1),(106,'Uberlândia','38400000',10,1),(107,'Campo Grande','79000000',11,1),(108,'Cuiabá','78000000',12,1),(109,'Belém','66000000',13,1),(110,'João Pessoa','58000000',14,1),(111,'Curitiba','80000000',15,1),(112,'Londrina','86000000',15,1),(113,'Recife','50000000',16,1),(114,'Teresina','64000000',17,1),(115,'Rio de Janeiro','20000000',18,1),(116,'Niterói','24000000',18,1),(117,'Natal','59000000',19,1),(118,'Porto Alegre','90000000',20,1),(119,'Caxias do Sul','95000000',20,1),(120,'Santa Maria','97000000',20,1),(121,'Santa Rosa','98780000',20,1),(122,'Ijuí','98700000',20,1),(123,'Cruz Alta','98000000',20,1),(124,'Santo Ângelo','98800000',20,1),(125,'Três Passos','98750000',20,1),(126,'Panambi','98740000',20,1),(127,'Nonoai','98830000',20,1),(128,'Horizontina','98900000',20,1),(129,'Três de Maio','98920000',20,1),(130,'Santa Bárbara do Sul','98890000',20,1),(131,'Florianópolis','88000000',21,1),(132,'Joinville','89200000',21,1);
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-26 19:36:36
