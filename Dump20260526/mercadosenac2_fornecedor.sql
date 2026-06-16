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
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornecedor` (
  `ID_Fornecedor` int NOT NULL AUTO_INCREMENT,
  `NM_Fornecedor` varchar(150) NOT NULL,
  `ID_Endereco` int DEFAULT NULL,
  `CNPJ` char(14) DEFAULT NULL,
  `Telefone` varchar(15) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_Fornecedor`),
  UNIQUE KEY `CNPJ` (`CNPJ`),
  KEY `ID_Endereco` (`ID_Endereco`),
  CONSTRAINT `fornecedor_ibfk_1` FOREIGN KEY (`ID_Endereco`) REFERENCES `endereco` (`ID_Endereco`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` VALUES (1,'Fornecedor A',1,'12345678000101','51999990001','contato@fornecedorA.com'),(2,'Fornecedor B',2,'12345678000202','51999990002','contato@fornecedorB.com'),(3,'Fornecedor C',3,'12345678000303','51999990003','contato@fornecedorC.com'),(4,'Fornecedor D',4,'12345678000404','51999990004','contato@fornecedorD.com'),(5,'Fornecedor E',5,'12345678000505','51999990005','contato@fornecedorE.com'),(6,'Fornecedor F',6,'12345678000606','51999990006','contato@fornecedorF.com'),(7,'Fornecedor G',7,'12345678000707','51999990007','contato@fornecedorG.com'),(8,'Fornecedor H',8,'12345678000808','51999990008','contato@fornecedorH.com'),(9,'Fornecedor I',9,'12345678000909','51999990009','contato@fornecedorI.com'),(10,'Fornecedor J',10,'12345678001010','51999990010','contato@fornecedorJ.com'),(11,'Fornecedor K',11,'12345678001111','51999990011','contato@fornecedorK.com'),(12,'Fornecedor L',12,'12345678001212','51999990012','contato@fornecedorL.com'),(13,'Fornecedor M',13,'12345678001313','51999990013','contato@fornecedorM.com'),(14,'Fornecedor N',14,'12345678001414','51999990014','contato@fornecedorN.com'),(15,'Fornecedor O',15,'12345678001515','51999990015','contato@fornecedorO.com'),(16,'Fornecedor P',16,'12345678001616','51999990016','contato@fornecedorP.com'),(17,'Fornecedor Q',17,'12345678001717','51999990017','contato@fornecedorQ.com'),(18,'Fornecedor R',18,'12345678001818','51999990018','contato@fornecedorR.com'),(19,'Fornecedor S',19,'12345678001919','51999990019','contato@fornecedorS.com'),(20,'Fornecedor T',20,'12345678002020','51999990020','contato@fornecedorT.com');
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

-- Dump completed on 2026-05-26 19:36:36
