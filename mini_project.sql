-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2024 at 08:59 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mini_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `majors`
--

CREATE TABLE `majors` (
  `id` bigint(20) NOT NULL,
  `des` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `majors`
--

INSERT INTO `majors` (`id`, `des`, `name`) VALUES
(1, 'Cơ khí abc', 'Cơ khí'),
(2, ' sử dụng trong nhiều lĩnh vực như trí tuệ nhân tạo, phân tích dữ liệu, và phát triển ứng dụng web và di động.', 'Công nghệ thông tin'),
(3, 'Các quản lý kinh doanh thường phải đưa ra quyết định chiến lược, phân bổ tài nguyên', 'Quản trị kinh doanh'),
(4, 'là quá trình ghi chép, phân tích và báo cáo về tài chính của một tổ chức hoặc cá nhân', 'Kế toán');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `major_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `address`, `email`, `name`, `major_id`) VALUES
(1, 'Bình Chánh', 'kit@gmail.com', 'Nguyễn Văn A', 4),
(2, 'Long An', 'dong@gmail.com', 'Đông', 3),
(3, 'Quảng Ngãi', 'nam@gmail.com', 'Nam', 3),
(4, 'Ho Chi Minh City', 'an@hotmail.com', 'An', 1),
(5, 'Hue', 'tung@gmail.com', 'Tung', 4),
(6, 'Nha Trang', 'lan@gmail.com', 'Lan', 2),
(7, 'Buon Ma Thuot', 'phuong@gmail.com', 'Phuong', 3),
(8, 'Bien Hoa', 'dat@hotmail.com', 'Dat', 4),
(9, 'Hai Phong', 'hoa@yahoo.com', 'Hoa', 2),
(10, 'Can Tho', 'quan@gmail.com', 'Quan', 1),
(11, 'Vinh', 'trang@example.com', 'Trang', 3),
(12, 'Kon Tum', 'bach@hotmail.com', 'Bach', 4),
(13, 'Phan Thiet', 'mylinh@yahoo.com', 'My Linh', 3),
(14, 'Dak Lak', 'thien@gmail.com', 'Thien', 2),
(15, 'Lao Cai', 'xuan@example.com', 'Xuan', 1),
(16, 'Lao Cai', 'xuan@example.com', 'Xuan', 1),
(17, 'Long An', 'pndsdt10@gmail.com', 'Phạm Đông', 2),
(18, 'Tân Túc', 'thang@gmail.com', 'Thắng Cá Chép', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `majors`
--
ALTER TABLE `majors`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKi04cc0278a1f49g0995mnuo63` (`major_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `majors`
--
ALTER TABLE `majors`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `FKi04cc0278a1f49g0995mnuo63` FOREIGN KEY (`major_id`) REFERENCES `majors` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
