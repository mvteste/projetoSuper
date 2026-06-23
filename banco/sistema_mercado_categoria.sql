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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Bebidas','Produtos líquidos'),(2,'Limpeza','Produtos de limpeza'),(3,'Alimentos','Produtos alimentícios'),(4,'Bebidas','Produtos líquidos'),(5,'Alimentos','Comidas em geral'),(6,'Limpeza','Produtos de limpeza'),(7,'Higiene','Produtos de higiene'),(8,'Padaria','Itens de padaria'),(9,'Frios','Produtos refrigerados'),(10,'Carnes','Carnes variadas'),(11,'Congelados','Produtos congelados'),(12,'Doces','Doces e chocolates'),(13,'Pet','Produtos pet'),(14,'Hortifruti','Frutas e verduras'),(15,'Laticínios','Leite e derivados'),(16,'Massas','Massas alimentícias'),(17,'Temperos','Temperos diversos'),(18,'Enlatados','Produtos enlatados'),(19,'Biscoitos','Biscoitos variados'),(20,'Cereais','Cereais e grãos'),(21,'Sorvetes','Sorvetes'),(22,'Utilidades','Itens domésticos'),(23,'Eletrônicos','Produtos eletrônicos'),(24,'Papelaria','Produtos escolares'),(25,'Bazar','Itens de bazar'),(26,'Fitness','Produtos fitness'),(27,'Infantil','Produtos infantis'),(28,'Automotivo','Produtos automotivos'),(29,'Farmácia','Medicamentos básicos'),(30,'Café','Cafés e derivados'),(31,'Chás','Chás diversos'),(32,'Sucos','Sucos naturais'),(33,'Importados','Produtos importados');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
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
