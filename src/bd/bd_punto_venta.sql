

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE DATABASE IF NOT EXISTS `jodysoft` DEFAULT CHARACTER SET latin1 ;
USE `jodysoft` ;

-- -----------------------------------------------------
-- Table `jodysoft`.`sucursal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jodysoft`.`sucursal` (
  `id_sucursal` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(25) NOT NULL,
  `calle` VARCHAR(25) NOT NULL,
  `colonia` VARCHAR(25) NOT NULL,
  `numero_exterior` INT(11) NOT NULL,
  PRIMARY KEY (`id_sucursal`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `jodysoft`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jodysoft`.`productos` (
  `id_producto` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(25) NOT NULL,
  `precio_compra` FLOAT NOT NULL,
  `precio_venta` FLOAT NOT NULL,
  `descripcion` VARCHAR(50) NOT NULL,
  `categoria` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_producto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `jodysoft`.`almacen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jodysoft`.`almacen` (
  `id_almacen` INT(11) NOT NULL AUTO_INCREMENT,
  `existencia` INT(11) NOT NULL,
  `id_sucursal` INT(11) NOT NULL,
  `id_productos` INT(11) NOT NULL,
  PRIMARY KEY (`id_almacen`),
  INDEX `fk_almacen_sucursal1_idx` (`id_sucursal` ASC),
  INDEX `fk_almacen_productos1_idx` (`id_productos` ASC),
  CONSTRAINT `fk_almacen_sucursal1`
    FOREIGN KEY (`id_sucursal`)
    REFERENCES `jodysoft`.`sucursal` (`id_sucursal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_almacen_productos1`
    FOREIGN KEY (`id_productos`)
    REFERENCES `jodysoft`.`productos` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `jodysoft`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jodysoft`.`clientes` (
  `id_cliente` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(25) NOT NULL,
  `ape_paterno` VARCHAR(25) NOT NULL,
  `ape_materno` VARCHAR(25) NOT NULL,
  `calle` VARCHAR(20) NOT NULL,
  `colonia` VARCHAR(10) NOT NULL,
  `numero` INT(11) NOT NULL,
  `tipo` VARCHAR(15) NOT NULL,
  `telefono` CHAR(12) NOT NULL,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `jodysoft`.`proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jodysoft`.`proveedor` (
  `id_proveedor` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(25) NOT NULL,
  `ape_paterno` VARCHAR(25) NOT NULL,
  `ape_materno` VARCHAR(25) NOT NULL,
  `empresa` VARCHAR(20) NOT NULL,
  `calle` VARCHAR(20) NOT NULL,
  `colonia` VARCHAR(20) NOT NULL,
  `numero` INT(11) NOT NULL,
  `telefono` CHAR(12) NOT NULL,
  PRIMARY KEY (`id_proveedor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `jodysoft`.`compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jodysoft`.`compra` (
  `id_compra` INT(11) NOT NULL AUTO_INCREMENT,
  `total` FLOAT NOT NULL,
  `id_proveedor` INT(11) NOT NULL,
  PRIMARY KEY (`id_compra`),
  INDEX `fk_compra_proveedor1_idx` (`id_proveedor` ASC),
  CONSTRAINT `fk_compra_proveedor1`
    FOREIGN KEY (`id_proveedor`)
    REFERENCES `jodysoft`.`proveedor` (`id_proveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `jodysoft`.`descuento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jodysoft`.`descuento` (
  `id_descuento` INT(11) NOT NULL AUTO_INCREMENT,
  `acomulado` FLOAT NOT NULL,
  `fecha_limite` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_cliente` INT(11) NOT NULL,
  PRIMARY KEY (`id_descuento`),
  INDEX `fk_descuento_clientes1_idx` (`id_cliente` ASC),
  CONSTRAINT `fk_descuento_clientes1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `jodysoft`.`clientes` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `jodysoft`.`detalle_compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jodysoft`.`detalle_compra` (
  `id_detalle_compra` INT(11) NOT NULL AUTO_INCREMENT,
  `cantidad` INT(11) NOT NULL,
  `precio_unitario` FLOAT NOT NULL,
  `subtotal` FLOAT NOT NULL,
  `id_productos` INT(11) NOT NULL,
  `id_compra` INT(11) NOT NULL,
  PRIMARY KEY (`id_detalle_compra`),
  INDEX `fk_detalle_compra_productos1_idx` (`id_productos` ASC),
  INDEX `fk_detalle_compra_compra1_idx` (`id_compra` ASC),
  CONSTRAINT `fk_detalle_compra_productos1`
    FOREIGN KEY (`id_productos`)
    REFERENCES `jodysoft`.`productos` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_compra_compra1`
    FOREIGN KEY (`id_compra`)
    REFERENCES `jodysoft`.`compra` (`id_compra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `jodysoft`.`empleados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jodysoft`.`empleados` (
  `id_empleado` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `ape_paterno` VARCHAR(40) NOT NULL,
  `ape_materno` VARCHAR(40) NOT NULL,
  `calle` VARCHAR(20) NOT NULL,
  `colonia` VARCHAR(20) NOT NULL,
  `numero` INT(5) NOT NULL,
  `rfc` VARCHAR(20) BINARY NOT NULL,
  `telefono` INT(12) NOT NULL,
  `sucursal_id_sucursal` INT(11) NOT NULL,
  PRIMARY KEY (`id_empleado`),
  INDEX `fk_empleados_sucursal1_idx` (`sucursal_id_sucursal` ASC),
  CONSTRAINT `fk_empleados_sucursal1`
    FOREIGN KEY (`sucursal_id_sucursal`)
    REFERENCES `jodysoft`.`sucursal` (`id_sucursal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `jodysoft`.`ventas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jodysoft`.`ventas` (
  `id_venta` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` TIMESTAMP NOT NULL ,
  `total` FLOAT NOT NULL,
  `id_empleado` INT(11) NOT NULL,
  `id_cliente` INT(11) NOT NULL,
  PRIMARY KEY (`id_venta`),
  INDEX `fk_ventas_empleados1_idx` (`id_empleado` ASC),
  INDEX `fk_ventas_clientes1_idx` (`id_cliente` ASC),
  CONSTRAINT `fk_ventas_empleados1`
    FOREIGN KEY (`id_empleado`)
    REFERENCES `jodysoft`.`empleados` (`id_empleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ventas_clientes1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `jodysoft`.`clientes` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `jodysoft`.`detalle_venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jodysoft`.`detalle_venta` (
  `id_detalle_venta` INT(11) NOT NULL AUTO_INCREMENT,
  `cantidad` INT(11) NULL DEFAULT NULL,
  `subtotal` FLOAT NULL DEFAULT NULL,
  `id_productos` INT(11) NOT NULL,
  `id_venta` INT(11) NOT NULL,
  PRIMARY KEY (`id_detalle_venta`),
  INDEX `fk_detalle_venta_productos_idx` (`id_productos` ASC),
  INDEX `fk_detalle_venta_ventas1_idx` (`id_venta` ASC),
  CONSTRAINT `fk_detalle_venta_productos`
    FOREIGN KEY (`id_productos`)
    REFERENCES `jodysoft`.`productos` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_venta_ventas1`
    FOREIGN KEY (`id_venta`)
    REFERENCES `jodysoft`.`ventas` (`id_venta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `jodysoft`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jodysoft`.`usuarios` (
  `id_usuarios` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  `rol` INT NOT NULL,
  `id_empleado` INT(11) NOT NULL,
  PRIMARY KEY (`id_usuarios`),
  INDEX `fk_usuarios_empleados1_idx` (`id_empleado` ASC),
  CONSTRAINT `fk_usuarios_empleados1`
    FOREIGN KEY (`id_empleado`)
    REFERENCES `jodysoft`.`empleados` (`id_empleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jodysoft`.`documento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jodysoft`.`documento` (
  `id_documento` INT(11) NOT NULL AUTO_INCREMENT,
  `serie` INT(10) NOT NULL DEFAULT 001,
  `tipo` VARCHAR(20) NOT NULL,
  `id_detalle_venta` INT(11) NOT NULL,
  PRIMARY KEY (`id_documento`),
  INDEX `fk_documento_detalle_venta1_idx` (`id_detalle_venta` ASC),
  CONSTRAINT `fk_documento_detalle_venta1`
    FOREIGN KEY (`id_detalle_venta`)
    REFERENCES `jodysoft`.`detalle_venta` (`id_detalle_venta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jodysoft`.`promocion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jodysoft`.`promocion` (
  `id_promocion` INT NOT NULL AUTO_INCREMENT,
  `fecha_limite` VARCHAR(45) NOT NULL,
  `porcentaje` INT(2) NULL,
  `productos_id_producto` INT(11) NOT NULL,
  PRIMARY KEY (`id_promocion`),
  INDEX `fk_promocion_productos1_idx` (`productos_id_producto` ASC),
  CONSTRAINT `fk_promocion_productos1`
    FOREIGN KEY (`productos_id_producto`)
    REFERENCES `jodysoft`.`productos` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
