CREATE DATABASE IF NOT EXISTS game_management;

USE game_management;

/*Ejercicio 1*/

CREATE TABLE IF NOT EXISTS genres (
id INT AUTO_INCREMENT PRIMARY KEY,
genres_name VARCHAR(60) NOT NULL
);

CREATE TABLE IF NOT EXISTS games (
id INT AUTO_INCREMENT PRIMARY KEY,
genres_id INT NOT NULL,
games_name VARCHAR(60) NOT NULL,
FOREIGN KEY (genres_id) REFERENCES genres (id)
);

CREATE TABLE IF NOT EXISTS publishers (
id INT AUTO_INCREMENT PRIMARY KEY,
publisher_names VARCHAR(60) NOT NULL
);

CREATE TABLE IF NOT EXISTS game_publishers (
id INT AUTO_INCREMENT PRIMARY KEY,
games_id INT NOT NULL,
publishers_id INT NOT NULL,
FOREIGN KEY (games_id) REFERENCES games (id),
FOREIGN KEY (publishers_id) REFERENCES publishers (id) 
);

SHOW CREATE TABLE game_publishers;

CREATE TABLE IF NOT EXISTS platforms (
id INT AUTO_INCREMENT PRIMARY KEY,
platform_names VARCHAR(60) NOT NULL
);

CREATE TABLE IF NOT EXISTS game_platforms (
id INT AUTO_INCREMENT PRIMARY KEY,
game_publishers_id INT NOT NULL,
platforms_id INT NOT NULL,
release_years INT NOT NULL,
FOREIGN KEY (game_publishers_id) REFERENCES game_publishers (id),
FOREIGN KEY (platforms_id) REFERENCES platforms (id)
);

CREATE TABLE IF NOT EXISTS regions (
id INT,
region_names VARCHAR(60) NOT NULL
);

CREATE TABLE IF NOT EXISTS region_sales (
regions_id INT,
game_platforms_id INT NOT NULL,
num_sales INT NOT NULL
);

SHOW CREATE TABLE region_sales;

ALTER TABLE regions
ADD CONSTRAINT PK_reg_id PRIMARY KEY (id);

ALTER TABLE region_sales
ADD CONSTRAINT PK_regsales_reg PRIMARY KEY (regions_id, game_platforms_id),
ADD CONSTRAINT FK_regsales_reg FOREIGN KEY (regions_id) REFERENCES regions (id),
ADD CONSTRAINT FK_regsales_gameplat FOREIGN KEY (game_platforms_id) REFERENCES game_platforms (id);

/*Ejercicio 2*/

CREATE INDEX idx_genres ON genres (id);

CREATE INDEX idx_games ON games (id, genres_id);

CREATE INDEX idx_game_publishers ON game_publishers (id, games_id, publishers_id);

CREATE INDEX idx_game_platforms ON game_platforms (id, game_publishers_id, platforms_id);

CREATE INDEX idx_platforms ON platforms (id);

CREATE INDEX idx_region_sales ON region_sales (regions_id, game_platforms_id);

CREATE INDEX idx_regions ON regions (id);

/*Ejercicio 3*/ 

ALTER TABLE publishers
ADD CONSTRAINT uc_publisher_names
UNIQUE (publisher_names);

ALTER TABLE regions
ADD CONSTRAINT uc_region_names
UNIQUE (region_names);

ALTER TABLE game_platforms
ALTER release_years SET DEFAULT '1989';

ALTER TABLE region_sales
ALTER num_sales SET DEFAULT '0';

ALTER TABLE game_platforms
ADD CONSTRAINT CHK_release_years CHECK (release_years >= 1989);

ALTER TABLE region_sales
ADD CONSTRAINT CHK_num_sales CHECK (num_sales >= 0);

/*Ejercicio 4*/

DROP INDEX uc_publisher_names ON publishers;

DROP INDEX uc_region_names ON regions;

ALTER TABLE game_platforms
ALTER release_years DROP DEFAULT;

ALTER TABLE region_sales
ALTER num_sales DROP DEFAULT;

ALTER TABLE game_platforms
DROP CHECK CHK_release_years;

ALTER TABLE region_sales
DROP CHECK CHK_num_sales;