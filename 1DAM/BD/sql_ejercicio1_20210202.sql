CREATE DATABASE if not exists gestionanimales;

USE gestionanimales;

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

/*
IMPORTANTE: REALIZAR COPIAS DE SEGURIDAD 
DE LA BASE DE DATOS 
*/

/* Cuidado con esta instrucción 
Comentamos para que no se elimine la tabla */

/* DROP TABLE empleados;*/

ALTER TABLE empleados RENAME TO employees;

/*
Cuidado con esta instrucción
porque elimina los datos de una tabla
*/
/*TRUNCATE TABLE employees;*/

ALTER TABLE employees ADD (
oficina int
);

DESCRIBE employees;

ALTER TABLE employees ADD (
jefe VARCHAR(20),
departamento BIT
);

/*
Cuidado al eliminar un campo, porque eliminas
los datos del mismo
*/

ALTER TABLE employees DROP COLUMN jefe;

DESCRIBE employees;

ALTER TABLE employees ADD (
boss VARCHAR(2)
);

ALTER TABLE employees MODIFY boss VARCHAR(20);

DROP TABLE tasks;

CREATE TABLE tasks (
id INT NOT NULL,
title VARCHAR(255) NOT NULL,
start_date DATE,
end_date DATE,
price INT CHECK (price > 0)
);

ALTER TABLE tasks
DROP CHECK tasks_chk_1;

ALTER TABLE tasks
ADD CONSTRAINT tas_tit_uk
UNIQUE (title);

SHOW INDEXES FROM tasks;

DESCRIBE tasks;

/* DDL DE UNA TABLE*/
SHOW CREATE TABLE employees;

/*LISTADO DE TABLAS*/
SHOW TABLES;
