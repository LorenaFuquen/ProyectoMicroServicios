-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 30, 2025 at 04:01 AM
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
-- Database: `MS_Ordenes`
--
CREATE DATABASE IF NOT EXISTS `MS_Ordenes` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `MS_Ordenes`;

-- --------------------------------------------------------

--
-- Table structure for table `MedioPago`
--

CREATE TABLE `MedioPago` (
  `idMedioPago` bigint NOT NULL,
  `nombreMedio` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `MedioPago`
--

INSERT INTO `MedioPago` (`idMedioPago`, `nombreMedio`) VALUES
(1, 'Tarjeta de Credito'),
(2, 'Tarjeta de Debito'),
(3, 'Efectivo');

-- --------------------------------------------------------

--
-- Table structure for table `Orden`
--

CREATE TABLE `Orden` (
  `idOrden` bigint NOT NULL,
  `fechaCreacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idMedioPago` bigint NOT NULL,
  `IdPersona` bigint NOT NULL,
  `fechaEntrega` date NOT NULL,
  `valorTotal` decimal(10,2) NOT NULL DEFAULT '0.00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Orden`
--

INSERT INTO `Orden` (`idOrden`, `fechaCreacion`, `idMedioPago`, `IdPersona`, `fechaEntrega`, `valorTotal`) VALUES
(4, '2025-05-25 19:07:22', 1, 3, '2025-05-28', 280000.00),
(6, '2025-05-26 02:57:07', 2, 4, '2025-05-31', 4300000.00),
(7, '2025-05-26 03:27:01', 2, 4, '2025-05-31', 4300000.00),
(8, '2025-05-26 03:29:32', 2, 4, '2025-05-31', 280000.00),
(9, '2025-05-26 03:30:13', 2, 4, '2025-05-31', 280000.00),
(10, '2025-05-29 04:38:42', 2, 4, '2025-05-31', 280000.00),
(11, '2025-05-29 04:39:03', 2, 4, '2025-05-31', 280000.00),
(12, '2025-05-29 04:40:30', 2, 4, '2025-05-31', 280000.00),
(13, '2025-05-30 03:50:34', 2, 4, '2025-05-31', 280000.00);

-- --------------------------------------------------------

--
-- Table structure for table `OrdenProductos`
--

CREATE TABLE `OrdenProductos` (
  `idOrden` bigint NOT NULL,
  `idProducto` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `OrdenProductos`
--

INSERT INTO `OrdenProductos` (`idOrden`, `idProducto`) VALUES
(4, 15),
(6, 16),
(6, 17),
(7, 16),
(7, 17),
(8, 14),
(9, 14),
(10, 14),
(11, 14),
(12, 14),
(13, 14);

-- --------------------------------------------------------

--
-- Table structure for table `Persona`
--

CREATE TABLE `Persona` (
  `idPersona` bigint NOT NULL,
  `idTipoDocumento` bigint NOT NULL,
  `numeroDocumento` varchar(45) NOT NULL,
  `nombrePersona` varchar(100) NOT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Persona`
--

INSERT INTO `Persona` (`idPersona`, `idTipoDocumento`, `numeroDocumento`, `nombrePersona`, `correo`, `telefono`, `direccion`) VALUES
(2, 1, '1010123456', 'Juan Carlos Ramirez Cardenas', 'prueba@prueba.com', '312453533', 'Diag 123 # 12 - 76'),
(3, 1, '1010123453', 'Maria Jose Cardenas', 'prueba2@prueba.com', '3102348393', 'Cra 12 # 12 - 11 Apto 103'),
(4, 1, '1010123410', 'Lina Maria Jimenez Lopez', 'prueba3@prueba.com', '3153350338', 'Cll 72 # 7 - 45');

-- --------------------------------------------------------

--
-- Table structure for table `TipoDocumento`
--

CREATE TABLE `TipoDocumento` (
  `idTipoDocumento` bigint NOT NULL,
  `tipoDocumento` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `TipoDocumento`
--

INSERT INTO `TipoDocumento` (`idTipoDocumento`, `tipoDocumento`) VALUES
(1, 'Cedula de ciudadania'),
(2, 'Cedula de extranjeria'),
(3, 'Pasaporte'),
(4, 'NIT'),
(5, 'Tarjeta de identidad');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `MedioPago`
--
ALTER TABLE `MedioPago`
  ADD PRIMARY KEY (`idMedioPago`);

--
-- Indexes for table `Orden`
--
ALTER TABLE `Orden`
  ADD PRIMARY KEY (`idOrden`),
  ADD KEY `fk_orden_persona` (`IdPersona`),
  ADD KEY `fk_orden_medio` (`idMedioPago`);

--
-- Indexes for table `OrdenProductos`
--
ALTER TABLE `OrdenProductos`
  ADD PRIMARY KEY (`idOrden`,`idProducto`);

--
-- Indexes for table `Persona`
--
ALTER TABLE `Persona`
  ADD PRIMARY KEY (`idPersona`),
  ADD KEY `fk_tipoDoc_persona` (`idTipoDocumento`);

--
-- Indexes for table `TipoDocumento`
--
ALTER TABLE `TipoDocumento`
  ADD PRIMARY KEY (`idTipoDocumento`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `MedioPago`
--
ALTER TABLE `MedioPago`
  MODIFY `idMedioPago` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `Orden`
--
ALTER TABLE `Orden`
  MODIFY `idOrden` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `Persona`
--
ALTER TABLE `Persona`
  MODIFY `idPersona` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `TipoDocumento`
--
ALTER TABLE `TipoDocumento`
  MODIFY `idTipoDocumento` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Orden`
--
ALTER TABLE `Orden`
  ADD CONSTRAINT `fk_orden_medio` FOREIGN KEY (`idMedioPago`) REFERENCES `MedioPago` (`idMedioPago`),
  ADD CONSTRAINT `fk_orden_persona` FOREIGN KEY (`IdPersona`) REFERENCES `Persona` (`idPersona`);

--
-- Constraints for table `OrdenProductos`
--
ALTER TABLE `OrdenProductos`
  ADD CONSTRAINT `fk_orden_producto` FOREIGN KEY (`idOrden`) REFERENCES `Orden` (`idOrden`);

--
-- Constraints for table `Persona`
--
ALTER TABLE `Persona`
  ADD CONSTRAINT `fk_tipoDoc_persona` FOREIGN KEY (`idTipoDocumento`) REFERENCES `TipoDocumento` (`idTipoDocumento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
