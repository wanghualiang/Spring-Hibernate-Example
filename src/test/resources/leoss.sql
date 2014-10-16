SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `LEOSS` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `LEOSS` ;

-- -----------------------------------------------------
-- Table `LEOSS`.`USER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `LEOSS`.`USER` ;

CREATE  TABLE IF NOT EXISTS `LEOSS`.`USER` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `login_name` VARCHAR(128) NOT NULL ,
  `password` VARCHAR(64) NULL ,
  `contact_name` VARCHAR(128) NULL ,
  `email` VARCHAR(128) NOT NULL ,
  `phone` CHAR(16) NOT NULL ,
  `company_type` VARCHAR(128) NULL ,
  `company_name` VARCHAR(256) NULL ,
  `company_site` VARCHAR(128) NULL ,
  `space_limit` BIGINT NULL ,
  `space_used` BIGINT NULL ,
  `flux_limit` BIGINT NULL ,
  `flux_used` BIGINT NULL ,
  `ctime` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `login_name_UNIQUE` (`login_name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LEOSS`.`KEY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `LEOSS`.`KEY` ;

CREATE  TABLE IF NOT EXISTS `LEOSS`.`KEY` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `access_key` VARCHAR(128) NULL ,
  `secret_key` VARCHAR(128) NULL ,
  `user_id` INT NULL ,
  `status` INT NULL ,
  `ctime` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `user_id_idx` (`user_id` ASC) ,
  UNIQUE INDEX `access_key_UNIQUE` (`access_key` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LEOSS`.`REGION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `LEOSS`.`REGION` ;

CREATE  TABLE IF NOT EXISTS `LEOSS`.`REGION` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(64) NULL ,
  `location` VARCHAR(128) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) )
ENGINE = InnoDB
COMMENT = '数据中心信息表。';


-- -----------------------------------------------------
-- Table `LEOSS`.`BUCKET`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `LEOSS`.`BUCKET` ;

CREATE  TABLE IF NOT EXISTS `LEOSS`.`BUCKET` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(128) NULL ,
  `user_id` INT NULL ,
  `region_id` INT NULL ,
  `space_limit` BIGINT NULL ,
  `space_used` BIGINT NULL ,
  `flux_limit` BIGINT NULL ,
  `flux_used` BIGINT NULL ,
  `ctime` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) ,
  INDEX `region_id_idx` (`region_id` ASC) ,
  INDEX `user_id_idx` (`user_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LEOSS`.`LOG`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `LEOSS`.`LOG` ;

CREATE  TABLE IF NOT EXISTS `LEOSS`.`LOG` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `user_id` INT NULL ,
  `category` VARCHAR(64) NULL ,
  `action` VARCHAR(64) NULL ,
  `operand` VARCHAR(1024) NULL ,
  `ctime` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `user_id_idx` (`user_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `LEOSS`.`STATISTICS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `LEOSS`.`STATISTICS` ;

CREATE  TABLE IF NOT EXISTS `LEOSS`.`STATISTICS` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `user_id` INT NULL ,
  `bucket_id` INT NULL ,
  `space` BIGINT NULL ,
  `flux` BIGINT NULL ,
  `right_get_num` BIGINT NULL ,
  `right_put_num` BIGINT NULL ,
  `wrong_get_num` BIGINT NULL ,
  `wrong_put_num` BIGINT NULL ,
  `date` DATE NULL ,
  `hour` INT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `user_id_idx` (`user_id` ASC) ,
  INDEX `bucket_id_idx` (`bucket_id` ASC) )
ENGINE = InnoDB
COMMENT = '统计信息表。以为单位。';

USE `LEOSS` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
