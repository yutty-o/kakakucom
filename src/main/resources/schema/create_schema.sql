DROP TABLE IF EXISTS `kakakucom`.`conversion`;
DROP TABLE IF EXISTS `kakakucom`.`item_bookmark`;
DROP TABLE IF EXISTS `kakakucom`.`store_item`;
DROP TABLE IF EXISTS `kakakucom`.`store_review`;
DROP TABLE IF EXISTS `kakakucom`.`item_review`;
DROP TABLE IF EXISTS `kakakucom`.`items`;
DROP TABLE IF EXISTS `kakakucom`.`stores`;
DROP TABLE IF EXISTS `kakakucom`.`users`;
DROP TABLE IF EXISTS `kakakucom`.`small_category`;
DROP TABLE IF EXISTS `kakakucom`.`large_category`;


CREATE TABLE IF NOT EXISTS `kakakucom`.`large_category` (
  `large_category_cd` VARCHAR(32) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`large_category_cd`))
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `kakakucom`.`small_category` (
  `small_category_cd` VARCHAR(32) NOT NULL,
  `large_category_cd` VARCHAR(32) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`small_category_cd`),
  INDEX `large_category_cd_idx` (`large_category_cd` ASC),
  CONSTRAINT `large_category_cd`
  FOREIGN KEY (`large_category_cd`)
  REFERENCES `kakakucom`.`large_category` (`large_category_cd`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `kakakucom`.`users` (
  `user_id` INT(6) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) NULL,
  `password` VARCHAR(32) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `is_deleted` TINYINT(1) NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC));

CREATE TABLE IF NOT EXISTS `kakakucom`.`stores` (
  `store_id` INT(6) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `url` VARCHAR(2083) NULL,
  `address` VARCHAR(255) NULL,
  `tel` VARCHAR(20) NULL,
  `bank_pay` TINYINT NULL,
  `credit_pay` TINYINT NULL,
  `convenience_pay` TINYINT NULL,
  PRIMARY KEY (`store_id`))
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `kakakucom`.`items` (
  `item_id` INT(6) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `image_path` VARCHAR(255) NULL,
  `large_category_cd` VARCHAR(32) NOT NULL,
  `small_category_cd` VARCHAR(32) NOT NULL,
  `description` TEXT NOT NULL,
  PRIMARY KEY (`item_id`),
  INDEX `item_large_category_cd_idx` (`large_category_cd` ASC),
  INDEX `item_small_category_cd_idx` (`small_category_cd` ASC),
  CONSTRAINT `item_large_category_cd`
  FOREIGN KEY (`large_category_cd`)
  REFERENCES `kakakucom`.`large_category` (`large_category_cd`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `item_small_category_cd`
  FOREIGN KEY (`small_category_cd`)
  REFERENCES `kakakucom`.`small_category` (`small_category_cd`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `kakakucom`.`item_review` (
  `review_id` INT NOT NULL AUTO_INCREMENT,
  `item_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `title` VARCHAR(255) NULL,
  `content` TEXT NULL,
  PRIMARY KEY (`review_id`),
  INDEX `item_id_idx` (`item_id` ASC),
  INDEX `user_id_idx` (`user_id` ASC),
  CONSTRAINT `item_review_item_id`
  FOREIGN KEY (`item_id`)
  REFERENCES `kakakucom`.`items` (`item_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `item_review_user_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `kakakucom`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `kakakucom`.`store_review` (
  `review_id` INT NOT NULL AUTO_INCREMENT,
  `store_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `title` VARCHAR(255) NULL,
  `content` TEXT NULL,
  PRIMARY KEY (`review_id`),
  INDEX `store_id_idx` (`store_id` ASC),
  INDEX `user_id_idx` (`user_id` ASC),
  CONSTRAINT `store_review_store_id`
  FOREIGN KEY (`store_id`)
  REFERENCES `kakakucom`.`stores` (`store_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `store_review_user_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `kakakucom`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `kakakucom`.`store_item` (
  `store_item_id` INT NOT NULL AUTO_INCREMENT,
  `store_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  `price` INT NOT NULL,
  `stock` INT NOT NULL,
  `shipping_period` VARCHAR(32) NULL,
  `area` VARCHAR(32) NULL,
  `comment` VARCHAR(255) NULL,
  `color` VARCHAR(6) NOT NULL,
  `url` VARCHAR(2083) NULL,
  `is_deleted` TINYINT NULL,
  PRIMARY KEY (`store_item_id`),
  INDEX `item_id_idx` (`item_id` ASC),
  CONSTRAINT `store_item_store_id`
  FOREIGN KEY (`store_id`)
  REFERENCES `kakakucom`.`stores` (`store_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `store_item_item_id`
  FOREIGN KEY (`item_id`)
  REFERENCES `kakakucom`.`items` (`item_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `kakakucom`.`conversion` (
  `store_item_id` INT NOT NULL,
  `cnt` BIGINT(20) NULL,
  PRIMARY KEY (`store_item_id`),
  INDEX `store_item_id_idx` (`store_item_id` ASC),
  CONSTRAINT `store_item_id`
  FOREIGN KEY (`store_item_id`)
  REFERENCES `kakakucom`.`store_item` (`store_item_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `kakakucom`.`item_bookmark` (
  `bookmark_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  PRIMARY KEY (`bookmark_id`),
  INDEX `bookmark_user_id_idx` (`user_id` ASC),
  INDEX `bookmark_item_id_idx` (`item_id` ASC),
  CONSTRAINT `bookmark_user_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `kakakucom`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `bookmark_item_id`
  FOREIGN KEY (`item_id`)
  REFERENCES `kakakucom`.`items` (`item_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB

