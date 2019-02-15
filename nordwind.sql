-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server Version:               10.1.30-MariaDB - mariadb.org binary distribution
-- Server Betriebssystem:        Win32
-- HeidiSQL Version:             9.5.0.5278
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Exportiere Datenbank Struktur für hibernate_tutorial
CREATE DATABASE IF NOT EXISTS `hibernate_tutorial` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `hibernate_tutorial`;

-- Exportiere Struktur von Tabelle hibernate_tutorial.tbl_personen
CREATE TABLE IF NOT EXISTS `tbl_personen` (
  `PersonenNr` int(11) NOT NULL AUTO_INCREMENT,
  `Nachname` varchar(255) DEFAULT NULL,
  `Vorname` varchar(255) DEFAULT NULL,
  `Land` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PersonenNr`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- Exportiere Daten aus Tabelle hibernate_tutorial.tbl_personen: ~12 rows (ungefähr)
DELETE FROM `tbl_personen`;
/*!40000 ALTER TABLE `tbl_personen` DISABLE KEYS */;
INSERT INTO `tbl_personen` (`PersonenNr`, `Nachname`, `Vorname`, `Land`) VALUES
	(1, 'Test', 'Tom', 'Polen'),
	(2, 'Mustermann', 'Max', 'Italien'),
	(3, 'Fuller', 'Andrew', 'USA'),
	(4, 'Leverling', 'Janet', 'United Kingdom'),
	(5, 'Peacock', 'Margaret', 'Spain'),
	(6, 'Musterfrau', 'Maria', 'Schweden'),
	(7, 'Suyama', 'Michael', 'Germany'),
	(8, 'King', 'Robert', 'United Kingdom'),
	(9, 'Callahan', 'Laura', 'Spain'),
	(10, 'Dodsworth', 'Anne', 'Greece'),
	(11, 'Schwammkopf', 'Spongebob', 'Pazifik'),
	(12, 'Ate', 'Tom', 'Schweiz'),
	(19, 'Dankert', 'Marcel', 'Deutschland');
/*!40000 ALTER TABLE `tbl_personen` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
