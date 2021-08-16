-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 21, 2019 at 09:41 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `accountclerk`
--

CREATE TABLE `accountclerk` (
  `clerkID` int(11) NOT NULL,
  `clerkName` varchar(22) NOT NULL,
  `password` varchar(5) NOT NULL,
  `clerkPhone` int(11) NOT NULL,
  `clerkAge` int(11) NOT NULL,
  `clerkWorkingHour` float(3,2) NOT NULL,
  `clerkWorkingShift` varchar(22) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accountclerk`
--

INSERT INTO `accountclerk` (`clerkID`, `clerkName`, `password`, `clerkPhone`, `clerkAge`, `clerkWorkingHour`, `clerkWorkingShift`) VALUES
(522, 'Mithun', '12345', 56454658, 55, 8.00, 'gfvhbnkml;@ughui'),
(6543, 'Mamun', '54321', 7654321, 33, 9.00, 'hgfdsa@hjg');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `doctorID` int(11) NOT NULL,
  `doctorName` varchar(20) NOT NULL,
  `password` varchar(3) NOT NULL,
  `doctorPhone` int(11) NOT NULL,
  `doctorVisitingHour` float(3,2) NOT NULL,
  `doctorSpecialist` varchar(20) NOT NULL,
  `doctorAge` int(11) NOT NULL,
  `doctorMail` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`doctorID`, `doctorName`, `password`, `doctorPhone`, `doctorVisitingHour`, `doctorSpecialist`, `doctorAge`, `doctorMail`) VALUES
(101, 'Mr Shekh', '123', 789452361, 3.00, 'Cardiologist', 50, 'poiu@qwer'),
(110, 'Mr Ali', '321', 123456789, 2.00, 'Medicine', 45, 'abcd@efgh');

-- --------------------------------------------------------

--
-- Table structure for table `medicalrecord`
--

CREATE TABLE `medicalrecord` (
  `checkupDate` varchar(11) NOT NULL,
  `checkupTime` float(3,2) NOT NULL,
  `drugs` varchar(22) NOT NULL,
  `reference` varchar(22) NOT NULL,
  `patientID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medicalrecord`
--

INSERT INTO `medicalrecord` (`checkupDate`, `checkupTime`, `drugs`, `reference`, `patientID`) VALUES
('2019-07-08', 9.99, 'Napa', 'Typhoid test', 15),
('2019-03-20', 9.99, 'Ace', 'Dengue Test', 54);

-- --------------------------------------------------------

--
-- Table structure for table `nurse`
--

CREATE TABLE `nurse` (
  `nurseID` int(11) NOT NULL,
  `nurseName` varchar(20) NOT NULL,
  `nursePhone` int(11) NOT NULL,
  `nurseMail` varchar(22) NOT NULL,
  `nurseAge` int(11) NOT NULL,
  `nurseSalary` int(11) NOT NULL,
  `nurseWorkingHour` float(3,2) NOT NULL,
  `nurseShift` varchar(22) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nurse`
--

INSERT INTO `nurse` (`nurseID`, `nurseName`, `nursePhone`, `nurseMail`, `nurseAge`, `nurseSalary`, `nurseWorkingHour`, `nurseShift`) VALUES
(543, 'Rina', 765432, 'gfdsa@hg', 33, 12000, 6.00, 'Day'),
(54321, 'Juma', 7654321, 'hgfds@uytt', 44, 15000, 7.00, 'Night');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `patientID` int(11) NOT NULL,
  `patientName` varchar(20) NOT NULL,
  `password` varchar(4) NOT NULL,
  `patientAddress` varchar(20) NOT NULL,
  `patientPhone` int(11) NOT NULL,
  `patientAge` int(3) NOT NULL,
  `patientGender` varchar(20) NOT NULL,
  `problemType` varchar(20) NOT NULL,
  `Bill` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`patientID`, `patientName`, `password`, `patientAddress`, `patientPhone`, `patientAge`, `patientGender`, `problemType`, `Bill`) VALUES
(15, 'Raju', '1234', 'Dhaka', 65398876, 44, 'Male', 'Dengue', 7560),
(54, 'Mina', '4321', 'Comilla', 76528766, 34, 'Female', 'Headache', 5000);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staffID` int(11) NOT NULL,
  `staffName` varchar(20) NOT NULL,
  `staffAddress` varchar(22) NOT NULL,
  `staffPhone` int(11) NOT NULL,
  `staffGender` varchar(22) NOT NULL,
  `staffType` varchar(22) NOT NULL,
  `staffAge` int(3) NOT NULL,
  `staffSalary` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`staffID`, `staffName`, `staffAddress`, `staffPhone`, `staffGender`, `staffType`, `staffAge`, `staffSalary`) VALUES
(123, 'Jamal', 'Manikganj', 1234567, 'Male', 'Clining', 32, 8000),
(567, 'Kamal', 'Narayanganj', 12345, 'Male', 'Supervisor', 38, 7000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accountclerk`
--
ALTER TABLE `accountclerk`
  ADD PRIMARY KEY (`clerkID`),
  ADD UNIQUE KEY `clerkPhone` (`clerkPhone`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`doctorID`),
  ADD UNIQUE KEY `doctorPhone` (`doctorPhone`);

--
-- Indexes for table `medicalrecord`
--
ALTER TABLE `medicalrecord`
  ADD PRIMARY KEY (`patientID`);

--
-- Indexes for table `nurse`
--
ALTER TABLE `nurse`
  ADD PRIMARY KEY (`nurseID`),
  ADD UNIQUE KEY `nursePhone` (`nursePhone`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`patientID`),
  ADD UNIQUE KEY `patientPhone` (`patientPhone`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staffID`),
  ADD UNIQUE KEY `staffPhone` (`staffPhone`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `doctorID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=112;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `patientID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
