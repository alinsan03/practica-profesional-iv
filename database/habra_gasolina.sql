-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-11-2024 a las 21:43:00
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `habra_gasolina`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `availabity`
--

CREATE TABLE `availabity` (
  `id_availabity` int(11) NOT NULL,
  `id_gas_station` int(11) NOT NULL,
  `id_type` int(11) NOT NULL,
  `id_status` int(11) NOT NULL,
  `date_updated` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fuel_type`
--

CREATE TABLE `fuel_type` (
  `id_fuel` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gas_station`
--

CREATE TABLE `gas_station` (
  `id_station` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `location` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `status`
--

CREATE TABLE `status` (
  `id_status` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `description` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `name` varchar(250) NOT NULL,
  `id_gas_station` int(11) NOT NULL,
  `date_last_login` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `availabity`
--
ALTER TABLE `availabity`
  ADD PRIMARY KEY (`id_availabity`),
  ADD KEY `id_gas_station` (`id_gas_station`,`id_type`,`id_status`),
  ADD KEY `id_status` (`id_status`),
  ADD KEY `id_type` (`id_type`);

--
-- Indices de la tabla `fuel_type`
--
ALTER TABLE `fuel_type`
  ADD PRIMARY KEY (`id_fuel`);

--
-- Indices de la tabla `gas_station`
--
ALTER TABLE `gas_station`
  ADD PRIMARY KEY (`id_station`);

--
-- Indices de la tabla `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id_status`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `id_gas_station` (`id_gas_station`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `availabity`
--
ALTER TABLE `availabity`
  MODIFY `id_availabity` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `fuel_type`
--
ALTER TABLE `fuel_type`
  MODIFY `id_fuel` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `gas_station`
--
ALTER TABLE `gas_station`
  MODIFY `id_station` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `status`
--
ALTER TABLE `status`
  MODIFY `id_status` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `availabity`
--
ALTER TABLE `availabity`
  ADD CONSTRAINT `availabity_ibfk_1` FOREIGN KEY (`id_gas_station`) REFERENCES `gas_station` (`id_station`),
  ADD CONSTRAINT `availabity_ibfk_2` FOREIGN KEY (`id_status`) REFERENCES `status` (`id_status`),
  ADD CONSTRAINT `availabity_ibfk_3` FOREIGN KEY (`id_type`) REFERENCES `fuel_type` (`id_fuel`);

--
-- Filtros para la tabla `gas_station`
--
ALTER TABLE `gas_station`
  ADD CONSTRAINT `gas_station_ibfk_1` FOREIGN KEY (`id_station`) REFERENCES `user` (`id_gas_station`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
