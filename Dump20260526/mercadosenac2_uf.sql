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
-- Table structure for table `uf`
--

DROP TABLE IF EXISTS `uf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uf` (
  `ID_UF` int NOT NULL AUTO_INCREMENT,
  `SG_UF` char(2) NOT NULL,
  `NM_UF` varchar(100) NOT NULL,
  `ID_Pais` int NOT NULL,
  PRIMARY KEY (`ID_UF`),
  KEY `ID_Pais` (`ID_Pais`),
  CONSTRAINT `uf_ibfk_1` FOREIGN KEY (`ID_Pais`) REFERENCES `pais` (`ID_Pais`)
) ENGINE=InnoDB AUTO_INCREMENT=226 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uf`
--

LOCK TABLES `uf` WRITE;
/*!40000 ALTER TABLE `uf` DISABLE KEYS */;
INSERT INTO `uf` VALUES (1,'AC','Acre',1),(2,'AL','Alagoas',1),(3,'AM','Amazonas',1),(4,'BA','Bahia',1),(5,'CE','Ceará',1),(6,'DF','Distrito Federal',1),(7,'ES','Espírito Santo',1),(8,'GO','Goiás',1),(9,'MA','Maranhão',1),(10,'MG','Minas Gerais',1),(11,'MS','Mato Grosso do Sul',1),(12,'MT','Mato Grosso',1),(13,'PA','Pará',1),(14,'PB','Paraíba',1),(15,'PR','Paraná',1),(16,'PE','Pernambuco',1),(17,'PI','Piauí',1),(18,'RJ','Rio de Janeiro',1),(19,'RN','Rio Grande do Norte',1),(20,'RS','Rio Grande do Sul',1),(21,'BA','Buenos Aires',2),(22,'CB','Córdoba',2),(23,'SF','Santa Fe',2),(24,'RM','Região Metropolitana',3),(25,'XV','Arica y Parinacota',3),(26,'MV','Montevideo',4),(27,'AS','Asunción',5),(28,'CA','California',6),(29,'NY','New York',6),(30,'TX','Texas',6),(31,'ON','Ontario',7),(32,'QC','Quebec',7),(33,'BC','British Columbia',7),(34,'CM','Ciudad de México',8),(35,'JL','Jalisco',8),(36,'LX','Lisboa',9),(37,'PT','Porto',9),(38,'MD','Madrid',10),(39,'CT','Cataluña',10),(40,'IF','Île-de-France',11),(41,'PC','Provence-Alpes-Côte d’Azur',11),(42,'BW','Baden-Württemberg',12),(43,'BY','Bayern',12),(44,'RM','Regione Lazio',13),(45,'LM','Lombardia',13),(46,'EG','England',14),(47,'ST','Scotland',14),(48,'LE','Leinster',15),(49,'MU','Munster',15),(50,'TK','Tóquio',16),(51,'OS','Osaka',16),(52,'BJ','Beijing',17),(53,'SH','Shanghai',17),(54,'MH','Maharashtra',18),(55,'DL','Delhi',18),(56,'NW','New South Wales',19),(57,'VC','Victoria',19),(58,'AK','Auckland',20),(59,'WN','Wellington',20),(60,'GP','Gauteng',21),(61,'WC','Western Cape',21),(62,'C','Cairo Governorate',22),(63,'RI','Riyadh Province',23),(64,'M','Makkah Province',23),(65,'IT','Istanbul',24),(66,'AK','Ankara',24),(67,'MW','Moscow',25),(68,'SP','Saint Petersburg',25),(69,'KY','Kyiv',26),(70,'OD','Odesa',26),(71,'MZ','Mazowieckie',27),(72,'SL','Śląskie',27),(73,'ST','Stockholm County',28),(74,'OS','Oslo',29),(75,'HV','Hovedstaden',30),(76,'AC','Acre',1),(77,'AL','Alagoas',1),(78,'AM','Amazonas',1),(79,'BA','Bahia',1),(80,'CE','Ceará',1),(81,'DF','Distrito Federal',1),(82,'ES','Espírito Santo',1),(83,'GO','Goiás',1),(84,'MA','Maranhão',1),(85,'MG','Minas Gerais',1),(86,'MS','Mato Grosso do Sul',1),(87,'MT','Mato Grosso',1),(88,'PA','Pará',1),(89,'PB','Paraíba',1),(90,'PR','Paraná',1),(91,'PE','Pernambuco',1),(92,'PI','Piauí',1),(93,'RJ','Rio de Janeiro',1),(94,'RN','Rio Grande do Norte',1),(95,'RS','Rio Grande do Sul',1),(96,'BA','Buenos Aires',2),(97,'CB','Córdoba',2),(98,'SF','Santa Fe',2),(99,'RM','Região Metropolitana',3),(100,'XV','Arica y Parinacota',3),(101,'MV','Montevideo',4),(102,'AS','Asunción',5),(103,'CA','California',6),(104,'NY','New York',6),(105,'TX','Texas',6),(106,'ON','Ontario',7),(107,'QC','Quebec',7),(108,'BC','British Columbia',7),(109,'CM','Ciudad de México',8),(110,'JL','Jalisco',8),(111,'LX','Lisboa',9),(112,'PT','Porto',9),(113,'MD','Madrid',10),(114,'CT','Cataluña',10),(115,'IF','Île-de-France',11),(116,'PC','Provence-Alpes-Côte d’Azur',11),(117,'BW','Baden-Württemberg',12),(118,'BY','Bayern',12),(119,'RM','Regione Lazio',13),(120,'LM','Lombardia',13),(121,'EG','England',14),(122,'ST','Scotland',14),(123,'LE','Leinster',15),(124,'MU','Munster',15),(125,'TK','Tóquio',16),(126,'OS','Osaka',16),(127,'BJ','Beijing',17),(128,'SH','Shanghai',17),(129,'MH','Maharashtra',18),(130,'DL','Delhi',18),(131,'NW','New South Wales',19),(132,'VC','Victoria',19),(133,'AK','Auckland',20),(134,'WN','Wellington',20),(135,'GP','Gauteng',21),(136,'WC','Western Cape',21),(137,'C','Cairo Governorate',22),(138,'RI','Riyadh Province',23),(139,'M','Makkah Province',23),(140,'IT','Istanbul',24),(141,'AK','Ankara',24),(142,'MW','Moscow',25),(143,'SP','Saint Petersburg',25),(144,'KY','Kyiv',26),(145,'OD','Odesa',26),(146,'MZ','Mazowieckie',27),(147,'SL','Śląskie',27),(148,'ST','Stockholm County',28),(149,'OS','Oslo',29),(150,'HV','Hovedstaden',30),(151,'AC','Acre',1),(152,'AL','Alagoas',1),(153,'AM','Amazonas',1),(154,'BA','Bahia',1),(155,'CE','Ceará',1),(156,'DF','Distrito Federal',1),(157,'ES','Espírito Santo',1),(158,'GO','Goiás',1),(159,'MA','Maranhão',1),(160,'MG','Minas Gerais',1),(161,'MS','Mato Grosso do Sul',1),(162,'MT','Mato Grosso',1),(163,'PA','Pará',1),(164,'PB','Paraíba',1),(165,'PR','Paraná',1),(166,'PE','Pernambuco',1),(167,'PI','Piauí',1),(168,'RJ','Rio de Janeiro',1),(169,'RN','Rio Grande do Norte',1),(170,'RS','Rio Grande do Sul',1),(171,'BA','Buenos Aires',2),(172,'CB','Córdoba',2),(173,'SF','Santa Fe',2),(174,'RM','Região Metropolitana',3),(175,'XV','Arica y Parinacota',3),(176,'MV','Montevideo',4),(177,'AS','Asunción',5),(178,'CA','California',6),(179,'NY','New York',6),(180,'TX','Texas',6),(181,'ON','Ontario',7),(182,'QC','Quebec',7),(183,'BC','British Columbia',7),(184,'CM','Ciudad de México',8),(185,'JL','Jalisco',8),(186,'LX','Lisboa',9),(187,'PT','Porto',9),(188,'MD','Madrid',10),(189,'CT','Cataluña',10),(190,'IF','Île-de-France',11),(191,'PC','Provence-Alpes-Côte d’Azur',11),(192,'BW','Baden-Württemberg',12),(193,'BY','Bayern',12),(194,'RM','Regione Lazio',13),(195,'LM','Lombardia',13),(196,'EG','England',14),(197,'ST','Scotland',14),(198,'LE','Leinster',15),(199,'MU','Munster',15),(200,'TK','Tóquio',16),(201,'OS','Osaka',16),(202,'BJ','Beijing',17),(203,'SH','Shanghai',17),(204,'MH','Maharashtra',18),(205,'DL','Delhi',18),(206,'NW','New South Wales',19),(207,'VC','Victoria',19),(208,'AK','Auckland',20),(209,'WN','Wellington',20),(210,'GP','Gauteng',21),(211,'WC','Western Cape',21),(212,'C','Cairo Governorate',22),(213,'RI','Riyadh Province',23),(214,'M','Makkah Province',23),(215,'IT','Istanbul',24),(216,'AK','Ankara',24),(217,'MW','Moscow',25),(218,'SP','Saint Petersburg',25),(219,'KY','Kyiv',26),(220,'OD','Odesa',26),(221,'MZ','Mazowieckie',27),(222,'SL','Śląskie',27),(223,'ST','Stockholm County',28),(224,'OS','Oslo',29),(225,'HV','Hovedstaden',30);
/*!40000 ALTER TABLE `uf` ENABLE KEYS */;
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
