CREATE TABLE stuffie (
	id SERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	type VARCHAR(255),
	manufacturer INT NOT NULL,
	owner INT NOT NULL,
	country INT NOT NULL,
	imagefile VARCHAR(255)
);

CREATE TABLE manufacturer (
	id SERIAL PRIMARY KEY,
	name varchar(255) NOT NULL
);

CREATE TABLE owner (
	id SERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL
);

CREATE TABLE country (
	id SERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL
);

ALTER TABLE stuffie ADD CONSTRAINT fk_stuffie_manufacturer FOREIGN KEY (manufacturer) REFERENCES manufacturer;
ALTER TABLE stuffie ADD CONSTRAINT fk_stuffie_owner FOREIGN KEY (owner) REFERENCES owner;
ALTER TABLE stuffie ADD CONSTRAINT fk_stuffie_country FOREIGN KEY (country) REFERENCES country;

INSERT INTO country (id, name) VALUES (0, 'USA');
INSERT INTO country (id, name) VALUES (1, 'UK');
ALTER SEQUENCE country_id_seq RESTART WITH 2;

INSERT INTO owner (id, name) VALUES (0, 'Alex');
INSERT INTO owner (id, name) VALUES (1, 'Sophie');
INSERT INTO owner (id, name) VALUES (2, 'Adam');
ALTER SEQUENCE owner_id_seq RESTART WITH 3;

INSERT INTO manufacturer (id, name) VALUES (0, 'AlpacaTui');
INSERT INTO manufacturer (id, name) VALUES (1, 'Apricot Lamb');
INSERT INTO manufacturer (id, name) VALUES (2, 'Aurora');
INSERT INTO manufacturer (id, name) VALUES (3, 'Douglas');
INSERT INTO manufacturer (id, name) VALUES (4, 'Fiesta');
INSERT INTO manufacturer (id, name) VALUES (5, 'HBL');
INSERT INTO manufacturer (id, name) VALUES (6, 'Impact');
INSERT INTO manufacturer (id, name) VALUES (7, 'Jazwares');
INSERT INTO manufacturer (id, name) VALUES (8, 'Jellycat');
INSERT INTO manufacturer (id, name) VALUES (9, 'Keeleco');
INSERT INTO manufacturer (id, name) VALUES (10, 'Kenji');
INSERT INTO manufacturer (id, name) VALUES (11, 'Moulin Roty');
INSERT INTO manufacturer (id, name) VALUES (12, 'Pillow Pets');
INSERT INTO manufacturer (id, name) VALUES (13, 'Squishable');
INSERT INTO manufacturer (id, name) VALUES (14, 'Ty');
INSERT INTO manufacturer (id, name) VALUES (15, 'Warmies');
ALTER SEQUENCE manufacturer_id_seq RESTART WITH 16;

INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (0, 'Squawk', 'Parrot', 9, 1, 0, 'IMG20250821142006.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (1, 'Banana Slug', 'Slug', 6, 2, 0, 'IMG20250821142035.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (2, 'Cattycat', 'Cat', 2, 0, 0, 'IMG20250821141818.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (3, 'Cheesy Cat', 'Cat', 2, 0, 0, 'IMG20250821141809.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (4, 'Claude', 'Aligator', 4, 1, 0, 'IMG20250821142051.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (5, 'Croak', 'Frog', 10, 2, 1, 'IMG20250810084652.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (6, 'Fluffy', null, 0, 1, 0, 'IMG20250821142023.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (7, 'Froggy', 'Frog', 13, 2, 0, 'IMG20250821142304.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (8, 'Ginger', 'Cat', 8, 0, 0, 'IMG20250821144419.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (9, 'Smokey', 'Cat', 8, 1, 0, 'IMG20250821144355.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (10, 'Snowy', 'Cat', 8, 2, 0, 'IMG20250821144413.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (11, 'Harry Potter Squishamallow', 'Human', 7, 0, 0, 'IMG20250821141754.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (12, 'Kittycorn', 'Kittycorn', 14, 1, 0, 'IMG20250821142108.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (13, 'Lavey', 'Hamster', 15, 1, 0, 'IMG20250821141836.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (14, 'Livey', 'Hamster', 15, 1, 0, 'IMG20250821141844.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (15, 'Lovey', 'Hamster', 15, 1, 1, 'IMG20250810084628.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (16, 'Other Snaily', 'Snail', 1, 2, 0, 'IMG20250821141909.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (17, 'Pikachu', 'Pokemon', 7, 0, 0, 'IMG20250821142228.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (18, 'Snorlax', 'Pokemon', 7, 0, 0, 'IMG20250821141744.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (19, 'Big Snorlax', 'Pokemon', 7, 0, 0, 'IMG20250821142139.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (20, 'Salty', 'Crab', 2, 2, 0, 'IMG20250821141939.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (21, 'Snaily', 'Snail', 3, 2, 0, 'IMG20250821141924.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (22, 'Socks', 'Cat', 3, 1, 0, 'IMG20250821141730.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (23, 'Texas', 'State', 12, 0, 0, 'IMG20250821142252.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (24, 'Mad Eye', 'Dog', 11, 2, 0, 'IMG20250821141955.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (25, 'Blue', 'Axolotl', 5, 2, 1, 'IMG20250808175816.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (26, 'Pink', 'Axolotl', 5, 1, 1, 'IMG20250808175758.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (27, 'Big Blue', 'Axolotl', 5, 2, 1, 'IMG20250808175827.jpg');
INSERT INTO stuffie (id, name, type, manufacturer, owner, country, imagefile) VALUES (28, 'Big Pink', 'Axolotl', 5, 1, 1, 'IMG20250808175844.jpg');
ALTER SEQUENCE stuffie_id_seq RESTART WITH 29;
