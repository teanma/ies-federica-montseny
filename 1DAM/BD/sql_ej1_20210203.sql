CREATE DATABASE if not exists test;

USE test;

SHOW DATABASES;

SHOW TABLES;

CREATE TABLE if not exists pets (
	name VARCHAR(20),
    owner VARCHAR(20),
    species VARCHAR(20),
    sex CHAR(1),
    birth DATE,
    death DATE
);

DESCRIBE pets;