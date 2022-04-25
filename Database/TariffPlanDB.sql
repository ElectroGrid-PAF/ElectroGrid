-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2022 at 05:52 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Database: `tariffplan`
--

-- --------------------------------------------------------

--
-- Table structure for table `electricity_tariff_plan`
--

CREATE TABLE `electricity_tariff_plan` (
  `ET_ID` varchar(30) NOT NULL,
  `Tarrif_Block` varchar(30) NOT NULL,
  `Unit_Rate` double NOT NULL,
  `Fixed_Charge` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `electricity_tariff_plan`
--

INSERT INTO `electricity_tariff_plan` (`ET_ID`, `Tarrif_Block`, `Unit_Rate`, `Fixed_Charge`) VALUES
('E001', 'UNIT < 100', 10, 250),
('E002', '100 < UNIT < 200', 12, 300),
('E003', '200 < UNIT < 300', 15, 350),
('E004', '300 < UNIT < 400', 18, 400),
('E005', 'UNIT > 500', 20, 600);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `electricity_tariff_plan`
--
ALTER TABLE `electricity_tariff_plan`
  ADD PRIMARY KEY (`ET_ID`(10));
COMMIT;
