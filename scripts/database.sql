CREATE database HabraGasolina;

CREATE USER 'usr_app_gasolina' IDENTIFIED BY 'gasolina';
GRANT ALL PRIVILEGES ON * . * TO 'usr_app_gasolina';
USE HabraGasolina;

CREATE TABLE `gas_stations` (
  `id_gas_station` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `location` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE `gas_stations`
  ADD PRIMARY KEY (`id_gas_station`);

ALTER TABLE `gas_stations`
  MODIFY `id_gas_station` int(11) NOT NULL AUTO_INCREMENT;

CREATE TABLE `fuel_types` (
  `id_fuel` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE `fuel_types`
  ADD PRIMARY KEY (`id_fuel`);

ALTER TABLE `fuel_types`
  MODIFY `id_fuel` int(11) NOT NULL AUTO_INCREMENT;

CREATE TABLE `statuses` (
  `id_status` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `description` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE `statuses`
  ADD PRIMARY KEY (`id_status`);

ALTER TABLE `statuses`
  MODIFY `id_status` int(11) NOT NULL AUTO_INCREMENT;

CREATE TABLE `availabilities` (
  `id_availabilities` int(11) NOT NULL,
  `id_gas_station` int(11) NOT NULL,
  `id_type` int(11) NOT NULL,
  `id_status` int(11) NOT NULL,
  `date_updated` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE `availabilities`
  ADD PRIMARY KEY (`id_availabilities`),
  ADD KEY `id_gas_station` (`id_gas_station`),
  ADD KEY `id_status` (`id_status`),
  ADD KEY `id_type` (`id_type`);

ALTER TABLE `availabilities`
  MODIFY `id_availabilities` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `availabilities`
  ADD CONSTRAINT `availabilities_ibfk_1` FOREIGN KEY (`id_gas_station`) REFERENCES `gas_stations` (`id_gas_station`),
  ADD CONSTRAINT `availabilities_ibfk_2` FOREIGN KEY (`id_status`) REFERENCES `statuses` (`id_status`),
  ADD CONSTRAINT `availabilities_ibfk_3` FOREIGN KEY (`id_type`) REFERENCES `fuel_types` (`id_fuel`);  

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `username` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `name` varchar(250) NOT NULL,
  `id_gas_station` int(11) NOT NULL,
  `date_last_login` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `id_gas_station` (`id_gas_station`);

  ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT;

  ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`id_gas_station`) REFERENCES `gas_stations` (`id_gas_station`);