-- ===========================================
-- SCRIPT COMPLETO: CREACIÓN DE TABLAS + DATOS
-- Base de datos: lineas_unidas
-- ===========================================

-- 🔒 Deshabilitar validación de llaves foráneas
SET FOREIGN_KEY_CHECKS = 0;

-- Borrar tablas (orden inverso de dependencias)
DROP TABLE IF EXISTS taquillero_boleto;
DROP TABLE IF EXISTS boleto;
DROP TABLE IF EXISTS viaje_urvan;
DROP TABLE IF EXISTS viaje_ruta;
DROP TABLE IF EXISTS viaje;
DROP TABLE IF EXISTS urvan;
DROP TABLE IF EXISTS ruta;
DROP TABLE IF EXISTS horario_viaje;
DROP TABLE IF EXISTS conductor;
DROP TABLE IF EXISTS taquillero;
DROP TABLE IF EXISTS gerente;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS horario_trabajo;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS checador;

-- 🔓 Habilitar validación de llaves
SET FOREIGN_KEY_CHECKS = 1;

-- ===========================================
-- CREACIÓN DE TABLAS
-- ===========================================

CREATE TABLE usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  apellido_m VARCHAR(255),
  apellido_p VARCHAR(255),
  nombre VARCHAR(255),
  telefono VARCHAR(255),
  correo VARCHAR(255),
  rol VARCHAR(255),
  PRIMARY KEY (id_usuario),
  UNIQUE KEY UK_usuario_correo (correo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE cliente (
  id_usuario INT NOT NULL,
  contrasenia VARCHAR(255),
  metodo_compra VARCHAR(255),
  PRIMARY KEY (id_usuario),
  CONSTRAINT FK_cliente_usuario FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE horario_trabajo (
  id_horario INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id_horario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE gerente (
  id_usuario INT NOT NULL,
  contrasenia VARCHAR(255),
  id_horario INT,
  PRIMARY KEY (id_usuario),
  CONSTRAINT FK_gerente_usuario FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
  CONSTRAINT FK_gerente_horario FOREIGN KEY (id_horario) REFERENCES horario_trabajo (id_horario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE taquillero (
  id_usuario INT PRIMARY KEY,
  id_horario INT,
  contrasenia VARCHAR(255),
  FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
  FOREIGN KEY (id_horario) REFERENCES horario_trabajo(id_horario)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE conductor (
  id_usuario INT NOT NULL,
  id_horario INT NOT NULL,
  permiso VARCHAR(255) NOT NULL,
  PRIMARY KEY (id_usuario),
  CONSTRAINT FK_conductor_usuario FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
  CONSTRAINT FK_conductor_horario FOREIGN KEY (id_horario) REFERENCES horario_trabajo (id_horario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE ruta (
  id_ruta INT NOT NULL AUTO_INCREMENT,
  destino VARCHAR(255),
  origen VARCHAR(255),
  distancia VARCHAR(255),
  PRIMARY KEY (id_ruta)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE horario_viaje (
  id_horario INT NOT NULL AUTO_INCREMENT,
  estado VARCHAR(255),
  fecha DATE,
  hora_salida TIME,
  hora_llegada TIME,
  PRIMARY KEY (id_horario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE viaje (
  id_viaje INT NOT NULL AUTO_INCREMENT,
  disponibilidad VARCHAR(255),
  precio FLOAT NOT NULL,
  id_horario INT,
  estado VARCHAR(255),
  PRIMARY KEY (id_viaje),
  CONSTRAINT FK_viaje_horario FOREIGN KEY (id_horario) REFERENCES horario_viaje (id_horario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE viaje_ruta (
  id_viaje INT NOT NULL,
  id_ruta INT NOT NULL,
  CONSTRAINT FK_viaje_ruta_viaje FOREIGN KEY (id_viaje) REFERENCES viaje (id_viaje),
  CONSTRAINT FK_viaje_ruta_ruta FOREIGN KEY (id_ruta) REFERENCES ruta (id_ruta)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE urvan (
  id_urban INT NOT NULL AUTO_INCREMENT,
  capacidad INT NOT NULL,
  placa VARCHAR(255),
  id_conductor INT,
  PRIMARY KEY (id_urban),
  UNIQUE KEY UK_urvan_conductor (id_conductor),
  CONSTRAINT FK_urvan_conductor FOREIGN KEY (id_conductor) REFERENCES conductor (id_usuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE viaje_urvan (
  id_viaje INT NOT NULL,
  id_urban INT NOT NULL,
  CONSTRAINT FK_viaje_urvan_viaje FOREIGN KEY (id_viaje) REFERENCES viaje (id_viaje),
  CONSTRAINT FK_viaje_urvan_urvan FOREIGN KEY (id_urban) REFERENCES urvan (id_urban)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE boleto (
  id_boleto INT NOT NULL AUTO_INCREMENT,
  estado VARCHAR(255),
  tipo VARCHAR(255),
  id_cliente INT NOT NULL,
  id_viaje INT NOT NULL,
  precio DECIMAL(10,2),  -- nueva columna
  PRIMARY KEY (id_boleto),
  CONSTRAINT FK_boleto_cliente FOREIGN KEY (id_cliente) REFERENCES cliente (id_usuario),
  CONSTRAINT FK_boleto_viaje FOREIGN KEY (id_viaje) REFERENCES viaje (id_viaje)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE `checador` (
  `id_usuario` int NOT NULL,
  `id_horario` int DEFAULT NULL,
  `contrasenia` varchar(255) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `FKqyc1dx8nlrdef9q8e5m5duxn6` (`id_horario`),
  CONSTRAINT `FK9cjmxoqjij4qcip2crujbalov` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `FKqyc1dx8nlrdef9q8e5m5duxn6` FOREIGN KEY (`id_horario`) REFERENCES `horario_trabajo` (`id_horario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE taquillero_boleto (
  id_taquillero INT NOT NULL,
  id_boleto INT NOT NULL,
  PRIMARY KEY (id_taquillero, id_boleto),
  CONSTRAINT FKb1gy4dsi6e1nu7ts90mvvjpbd FOREIGN KEY (id_taquillero) REFERENCES taquillero(id_usuario),
  CONSTRAINT FK3bnst5q9g6kj8ou3cxeeytrc8 FOREIGN KEY (id_boleto) REFERENCES boleto(id_boleto)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ===========================================
-- INSERCIONES DE DATOS
-- ===========================================

-- 1️⃣ Usuarios
INSERT INTO usuario (id_usuario, nombre, apellido_p, apellido_m, telefono, correo, rol) VALUES
(1, 'Juan', 'Pérez', 'Lopez', '9511234567', 'juan@example.com', 'Cliente'),
(2, 'María', 'Gómez', 'Sánchez', '9512345678', 'maria@example.com', 'Cliente'),
(3, 'Luis', 'Ramírez', 'Torres', '9513456789', 'luis@example.com', 'Conductor'),
(4, 'Ana', 'Martínez', 'Rojas', '9514567890', 'ana@example.com', 'Conductor'),
(5, 'Pedro', 'Pérez', 'Lopez', '9515678901', 'pedro@mail.com', 'Gerente'),
(6, 'Carla', 'Vargas', 'Santos', '9516789012', 'carla@mail.com', 'Taquillero'),
(7, 'Carloss', 'Vargas', 'Santos', '9516789012', 'carlo@mail.com', 'Checador');

-- 2️⃣ Clientes
INSERT INTO cliente (id_usuario, contrasenia, metodo_compra) VALUES
(1, '1234', 'Online'),
(2, 'abcd', 'Taquilla');

-- 3️⃣ Horarios de trabajo
INSERT INTO horario_trabajo (id_horario) VALUES
(1),
(2);

-- 4️⃣ Gerente
INSERT INTO gerente (id_usuario, contrasenia, id_horario) VALUES
(5, 'pass123', 1);

-- 5️⃣ Taquillero
INSERT INTO taquillero (id_usuario, id_horario, contrasenia) VALUES
(6, 2, 'taqui123');

-- 6️⃣ Conductores
INSERT INTO conductor (id_usuario, id_horario, permiso) VALUES
(3, 1, 'PermisoA'),
(4, 2, 'PermisoB');

-- 7️⃣ Rutas
INSERT INTO ruta (id_ruta, destino, origen, distancia) VALUES
(1, 'Miahuatlán de Porfirio Díaz', 'Oaxaca', '120 km'),
(2, 'San Pedro Pochutla', 'Oaxaca', '250 km'),
(3, 'San José del Pacífico', 'Oaxaca', '100 km'),
(4, 'Zipolite', 'Oaxaca', '350 km');

-- 8️⃣ Horarios de viaje
INSERT INTO horario_viaje (id_horario, estado, fecha, hora_salida, hora_llegada) VALUES
(1, 'Disponible', '2025-09-21', '08:00:00', '10:00:00'),
(2, 'Disponible', '2025-09-21', '12:00:00', '15:00:00'),
(3, 'Disponible', '2025-09-22', '09:00:00', '11:30:00'),
(4, 'Disponible', '2025-09-22', '14:00:00', '18:00:00');

-- 9️⃣ Viajes
INSERT INTO viaje (id_viaje, disponibilidad, precio, id_horario, estado) VALUES
(1, 'Disponible', 800.00, 1, 'Activo'),
(2, 'Disponible', 1200.00, 2, 'Activo'),
(3, 'Disponible', 950.00, 3, 'Activo'),
(4, 'Disponible', 1500.00, 4, 'Activo');

-- 🔟 Relación viajes - rutas
INSERT INTO viaje_ruta (id_viaje, id_ruta) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4);

-- 1️⃣1️⃣ Urvans
INSERT INTO urvan (id_urban, capacidad, placa, id_conductor) VALUES
(1, 40, 'OAX-123-A', 3),
(2, 35, 'OAX-456-B', 4),
(3, 30, 'OAX-789-C', NULL),
(4, 45, 'OAX-321-D', NULL);

-- 1️⃣2️⃣ Relación viajes - urvans
INSERT INTO viaje_urvan (id_viaje, id_urban) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4);

-- 1️⃣3️⃣ Boletos
INSERT INTO boleto (id_boleto, estado, tipo, id_cliente, id_viaje, precio) VALUES
(1, 'Comprado', 'Adulto', 1, 1, 150.00),
(2, 'Comprado', 'Niño', 2, 2, 75.00);


INSERT INTO checador (id_usuario, id_horario, contrasenia) VALUES
(7, 1, 'passchecador');


-- 1️⃣4️⃣ Relación taquillero - boletos
INSERT INTO taquillero_boleto (id_taquillero, id_boleto) VALUES
(6, 1),
(6, 2);
