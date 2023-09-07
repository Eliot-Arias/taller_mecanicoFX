-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-09-2023 a las 14:57:21
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
-- Base de datos: `taller_mecanico`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualiza_auto` (`id_auto` INT, `placa_auto` VARCHAR(7), `var_marca` VARCHAR(80), `var_modelo` VARCHAR(80), `var_año` VARCHAR(4), `var_color` VARCHAR(15), `var_garantia` INT, `var_historial` INT)   BEGIN DECLARE rows_affected INT;
UPDATE automovil
SET
    nro_placa = placa_auto,
    marca = var_marca,
    modelo = var_modelo,
    año = var_año,
    color = var_color,
    id_garantia = var_garantia,
    id_historial = var_historial
WHERE
    id_automovil = id_auto;
SET rows_affected = ROW_COUNT();
IF rows_affected > 0 THEN SIGNAL SQLSTATE '10000'
SET
    MESSAGE_TEXT = 'REGISTRO ACTUALIZADO CON ÉXITO';
ELSE SIGNAL SQLSTATE '45000'
SET
    MESSAGE_TEXT = 'NO SE ENCONTRÓ UN REGISTRO CON EL ID ESPECIFICADO';
END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `consultar_cliente` (`nro_doc` VARCHAR(30))   BEGIN
    SELECT * FROM clientes WHERE nro_documento = nro_doc;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `editar_cliente` (`id_client` INT, `nombre` VARCHAR(120), `tipo_docu` VARCHAR(35), `nro_docu` VARCHAR(30), `var_correo` VARCHAR(80), `telef` VARCHAR(12))   BEGIN
    UPDATE clientes SET nombre_o_razon_social = nombre, tipo_documento = tipo_docu, nro_documento = nro_docu, correo = var_correo, telefono = telef
    WHERE id_cliente = id_client;
    SIGNAL SQLSTATE '46000'
SET
    MESSAGE_TEXT = 'REGISTRO EDITADO CON EXITO';
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_auto` (`ID_AUTO` INT)   BEGIN 
	DECLARE rows_affected INT;
	DELETE FROM automovil WHERE id_automovil = id_auto;
	SET rows_affected = ROW_COUNT();
	IF rows_affected > 0 THEN SIGNAL SQLSTATE '10000'
	SET
	    MESSAGE_TEXT = 'REGISTRO ELIMINADO CON ÉXITO';
	ELSE SIGNAL SQLSTATE '45000'
	SET
	    MESSAGE_TEXT = 'NO SE ENCONTRÓ UN REGISTRO CON EL ID ESPECIFICADO';
	END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_cliente` (`id_client` INT)   BEGIN
    DELETE FROM clientes WHERE id_cliente = id_client;
    SIGNAL SQLSTATE '48000'
SET
    MESSAGE_TEXT = 'REGISTRO ELIMINADO CON EXITO';
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `guardarAuto` (`var_id_clent` INT, `var_nro_placa` VARCHAR(7), `var_marca` VARCHAR(80), `var_modelo` VARCHAR(80), `var_año` VARCHAR(4), `var_color` VARCHAR(15), `var_id_garantia` INT, `var_id_historial` INT)   BEGIN
    INSERT INTO automovil(id_cliente, nro_placa, marca, modelo, año, color, id_garantia, id_historial) VALUES(var_id_clent, var_nro_placa, var_marca, var_modelo, var_año, var_color, var_id_garantia, var_id_historial);
    SIGNAL SQLSTATE '45000'
SET
    MESSAGE_TEXT = 'REGISTRO REALIZADO CON EXITO';
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `mostrar_auto` ()   BEGIN
        SELECT
        a.id_automovil,
        a.marca,
        a.año,
        a.color,
        a.modelo,
        a.nro_placa,
        c.nombre_o_razon_social as cliente,
        c.id_cliente
    FROM automovil a
        JOIN clientes c ON a.id_cliente = c.id_cliente;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `registrar_cliente` (`nombre` VARCHAR(120), `tipo_docu` VARCHAR(35), `nro_docu` VARCHAR(30), `var_correo` VARCHAR(80), `telef` VARCHAR(12))   BEGIN
    INSERT INTO clientes(nombre_o_razon_social, tipo_documento, nro_documento, correo, telefono) VALUES(nombre, tipo_docu, nro_docu, var_correo, telef);

    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'REGISTRO REALIZADO CON EXITO';
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `validar_usuario` (`nomuser` VARCHAR(15), `pwd` VARCHAR(20))   BEGIN
    SELECT * FROM usuarios WHERE nombre_usuario = nomuser AND contraseña = pwd;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `automovil`
--

CREATE TABLE `automovil` (
  `id_automovil` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `nro_placa` varchar(7) NOT NULL,
  `marca` varchar(80) NOT NULL,
  `modelo` varchar(80) NOT NULL,
  `año` varchar(4) NOT NULL,
  `color` varchar(15) NOT NULL,
  `id_garantia` int(11) DEFAULT NULL,
  `id_historial` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `automovil`:
--   `id_cliente`
--       `clientes` -> `id_cliente`
--   `id_garantia`
--       `garantia` -> `id_garantia`
--   `id_historial`
--       `historial_de_mantenimiento` -> `id_historial`
--

--
-- Volcado de datos para la tabla `automovil`
--

INSERT INTO `automovil` (`id_automovil`, `id_cliente`, `nro_placa`, `marca`, `modelo`, `año`, `color`, `id_garantia`, `id_historial`) VALUES
(6, 5, '544-JOK', 'Barbie', 'AVentura', '2036', 'Rosado', NULL, NULL),
(7, 5, '123asd', 'caja', 'Losa', '2019', 'azul', NULL, NULL),
(9, 14, 'ABC-456', 'Hyundai', 'Picanto', '2014', 'Negro', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `nombre_o_razon_social` varchar(120) NOT NULL,
  `tipo_documento` varchar(35) NOT NULL,
  `nro_documento` varchar(30) NOT NULL,
  `correo` varchar(80) NOT NULL,
  `telefono` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `clientes`:
--

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombre_o_razon_social`, `tipo_documento`, `nro_documento`, `correo`, `telefono`) VALUES
(5, 'Eliot Arias', 'Documento Nacional de Identidad', '74996280', 'asd12323123213asd@asd.com', '959595966'),
(6, 'ASD CDAD11111', 'RUC', '2060504050', 'asdasd@a1111sd.com', '159456753'),
(7, 'ASD CDAD', 'RUC', '2060504050', 'asdasd@asd.com', '959596332'),
(8, 'ASD CDAD', 'Registro Unico de Contribuyente', '2060504050', 'asdasd@asd.com', 'aasd'),
(9, 'Abel Roto', 'Pasaporte', '954123456', 'asdasd@asd.com', '959596332'),
(10, 'ASD CDAD', 'RUC', '2060504050', 'asdasd@asd.com', '959596332'),
(11, 'ASD CDAD', 'RUC', '2060504050', 'asdasd@asd.com', '959596332'),
(12, 'Josephg', 'Documento Nacional de Identidad', '2060504050', 'asdasd@asd.com', '959596332'),
(13, 'asdasdasd', 'Carnet de Extrangería', '213', '123123', '123123'),
(14, 'Elmer', 'Documento Nacional de Identidad', '4651432132', 'asdasd@:vasd.com', '959596885');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprobante`
--

CREATE TABLE `comprobante` (
  `id_comprobante` int(11) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `nro_ticket` int(11) NOT NULL,
  `tipo_documento` varchar(20) NOT NULL,
  `nro_documento` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `comprobante`:
--   `id_usuario`
--       `usuarios` -> `id_usario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `id_empleado` int(11) NOT NULL,
  `rol` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `tipo_documento` varchar(20) NOT NULL,
  `nro_documento` varchar(30) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `hora_entrada` datetime DEFAULT NULL,
  `hora_salida` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `empleado`:
--

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`id_empleado`, `rol`, `nombre`, `tipo_documento`, `nro_documento`, `telefono`, `direccion`, `hora_entrada`, `hora_salida`) VALUES
(1, 'administrador', 'trabajador1', 'dni', '68754129', '987654321', 'a', NULL, NULL),
(2, 'mecanico', 'trabajador2', 'dni', '74568901', '998322156', 'b', NULL, NULL),
(3, 'mecanica', 'trabajadora3', 'dni', '58365530', '966345731', 'c', NULL, NULL),
(4, 'administrador', 'trabajador1', 'dni', '68754129', '987654321', 'a', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `garantia`
--

CREATE TABLE `garantia` (
  `id_garantia` int(11) NOT NULL,
  `id_automovil` int(11) NOT NULL,
  `fecha_inicio` datetime NOT NULL,
  `fecha_termino` datetime NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `garantia`:
--   `id_automovil`
--       `automovil` -> `id_automovil`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_de_mantenimiento`
--

CREATE TABLE `historial_de_mantenimiento` (
  `id_historial` int(11) NOT NULL,
  `id_servicio` int(11) NOT NULL,
  `fecha_atencion` date NOT NULL,
  `id_comprobante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `historial_de_mantenimiento`:
--   `id_servicio`
--       `servicio` -> `id_servicio`
--   `id_comprobante`
--       `comprobante` -> `id_comprobante`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `id_servicio` int(11) NOT NULL,
  `id_tipo_de_servicio` int(11) NOT NULL,
  `fecha_ingreso` datetime NOT NULL,
  `fecha_salida` datetime NOT NULL,
  `costo_total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `servicio`:
--   `id_tipo_de_servicio`
--       `tipo_de_servicio` -> `id_tipo_de_servicio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket`
--

CREATE TABLE `ticket` (
  `id_ticket` int(11) NOT NULL,
  `id_servicio` int(11) DEFAULT NULL,
  `id_cliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `ticket`:
--   `id_servicio`
--       `servicio` -> `id_servicio`
--   `id_cliente`
--       `clientes` -> `id_cliente`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_de_servicio`
--

CREATE TABLE `tipo_de_servicio` (
  `id_tipo_de_servicio` int(11) NOT NULL,
  `id_empleado` int(11) DEFAULT NULL,
  `id_automovil` int(11) DEFAULT NULL,
  `costo` float NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `tiempo_estimado` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `tipo_de_servicio`:
--   `id_empleado`
--       `empleado` -> `id_empleado`
--   `id_automovil`
--       `automovil` -> `id_automovil`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usario` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `nombre_usuario` varchar(15) NOT NULL,
  `contraseña` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `usuarios`:
--   `id_empleado`
--       `empleado` -> `id_empleado`
--

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usario`, `id_empleado`, `nombre_usuario`, `contraseña`) VALUES
(2, 1, 'user1', '123456');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `automovil`
--
ALTER TABLE `automovil`
  ADD PRIMARY KEY (`id_automovil`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_garantia` (`id_garantia`),
  ADD KEY `id_historial` (`id_historial`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `comprobante`
--
ALTER TABLE `comprobante`
  ADD PRIMARY KEY (`id_comprobante`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`id_empleado`);

--
-- Indices de la tabla `garantia`
--
ALTER TABLE `garantia`
  ADD PRIMARY KEY (`id_garantia`),
  ADD KEY `id_automovil` (`id_automovil`);

--
-- Indices de la tabla `historial_de_mantenimiento`
--
ALTER TABLE `historial_de_mantenimiento`
  ADD PRIMARY KEY (`id_historial`),
  ADD KEY `id_servicio` (`id_servicio`),
  ADD KEY `id_comprobante` (`id_comprobante`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`id_servicio`),
  ADD KEY `id_tipo_de_servicio` (`id_tipo_de_servicio`);

--
-- Indices de la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id_ticket`),
  ADD KEY `id_servicio` (`id_servicio`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indices de la tabla `tipo_de_servicio`
--
ALTER TABLE `tipo_de_servicio`
  ADD PRIMARY KEY (`id_tipo_de_servicio`),
  ADD KEY `id_empleado` (`id_empleado`),
  ADD KEY `id_automovil` (`id_automovil`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usario`),
  ADD UNIQUE KEY `nombre_usuario` (`nombre_usuario`),
  ADD KEY `id_empleado` (`id_empleado`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `automovil`
--
ALTER TABLE `automovil`
  MODIFY `id_automovil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `comprobante`
--
ALTER TABLE `comprobante`
  MODIFY `id_comprobante` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `id_empleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `garantia`
--
ALTER TABLE `garantia`
  MODIFY `id_garantia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `historial_de_mantenimiento`
--
ALTER TABLE `historial_de_mantenimiento`
  MODIFY `id_historial` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `servicio`
--
ALTER TABLE `servicio`
  MODIFY `id_servicio` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id_ticket` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_de_servicio`
--
ALTER TABLE `tipo_de_servicio`
  MODIFY `id_tipo_de_servicio` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `automovil`
--
ALTER TABLE `automovil`
  ADD CONSTRAINT `automovil_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`),
  ADD CONSTRAINT `automovil_ibfk_2` FOREIGN KEY (`id_garantia`) REFERENCES `garantia` (`id_garantia`),
  ADD CONSTRAINT `automovil_ibfk_3` FOREIGN KEY (`id_historial`) REFERENCES `historial_de_mantenimiento` (`id_historial`);

--
-- Filtros para la tabla `comprobante`
--
ALTER TABLE `comprobante`
  ADD CONSTRAINT `comprobante_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usario`);

--
-- Filtros para la tabla `garantia`
--
ALTER TABLE `garantia`
  ADD CONSTRAINT `garantia_ibfk_1` FOREIGN KEY (`id_automovil`) REFERENCES `automovil` (`id_automovil`);

--
-- Filtros para la tabla `historial_de_mantenimiento`
--
ALTER TABLE `historial_de_mantenimiento`
  ADD CONSTRAINT `historial_de_mantenimiento_ibfk_1` FOREIGN KEY (`id_servicio`) REFERENCES `servicio` (`id_servicio`),
  ADD CONSTRAINT `historial_de_mantenimiento_ibfk_2` FOREIGN KEY (`id_comprobante`) REFERENCES `comprobante` (`id_comprobante`);

--
-- Filtros para la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD CONSTRAINT `servicio_ibfk_1` FOREIGN KEY (`id_tipo_de_servicio`) REFERENCES `tipo_de_servicio` (`id_tipo_de_servicio`);

--
-- Filtros para la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`id_servicio`) REFERENCES `servicio` (`id_servicio`),
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`);

--
-- Filtros para la tabla `tipo_de_servicio`
--
ALTER TABLE `tipo_de_servicio`
  ADD CONSTRAINT `tipo_de_servicio_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`),
  ADD CONSTRAINT `tipo_de_servicio_ibfk_2` FOREIGN KEY (`id_automovil`) REFERENCES `automovil` (`id_automovil`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
