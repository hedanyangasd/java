-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.26 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 scores 的数据库结构
CREATE DATABASE IF NOT EXISTS `scores` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `scores`;

-- 导出  表 scores.course 结构
CREATE TABLE IF NOT EXISTS `course` (
  `cursno` varchar(20) COLLATE utf8_bin NOT NULL,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  `credit` int(10) NOT NULL,
  PRIMARY KEY (`cursno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  scores.course 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`cursno`, `name`, `credit`) VALUES
	('001', 'java', 4),
	('002', 'c++', 3);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

-- 导出  表 scores.sc 结构
CREATE TABLE IF NOT EXISTS `sc` (
  `stdno` varchar(20) COLLATE utf8_bin NOT NULL,
  `cursno` varchar(20) COLLATE utf8_bin NOT NULL,
  `grade` int(10) DEFAULT NULL,
  PRIMARY KEY (`stdno`,`cursno`),
  KEY `FK_sc_course` (`cursno`),
  CONSTRAINT `FK_sc_course` FOREIGN KEY (`cursno`) REFERENCES `course` (`cursno`),
  CONSTRAINT `FK_sc_student` FOREIGN KEY (`stdno`) REFERENCES `student` (`stdno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  scores.sc 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sc` DISABLE KEYS */;
/*!40000 ALTER TABLE `sc` ENABLE KEYS */;

-- 导出  表 scores.student 结构
CREATE TABLE IF NOT EXISTS `student` (
  `stdno` varchar(20) COLLATE utf8_bin NOT NULL,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  `sex` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `password` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`stdno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  scores.student 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`stdno`, `name`, `sex`, `birthday`, `password`) VALUES
	('2016110306', '张三', 'male', '1997-08-09', '123456'),
	('2016110307', 'xiaohan', 'famale', '1997-01-01', '12345'),
	('2016110308', 'hedanyang', 'famale', '1997-04-15', 'aaa111,.');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
