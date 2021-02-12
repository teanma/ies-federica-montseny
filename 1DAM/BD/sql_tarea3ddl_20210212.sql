/* CREA LAS SIGUIENTES TABLAS */

CREATE DATABASE IF NOT EXISTS gestion_pub;

USE gestion_pub; 

/*Ejercicio 1*/

CREATE TABLE IF NOT EXISTS pub (
cod_pub INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(20) NOT NULL,
licencia_fiscal VARCHAR(20) NOT NULL,
domicilio VARCHAR(20),
codigo_localidad INT NOT NULL
);

CREATE TABLE IF NOT EXISTS titular (
dni_titular VARCHAR(9) PRIMARY KEY,
nombre VARCHAR(20) NOT NULL,
domicilio VARCHAR(20),
cod_pub INT NOT NULL
);

CREATE TABLE IF NOT EXISTS empleado (
dni_empleado VARCHAR(9) PRIMARY KEY,
nombre VARCHAR(20) NOT NULL,
domicilio VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS existencias (
cod_articulo INT NOT NULL,
nombre VARCHAR(20) NOT NULL,
cantidad INT NOT NULL,
cod_pub INT NOT NULL
);

CREATE TABLE IF NOT EXISTS localidad (
cod_localidad INT NOT NULL,
nombre VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS pub_empleado (
cod_pub INT NOT NULL,
dni_empleado VARCHAR(9) NOT NULL,
funcion VARCHAR(20) NOT NULL
);

/*Ejercicio 2*/

ALTER TABLE pub RENAME TO pubs;

ALTER TABLE empleado RENAME TO employees;

ALTER TABLE existencias RENAME TO stocks;

ALTER TABLE localidad RENAME TO cities;

ALTER TABLE titular RENAME TO owners;

ALTER TABLE pub_empleado RENAME TO pub_employees;

/*Ejercicio 3*/

ALTER TABLE pubs ADD (
fecha_apertura DATE,
horario DATE
);

ALTER TABLE stocks ADD (
precio INT
);

ALTER TABLE cities ADD (
provincia VARCHAR(20)
);

ALTER TABLE employees ADD (
edad INT NOT NULL
);

/*Ejercicio 4*/

ALTER TABLE stocks 
ADD CONSTRAINT sto_codart_pk
PRIMARY KEY (cod_articulo);

ALTER TABLE cities
ADD CONSTRAINT cit_codcit_pk
PRIMARY KEY (cod_localidad);

ALTER TABLE pub_employees
ADD CONSTRAINT pub_codpub_pk
PRIMARY KEY (cod_pub, dni_empleado, funcion); 

/*Ejercicio 5*/

ALTER TABLE pubs
MODIFY fecha_apertura DATE NOT NULL;

ALTER TABLE pubs
MODIFY horario VARCHAR(20) NOT NULL;

ALTER TABLE employees
MODIFY provincia VARCHAR(20) NOT NULL;

ALTER TABLE stocks
MODIFY precio INT CHECK (precio > 0);

ALTER TABLE stocks
MODIFY precio INT DEFAULT (precio = 1);
 
ALTER TABLE owners 
ADD INDEX id_owners (dni_titular, nombre);

ALTER TABLE stocks
MODIFY cantidad INT DEFAULT (cantidad = 1);

ALTER TABLE cities 
ADD INDEX id_cities (cod_localidad, nombre);

/*Ejercicio 6*/

ALTER TABLE owners 
DROP INDEX id_owners;

ALTER TABLE stocks 
ALTER cantidad DROP DEFAULT;

ALTER TABLE cities
DROP INDEX id_cities;

ALTER TABLE stocks
DROP CHECK CHK_stocks;

ALTER TABLE stocks
ALTER precio DROP DEFAULT;

/*Ejercicio 7*/

ALTER TABLE owners
ADD CONSTRAINT FK_pubs
FOREIGN KEY (cod_pub) REFERENCES pubs (cod_pub);

ALTER TABLE pub_employees
ADD CONSTRAINT FK_pub_employees
FOREIGN KEY (cod_pub) REFERENCES pubs (cod_pub);

ALTER TABLE pub_employees
ADD CONSTRAINT FK_employees
FOREIGN KEY (dni_empleado) REFERENCES employees (dni_empleado);

ALTER TABLE stocks
ADD CONSTRAINT FK_pub_stocks
FOREIGN KEY (cod_pub) REFERENCES pubs (cod_pub);
 
ALTER TABLE pubs
ADD CONSTRAINT FK_cities_stocks
FOREIGN KEY (cod_localidad) REFERENCES cities (cod_localidad); 

/*Ejercicio 8*/

alter table owners
drop foreign key FK_pubs;

alter table pub_employees
drop foreign key FK_pub_employees;

alter table pub_employees
drop foreign key FK_employees;

alter table stocks
drop foreign key FK_pub_stocks;

alter table pubs
drop foreign key FK_cities_pubs;

/*Ejercicio 9*/

DROP TABLE owners;

DROP TABLE pubs;

DROP TABLE pub_employees;

CREATE TABLE pub (
cod_pub INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(20) NOT NULL,
licencia_fiscal VARCHAR(20) NOT NULL,
domicilio VARCHAR(20),
codigo_localidad INT NOT NULL,
CONSTRAINT FK_cities_stocks
FOREIGN KEY (cod_localidad) REFERENCES localidad(cods_localidad)
);

CREATE TABLE owners (
dni_titular VARCHAR(9) PRIMARY KEY,
nombre VARCHAR(20) NOT NULL,
domicilio VARCHAR(20),
cod_pub INT NOT NULL,
CONSTRAINT FK_pubs
FOREIGN KEY (cod_pub) REFERENCES pubs(cod_pub)
);

CREATE TABLE pub_employees (
cod_pub INT NOT NULL,
dni_empleado VARCHAR(9) NOT NULL,
funcion VARCHAR(20) NOT NULL,
PRIMARY KEY (cod_pub, dni_empleado, funcion),
CONSTRAINT FK_pubs
FOREIGN KEY (cod_pub) REFERENCES pubs(cod_pub),
CONSTRAINT FK_employees
FOREIGN KEY (dni_empleado) REFERENCES emplopyees(dni_empleado)
);




