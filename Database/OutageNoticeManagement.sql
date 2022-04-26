-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 24, 2022 at 07:53 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Database: `noticesmanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `notices`
--

CREATE TABLE `notices` (
  `noticeID` int(11) NOT NULL,
  `regionID` varchar(10) CHARACTER SET latin1 NOT NULL,
  `group` varchar(5) CHARACTER SET latin1 NOT NULL,
  `Description` varchar(200) CHARACTER SET latin1 NOT NULL,
  `outageStartTime` varchar(11) CHARACTER SET latin1 NOT NULL,
  `outageEndTime` varchar(11) CHARACTER SET latin1 NOT NULL,
  `informerID` varchar(10) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `notices`
--

INSERT INTO `notices` (`noticeID`, `regionID`, `group`, `Description`, `outageStartTime`, `outageEndTime`, `informerID`) VALUES
(1, '02', 'A', 'Please be noticed on <b>Monday, May 2nd, 2022</b> that the region-02 group-A will be expecting a power outage from 8.00 am to 12.00 noon. We apologize for this inconvenience.', '8.00 am', '12.00 noon', 'E-25-02A'),
(4, '07', 'J', 'Please be noticed on <b>Monday, May 2nd, 2022</b> that the region-07 group-J will be expecting a power outage from 6.30 am to 8.30 am. We apologize for this inconvenience.', '6.30 am', '8.30 am', 'E-72-07J'),
(6, '01', 'K', 'Please be noticed on <b>Tuesday, May 3rd, 2022</b> that the region-01 group-K will be expecting a power outage from 4.30 pm to 6.00 pm. We apologize for this inconvenience.', '4.30 pm', '6.00 pm', 'E-12-01K'),
(7, '08', 'G', 'Please be noticed on <b>Tuesday, May 3rd, 2022</b> that the region-08 group-G will be expecting a power outage from 11.00 am to 2.30 pm. We apologize for this inconvenience.', '11.00 am', '2.30 pm', 'E-35-08G'),
(8, '04', 'R', 'Please be noticed on <b>Wednesday, May 4th, 2022</b> that the region-04 group-R will be expecting a power outage from 10.00 am to 11.30 am. We apologize for this inconvenience.', '10.00 am', '11.30 am', 'E-50-04R'),
(9, '06', 'T', 'Please be noticed on <b>Wednesday, May 4th, 2022</b> that the region-06 group-M will be expecting a power outage from 1.20 pm to 6.30 pm. We apologize for this inconvenience.', '1.20 pm', '6.30 pm', 'E-62-06M'),
(11, '06', 'W', 'Please be noticed on <b>Wednesday, May 4th, 2022</b> that the region-06 group-W will be expecting a power outage from 9.15 am to 3.20 pm. We apologize for this inconvenience.', '9.15 am', '3.20 pm', 'E-47-06W');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `notices`
--
ALTER TABLE `notices`
  ADD PRIMARY KEY (`noticeID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `notices`
--
ALTER TABLE `notices`
  MODIFY `noticeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;
