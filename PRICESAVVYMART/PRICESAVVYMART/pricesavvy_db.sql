-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 16, 2023 at 02:20 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pricesavvy_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `owner`
--

CREATE TABLE `owner` (
  `id` varchar(11) NOT NULL,
  `storeId` varchar(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `store_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `owner`
--

INSERT INTO `owner` (`id`, `storeId`, `username`, `password`, `store_name`, `email`) VALUES
('112', 'A1', 'benty', '1', 'taskmart', 'b@gmail.com'),
('456', 'A1', 'Edd', '123', 'Taskmart', 'eddy@gmail.com'),
('b16', 'A2', 'mady', '123', 'Quickstore', 'mady@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `quickstore`
--

CREATE TABLE `quickstore` (
  `store_id` varchar(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `product` varchar(50) NOT NULL,
  `price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `quickstore`
--

INSERT INTO `quickstore` (`store_id`, `product_id`, `product`, `price`, `quantity`) VALUES
('A2', 3, 'milk', 100, 3),
('A2', 4, 'bread', 50, 4);

-- --------------------------------------------------------

--
-- Table structure for table `taskmart`
--

CREATE TABLE `taskmart` (
  `store_id` varchar(11) NOT NULL,
  `product_id` int(10) NOT NULL,
  `product` varchar(50) NOT NULL,
  `price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `taskmart`
--

INSERT INTO `taskmart` (`store_id`, `product_id`, `product`, `price`, `quantity`) VALUES
('A1', 2, 'bread', 160, 7),
('A1', 3, 'exercise book', 70, 30),
('A1', 4, 'water', 15, 7);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(39) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `email`) VALUES
(1, 'Stacy', '123', ''),
(2, 'Donarld', '456', 'don@gmail.com'),
(3, 'ben', '098', 'ben@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `owner`
--
ALTER TABLE `owner`
  ADD PRIMARY KEY (`id`,`storeId`),
  ADD KEY `storeId` (`storeId`);

--
-- Indexes for table `quickstore`
--
ALTER TABLE `quickstore`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `store_id` (`store_id`);

--
-- Indexes for table `taskmart`
--
ALTER TABLE `taskmart`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `store_id` (`store_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `quickstore`
--
ALTER TABLE `quickstore`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `taskmart`
--
ALTER TABLE `taskmart`
  MODIFY `product_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `quickstore`
--
ALTER TABLE `quickstore`
  ADD CONSTRAINT `quickstore_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `owner` (`storeId`);

--
-- Constraints for table `taskmart`
--
ALTER TABLE `taskmart`
  ADD CONSTRAINT `taskmart_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `owner` (`storeId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
