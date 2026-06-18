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
-- Temporary view structure for view `estoque_status_critico`
--

DROP TABLE IF EXISTS `estoque_status_critico`;
/*!50001 DROP VIEW IF EXISTS `estoque_status_critico`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `estoque_status_critico` AS SELECT 
 1 AS `Produto`,
 1 AS `Categoria`,
 1 AS `Fornecedor`,
 1 AS `Estoque_Atual`,
 1 AS `Estoque_Minimo`,
 1 AS `Local_Estoque`,
 1 AS `Status_Estoque`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `estoque_status_critico`
--

/*!50001 DROP VIEW IF EXISTS `estoque_status_critico`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `estoque_status_critico` AS select `prod`.`DS_Produto` AS `Produto`,`cat`.`DS_Categoria` AS `Categoria`,`forn`.`NM_Fornecedor` AS `Fornecedor`,`est`.`QT_Estoque` AS `Estoque_Atual`,`est`.`QT_Minima` AS `Estoque_Minimo`,`loc`.`DS_Local` AS `Local_Estoque`,(case when (`est`.`QT_Estoque` <= `est`.`QT_Minima`) then 'CRÍTICO' when (`est`.`QT_Estoque` <= (`est`.`QT_Minima` * 1.5)) then 'ALERTA' else 'NORMAL' end) AS `Status_Estoque` from ((((`estoque` `est` join `produto` `prod` on((`est`.`ID_Produto` = `prod`.`ID_Produto`))) join `categoria_produto` `cat` on((`prod`.`ID_Categoria` = `cat`.`ID_Categoria`))) left join `fornecedor` `forn` on((`prod`.`ID_Fornecedor` = `forn`.`ID_Fornecedor`))) join `local_estoque` `loc` on((`est`.`ID_Local_Estoque` = `loc`.`ID_Local_Estoque`))) where (`est`.`QT_Estoque` <= (`est`.`QT_Minima` * 2)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-26 19:36:38
