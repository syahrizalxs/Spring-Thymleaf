-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2019 at 10:48 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `belajar`
--

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `name`, `address`) VALUES
(7, 'Helmi', 'Jakarta'),
(8, 'Helmi', 'Jakarta');

-- --------------------------------------------------------

--
-- Table structure for table `table_dosen`
--

CREATE TABLE `table_dosen` (
  `dosen_id` int(11) NOT NULL,
  `name` varchar(128) NOT NULL,
  `address` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `table_dosen`
--

INSERT INTO `table_dosen` (`dosen_id`, `name`, `address`) VALUES
(1, 'Bowo', 'Jambi'),
(2, 'Sutoyo M.kom', 'Jakarta Pusat'),
(3, 'Marnia M.Pd', 'Bogor');

-- --------------------------------------------------------

--
-- Table structure for table `table_jurusan`
--

CREATE TABLE `table_jurusan` (
  `jurusan_id` varchar(10) NOT NULL,
  `namaJurusan` text NOT NULL,
  `fakultas` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `table_jurusan`
--

INSERT INTO `table_jurusan` (`jurusan_id`, `namaJurusan`, `fakultas`) VALUES
('SB01', 'Sastra indonesia', 'Seni dan Bahasa'),
('SB02', 'Seni Tari Nasional', 'Seni dan Bahasa');

-- --------------------------------------------------------

--
-- Table structure for table `table_krs`
--

CREATE TABLE `table_krs` (
  `NoKRS` text,
  `student_id` text,
  `id_matkul` text,
  `semester` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `table_krs`
--

INSERT INTO `table_krs` (`NoKRS`, `student_id`, `id_matkul`, `semester`) VALUES
('KRS1', '1', 'PBO1', '3'),
('KRS2', '2', 'PV1', '3');

-- --------------------------------------------------------

--
-- Table structure for table `table_matkul`
--

CREATE TABLE `table_matkul` (
  `id_matkul` varchar(10) NOT NULL,
  `namaMataKuliah` text NOT NULL,
  `jumlahSks` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `table_matkul`
--

INSERT INTO `table_matkul` (`id_matkul`, `namaMataKuliah`, `jumlahSks`) VALUES
('PBO1', 'Pemograman Beroirientasi Objek', 3),
('PV1', 'Pemograman Visual', 3);

-- --------------------------------------------------------

--
-- Table structure for table `table_students`
--

CREATE TABLE `table_students` (
  `student_id` int(11) NOT NULL,
  `name` varchar(128) NOT NULL,
  `address` varchar(128) NOT NULL,
  `jurusan_id` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `table_students`
--

INSERT INTO `table_students` (`student_id`, `name`, `address`, `jurusan_id`) VALUES
(1, 'Helmi', 'Jakarta', 'SB01'),
(2, 'Dana Nur', 'Jakarta Selatan', 'SB02');

-- --------------------------------------------------------

--
-- Table structure for table `table_user`
--

CREATE TABLE `table_user` (
  `id` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `table_dosen`
--
ALTER TABLE `table_dosen`
  ADD PRIMARY KEY (`dosen_id`);

--
-- Indexes for table `table_jurusan`
--
ALTER TABLE `table_jurusan`
  ADD PRIMARY KEY (`jurusan_id`);

--
-- Indexes for table `table_matkul`
--
ALTER TABLE `table_matkul`
  ADD PRIMARY KEY (`id_matkul`);

--
-- Indexes for table `table_students`
--
ALTER TABLE `table_students`
  ADD PRIMARY KEY (`student_id`),
  ADD KEY `jurusan_id` (`jurusan_id`);

--
-- Indexes for table `table_user`
--
ALTER TABLE `table_user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `table_dosen`
--
ALTER TABLE `table_dosen`
  MODIFY `dosen_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `table_students`
--
ALTER TABLE `table_students`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `table_user`
--
ALTER TABLE `table_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `table_students`
--
ALTER TABLE `table_students`
ADD CONSTRAINT `table_students_ibfk_1` FOREIGN KEY (`jurusan_id`) REFERENCES `table_jurusan` (`jurusan_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
