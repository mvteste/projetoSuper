-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: sistema_mercado
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
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornecedor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cnpj` varchar(18) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `endereco` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cnpj` (`cnpj`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` VALUES (1,'Distribuidora Sul','12345678000199','sul@email.com','Rua A'),(2,'Mercado Central','98765432000188','central@email.com','Rua B'),(3,'Fornecedor 1','11111111111111','f1@email.com','Rua 1'),(4,'Fornecedor 2','22222222222222','f2@email.com','Rua 2'),(5,'Fornecedor 3','33333333333333','f3@email.com','Rua 3'),(6,'Fornecedor 4','44444444444444','f4@email.com','Rua 4'),(7,'Fornecedor 5','55555555555555','f5@email.com','Rua 5'),(8,'Fornecedor 6','66666666666666','f6@email.com','Rua 6'),(9,'Fornecedor 7','77777777777777','f7@email.com','Rua 7'),(10,'Fornecedor 8','88888888888888','f8@email.com','Rua 8'),(11,'Fornecedor 9','99999999999999','f9@email.com','Rua 9'),(12,'Fornecedor 10','10101010101010','f10@email.com','Rua 10'),(13,'Fornecedor 11','11111111111112','f11@email.com','Rua 11'),(14,'Fornecedor 12','12121212121212','f12@email.com','Rua 12'),(15,'Fornecedor 13','13131313131313','f13@email.com','Rua 13'),(16,'Fornecedor 14','14141414141414','f14@email.com','Rua 14'),(17,'Fornecedor 15','15151515151515','f15@email.com','Rua 15'),(18,'Fornecedor 16','16161616161616','f16@email.com','Rua 16'),(19,'Fornecedor 17','17171717171717','f17@email.com','Rua 17'),(20,'Fornecedor 18','18181818181818','f18@email.com','Rua 18'),(21,'Fornecedor 19','19191919191919','f19@email.com','Rua 19'),(22,'Fornecedor 20','20202020202020','f20@email.com','Rua 20'),(23,'Fornecedor 21','21212121212121','f21@email.com','Rua 21'),(24,'Fornecedor 22','22222222222223','f22@email.com','Rua 22'),(25,'Fornecedor 23','23232323232323','f23@email.com','Rua 23'),(26,'Fornecedor 24','24242424242424','f24@email.com','Rua 24'),(27,'Fornecedor 25','25252525252525','f25@email.com','Rua 25'),(28,'Fornecedor 26','26262626262626','f26@email.com','Rua 26'),(29,'Fornecedor 27','27272727272727','f27@email.com','Rua 27'),(30,'Fornecedor 28','28282828282828','f28@email.com','Rua 28'),(31,'Fornecedor 29','29292929292929','f29@email.com','Rua 29'),(32,'Fornecedor 30','30303030303030','f30@email.com','Rua 30'),(33,'Teste','0000000000000','g@g.com','dasdfasfa');
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-22 19:12:41
