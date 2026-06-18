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
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pais` (
  `ID_Pais` int NOT NULL AUTO_INCREMENT,
  `NM_Pais` varchar(100) NOT NULL,
  PRIMARY KEY (`ID_Pais`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,'Brasil'),(2,'Argentina'),(3,'Chile'),(4,'Uruguai'),(5,'Paraguai'),(6,'Estados Unidos'),(7,'Canadá'),(8,'México'),(9,'Portugal'),(10,'Espanha'),(11,'França'),(12,'Alemanha'),(13,'Italia'),(14,'Reino Unido'),(15,'Irlanda'),(16,'Japão'),(17,'China'),(18,'Índia'),(19,'Austrália'),(20,'Nova Zelândia'),(21,'África do Sul'),(22,'Egito'),(23,'Arábia Saudita'),(24,'Turquia'),(25,'Rússia'),(26,'Ucrânia'),(27,'Polônia'),(28,'Suécia'),(29,'Noruega'),(30,'Dinamarca'),(31,'Brasil'),(32,'Argentina'),(33,'Chile'),(34,'Uruguai'),(35,'Paraguai'),(36,'Estados Unidos'),(37,'Canadá'),(38,'México'),(39,'Portugal'),(40,'Espanha'),(41,'França'),(42,'Alemanha'),(43,'Italia'),(44,'Reino Unido'),(45,'Irlanda'),(46,'Japão'),(47,'China'),(48,'Índia'),(49,'Austrália'),(50,'Nova Zelândia'),(51,'África do Sul'),(52,'Egito'),(53,'Arábia Saudita'),(54,'Turquia'),(55,'Rússia'),(56,'Ucrânia'),(57,'Polônia'),(58,'Suécia'),(59,'Noruega'),(60,'Dinamarca'),(61,'Brasil'),(62,'Argentina'),(63,'Chile'),(64,'Uruguai'),(65,'Paraguai'),(66,'Estados Unidos'),(67,'Canadá'),(68,'México'),(69,'Portugal'),(70,'Espanha'),(71,'França'),(72,'Alemanha'),(73,'Italia'),(74,'Reino Unido'),(75,'Irlanda'),(76,'Japão'),(77,'China'),(78,'Índia'),(79,'Austrália'),(80,'Nova Zelândia'),(81,'África do Sul'),(82,'Egito'),(83,'Arábia Saudita'),(84,'Turquia'),(85,'Rússia'),(86,'Ucrânia'),(87,'Polônia'),(88,'Suécia'),(89,'Noruega'),(90,'Dinamarca');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-26 19:36:37
