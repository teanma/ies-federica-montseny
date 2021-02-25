/* CREA LAS SIGUIENTES TABLAS */

CREATE DATABASE IF NOT EXISTS gestion_pub;

USE gestion_pub; 

/*Ejercicio 1*/

CREATE TABLE IF NOT EXISTS pub (
cod_pub INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(60) NOT NULL,
licencia_fiscal VARCHAR(60) NOT NULL,
domicilio VARCHAR(60),
codigo_localidad INT NOT NULL
);

CREATE TABLE IF NOT EXISTS titular (
dni_titular VARCHAR(9) PRIMARY KEY,
nombre VARCHAR(60) NOT NULL,
domicilio VARCHAR(60),
cod_pub INT NOT NULL
);

CREATE TABLE IF NOT EXISTS empleado (
dni_empleado VARCHAR(9) PRIMARY KEY,
nombre VARCHAR(60) NOT NULL,
domicilio VARCHAR(60)
);

CREATE TABLE IF NOT EXISTS existencias (
cod_articulo INT NOT NULL,
nombre VARCHAR(60) NOT NULL,
cantidad INT NOT NULL,
cod_pub INT NOT NULL
);

CREATE TABLE IF NOT EXISTS localidad (
cod_localidad INT NOT NULL,
nombre VARCHAR(60) NOT NULL
);

CREATE TABLE IF NOT EXISTS pub_empleado (
cod_pub INT NOT NULL,
dni_empleado VARCHAR(9) NOT NULL,
funcion VARCHAR(9) NOT NULL
);

/*Inserts*/

INSERT INTO pubs (nombre, licencia_fiscal)
VALUES ('Carpe Diem', 'B58483883');

INSERT INTO owners (nombre, domicilio)
VALUES ('Carpe Diem', 'Calle Bahía Nº3');

INSERT INTO employees (nombre, domicilio)
VALUES ('Santiago', 'Calle Naranjo Nº15');

INSERT INTO stocks (nombre, cantidad)
VALUES ('Ron', '23');

INSERT INTO cities (nombre, provincia)
VALUES ('Montgat', 'Barcelona');

INSERT INTO pub_employees (dni_empleado, funcion)
VALUES ('J29452475', 'Camarero');

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
provincia VARCHAR(50)
);

ALTER TABLE employees ADD (
edad INT
);

/*Ejercicio 4*/

ALTER TABLE stocks
ADD CONSTRAINT PK_stocks PRIMARY KEY(cod_articulo);

ALTER TABLE cities
ADD CONSTRAINT PK_cod_localidad PRIMARY KEY(cod_localidad);

ALTER TABLE pub_employees
ADD CONSTRAINT PK_pub_employees PRIMARY KEY(dni_empleado, cod_pub, funcion);

/*Ejercicio 5*/

ALTER TABLE pubs
MODIFY fecha_apertura DATE NOT NULL;

ALTER TABLE pubs
MODIFY horario DATE NOT NULL;

ALTER TABLE employees
MODIFY provincia VARCHAR(60) NOT NULL;

ALTER TABLE stocks
ADD CONSTRAINT chk_stocks_price CHECK (precio > 0);

ALTER TABLE stocks
ALTER precio SET DEFAULT 1;

CREATE INDEX idx_dni_nombre
ON owners (dni_titular, nombre);

ALTER TABLE stocks
ALTER cantidad SET DEFAULT 1;

CREATE INDEX idx_cod_localidad_nombre
ON cities (cod_localidad, nombre);

/*Ejercicio 6*/

ALTER TABLE owners
DROP INDEX idx_dni_nombre;

ALTER TABLE stocks
ALTER cantidad DROP DEFAULT;

ALTER TABLE cities
DROP INDEX idx_cod_localidad_nombre;

ALTER TABLE stocks
DROP CHECK chk_stocks_price;

ALTER TABLE stocks
ALTER precio DROP DEFAULT;

/*Ejercicio 7*/

ALTER TABLE owners
ADD CONSTRAINT FK_pubs
FOREIGN KEY (cod_pub) REFERENCES pubs(cod_pub);

ALTER TABLE pub_employees
ADD CONSTRAINT FK_pub_employees
FOREIGN KEY (cod_pub) REFERENCES pubs(cod_pub);

ALTER TABLE pub_employees
ADD CONSTRAINT FK_employees
FOREIGN KEY (dni_empleado) REFERENCES employees(dni_empleado);

ALTER TABLE stocks
ADD CONSTRAINT FK_pub_stocks
FOREIGN KEY (cod_pub) REFERENCES pubs(cod_pub);

ALTER TABLE pubs
ADD CONSTRAINT FK_cities_pubs
FOREIGN KEY (cod_localidad) REFERENCES cities(cod_localidad);

/*Ejercicio 8*/

ALTER TABLE owners 
DROP FOREIGN KEY FK_pubs;

ALTER TABLE pub_employees 
DROP FOREIGN KEY FK_pub_employees;

ALTER TABLE pub_employees 
DROP FOREIGN KEY FK_employees;

ALTER TABLE stocks 
DROP FOREIGN KEY FK_pub_stocks;

ALTER TABLE pubs 
DROP FOREIGN KEY FK_cities_pubs;

/*Ejercicio 9*/

DROP TABLE owners;

DROP TABLE pubs;

DROP TABLE pub_employees;

CREATE TABLE pubs (
cod_pub INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(60) NOT NULL,
licencia_fiscal VARCHAR(60) NOT NULL,
domicilio VARCHAR(60),
codigo_localidad INT NOT NULL,
CONSTRAINT FK_cities_pubs
FOREIGN KEY (cod_localidad) REFERENCES localidad(cods_localidad)
);

CREATE TABLE owners (
dni_titular VARCHAR(9) PRIMARY KEY,
nombre VARCHAR(60) NOT NULL,
domicilio VARCHAR(60),
cod_pub INT NOT NULL,
CONSTRAINT FK_pubs
FOREIGN KEY (cod_pub) REFERENCES pubs(cod_pub)
);

CREATE TABLE pub_employees (
cod_pub INT NOT NULL,
dni_empleado VARCHAR(9) NOT NULL,
funcion VARCHAR(60) NOT NULL,
PRIMARY KEY (cod_pub, dni_empleado, funcion),
CONSTRAINT FK_pubs
FOREIGN KEY (cod_pub) REFERENCES pubs(cod_pub),
CONSTRAINT FK_employees
FOREIGN KEY (dni_empleado) REFERENCES emplopyees(dni_empleado)
);