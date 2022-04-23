-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 23, 2022 at 08:18 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Database: `electricityreadings`
--

-- --------------------------------------------------------

--
-- Table structure for table `electricity_bills`
--

CREATE TABLE `electricity_bills` (
  `Account_ID` varchar(30) NOT NULL,
  `Invoice_No` varchar(30) NOT NULL,
  `Bill_Amount` double NOT NULL,
  `Units_Consumed` double NOT NULL,
  `Issued_Date` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `electricity_bills`
--

INSERT INTO `electricity_bills` (`Account_ID`, `Invoice_No`, `Bill_Amount`, `Units_Consumed`, `Issued_Date`) VALUES
('1234', 'INV2022-02-12B1234M001', 54421.6, 300.12, '2022-02-12'),
('1234', 'INV2022-02-12B1234M002', 25300, 200, '2022-02-12'),
('2345', 'INV2042-03-04B2345M002', 34925, 230.5, '2042-03-04'),
('2346', 'INV2022-03-10B2346M003', 72400, 400, '2022-03-10'),
('5424', 'INV2022-02-12B5424M001', 54421.6, 300.12, '2022-02-12');

-- --------------------------------------------------------

--
-- Table structure for table `meterreadings`
--

CREATE TABLE `meterreadings` (
  `Account_ID` varchar(30) NOT NULL,
  `Last_Reading` double NOT NULL,
  `New_Reading` double NOT NULL,
  `Reviewed_By` varchar(30) NOT NULL,
  `Reviewed_Date` date NOT NULL,
  `Meter_ID` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `meterreadings`
--

INSERT INTO `meterreadings` (`Account_ID`, `Last_Reading`, `New_Reading`, `Reviewed_By`, `Reviewed_Date`, `Meter_ID`) VALUES
('1234', 400.12, 600.12, 'SANJAY', '2022-02-12', 'M002'),
('2345', 400, 700, 'SANJAY', '2022-03-14', 'M002'),
('2346', 400, 800, 'SANJAY', '2022-03-10', 'M003'),
('5424', 300, 600.12, 'SANJAY', '2022-02-12', 'M001'),
('5424', 600.12, 900.4, 'SANJAY', '2022-03-12', 'M002');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `electricity_bills`
--
ALTER TABLE `electricity_bills`
  ADD PRIMARY KEY (`Account_ID`,`Invoice_No`);

--
-- Indexes for table `meterreadings`
--
ALTER TABLE `meterreadings`
  ADD PRIMARY KEY (`Account_ID`,`Meter_ID`),
  ADD UNIQUE KEY `Account_ID` (`Account_ID`,`Last_Reading`),
  ADD UNIQUE KEY `Account_ID_2` (`Account_ID`,`Last_Reading`),
  ADD UNIQUE KEY `Account_ID_3` (`Account_ID`,`Last_Reading`);
COMMIT;
