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
-- Table structure for table `categoria_produto`
--

DROP TABLE IF EXISTS `categoria_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria_produto` (
  `ID_Categoria` int NOT NULL AUTO_INCREMENT,
  `DS_Categoria` varchar(100) NOT NULL,
  PRIMARY KEY (`ID_Categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria_produto`
--

LOCK TABLES `categoria_produto` WRITE;
/*!40000 ALTER TABLE `categoria_produto` DISABLE KEYS */;
INSERT INTO `categoria_produto` VALUES (1,'Bebidas'),(2,'Alimentos Frescos'),(3,'Congelados'),(4,'Laticínios'),(5,'Padaria'),(6,'Higiene Pessoal'),(7,'Limpeza'),(8,'Carnes'),(9,'Frutas e Verduras'),(10,'Massas e Grãos'),(11,'Enlatados e Conservas'),(12,'Doces e Sobremesas'),(13,'Biscoitos e Snacks'),(14,'Cereais e Café da Manhã'),(15,'Bebidas Alcoólicas'),(16,'Produtos de Pet Shop'),(17,'Eletrônicos e Eletrodomésticos'),(18,'Utensílios de Cozinha'),(19,'Roupas e Acessórios'),(20,'Materiais de Escritório'),(21,'Bebidas'),(22,'Alimentos Frescos'),(23,'Congelados'),(24,'Laticínios'),(25,'Padaria'),(26,'Higiene Pessoal'),(27,'Limpeza'),(28,'Carnes'),(29,'Frutas e Verduras'),(30,'Massas e Grãos'),(31,'Enlatados e Conservas'),(32,'Doces e Sobremesas'),(33,'Biscoitos e Snacks'),(34,'Cereais e Café da Manhã'),(35,'Bebidas Alcoólicas'),(36,'Produtos de Pet Shop'),(37,'Eletrônicos e Eletrodomésticos'),(38,'Utensílios de Cozinha'),(39,'Roupas e Acessórios'),(40,'Materiais de Escritório'),(41,'Bebidas'),(42,'Alimentos Frescos'),(43,'Congelados'),(44,'Laticínios'),(45,'Padaria'),(46,'Higiene Pessoal'),(47,'Limpeza'),(48,'Carnes'),(49,'Frutas e Verduras'),(50,'Massas e Grãos'),(51,'Enlatados e Conservas'),(52,'Doces e Sobremesas'),(53,'Biscoitos e Snacks'),(54,'Cereais e Café da Manhã'),(55,'Bebidas Alcoólicas'),(56,'Produtos de Pet Shop'),(57,'Eletrônicos e Eletrodomésticos'),(58,'Utensílios de Cozinha'),(59,'Roupas e Acessórios'),(60,'Materiais de Escritório');
/*!40000 ALTER TABLE `categoria_produto` ENABLE KEYS */;
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
