USE game_management;

-- 1. Crea los siguientes registros en la tabla genres
-- a. Mediante un solo comando: Action, Adventure, Fighting, Misc, Platform, Puzzle, 
-- b. Cada opción un comando en un insert: Racing, Role-Playing, Shooter, Simulation, Sports, Strategy

INSERT INTO genres VALUES (NULL, 'Action'), (NULL, 'Adventure'), (NULL, 'Fighting'), (NULL, 'Misc'), (NULL, 'Platform'), (NULL, 'Puzzle');
INSERT INTO genres VALUES (NULL, 'Racing');
INSERT INTO genres VALUES (NULL, 'Role-Playing');
INSERT INTO genres VALUES (NULL, 'Shooter');
INSERT INTO genres VALUES (NULL, 'Simulation');
INSERT INTO genres VALUES (NULL, 'Sports');
INSERT INTO genres VALUES (NULL, 'Strategy');

SELECT * FROM genres;

-- 2. Crea los siguientes registros en la tabla platforms
-- (1,'Wii U'),(2,'PS5'),(3,'XBOX ONE'),(4,'PS3')
-- (5,'3DS'),(6,'PS4'),(7,'PC')

INSERT INTO platforms VALUES (NULL, 'Wii U');
INSERT INTO platforms VALUES (NULL, 'PS5');
INSERT INTO platforms VALUES (NULL, 'XBOX ONE');
INSERT INTO platforms VALUES (NULL, 'PS3');
INSERT INTO platforms VALUES (NULL, '3DS');
INSERT INTO platforms VALUES (NULL, 'PS4');
INSERT INTO platforms VALUES (NULL, 'PC');

SELECT * FROM platforms;

-- 3. Crea los siguientes registros en la tabla publisers mediante un solo comando insert
-- (1,'10TACLE Studios'),(2,'1C Company'),(3,'20th Century Fox Video Games')
-- (4,'Activision'),(5,'Activision Blizzard'),(6,'Activision Value')

INSERT INTO publishers VALUES (NULL, '10TACLE Studios'), (NULL, '1C Company'), (NULL, '20th Century Fox Video Games'), (NULL, 'Activision'), (NULL, 'Activision Blizzard'), (NULL, 'Activision Value');

SELECT * FROM publishers;

-- 4. Crea los siguientes registros en la tabla regions mediante un solo comando insert
-- (1,'North America'),(2,'Europe'),(3,'Japan'),(4,'Other')

INSERT INTO regions VALUES (NULL, 'North America'), (NULL, 'Europe'), (NULL, 'Japan'), (NULL, 'Other');

SELECT * FROM regions;

-- 5. Crea los campos 'created_at' y 'updated_at' para las siguientes tablas:
-- a. game, game_publisher y game_platform
-- b. NOTA: los campos deben guardar por defecto la fecha actual

ALTER TABLE games ADD (
created_at DATETIME DEFAULT NULL,
updated_at DATETIME DEFAULT NULL
);

INSERT INTO games (created_at, updated_at)
VALUES (CURRENT_TIME(), CURRENT_TIME());

SELECT * FROM games;

ALTER TABLE game_publishers ADD (
created_at DATETIME DEFAULT NULL,
updated_at DATETIME DEFAULT NULL
);

INSERT INTO game_publishers (created_at, updated_at)
VALUES (CURRENT_TIME(), CURRENT_TIME());

SELECT * FROM game_publishers;

ALTER TABLE game_platforms ADD (
created_at DATETIME DEFAULT NULL,
updated_at DATETIME DEFAULT NULL
);

INSERT INTO game_platforms (created_at, updated_at)
VALUES (CURRENT_TIME(), CURRENT_TIME());

SELECT * FROM game_platforms;