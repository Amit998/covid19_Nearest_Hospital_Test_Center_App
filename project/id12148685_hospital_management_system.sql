-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 15, 2020 at 04:31 PM
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
-- Table structure for table `booking_details`
--

CREATE TABLE `booking_details` (
  `id` int(10) NOT NULL,
  `placeName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `patientNumber` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `patientAddress` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `uid` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Symptoms` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `problem` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `fromP` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `time` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `patientName` varchar(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `booking_details`
--

INSERT INTO `booking_details` (`id`, `placeName`, `patientNumber`, `patientAddress`, `uid`, `Symptoms`, `problem`, `fromP`, `time`, `patientName`) VALUES
(1, 'kolkata Hospital', 'Fever', 'Kolkata', '57657', 'fever', 'fever', 'Hospital', 'Today', 'Amit Dutta'),
(2, 'kolkata Hospital', '11', 'Kolkata', '57657', 'fever', 'fever', 'Hospital', 'Today', 'Amit Dutta'),
(3, 'kolkata Hospital', '11', 'Kolkata', '57657', 'fever', 'fever', 'Hospital', 'Today', 'Amit Dutta'),
(4, 'kolkata', '887876666', 'kolkata', '7kkjugs9xm', 'fever', '', 'Hospital', '2020-06-15 04:02:29', 'Ram'),
(5, 'kolkata', '68975677897', 'kolkata', 'err4t3k465', 'fever', '', 'Hospital', '2020-06-15 04:09:40', 'Sam'),
(6, 'kolkata', '68975677897', 'kolkata', 'w0pwnm495e', 'fever', '', 'Hospital', '2020-06-15 04:09:57', 'Sam'),
(7, 'delhi', '7857656576', 'delhi', '6auf5u3b11', 'fever', '', 'Hospital', '2020-06-15 04:18:53', 'Virat'),
(8, 'kolkata', '67564674564', 'kolkata', '1t42gqp68d', 'fever', 'fever', 'Hospital', '2020-06-15 04:20:46', 'sachin'),
(9, 'katwa', '7478159715', 'katwa', 'lvkbp6poec', 'fever', 'fever', 'Hospital', '2020-06-15 05:26:05', 'Amit Dutta'),
(10, 'xhxhcjgg', '686868', 'xhxhcjgg', 'buxy450hr1', 'bxhcjcv', 'jcgkgkhv', 'Test Center', '2020-06-15 05:46:50', 'dhfjc'),
(11, 'xhxhcjgg', '686868', 'xhxhcjgg', 't8xhjbmdmr', 'bxhcjcv', 'jcgkgkhv', 'Test Center', '2020-06-15 05:47:32', 'dhfjc');

-- --------------------------------------------------------

--
-- Table structure for table `hospitalName`
--

CREATE TABLE `hospitalName` (
  `id` int(11) NOT NULL,
  `hp_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `total_cost` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `beds` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `location` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `admitted` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phno` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `recovered` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `total_death` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `availability` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hospitalName`
--

INSERT INTO `hospitalName` (`id`, `hp_name`, `total_cost`, `beds`, `location`, `admitted`, `email`, `phno`, `recovered`, `total_death`, `availability`) VALUES
(2, 'Kolkata medical Hospital', '1800', '12', 'kolkata', '10', 'kolkata@gmail.com', '1234567895', '1', '2', 'Available'),
(3, 'Durgapur medical Hospital', '1700', '10', 'durgapur', '6', 'durgapur@gmail.com', '7667476443', '3', '', ''),
(5, 'Katwa Hospital', '100', '100', 'Katwa', '100', 'katwa@gmail.com', '78765867', '10', '', ''),
(7, 'Bidhan Nagar Hopital', '500', '50', 'bidhan nagar', '10', 'bidhnnagar@gmail.com', '8967652567', '2', '1', 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `TestCenterView`
--

CREATE TABLE `TestCenterView` (
  `testCenterId` int(11) NOT NULL,
  `testCenterName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `availability` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `cost` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `tested` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phno` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `successRate` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `TestCenterView`
--

INSERT INTO `TestCenterView` (`testCenterId`, `testCenterName`, `availability`, `cost`, `tested`, `email`, `phno`, `address`, `successRate`) VALUES
(1, 'Kolkata Health Care Center', 'Available ', '1200', '3000', 'kolktata@gmail.com', '7867892637', 'Kolkata,New Town', '80%'),
(3, 'Durgapur Medical Test Center', 'Available', '1200', '2000', 'dgpMedical@gmail', '98899868', 'Durgapur', '90');

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
-- Indexes for table `booking_details`
--
ALTER TABLE `booking_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hospitalName`
--
ALTER TABLE `hospitalName`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `TestCenterView`
--
ALTER TABLE `TestCenterView`
  ADD PRIMARY KEY (`testCenterId`);

--
-- Indexes for table `userReg`
--
ALTER TABLE `userReg`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booking_details`
--
ALTER TABLE `booking_details`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `hospitalName`
--
ALTER TABLE `hospitalName`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `TestCenterView`
--
ALTER TABLE `TestCenterView`
  MODIFY `testCenterId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `userReg`
--
ALTER TABLE `userReg`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
