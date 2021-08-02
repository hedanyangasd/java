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


-- 导出 students 的数据库结构
DROP DATABASE IF EXISTS `students`;
CREATE DATABASE IF NOT EXISTS `students` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `students`;

-- 导出  表 students.dorm 结构
DROP TABLE IF EXISTS `dorm`;
CREATE TABLE IF NOT EXISTS `dorm` (
  `dno` varchar(20) COLLATE utf8_bin NOT NULL,
  `class` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`dno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  students.dorm 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `dorm` DISABLE KEYS */;
INSERT INTO `dorm` (`dno`, `class`) VALUES
	('217', NULL),
	('219', NULL),
	('221', NULL);
/*!40000 ALTER TABLE `dorm` ENABLE KEYS */;

-- 导出  表 students.student 结构
DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `stuno` varchar(20) COLLATE utf8_bin NOT NULL,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`stuno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  students.student 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`stuno`, `name`) VALUES
	('001', 'hdy'),
	('002', 'hrl'),
	('003', 'ft'),
	('004', 'gxh');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- 导出  表 students.student_height 结构
DROP TABLE IF EXISTS `student_height`;
CREATE TABLE IF NOT EXISTS `student_height` (
  `stuno` varchar(20) COLLATE utf8_bin NOT NULL,
  `height` int(11) NOT NULL,
  PRIMARY KEY (`stuno`),
  CONSTRAINT `FK_sh_student` FOREIGN KEY (`stuno`) REFERENCES `student` (`stuno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  students.student_height 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `student_height` DISABLE KEYS */;
INSERT INTO `student_height` (`stuno`, `height`) VALUES
	('001', 160),
	('002', 160),
	('003', 160),
	('004', 160);
/*!40000 ALTER TABLE `student_height` ENABLE KEYS */;

-- 导出  表 students.student_in_dorm 结构
DROP TABLE IF EXISTS `student_in_dorm`;
CREATE TABLE IF NOT EXISTS `student_in_dorm` (
  `stuno` varchar(20) COLLATE utf8_bin NOT NULL,
  `dno` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`stuno`),
  CONSTRAINT `FK_sd_student` FOREIGN KEY (`stuno`) REFERENCES `student` (`stuno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  students.student_in_dorm 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `student_in_dorm` DISABLE KEYS */;
INSERT INTO `student_in_dorm` (`stuno`, `dno`) VALUES
	('001', '221'),
	('002', '219'),
	('003', '217'),
	('004', '217');
/*!40000 ALTER TABLE `student_in_dorm` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
