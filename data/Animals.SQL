/*
Created: 11.04.2023
Modified: 11.04.2023
Model: MySQL 8.0
Database: MySQL 8.0
*/

-- Table animal

CREATE TABLE `animal`
(
  `id` Int NOT NULL AUTO_INCREMENT,
  `animal_name` Varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
)
;

-- Table home_animal

CREATE TABLE `home_animal`
(
  `id` Int NOT NULL AUTO_INCREMENT,
  `home_name` Varchar(20) NOT NULL,
  `livePlace` Varchar(20),
  `id_animal` Int,
  PRIMARY KEY (`id`)
)
;

CREATE INDEX `animal_home` ON `home_animal` (`id_animal`)
;

-- Table cat

CREATE TABLE `cat`
(
  `id` Int NOT NULL AUTO_INCREMENT,
  `cat_name` Varchar(30) NOT NULL,
  `date_birth` Date NOT NULL,
  `commands` Varchar(200),
  `color` Varchar(20),
  `id_home` Int,
  PRIMARY KEY (`id`)
)
;

CREATE INDEX `home_cat` ON `cat` (`id_home`)
;

-- Table dog

CREATE TABLE `dog`
(
  `id` Int NOT NULL AUTO_INCREMENT,
  `dog_name` Varchar(30) NOT NULL,
  `date_birth` Date NOT NULL,
  `commands` Varchar(200),
  `color` Varchar(20),
  `id_home` Int,
  PRIMARY KEY (`id`)
)
;

CREATE INDEX `home_dog` ON `dog` (`id_home`)
;

-- Table hamster

CREATE TABLE `hamster`
(
  `id` Int NOT NULL AUTO_INCREMENT,
  `hamster_name` Varchar(30) NOT NULL,
  `date_birth` Date NOT NULL,
  `commands` Varchar(200),
  `color` Varchar(20),
  `id_home` Int,
  PRIMARY KEY (`id`)
)
;

CREATE INDEX `home_hamster` ON `hamster` (`id_home`)
;


-- Table pack_animal

CREATE TABLE `pack_animal`
(
  `id` Int NOT NULL AUTO_INCREMENT,
  `pack_name` Varchar(20) NOT NULL,
  `livePlace` Varchar(20),
  `id_animal` Int,
  PRIMARY KEY (`id`)
)
;

CREATE INDEX `animal_pack` ON `pack_animal` (`id_animal`)
;



-- Table camel

CREATE TABLE `camel`
(
  `id` Int NOT NULL AUTO_INCREMENT,
  `name` Varchar(30) NOT NULL,
  `date_birth` Date NOT NULL,
  `commands` Varchar(200),
  `color` Varchar(20),
  `id_pack` Int,
  PRIMARY KEY (`id`)
)
;

CREATE INDEX `pack_camel` ON `camel` (`id_pack`)
;

-- Table horse

CREATE TABLE `horse`
(
  `id` Int NOT NULL AUTO_INCREMENT,
  `name` Varchar(30) NOT NULL,
  `date_birth` Date NOT NULL,
  `commands` Varchar(200),
  `color` Varchar(20),
  `id_pack` Int,
  PRIMARY KEY (`id`)
)
;

CREATE INDEX `pack_hourse` ON `horse` (`id_pack`)
;

-- Table mule

CREATE TABLE `mule`
(
  `id` Int NOT NULL AUTO_INCREMENT,
  `name` Varchar(30) NOT NULL,
  `date_birth` Date NOT NULL,
  `commands` Varchar(200),
  `color` Varchar(20),
  `id_pack` Int,
  PRIMARY KEY (`id`)
)
;

CREATE INDEX `pack_mule` ON `mule` (`id_pack`)
;

-- Create foreign keys (relationships) section -------------------------------------------------

ALTER TABLE `home_animal` ADD CONSTRAINT `animal_to_home` FOREIGN KEY (`id_animal`) REFERENCES `animal` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `cat` ADD CONSTRAINT `home_to_cat` FOREIGN KEY (`id_home`) REFERENCES `home_animal` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `dog` ADD CONSTRAINT `home_to_dog` FOREIGN KEY (`id_home`) REFERENCES `home_animal` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `hamster` ADD CONSTRAINT `home_to_hamster` FOREIGN KEY (`id_home`) REFERENCES `home_animal` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `camel` ADD CONSTRAINT `pack_to_camel` FOREIGN KEY (`id_pack`) REFERENCES `pack_animal` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `horse` ADD CONSTRAINT `pack_to_horse` FOREIGN KEY (`id_pack`) REFERENCES `pack_animal` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `mule` ADD CONSTRAINT `pack_to_mule` FOREIGN KEY (`id_pack`) REFERENCES `pack_animal` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

