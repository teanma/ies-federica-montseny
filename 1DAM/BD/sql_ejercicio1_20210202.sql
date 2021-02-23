
CREATE DATABASE if not exists gestionanimales;

USE gestionanimales;

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

/*INDEX*/

DROP TABLE IF EXISTS employees;

CREATE TABLE IF NOT EXISTS employees (
id INT,
name_employee VARCHAR(30),
age INT,
INDEX (id)
);
/* CUIDADO CON BORRAR TABLAS */
DROP INDEX id ON employees;
/*Cuando la tabla ya está creada*/
CREATE INDEX IDX_id ON employees (id);

DROP INDEX IDX_id ON employees;

SHOW CREATE TABLE employees;

/* AUTO INCREMENT */

DROP TABLE IF EXISTS employees;

CREATE TABLE IF NOT EXISTS employees (
id INT AUTO_INCREMENT,
name_employee VARCHAR(30),
age INT,
PRIMARY KEY (id)
);

ALTER TABLE employees
MODIFY id INT;

ALTER TABLE employees
MODIFY id INT AUTO_INCREMENT;

SHOW CREATE TABLE employees; 

DROP TABLE IF EXISTS employees;

/* PRIMARY KEY */

CREATE TABLE IF NOT EXISTS employees (
id INT AUTO_INCREMENT, 
name_employee VARCHAR(30), 
age INT,
PRIMARY KEY (id)
);

DROP TABLE employees;

CREATE TABLE employees ( 
	id_employee INT, 
    nombre VARCHAR(30), 
    edad int
);

show create table employees;

ALTER TABLE employees
ADD CONSTRAINT PK_employee PRIMARY KEY(id_employee);

alter table employees
modify id int AUTO_INCREMENT;

ALTER TABLE employees
MODIFY id INT;




/* PRIMARY KEY */
/* FOREIGN KEY */
DROP TABLE IF EXISTS employees;

CREATE TABLE IF NOT EXISTS employees ( 
	id_employee INT not null auto_increment, 
    nombre VARCHAR(30), 
    edad int,
    PRIMARY KEY (id_employee)
);

CREATE TABLE IF NOT EXISTS employees ( 
	id_employee INT not null auto_increment, 
    nombre VARCHAR(30), 
    edad int,
    PRIMARY KEY (id_employee, nombre)
);

CREATE TABLE IF NOT EXISTS employees ( 
	id_employee INT not null auto_increment PRIMARY KEY, 
    nombre VARCHAR(30), 
    edad int
);

SHOW CREATE TABLE employees;

ALTER TABLE employees 
MODIFY id_employee INT NOT NULL AUTO_INCREMENT PRIMARY KEY;

ALTER TABLE employees
ADD CONSTRAINT PK_Employee PRIMARY KEY (id_employee);

ALTER TABLE employees 
DROP primary key;

ALTER TABLE tasks
ADD COLUMN id_employee INT;

ALTER TABLE tasks 
DROP primary key;

SHOW CREATE TABLE employees;

/* DEFAULT */

DROP TABLE IF EXISTS employees;

CREATE TABLE IF NOT EXISTS employees ( 
	id_employee INT not null auto_increment PRIMARY KEY, 
    nombre VARCHAR(30) NOT NULL, 
    edad int
);

ALTER TABLE employees
ALTER edad SET DEFAULT 0;

ALTER TABLE employees
ALTER nombre SET DEFAULT 'NOMBRE';

ALTER TABLE employees
ALTER edad DROP DEFAULT;

/* foreign key*/

ALTER TABLE tasks
ADD CONSTRAINT FK_EmployeeTasks
FOREIGN KEY (id_employee) REFERENCES employees(id_employee);

ALTER TABLE tasks
ADD foreign key (id_employee) REFERENCES employees(id_employee);

ALTER TABLE tasks 
DROP FOREIGN KEY tasks_ibfk_1;

ALTER TABLE tasks 
DROP FOREIGN KEY FK_EmployeeTasks;