-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 30, 2025 at 04:04 AM
-- Server version: 8.0.40
-- PHP Version: 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `MS_Productos`
--
CREATE DATABASE IF NOT EXISTS `MS_Productos` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `MS_Productos`;

-- --------------------------------------------------------

--
-- Table structure for table `Categoria`
--

CREATE TABLE `Categoria` (
  `idCategoria` bigint NOT NULL,
  `nombreCategoria` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Categoria`
--

INSERT INTO `Categoria` (`idCategoria`, `nombreCategoria`) VALUES
(1, 'Electrodomesticos'),
(2, 'Computación y celulares');

-- --------------------------------------------------------

--
-- Table structure for table `Estado`
--

CREATE TABLE `Estado` (
  `idEstado` bigint NOT NULL,
  `nombreEstado` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Estado`
--

INSERT INTO `Estado` (`idEstado`, `nombreEstado`) VALUES
(1, 'Disponible'),
(2, 'Agotado');

-- --------------------------------------------------------

--
-- Table structure for table `Marca`
--

CREATE TABLE `Marca` (
  `idMarca` bigint NOT NULL,
  `nombreMarca` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Marca`
--

INSERT INTO `Marca` (`idMarca`, `nombreMarca`) VALUES
(1, 'LG'),
(2, 'Samsung'),
(3, 'Panasonic'),
(4, 'Haceb'),
(5, 'Kalley');

-- --------------------------------------------------------

--
-- Table structure for table `Producto`
--

CREATE TABLE `Producto` (
  `idProducto` bigint NOT NULL,
  `nombreProducto` varchar(100) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `idCategoria` bigint DEFAULT NULL,
  `idMarca` bigint DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `idEstado` bigint DEFAULT NULL,
  `idTipo` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Producto`
--

INSERT INTO `Producto` (`idProducto`, `nombreProducto`, `descripcion`, `idCategoria`, `idMarca`, `color`, `precio`, `idEstado`, `idTipo`) VALUES
(14, 'Sanduchera grande', 'prueba', 1, 5, 'Blanco', 280000.00, 1, 2),
(15, 'Televisor 55 pulgadas', 'prueba', 1, 3, 'Negro', 280000.00, 1, 2),
(16, 'Equipo de sonido con 4 parlantes', 'prueba', 1, 3, 'Negro', 2500000.00, 1, 2),
(17, 'Parlante', 'prueba', 1, 3, 'Negro', 1800000.00, 1, 1),
(18, 'Televisor 55 pulgadas', 'prueba', 1, 3, 'Negro', 280000.00, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `TipoProducto`
--

CREATE TABLE `TipoProducto` (
  `idTipo` bigint NOT NULL,
  `nombreTipo` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `TipoProducto`
--

INSERT INTO `TipoProducto` (`idTipo`, `nombreTipo`) VALUES
(1, 'Lavadoras'),
(2, 'Televisores'),
(3, 'Sonido'),
(4, 'Neveras'),
(5, 'Portatil'),
(6, 'PC Escritorio'),
(7, 'Sonido');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Categoria`
--
ALTER TABLE `Categoria`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Indexes for table `Estado`
--
ALTER TABLE `Estado`
  ADD PRIMARY KEY (`idEstado`);

--
-- Indexes for table `Marca`
--
ALTER TABLE `Marca`
  ADD PRIMARY KEY (`idMarca`);

--
-- Indexes for table `Producto`
--
ALTER TABLE `Producto`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `fk_producto_categoria` (`idCategoria`),
  ADD KEY `fk_producto_marca` (`idMarca`),
  ADD KEY `fk_producto_estado` (`idEstado`),
  ADD KEY `fk_producto_tipo` (`idTipo`);

--
-- Indexes for table `TipoProducto`
--
ALTER TABLE `TipoProducto`
  ADD PRIMARY KEY (`idTipo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Categoria`
--
ALTER TABLE `Categoria`
  MODIFY `idCategoria` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `Estado`
--
ALTER TABLE `Estado`
  MODIFY `idEstado` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `Marca`
--
ALTER TABLE `Marca`
  MODIFY `idMarca` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `Producto`
--
ALTER TABLE `Producto`
  MODIFY `idProducto` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `TipoProducto`
--
ALTER TABLE `TipoProducto`
  MODIFY `idTipo` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Producto`
--
ALTER TABLE `Producto`
  ADD CONSTRAINT `fk_producto_categoria` FOREIGN KEY (`idCategoria`) REFERENCES `Categoria` (`idCategoria`),
  ADD CONSTRAINT `fk_producto_estado` FOREIGN KEY (`idEstado`) REFERENCES `Estado` (`idEstado`),
  ADD CONSTRAINT `fk_producto_marca` FOREIGN KEY (`idMarca`) REFERENCES `Marca` (`idMarca`),
  ADD CONSTRAINT `fk_producto_tipo` FOREIGN KEY (`idTipo`) REFERENCES `TipoProducto` (`idTipo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
