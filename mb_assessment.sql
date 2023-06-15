-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 15, 2023 at 03:41 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mb_assessment`
--

-- --------------------------------------------------------

--
-- Table structure for table `record`
--

CREATE TABLE `record` (
  `id` bigint(20) NOT NULL,
  `account_number` bigint(20) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `trx_amount` double DEFAULT NULL,
  `trx_date` varchar(255) DEFAULT NULL,
  `trx_time` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `record`
--

INSERT INTO `record` (`id`, `account_number`, `customer_id`, `description`, `trx_amount`, `trx_date`, `trx_time`) VALUES
(1, 8872838283, 222, 'FUND TRANSFER', 123, '2019-09-12', '11:11:11'),
(2, 8872838283, 222, 'FUND TRANSFER', 123, '2019-09-12', '11:11:11'),
(3, 8872838283, 222, 'ATM WITHDRWAL', 1123, '2019-09-11', '11:11:11'),
(4, 8872838283, 222, 'FUND TRANSFER', 1223, '2019-10-11', '11:11:11'),
(5, 8872838283, 222, 'FUND TRANSFER', 1233, '2019-11-11', '11:11:11'),
(6, 8872838283, 222, '3rd Party FUND TRANSFER', 1243, '2019-08-11', '11:11:11'),
(7, 8872838283, 222, '3rd Party FUND TRANSFER', 12553, '2019-07-11', '11:11:11'),
(8, 8872838283, 222, 'BILL PAYMENT', 12113, '2019-08-11', '11:11:11'),
(9, 8872838283, 222, 'BILL PAYMENT', 1222, '2019-09-11', '11:11:11'),
(10, 8872838283, 222, 'FUND TRANSFER', 2123, '2019-09-11', '11:11:11'),
(11, 8872838283, 222, 'FUND TRANSFER', 1323, '2019-09-11', '11:11:11'),
(12, 8872838283, 222, 'FUND TRANSFER', 12443, '2019-09-11', '11:11:11'),
(13, 8872838283, 222, 'FUND TRANSFER', 125553, '2019-09-11', '11:11:11'),
(14, 8872838283, 222, 'FUND TRANSFER', 126663, '2019-09-11', '11:11:11'),
(15, 8872838283, 222, 'FUND TRANSFER', 1266663, '2019-09-11', '11:11:11'),
(16, 8872838299, 222, 'FUND TRANSFER', 1121223, '2019-09-11', '11:11:11'),
(17, 8872838299, 222, 'FUND TRANSFER', 12231233, '2019-09-11', '11:11:11'),
(18, 8872838299, 222, 'FUND TRANSFER', 111123, '2019-09-11', '11:11:11'),
(19, 8872838299, 222, 'BILL PAYMENT', 12223, '2019-09-11', '11:11:11'),
(20, 8872838299, 222, 'BILL PAYMENT', 1223233, '2019-09-11', '11:11:11'),
(21, 8872838299, 222, 'ATM WITHDRWAL', 1223233, '2019-09-11', '11:11:11'),
(22, 8872838299, 222, 'ATM WITHDRWAL', 1223123233, '2019-09-11', '11:11:11'),
(23, 8872838299, 222, '3rd Party FUND TRANSFER', 1223233, '2019-09-11', '11:11:11'),
(24, 8872838299, 222, '3rd Party FUND TRANSFER', 12232133, '2019-09-11', '11:11:11'),
(25, 8872838299, 222, '3rd Party FUND TRANSFER', 1223233, '2019-09-11', '11:11:11'),
(26, 8872838299, 222, 'BILL PAYMENT', 1111123, '2019-09-11', '11:11:11'),
(27, 8872838299, 222, 'BILL PAYMENT', 122223, '2019-09-11', '11:11:11'),
(28, 8872838299, 222, 'BILL PAYMENT', 1222223, '2019-09-11', '11:11:11'),
(29, 8872838299, 222, 'FUND TRANSFER', 1223233, '2019-09-11', '11:11:11'),
(30, 8872838299, 222, 'FUND TRANSFER', 11123, '2019-09-11', '11:11:11'),
(31, 8872838299, 222, 'FUND TRANSFER', 1223233, '2019-09-11', '11:11:11'),
(32, 8872838299, 222, 'FUND TRANSFER', 123666, '2019-09-11', '11:11:11'),
(33, 6872838260, 333, 'BILL PAYMENT', 1, '2019-09-11', '11:11:11'),
(34, 6872838260, 333, 'BILL PAYMENT', 1223, '2019-09-12', '11:11:11'),
(35, 6872838260, 333, 'BILL PAYMENT', 12323, '2019-09-13', '11:11:11'),
(36, 6872838260, 333, 'BILL PAYMENT', 12323, '2019-09-11', '11:11:11'),
(37, 6872838260, 333, 'BILL PAYMENT', 121233, '2019-09-11', '11:11:11'),
(38, 6872838260, 333, 'BILL PAYMENT', 19923, '2019-09-11', '11:11:11'),
(39, 6872838260, 333, 'BILL PAYMENT', 12893, '2019-09-13', '11:11:11'),
(40, 6872838260, 333, 'FUND TRANSFER', 99123, '2019-09-14', '11:11:11'),
(41, 6872838260, 333, 'FUND TRANSFER', 19923, '2019-09-11', '11:11:11'),
(42, 6872838260, 333, 'FUND TRANSFER', 12993, '2019-09-11', '11:11:11'),
(43, 6872838260, 333, 'FUND TRANSFER', 12993, '2019-09-15', '11:11:11'),
(44, 6872838260, 333, 'FUND TRANSFER', 12993, '2019-09-11', '11:11:11'),
(45, 6872838260, 333, 'FUND TRANSFER', 12993, '2019-09-16', '11:11:11'),
(46, 6872838260, 333, 'FUND TRANSFER', 12993, '2019-09-17', '11:11:11'),
(47, 6872838260, 333, 'FUND TRANSFER', 9123, '2019-09-11', '11:11:11'),
(48, 6872838260, 333, 'FUND TRANSFER', 1923, '2019-09-11', '11:11:11'),
(50, 1234567899, 222, 'DUMMY DATA', 123, '2019-09-12', '11:11:11');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `record`
--
ALTER TABLE `record`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `record`
--
ALTER TABLE `record`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
