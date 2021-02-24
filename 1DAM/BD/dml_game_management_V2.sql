USE game_management;

-- 1. Crea los siguientes registros en la tabla genres
-- a. Mediante un solo comando: Action, Adventure, Fighting, Misc, Platform, Puzzle, 
-- b. Cada opción un comando en un insert: Racing, Role-Playing, Shooter, Simulation, Sports, Strategy

INSERT INTO genres (genres_name) VALUES ('Action'), ('Adventure'), ('Fighting'), ('Misc'), ('Platform'), ('Puzzle');

SELECT * FROM genres;

INSERT INTO genres (genres_name) VALUES ('Racing');
INSERT INTO genres (genres_name) VALUES ('Role-Playing');
INSERT INTO genres (genres_name) VALUES ('Shooter');
INSERT INTO genres (genres_name) VALUES ('Simulation');
INSERT INTO genres (genres_name) VALUES ('Sports');
INSERT INTO genres (genres_name) VALUES ('Strategy');

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

INSERT INTO publishers (publisher_names) VALUES ('10TACLE Studios'), ('1C Company'), ('20th Century Fox Video Games'), ('Activision'), ('Activision Blizzard'), ('Activision Value');

SELECT * FROM publishers;

-- 4. Crea los siguientes registros en la tabla regions mediante un solo comando insert
-- (1,'North America'),(2,'Europe'),(3,'Japan'),(4,'Other')

INSERT INTO regions (region_names) VALUES ('North America'), ('Europe'), ('Japan'), ('Other');

SELECT * FROM regions;

-- 5. Crea los campos 'created_at' y 'updated_at' para las siguientes tablas:
-- a. game, game_publisher y game_platform
-- b. NOTA: los campos deben guardar por defecto la fecha actual

ALTER TABLE games ADD (
created_at DATETIME DEFAULT NOW(),
updated_at DATETIME DEFAULT NOW()
);

INSERT INTO games (genres_id, games_name)
VALUES (CURRENT_TIME(), CURRENT_TIME());

SELECT * FROM games;

ALTER TABLE game_publishers ADD (
created_at DATETIME DEFAULT NOW(),
updated_at DATETIME DEFAULT NOW()
);

INSERT INTO game_publishers (games_id, publishers_id)
VALUES (CURRENT_TIME(), CURRENT_TIME());

SELECT * FROM game_publishers;

ALTER TABLE game_platforms ADD (
created_at DATETIME DEFAULT NOW(),
updated_at DATETIME DEFAULT NOW()
);

INSERT INTO game_platforms (game_publishers_id, platforms_id, release_years)
VALUES (CURRENT_TIME(), CURRENT_TIME(), CURRENT_TIME());

SELECT * FROM game_platforms;