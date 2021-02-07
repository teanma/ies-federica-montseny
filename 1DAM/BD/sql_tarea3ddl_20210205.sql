/* CREA LAS SIGUIENTES TABLAS */

CREATE DATABASE IF NOT EXISTS gestion_pub;

USE gestion_pub; 

CREATE TABLE IF NOT EXISTS pub (
cod_pub INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(20),
licencia_fiscal VARCHAR(20),
domicilio VARCHAR(20),
codigo_localidad INT
);

CREATE TABLE IF NOT EXISTS titular (
dni_titular VARCHAR(9) NOT NULL PRIMARY KEY,
nombre VARCHAR(20),
domicilio VARCHAR(20),
cod_pub INT
);

CREATE TABLE IF NOT EXISTS empleado (
dni_empleado VARCHAR(9) NOT NULL PRIMARY KEY,
nombre VARCHAR(20),
domicilio VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS existencias (
cod_articulo VARCHAR(20),
nombre VARCHAR(20),
cantidad INT,
cod_pub INT
);

CREATE TABLE IF NOT EXISTS localidad (
cod_localidad INT,
nombre VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS pub_empleado (
cod_pub INT AUTO_INCREMENT,
dni_empleado VARCHAR(9),
funcion VARCHAR(20)
);
