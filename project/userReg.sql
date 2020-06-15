-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 15, 2020 at 04:28 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id12148685_hospital_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `userReg`
--

CREATE TABLE `userReg` (
  `id` int(11) NOT NULL,
  `username` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `role` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `userReg`
--

INSERT INTO `userReg` (`id`, `username`, `role`, `password`, `email`) VALUES
(1, 'Amit Dutta', 'admin', '12345678', 'damitlucky998@gmail.com'),
(2, 'Kuntal Dutta', 'user', '12345678', 'kuntaldutta@998'),
(4, 'Admin', 'user', 'Admin@gmail.com', '12345678'),
(5, 'ramesh Khan', 'user', 'ramu@gmail.com', '12345678'),
(6, 'Saikat Pal', 'user', 'saikat@gmail.com', 'saikat'),
(7, 'root', 'user', 'password', 'root@email'),
(8, 'admin', 'user', '12345678', 'admin@gmail.com'),
(9, 'ut', 'user', 'krishnautpal', 'banerjeeutpal752@gmail.com'),
(10, 'ut', 'user', 'krishnautpal', 'banerjeeutpal752@gmail.com'),
(11, 'ut', 'user', 'krishnautpal', 'banerjeeutpal752@gmail.com'),
(12, 'ut', 'user', 'krishnautpal', 'banerjeeutpal752@gmail.com'),
(13, 'gssjsksndn', 'user', 'soumik', 'sghsyeuwjwj@gmail.com'),
(14, 'abhi', 'user', 'abhi', 'abhi@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `userReg`
--
ALTER TABLE `userReg`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `userReg`
--
ALTER TABLE `userReg`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
