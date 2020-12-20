-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 18, 2020 at 06:38 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34
drop database tkxdpm;
create database tkxdpm;
use tkxdpm;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";



--
-- Database: `tkxdpm_ver2`
--

-- --------------------------------------------------------

--
-- Table structure for table `bikes`
--

CREATE TABLE `bikes` (
  `id` int(20) NOT NULL PRIMARY KEY,
  `name` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `weight` float NOT NULL,
  `license_plate` varchar(100) NOT NULL,
  `manuafacturing_date` date NOT NULL,
  `producer` varchar(100) NOT NULL,
  `batery_percentage` varchar(100) DEFAULT NULL,
  `load_cycles` varchar(100) DEFAULT NULL,
  `time_remaining` varchar(100) DEFAULT NULL,
  `barcode` varchar(100) NOT NULL,
  `status` int(20) NOT NULL DEFAULT 0,
  `station_id` int(20) NOT NULL,
  `image` varchar(100) NOT NULL DEFAULT 'bike_default.png'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bikes`
--

INSERT INTO `bikes` (`id`, `name`, `type`, `weight`, `license_plate`, `manuafacturing_date`, `producer`, `batery_percentage`, `load_cycles`, `time_remaining`, `barcode`, `status`, `station_id`, `image`) VALUES
(1, 'Thống Nhất màu xanh', 'Bike', 7, '30T4\r\n1975', '2020-12-19', 'Thống Nhất', NULL, NULL, NULL, '00000001', 0, 3, 'bike_default.png'),
(2, 'Xe điện màu đỏ', 'EBike', 20, '30 M1\r\n6868', '2020-12-19', '133S', '100', '3', '100', '00000010', 0, 1, 'bike_default.png'),
(3, 'Xe đôi tình yêu', 'Twin Bike', 11, '7749', '2020-12-19', 'MTP Entertaiment', NULL, NULL, NULL, '00000011', 0, 2, 'bike_default.png');

-- --------------------------------------------------------


--
CREATE TABLE virtual_accounts (
`account_id` int(20) PRIMARY KEY AUTO_INCREMENT,
`card_holder_name` varchar(100) NOT NULL,
`card_number` varchar(100) NOT NULL,
`issuing_bank` varchar(100) NOT NULL,
`expiration_date` date NOT NULL,
`cvv` int(10) NOT NULL,
`amount_money` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO virtual_accounts VALUES 
(null, 'HOANG TRUNG DUC', '123456789', 'Vietinbank', '2025-10-10', '123', 99999999999);
-- Table structure for table `cost`
--

CREATE TABLE `cost` (
  `bike_type` varchar(100) NOT NULL,
  `deposit` float NOT NULL,
  `30m_first` float NOT NULL,
  `15m_later` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cost`
--

INSERT INTO `cost` (`bike_type`, `deposit`, `30m_first`, `15m_later`) VALUES
('Bike', 400000, 10000, 3000),
('EBike', 700000, 15000, 4500),
('Twin Bike', 550000, 15000, 4500);

-- --------------------------------------------------------

--
-- Table structure for table `payment_method`
--

CREATE TABLE `payment_methods` (
	`payment_id` int(20) NOT NULL PRIMARY KEY,
  `virtual_account_id` int(20) NOT NULL,
  `user_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `payment_method`
--

-- --------------------------------------------------------

--
-- Table structure for table `stations`
--

CREATE TABLE `stations` (
  `id` int(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `number_of_docks` int(20) NOT NULL,
  `distance_to_walk` float NOT NULL,
  `time_to_walk` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `stations`
--

INSERT INTO `stations` (`id`, `name`, `address`, `number_of_docks`, `distance_to_walk`, `time_to_walk`) VALUES
(1, 'TC 304', 'Tạ Quang Bửu', 20, 100, '100'),
(2, 'TC 407', 'Tạ Quang Bửu', 20, 100, '100'),
(3, 'D5 301', 'Trần Đại Nghĩa', 20, 30, '60');

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `id` int(20) NOT NULL,
  `bike_id` int(20) NOT NULL,
  `user_id` int(20) NOT NULL,
  `payment_method_id` int(20) NOT NULL,
  `start_time` datetime NOT NULL DEFAULT current_timestamp(),
  `end_time` datetime DEFAULT NULL,
  `status` int(20) NOT NULL DEFAULT 1,
  `description` varchar(100) DEFAULT NULL,
  `deposit` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `status` int(20) NOT NULL DEFAULT 0,
  `isAdmin` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `username`, `password`, `status`, `isAdmin`) VALUES
(1, 'Nguyen Cong Luat', 'luatnc', 'nchust', 0, 0),
(2, 'Nguyen Hai Long', 'longnh', 'nhhust', 0, 0),
(3, 'Hoang Trung Duc', 'ducht', 'hthust', 0, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bikes`
--
ALTER TABLE `bikes`
  ADD KEY `bikes_stations` (`station_id`),
  ADD KEY `bikes_cost` (`type`);

--
-- Indexes for table `cost`
--
ALTER TABLE `cost`
  ADD PRIMARY KEY (`bike_type`);

--
-- Indexes for table `payment_method`
--


--
-- Indexes for table `stations`
--
ALTER TABLE `stations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `transaction_bikes_id` (`bike_id`),
  ADD KEY `transactions_users_id` (`user_id`),
  ADD KEY `transactions_payment_method_id` (`payment_method_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bikes`
--
ALTER TABLE `bikes`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `payment_method`
--
ALTER TABLE `payment_methods`
  MODIFY `payment_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `stations`
--
ALTER TABLE `stations`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bikes`
--
ALTER TABLE `bikes`
  ADD CONSTRAINT `bikes_cost` FOREIGN KEY (`type`) REFERENCES `cost` (`bike_type`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bikes_stations` FOREIGN KEY (`station_id`) REFERENCES `stations` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `payment_method`
--
ALTER TABLE `payment_methods`
  ADD CONSTRAINT `payment_account` FOREIGN KEY (`virtual_account_id`) REFERENCES `virtual_accounts` (`account_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `payment_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
  

--
-- Constraints for table `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `transactions_bikes` FOREIGN KEY (`bike_id`) REFERENCES `bikes` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `transactions_payment_method` FOREIGN KEY (`payment_method_id`) REFERENCES `payment_methods` (`payment_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `transactions_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;


