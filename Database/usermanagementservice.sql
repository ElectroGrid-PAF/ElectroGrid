-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2022 at 02:13 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `usermanagementservice`
--

-- --------------------------------------------------------

--
-- Table structure for table `complaint`
--

CREATE TABLE `complaint` (
  `ComplaintID` int(11) NOT NULL,
  `SenderName` varchar(50) NOT NULL,
  `RecipientDept` varchar(50) NOT NULL,
  `EmailAddress` varchar(50) NOT NULL,
  `Subject` varchar(50) NOT NULL,
  `Complaint` varchar(500) NOT NULL,
  `Response` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `complaint`
--

INSERT INTO `complaint` (`ComplaintID`, `SenderName`, `RecipientDept`, `EmailAddress`, `Subject`, `Complaint`, `Response`) VALUES
(2, 'Jenkins Fernando', 'Customer Support', 'fernjenkins@gmail.com', 'Uninformed power cut', 'Power cuts are not informed beforehand in my area, therefore, difficult to manage work schedule', 'Issue is noted and power cuts will be informed beforehand next week onwards.'),
(4, 'Anne Marie', 'Power Cut Department', 'annem2000@gmail.com', 'Too many powercuts', 'There are way too many power cuts in our area', ''),
(6, 'Anne Marie', 'Power Cut Department', 'annem2000@gmail.com', 'Too many powercuts', 'I complained about too many powercuts in my area but still received no response and the issue is still ongoing.', ''),
(7, 'Darwood Jenks', 'Power Cut Department', 'wooddar@gmail.com', 'Breakdown', 'A breakdown in my region and would like it if you could send a team ASAP', ''),
(8, 'Darwood Jenks', 'Customer Service Department', 'wooddar@gmail.com', 'Connection request', 'Requested for a connection but not yet granted', '');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `UserID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `PhoneNo` char(10) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `UserType` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`UserID`, `Name`, `Email`, `Address`, `PhoneNo`, `Username`, `Password`, `UserType`) VALUES
(1, 'Jenkins Fernando', 'fjenkins@gmail.com', '11A, Park Street, Colombo 3', '0776154887', 'jenkinsF', 'Jenkins@Fern123', 'Customer'),
(2, 'Anne Frankley', 'annefrank@gmail.com', '286, Victoria Street, Colombo 1', '0715154825', 'fanneley', 'FrankAn@ne125', 'Customer'),
(3, 'Jane Watson', 'watjane@gmail.com', '5B/2, Lake Road, Colombo', '0775226556', 'janewatson', 'Watson@1978', 'Customer Service Manager'),
(8, 'Anne Ranathunga', 'anner@gmail.com', '5B/2, Cinnamon Road', '0711126556', 'aneerana', 'anner@nathun3', 'Customer'),
(9, 'Darwood Jenks', 'wooddar@gmail.com', '286A, Kaduwela', '0778768767', 'woodddar', 'woode234#', 'Customer');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `complaint`
--
ALTER TABLE `complaint`
  ADD PRIMARY KEY (`ComplaintID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`UserID`),
  ADD UNIQUE KEY `Username` (`Username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `complaint`
--
ALTER TABLE `complaint`
  MODIFY `ComplaintID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
