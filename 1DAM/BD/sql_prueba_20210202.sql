CREATE TABLE if not exists prueba;

USE prueba;

CREATE TABLE usuarios (
id INT PRIMARY KEY,
dni VARCHAR(9) UNIQUE,
nombre VARCHAR(50) NOT NULL,
edad INT
);