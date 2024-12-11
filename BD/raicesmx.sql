-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `raices` DEFAULT CHARACTER SET utf8 ;
USE `raices` ;

-- -----------------------------------------------------
-- Table `mydb`.`Clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `raices`.`Clientes` (
  `id_clientes` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `apellido` VARCHAR(100) NOT NULL,
  `correo` VARCHAR(100) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(12) NOT NULL,
  `direccion` TEXT(200) NOT NULL,
  `ciudad` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `codigo_postal` VARCHAR(6) NOT NULL,
  `tipo_usuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_clientes`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Artesano`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `raices`.`Artesano` (
  `id_artesano` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `apellido` VARCHAR(100) NOT NULL,
  `empresa` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(100) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `direccion` TEXT(300) NOT NULL,
  `telefono` VARCHAR(15) NOT NULL,
  `codigo_postal` VARCHAR(6) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `tipo_usuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_artesano`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `raices`.`Categorias` (
  `id_categorias` INT NOT NULL AUTO_INCREMENT,
  `nombre_categoria` VARCHAR(45) NULL,
  PRIMARY KEY (`id_categorias`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `raices`.`Producto` (
  `id_producto` INT NOT NULL AUTO_INCREMENT,
  `Imagen_url` TEXT(300) NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `precio` DECIMAL(10,2) NOT NULL,
  `stock` INT NOT NULL,
  `Categorias_idCategorias` INT NOT NULL,
  `status` VARCHAR(45) NULL,
  `descripcion` TEXT(200) NOT NULL,
  `Artesano_idArtesano` INT NOT NULL,
  PRIMARY KEY (`id_producto`, `Categorias_idCategorias`),
  INDEX `fk_Producto_Artesano1_idx` (`Artesano_idArtesano` ASC) VISIBLE,
  INDEX `fk_Producto_Categorias1_idx` (`Categorias_idCategorias` ASC) VISIBLE,
  CONSTRAINT `fk_Producto_Artesano1`
    FOREIGN KEY (`Artesano_idArtesano`)
    REFERENCES `raices`.`Artesano` (`id_artesano`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_Categorias1`
    FOREIGN KEY (`Categorias_idCategorias`)
    REFERENCES `raices`.`Categorias` (`id_categorias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `raices`.`Pedido` (
  `id_pedido` INT NOT NULL AUTO_INCREMENT,
  `total` DECIMAL(10,2) NULL,
  `descripcion` TEXT(300) NULL,
  `estado_pedido` VARCHAR(100) NULL,
  `fecha` DATETIME NULL,
  `Clientes_idClientes` INT NOT NULL,
  PRIMARY KEY (`id_pedido`),
  INDEX `fk_Pedido_Clientes_idx` (`Clientes_idClientes` ASC) VISIBLE,
  CONSTRAINT `fk_Pedido_Clientes`
    FOREIGN KEY (`Clientes_idClientes`)
    REFERENCES `raices`.`Clientes` (`id_clientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pedido_has_Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `raices`.`Pedido_has_Producto` (
  `Pedido_id_pedido` INT NOT NULL,
  `Producto_idProducto` INT NOT NULL,
  `Producto_Categorias_idCategorias` INT NOT NULL,
  PRIMARY KEY (`Pedido_id_pedido`, `Producto_idProducto`, `Producto_Categorias_idCategorias`),
  INDEX `fk_Pedido_has_Producto_Producto1_idx` (`Producto_idProducto` ASC, `Producto_Categorias_idCategorias` ASC) VISIBLE,
  INDEX `fk_Pedido_has_Producto_Pedido1_idx` (`Pedido_id_pedido` ASC) VISIBLE,
  CONSTRAINT `fk_Pedido_has_Producto_Pedido1`
    FOREIGN KEY (`Pedido_id_pedido`)
    REFERENCES `raices`.`Pedido` (`id_pedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_has_Producto_Producto1`
    FOREIGN KEY (`Producto_idProducto` , `Producto_Categorias_idCategorias`)
    REFERENCES `raices`.`Producto` (`id_producto` , `Categorias_idCategorias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
