CREATE DATABASE if not exists test;

USE test;

SHOW DATABASES;

SHOW TABLES;

/* 
Creación de la tabla de mascotas
*/

CREATE TABLE IF NOT EXISTS pets (
name varchar(20),
owner varchar(20),
species varchar(20),
sex char(1),
birth date,
death date
);

DESCRIBE pets;

/*
Creación de la tabla de empleados
*/

CREATE TABLE IF NOT EXISTS empleados (
id INT,
nombre VARCHAR(30),
edad int
);

SHOW TABLES;

DESCRIBE empleados;


