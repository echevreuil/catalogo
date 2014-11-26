CREATE DATABASE  IF NOT EXISTS `catalogo` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `catalogo`;
-- MySQL dump 10.13  Distrib 5.6.19, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: catalogo
-- ------------------------------------------------------
-- Server version	5.5.38-0ubuntu0.12.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `album` (
  `id_album` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `id_artista` int(11) DEFAULT NULL,
  `id_genero` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_album`),
  KEY `fk_album_artista_idx` (`id_artista`),
  KEY `fk_album_genero_idx` (`id_genero`),
  CONSTRAINT `fk_album_genero` FOREIGN KEY (`id_genero`) REFERENCES `genero` (`id_genero`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_album_artista` FOREIGN KEY (`id_artista`) REFERENCES `artista` (`id_artista`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `album_musica`
--

DROP TABLE IF EXISTS `album_musica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `album_musica` (
  `id_album` int(11) NOT NULL,
  `id_musica` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_album`),
  KEY `fk_album_musica_musica_idx` (`id_musica`),
  CONSTRAINT `fk_album_musica_album` FOREIGN KEY (`id_album`) REFERENCES `album` (`id_album`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_album_musica_musica` FOREIGN KEY (`id_musica`) REFERENCES `musica` (`id_musica`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album_musica`
--

LOCK TABLES `album_musica` WRITE;
/*!40000 ALTER TABLE `album_musica` DISABLE KEYS */;
/*!40000 ALTER TABLE `album_musica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artista`
--

DROP TABLE IF EXISTS `artista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `artista` (
  `id_artista` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_artista`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artista`
--

LOCK TABLES `artista` WRITE;
/*!40000 ALTER TABLE `artista` DISABLE KEYS */;
/*!40000 ALTER TABLE `artista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalogo`
--

DROP TABLE IF EXISTS `catalogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `catalogo` (
  `id_catalogo` int(11) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_catalogo`),
  KEY `fk_usuario_idx` (`id_usuario`),
  CONSTRAINT `fk_catalogo_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalogo`
--

LOCK TABLES `catalogo` WRITE;
/*!40000 ALTER TABLE `catalogo` DISABLE KEYS */;
/*!40000 ALTER TABLE `catalogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalogo_album`
--

DROP TABLE IF EXISTS `catalogo_album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `catalogo_album` (
  `rating` int(11) NOT NULL,
  `id_album` int(11) DEFAULT NULL,
  `id_catalogo` int(11) DEFAULT NULL,
  PRIMARY KEY (`rating`),
  KEY `fk_catalogo_album_album_idx` (`id_album`),
  KEY `fk_catalogo_album_catalogo_idx` (`id_catalogo`),
  CONSTRAINT `fk_catalogo_album_album` FOREIGN KEY (`id_album`) REFERENCES `album` (`id_album`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_catalogo_album_catalogo` FOREIGN KEY (`id_catalogo`) REFERENCES `catalogo` (`id_catalogo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalogo_album`
--

LOCK TABLES `catalogo_album` WRITE;
/*!40000 ALTER TABLE `catalogo_album` DISABLE KEYS */;
/*!40000 ALTER TABLE `catalogo_album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentario`
--

DROP TABLE IF EXISTS `comentario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentario` (
  `id_comentario` int(11) NOT NULL,
  `descricao` varchar(4000) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_comentario_pai` int(11) DEFAULT NULL,
  `tipo_comentario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_comentario`),
  KEY `fk_comentario_usario_idx` (`id_usuario`),
  KEY `fk_comentario_pai_idx` (`id_comentario_pai`),
  KEY `fk_comentario_1_idx` (`tipo_comentario`),
  CONSTRAINT `fk_comentario_pai` FOREIGN KEY (`id_comentario_pai`) REFERENCES `comentario` (`id_comentario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comentario_usario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentario`
--

LOCK TABLES `comentario` WRITE;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genero` (
  `id_genero` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_genero`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo` (
  `id_grupo` int(11) NOT NULL,
  `nome` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_grupo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo_usuario`
--

DROP TABLE IF EXISTS `grupo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo_usuario` (
  `id_usuario` int(11) NOT NULL,
  `id_grupo` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_grupo`),
  KEY `fk_id_grupo_idx` (`id_grupo`),
  CONSTRAINT `fk_grupo_usuario_grupo` FOREIGN KEY (`id_grupo`) REFERENCES `grupo` (`id_grupo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_grupo_usuario_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo_usuario`
--

LOCK TABLES `grupo_usuario` WRITE;
/*!40000 ALTER TABLE `grupo_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `grupo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musica`
--

DROP TABLE IF EXISTS `musica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `musica` (
  `id_musica` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `versao` varchar(45) DEFAULT NULL,
  `id_genero` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_musica`),
  KEY `fk_musica_genero_idx` (`id_genero`),
  CONSTRAINT `fk_musica_genero` FOREIGN KEY (`id_genero`) REFERENCES `genero` (`id_genero`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musica`
--

LOCK TABLES `musica` WRITE;
/*!40000 ALTER TABLE `musica` DISABLE KEYS */;
/*!40000 ALTER TABLE `musica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `login` varchar(200) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `dt_nascimento` date DEFAULT NULL,
  `nome` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-26 20:46:28
