-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema eShopDB
-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `eShopDB` DEFAULT CHARACTER SET utf8 ;
USE `eShopDB` ;

CREATE TABLE IF NOT EXISTS `eShopDB`.`user` (
  `username` VARCHAR(16) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `first name` VARCHAR(45) NOT NULL,
  `last name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(45) NULL,
  `birthdate` DATE NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `eShopDB`.`product` (
  `idproduct` INT NOT NULL,
  `pname` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `stock` INT NOT NULL,
  `price` FLOAT NOT NULL,
  `image_source` VARCHAR(100) NULL,
  PRIMARY KEY (`idproduct`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `eShopDB`.`category` (
  `category_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`category_name`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `eShopDB`.`cart` (
  `username_FK` VARCHAR(16) NOT NULL,
  `idproduct_cart_FK` INT NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`username_FK`, `idproduct_cart_FK`),
  KEY `username_FK`(`username_FK`),
  INDEX `idproduct_idx` (`idproduct_cart_FK` ASC) VISIBLE,
  CONSTRAINT `username_FK`
    FOREIGN KEY (`username_FK`)
    REFERENCES `eShopDB`.`user` (`username`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idproduct_cart_FK`
    FOREIGN KEY (`idproduct_cart_FK`)
    REFERENCES `eShopDB`.`product` (`idproduct`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `eShopDB`.`belongsTo` (
  `idproduct_belongsto_FK` INT NOT NULL,
  `category_name_FK` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idproduct_belongsto_FK`, `category_name_FK`),
  INDEX `category_name_idx` (`category_name_FK` ASC) VISIBLE,
  CONSTRAINT `idproduct_belongsto_FK`
    FOREIGN KEY (`idproduct_belongsto_FK`)
    REFERENCES `eShopDB`.`product` (`idproduct`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `category_name_FK`
    FOREIGN KEY (`category_name_FK`)
    REFERENCES `eShopDB`.`category` (`category_name`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
