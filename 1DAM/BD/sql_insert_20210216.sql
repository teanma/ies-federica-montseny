
DROP TABLE employees;

CREATE TABLE `employees` (
`id_employee` int auto_increment PRIMARY KEY,
`nombre` varchar(30) NOT NULL,
apellido1 varchar(30) NOT NULL,
apellido2 VARCHAR(30),
`edad` int NOT NULL DEFAULT 18
);

SHOW CREATE TABLE employees;

INSERT INTO employees (id_employee, nombre, edad)
VALUES (1, 'Sergio', 30);

INSERT INTO employees (nombre, edad)
VALUES ('Pepe', 28);

INSERT INTO employees (nombre)
VALUES ('Julian', 'Apellido1', 'Apellido2', DEFAULT);

SELECT * FROM employees;

CREATE TABLE clientes (
id INT AUTO_INCREMENT PRIMARY KEY,
dni VARCHAR(9) NOT NULL,
nombre VARCHAR(30) NOT NULL,
ape1 VARCHAR(30) NOT NULL,
ape2 VARCHAR(30),
localidad VARCHAR(30) NOT NULL,
direccion VARCHAR(30) NOT NULL
);

INSERT INTO clientes (dni, nombre, ape1, ape2, localidad, direccion)
VALUES ('11111111H', 'Pedro', 'Gutierrez', NULL, '', ''),
('11111112H', 'Juan', 'Gutierrez', NULL, '', ''),
('11111113H', 'Jose', 'Gutierrez', NULL, '', '');

SELECT * FROM clientes;

DROP TABLE IF EXISTS tasks;

CREATE TABLE IF NOT EXISTS tasks (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(255) NOT NULL,
start_date DATETIME DEFAULT NULL,
end_date DATETIME DEFAULT NULL,
price int DEFAULT NULL,
id_employee int DEFAULT NULL,
creation_date DATETIME,
modification_date DATETIME
);

SHOW CREATE TABLE tasks;

INSERT INTO tasks (id, title, price, id_employee, start_date, end_date, creation_date, modification_date)
VALUES (NULL, 'formatear', 25, 1, CURRENT_DATE(), '2021-02-18', CURRENT_TIME(), CURRENT_TIME());

INSERT INTO tasks (id, title, price)
VALUES (NULL, 'formatear', 25);

SELECT * FROM tasks;