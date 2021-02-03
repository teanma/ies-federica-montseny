<<<<<<< HEAD
CREATE DATABASE if not exists prueba;

=======
>>>>>>> c48ba579b9f39507b86fbd9ee239f976667a6ca4
USE prueba;

CREATE TABLE usuarios (
id INT PRIMARY KEY,
dni VARCHAR(9) UNIQUE,
nombre VARCHAR(50) NOT NULL,
edad INT
);