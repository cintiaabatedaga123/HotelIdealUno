-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-10-2018 a las 20:05:54
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hotelideal1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `id_habitacion` int(11) NOT NULL,
  `piso` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `id_tipohabitacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `huesped`
--

CREATE TABLE `huesped` (
  `id_huesped` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `dni` int(14) NOT NULL,
  `domicilio` varchar(30) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `celular` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `huesped`
--

INSERT INTO `huesped` (`id_huesped`, `nombre`, `dni`, `domicilio`, `correo`, `celular`) VALUES
(2, 'Santigo Aballay', 45666777, 'Rawson 999', 'santiagoaballay@ulp.edu.ar', 2664335566),
(3, 'Pedro Ledesma', 33444555, 'Las Golondrinas 234', 'pedro@ulp.edu.ar', 2664889966),
(4, 'Aylen Aballay', 49888777, 'Rawson 532', 'aylen@ulp.edu.ar', 2664998877),
(5, 'Lautaro Ledesma', 49334455, 'Las Palomas 987', 'lautaro@ulp.edu.ar', 2664009988),
(6, 'Anabela de Ledesma', 34112233, 'Las Palomas 456', 'anabela@ulp.edu.ar', 2664556677),
(8, 'Maria Juana Gomez', 35325467, 'Av San Martin, Cordoba', 'mariagomez@hotmail.com', 2664876590),
(11, 'Sandra Mercado', 24567890, 'Los Olvidados 123', 'sandra@ulp.edu.ar', 2664556677);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `id_reserva` int(11) NOT NULL,
  `cantidadPersonas` int(11) NOT NULL,
  `fechaEntrada` date NOT NULL,
  `fechaSalida` date NOT NULL,
  `importeTotal` double NOT NULL,
  `estadoReserva` tinyint(1) NOT NULL,
  `id_habitacion` int(11) NOT NULL,
  `id_huesped` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipohabitacion`
--

CREATE TABLE `tipohabitacion` (
  `id_tipohabitacion` int(11) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `precioPorNoche` double NOT NULL,
  `cantPersonasMax` int(11) NOT NULL,
  `cantCamas` int(11) NOT NULL,
  `tipoCama` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`id_habitacion`),
  ADD KEY `id_tipohabitacion` (`id_tipohabitacion`);

--
-- Indices de la tabla `huesped`
--
ALTER TABLE `huesped`
  ADD PRIMARY KEY (`id_huesped`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id_reserva`),
  ADD KEY `id_habitacion` (`id_habitacion`,`id_huesped`),
  ADD KEY `id_huesped` (`id_huesped`);

--
-- Indices de la tabla `tipohabitacion`
--
ALTER TABLE `tipohabitacion`
  ADD PRIMARY KEY (`id_tipohabitacion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  MODIFY `id_habitacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `huesped`
--
ALTER TABLE `huesped`
  MODIFY `id_huesped` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `id_reserva` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipohabitacion`
--
ALTER TABLE `tipohabitacion`
  MODIFY `id_tipohabitacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD CONSTRAINT `habitacion_ibfk_1` FOREIGN KEY (`id_tipohabitacion`) REFERENCES `tipohabitacion` (`id_tipoHabitacion`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`id_huesped`) REFERENCES `huesped` (`id_huesped`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`id_habitacion`) REFERENCES `habitacion` (`id_habitacion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
