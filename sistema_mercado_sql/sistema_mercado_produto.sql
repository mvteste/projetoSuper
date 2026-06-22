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
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `descricao` varchar(150) DEFAULT NULL,
  `data_vencimento` date DEFAULT NULL,
  `categoria_id` int DEFAULT NULL,
  `preco` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `categoria_id` (`categoria_id`),
  CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Coca-Cola 2L','Refrigerante','2026-01-10',1,NULL),(2,'Detergente','Detergente líquido','2027-05-01',2,NULL),(3,'Arroz 5KG','Arroz branco','2026-08-15',3,NULL),(4,'Coca-Cola 2L','Refrigerante cola','2026-01-10',1,NULL),(5,'Pepsi 2L','Refrigerante cola','2026-02-15',1,NULL),(6,'Arroz 5KG','Arroz branco','2026-08-10',2,NULL),(7,'Feijão Preto','Feijão tipo 1','2026-09-11',2,NULL),(8,'Detergente Ypê','Detergente líquido','2027-05-10',3,NULL),(9,'Água Sanitária','Produto limpeza','2027-03-20',3,NULL),(10,'Shampoo Seda','Shampoo cabelo','2027-07-11',4,NULL),(11,'Sabonete Dove','Sabonete hidratante','2027-10-01',4,NULL),(12,'Pão Francês','Pão fresco','2025-05-22',5,NULL),(13,'Queijo Mussarela','Queijo fatiado','2025-06-11',6,NULL),(14,'Picanha','Carne bovina','2025-06-01',7,NULL),(15,'Hambúrguer','Carne congelada','2026-04-01',8,NULL),(16,'Chocolate Lacta','Chocolate ao leite','2026-10-01',9,NULL),(17,'Ração Pedigree','Ração cachorro','2027-01-01',10,NULL),(18,'Banana','Banana caturra','2025-05-25',11,NULL),(19,'Leite Integral','Leite longa vida','2025-12-20',12,NULL),(20,'Macarrão','Massa espaguete','2026-11-01',13,NULL),(21,'Orégano','Tempero seco','2027-02-02',14,NULL),(22,'Milho Enlatado','Milho verde','2026-08-08',15,NULL),(23,'Biscoito Oreo','Biscoito recheado','2026-09-09',16,NULL),(24,'Granola','Cereal integral','2026-07-07',17,NULL),(25,'Sorvete Kibon','Sorvete creme','2026-01-01',18,NULL),(26,'Panela','Panela alumínio',NULL,19,NULL),(27,'Mouse Gamer','Mouse RGB',NULL,20,NULL),(28,'Caderno 10 matérias','Caderno escolar',NULL,21,NULL),(29,'Balde','Balde plástico',NULL,22,NULL),(30,'Whey Protein','Suplemento','2027-06-01',23,NULL),(31,'Fralda Infantil','Pacote fralda','2028-01-01',24,NULL),(32,'Óleo Motor','Óleo automotivo','2027-01-01',25,NULL),(33,'Paracetamol','Medicamento','2027-12-01',26,NULL),(34,'Teste 1','Coca Cuela','2026-06-18',1,NULL),(35,'Teste 2 ','Teste','2026-11-27',1,0.00);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-22 19:12:40
