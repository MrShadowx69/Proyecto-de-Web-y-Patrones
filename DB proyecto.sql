-- Creación de la base de datos
CREATE DATABASE IF NOT EXISTS veterinaria;

-- Selección de la base de datos
USE veterinaria;
CREATE USER 'usuario'@'%' IDENTIFIED BY '1234';

GRANT ALL PRIVILEGES ON veterinaria.* TO 'usuario'@'%';
FLUSH PRIVILEGES;
-- Tabla para almacenar información de los clientes
CREATE TABLE cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(100)
    
);

-- Tabla para almacenar información de las mascotas
CREATE TABLE mascota (
    id_mascota INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    especie VARCHAR(50) NOT NULL,
    raza VARCHAR(50),
    edad INT,
    id_cliente INT,
    imagen_mascota VARCHAR(1044),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);


-- Tabla para almacenar información de las visitas veterinarias
CREATE TABLE visita_veterinaria (
    id_visita INT AUTO_INCREMENT PRIMARY KEY,
    id_mascota INT,
    fecha DATE,
    diagnostico TEXT,
    tratamiento TEXT,
    FOREIGN KEY (id_mascota) REFERENCES mascota(id_mascota)
);

-- Tabla para almacenar información de los servicios ofrecidos
CREATE TABLE servicio (
    id_servicio INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10, 2)
);

-- Tabla para registrar los servicios realizados en cada visita
CREATE TABLE visita_servicio (
    id_visita INT,
    id_servicio INT,
    cantidad INT,
    PRIMARY KEY (id_visita, id_servicio),
    FOREIGN KEY (id_visita) REFERENCES visita_veterinaria(id_visita),
    FOREIGN KEY (id_servicio) REFERENCES servicio(id_servicio)
);

select*from mascota