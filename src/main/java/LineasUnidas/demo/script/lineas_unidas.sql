-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: lineas_unidas
-- ------------------------------------------------------
-- Server version	9.4.0

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
-- Table structure for table `boleto`
--

DROP TABLE IF EXISTS `boleto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boleto` (
  `id_boleto` int NOT NULL AUTO_INCREMENT,
  `estado` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `id_cliente` int NOT NULL,
  `id_viaje` int NOT NULL,
  PRIMARY KEY (`id_boleto`),
  KEY `FK30cqpepm4at2flx7r4yqng9pa` (`id_cliente`),
  KEY `FKanipwfhhxpecohdagj83vni79` (`id_viaje`),
  CONSTRAINT `FK30cqpepm4at2flx7r4yqng9pa` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_usuario`),
  CONSTRAINT `FKanipwfhhxpecohdagj83vni79` FOREIGN KEY (`id_viaje`) REFERENCES `viaje` (`id_viaje`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `checador`
--

DROP TABLE IF EXISTS `checador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `checador` (
  `id_usuario` int NOT NULL,
  `id_horario` int DEFAULT NULL,
  `contrasenia` varchar(255) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `FKqyc1dx8nlrdef9q8e5m5duxn6` (`id_horario`),
  CONSTRAINT `FK9cjmxoqjij4qcip2crujbalov` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `FKqyc1dx8nlrdef9q8e5m5duxn6` FOREIGN KEY (`id_horario`) REFERENCES `horario_trabajo` (`id_horario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `metodo_compra` varchar(255) DEFAULT NULL,
  `id_usuario` int NOT NULL,
  `contrasenia` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  CONSTRAINT `FKetx0tojxf5yevxcyt6qb526x5` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `conductor`
--

DROP TABLE IF EXISTS `conductor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conductor` (
  `permiso` varchar(255) NOT NULL,
  `id_usuario` int NOT NULL,
  `id_horario` int NOT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `FKibfmhlbnu36aljoidhjb28cpc` (`id_horario`),
  CONSTRAINT `FKibfmhlbnu36aljoidhjb28cpc` FOREIGN KEY (`id_horario`) REFERENCES `horario_trabajo` (`id_horario`),
  CONSTRAINT `FKko6797aa2qc6xevfmkpntpk29` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `gerente`
--

DROP TABLE IF EXISTS `gerente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gerente` (
  `id_usuario` int NOT NULL,
  `contrasenia` varchar(255) NOT NULL,
  `id_horario` int NOT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `FKr5k80ehaw81ftg3trq0oog4ql` (`id_horario`),
  CONSTRAINT `FK5ijo3k1uhl9fo2j8fl7bl5xe` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `FKr5k80ehaw81ftg3trq0oog4ql` FOREIGN KEY (`id_horario`) REFERENCES `horario_trabajo` (`id_horario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `horario_dias`
--

DROP TABLE IF EXISTS `horario_dias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horario_dias` (
  `id_horario` int NOT NULL,
  `dia` varchar(255) DEFAULT NULL,
  KEY `FKj257nep5o8g4bo6yil386ll1e` (`id_horario`),
  CONSTRAINT `FKj257nep5o8g4bo6yil386ll1e` FOREIGN KEY (`id_horario`) REFERENCES `horario_trabajo` (`id_horario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `horario_horas`
--

DROP TABLE IF EXISTS `horario_horas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horario_horas` (
  `id_horario` int NOT NULL,
  `hora` varchar(255) DEFAULT NULL,
  KEY `FKe7ndkix4xvj92yfee1j5akhse` (`id_horario`),
  CONSTRAINT `FKe7ndkix4xvj92yfee1j5akhse` FOREIGN KEY (`id_horario`) REFERENCES `horario_trabajo` (`id_horario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `horario_trabajo`
--

DROP TABLE IF EXISTS `horario_trabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horario_trabajo` (
  `id_horario` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_horario`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `horario_viaje`
--

DROP TABLE IF EXISTS `horario_viaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horario_viaje` (
  `id_horario` int NOT NULL AUTO_INCREMENT,
  `estado` varchar(255) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora_llegada` time(6) DEFAULT NULL,
  `hora_salida` time(6) DEFAULT NULL,
  PRIMARY KEY (`id_horario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ruta`
--

DROP TABLE IF EXISTS `ruta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ruta` (
  `id_ruta` int NOT NULL AUTO_INCREMENT,
  `destino` varchar(255) DEFAULT NULL,
  `distancia` varchar(255) DEFAULT NULL,
  `origen` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_ruta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `taquillero`
--

DROP TABLE IF EXISTS `taquillero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taquillero` (
  `id_usuario` int NOT NULL,
  `id_horario` int NOT NULL,
  `contrasenia` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `FK8fbq5t9shilj42k38g0pswllb` (`id_horario`),
  CONSTRAINT `FK8fbq5t9shilj42k38g0pswllb` FOREIGN KEY (`id_horario`) REFERENCES `horario_trabajo` (`id_horario`),
  CONSTRAINT `FK8ycw2svppovwlypt3vada2sj0` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `taquillero_boleto`
--

DROP TABLE IF EXISTS `taquillero_boleto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taquillero_boleto` (
  `id_taquillero` int NOT NULL,
  `id_boleto` int NOT NULL,
  PRIMARY KEY (`id_taquillero`,`id_boleto`),
  KEY `FK3bnst5q9g6kj8ou3cxeeytrc8` (`id_boleto`),
  CONSTRAINT `FK3bnst5q9g6kj8ou3cxeeytrc8` FOREIGN KEY (`id_boleto`) REFERENCES `boleto` (`id_boleto`),
  CONSTRAINT `FKb1gy4dsi6e1nu7ts90mvvjpbd` FOREIGN KEY (`id_taquillero`) REFERENCES `taquillero` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `urvan`
--

DROP TABLE IF EXISTS `urvan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `urvan` (
  `id_urban` int NOT NULL AUTO_INCREMENT,
  `capacidad` int NOT NULL,
  `placa` varchar(255) DEFAULT NULL,
  `id_conductor` int DEFAULT NULL,
  PRIMARY KEY (`id_urban`),
  UNIQUE KEY `UKn259ykc5al4c5dujtd9eqm63b` (`id_conductor`),
  CONSTRAINT `FKsqo7yl1q59nia7sjasm70bb4s` FOREIGN KEY (`id_conductor`) REFERENCES `conductor` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `apellido_m` varchar(255) DEFAULT NULL,
  `apellido_p` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `UK2mlfr087gb1ce55f2j87o74t` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `viaje`
--

DROP TABLE IF EXISTS `viaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `viaje` (
  `id_viaje` int NOT NULL AUTO_INCREMENT,
  `disponibilidad` varchar(255) DEFAULT NULL,
  `precio` float NOT NULL,
  `id_horario` int DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_viaje`),
  UNIQUE KEY `UKorclk706hbmws6qvcifablwqf` (`id_horario`),
  CONSTRAINT `FKlmtr25pwvusk3ga0bkcb5fna2` FOREIGN KEY (`id_horario`) REFERENCES `horario_viaje` (`id_horario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `viaje_ruta`
--

DROP TABLE IF EXISTS `viaje_ruta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `viaje_ruta` (
  `id_viaje` int NOT NULL,
  `id_ruta` int NOT NULL,
  KEY `FKrpqihtj1atq5padplnkv0s7rq` (`id_ruta`),
  KEY `FKj7f1dv6fu4mc1csfqcqqmeab1` (`id_viaje`),
  CONSTRAINT `FKj7f1dv6fu4mc1csfqcqqmeab1` FOREIGN KEY (`id_viaje`) REFERENCES `viaje` (`id_viaje`),
  CONSTRAINT `FKrpqihtj1atq5padplnkv0s7rq` FOREIGN KEY (`id_ruta`) REFERENCES `ruta` (`id_ruta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `viaje_urvan`
--

DROP TABLE IF EXISTS `viaje_urvan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `viaje_urvan` (
  `id_viaje` int NOT NULL,
  `id_urban` int NOT NULL,
  KEY `FKbiisbmmgkw084akpu1lmsaw7p` (`id_urban`),
  KEY `FKdpbfwg2n286nxxkj99ue6pxd9` (`id_viaje`),
  CONSTRAINT `FKbiisbmmgkw084akpu1lmsaw7p` FOREIGN KEY (`id_urban`) REFERENCES `urvan` (`id_urban`),
  CONSTRAINT `FKdpbfwg2n286nxxkj99ue6pxd9` FOREIGN KEY (`id_viaje`) REFERENCES `viaje` (`id_viaje`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-09-20 12:31:06
