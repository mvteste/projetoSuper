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
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `endereco` varchar(150) DEFAULT NULL,
  `data_admissao` date DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `tipo_funcionario_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf` (`cpf`),
  KEY `tipo_funcionario_id` (`tipo_funcionario_id`),
  CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`tipo_funcionario_id`) REFERENCES `tipo_funcionario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Carlos Mendes','11122233344','47999991111','carlos@email.com','Rua Alpha','2025-01-10','1990-02-15','A',1),(2,'Ana Lima','55566677788','47988882222','ana@email.com','Rua Beta','2025-02-01','1998-10-20','A',2),(3,'Funcionario 1','90000000001','47988880001','f1@email.com','Rua 1','2025-01-01','1990-01-01','A',1),(4,'Funcionario 2','90000000002','47988880002','f2@email.com','Rua 2','2025-01-01','1990-01-01','A',2),(5,'Funcionario 3','90000000003','47988880003','f3@email.com','Rua 3','2025-01-01','1990-01-01','A',3),(6,'Funcionario 4','90000000004','47988880004','f4@email.com','Rua 4','2025-01-01','1990-01-01','A',4),(7,'Funcionario 5','90000000005','47988880005','f5@email.com','Rua 5','2025-01-01','1990-01-01','A',5),(8,'Funcionario 6','90000000006','47988880006','f6@email.com','Rua 6','2025-01-01','1990-01-01','A',1),(9,'Funcionario 7','90000000007','47988880007','f7@email.com','Rua 7','2025-01-01','1990-01-01','A',2),(10,'Funcionario 8','90000000008','47988880008','f8@email.com','Rua 8','2025-01-01','1990-01-01','A',3),(11,'Funcionario 9','90000000009','47988880009','f9@email.com','Rua 9','2025-01-01','1990-01-01','A',4),(12,'Funcionario 10','90000000010','47988880010','f10@email.com','Rua 10','2025-01-01','1990-01-01','A',5),(13,'Funcionario 11','90000000011','47988880011','f11@email.com','Rua 11','2025-01-01','1990-01-01','A',1),(14,'Funcionario 12','90000000012','47988880012','f12@email.com','Rua 12','2025-01-01','1990-01-01','A',2),(15,'Funcionario 13','90000000013','47988880013','f13@email.com','Rua 13','2025-01-01','1990-01-01','A',3),(16,'Funcionario 14','90000000014','47988880014','f14@email.com','Rua 14','2025-01-01','1990-01-01','A',4),(17,'Funcionario 15','90000000015','47988880015','f15@email.com','Rua 15','2025-01-01','1990-01-01','A',5),(18,'Funcionario 16','90000000016','47988880016','f16@email.com','Rua 16','2025-01-01','1990-01-01','A',1),(19,'Funcionario 17','90000000017','47988880017','f17@email.com','Rua 17','2025-01-01','1990-01-01','A',2),(20,'Funcionario 18','90000000018','47988880018','f18@email.com','Rua 18','2025-01-01','1990-01-01','A',3),(21,'Funcionario 19','90000000019','47988880019','f19@email.com','Rua 19','2025-01-01','1990-01-01','A',4),(22,'Funcionario 20','90000000020','47988880020','f20@email.com','Rua 20','2025-01-01','1990-01-01','A',5),(23,'Funcionario 21','90000000021','47988880021','f21@email.com','Rua 21','2025-01-01','1990-01-01','A',1),(24,'Funcionario 22','90000000022','47988880022','f22@email.com','Rua 22','2025-01-01','1990-01-01','A',2),(25,'Funcionario 23','90000000023','47988880023','f23@email.com','Rua 23','2025-01-01','1990-01-01','A',3),(26,'Funcionario 24','90000000024','47988880024','f24@email.com','Rua 24','2025-01-01','1990-01-01','A',4),(27,'Funcionario 25','90000000025','47988880025','f25@email.com','Rua 25','2025-01-01','1990-01-01','A',5),(28,'Funcionario 26','90000000026','47988880026','f26@email.com','Rua 26','2025-01-01','1990-01-01','A',1),(29,'Funcionario 27','90000000027','47988880027','f27@email.com','Rua 27','2025-01-01','1990-01-01','A',2),(30,'Funcionario 28','90000000028','47988880028','f28@email.com','Rua 28','2025-01-01','1990-01-01','A',3),(31,'Funcionario 29','90000000029','47988880029','f29@email.com','Rua 29','2025-01-01','1990-01-01','A',4),(32,'Funcionario 30','90000000030','47988880030','f30@email.com','Rua 30','2025-01-01','1990-01-01','A',5);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-23 20:58:00
