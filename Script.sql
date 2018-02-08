SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `trinitydb` DEFAULT CHARACTER SET utf8 ;
USE `trinitydb` ;

-- -----------------------------------------------------
-- Table `trinitydb`.`amministratore`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `trinitydb`.`amministratore` (
  `idAmministratore` INT(11) NOT NULL AUTO_INCREMENT ,
  `userAmministratore` VARCHAR(45) NOT NULL ,
  `passwordAmministratore` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idAmministratore`) )
ENGINE = InnoDB
AUTO_INCREMENT=0
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `trinitydb`.`categoria`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `trinitydb`.`categoria` (
  `idCategoria` INT(11) NOT NULL AUTO_INCREMENT ,
  `nomeCategoria` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`idCategoria`) )
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `trinitydb`.`oggetto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `trinitydb`.`oggetto` (
  `idOggetto` INT(11) NOT NULL AUTO_INCREMENT ,
  `nomeOggetto` VARCHAR(45) NOT NULL ,
  `descrizione` VARCHAR(100) NOT NULL ,
  `categoria` INT(11) NOT NULL ,
  PRIMARY KEY (`idOggetto`) ,
  CONSTRAINT `oggetto_categoria`
    FOREIGN KEY (`categoria` )
    REFERENCES `trinitydb`.`categoria` (`idCategoria` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `oggetto_categoria_idx` ON `trinitydb`.`oggetto` (`categoria` ASC) ;


-- -----------------------------------------------------
-- Table `trinitydb`.`utenteregistrato`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `trinitydb`.`utenteregistrato` (
  `idUtente` INT(11) NOT NULL AUTO_INCREMENT ,
  `nomeUtente` VARCHAR(45) NOT NULL ,
  `cognomeUtente` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `indirizzo` VARCHAR(45) NOT NULL ,
  `numeroCarta` VARCHAR(45) NOT NULL ,
  `crediti` VARCHAR(45) NULL DEFAULT '0' ,
  PRIMARY KEY (`idUtente`) )
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `trinitydb`.`astabustachiusa`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `trinitydb`.`astabustachiusa` (
  `idAstaBustaChiusa` INT(11) NOT NULL AUTO_INCREMENT ,
  `baseAsta` INT(11) NOT NULL ,
  `oraInizio` TIME NOT NULL ,
  `oraFine` TIME NOT NULL ,
  `timeslot` TIME NOT NULL ,
  `oggetto` INT(11) NOT NULL ,
  `venditore` INT(11) NOT NULL ,
  PRIMARY KEY (`idAstaBustaChiusa`) ,
  CONSTRAINT `astaBC_oggetto`
    FOREIGN KEY (`oggetto` )
    REFERENCES `trinitydb`.`oggetto` (`idOggetto` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `astaBC_venditore`
    FOREIGN KEY (`venditore` )
    REFERENCES `trinitydb`.`utenteregistrato` (`idUtente` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `astaBC_oggetto_idx` ON `trinitydb`.`astabustachiusa` (`oggetto` ASC) ;

CREATE INDEX `astaBC_venditore_idx` ON `trinitydb`.`astabustachiusa` (`venditore` ASC) ;


-- -----------------------------------------------------
-- Table `trinitydb`.`astamanager`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `trinitydb`.`astamanager` (
  `idAstaManager` INT(11) NOT NULL AUTO_INCREMENT,
  `userAstaManager` VARCHAR(45) NOT NULL ,
  `passwordAstaManager` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idAstaManager`) )
ENGINE = InnoDB
AUTO_INCREMENT=0
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `trinitydb`.`astasuperamentoimmediato`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `trinitydb`.`astasuperamentoimmediato` (
  `idAsta` INT(11) NOT NULL AUTO_INCREMENT ,
  `baseAsta` INT(11) NOT NULL ,
  `oraInizio` TIME NOT NULL ,
  `oraFine` TIME NOT NULL ,
  `timeSlot` INT(11) NOT NULL ,
  `oggetto` INT(11) NOT NULL ,
  `venditore` INT(11) NOT NULL ,
  PRIMARY KEY (`idAsta`) ,
  CONSTRAINT `astaSI_oggetto`
    FOREIGN KEY (`oggetto` )
    REFERENCES `trinitydb`.`oggetto` (`idOggetto` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `astaSI_venditore`
    FOREIGN KEY (`venditore` )
    REFERENCES `trinitydb`.`utenteregistrato` (`idUtente` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT=0
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `astaSI_oggetto_idx` ON `trinitydb`.`astasuperamentoimmediato` (`oggetto` ASC) ;

CREATE INDEX `astaSI_venditore_idx` ON `trinitydb`.`astasuperamentoimmediato` (`venditore` ASC) ;


-- -----------------------------------------------------
-- Table `trinitydb`.`offertabustachiusa`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `trinitydb`.`offertabustachiusa` (
  `idOffertaBC` INT(11) NOT NULL AUTO_INCREMENT ,
  `valore` INT(11) NOT NULL ,
  `asta` INT(11) NOT NULL ,
  `offerente` INT(11) NOT NULL ,
  PRIMARY KEY (`idOffertaBC`) ,
  CONSTRAINT `offertaBC_asta`
    FOREIGN KEY (`asta` )
    REFERENCES `trinitydb`.`astabustachiusa` (`idAstaBustaChiusa` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT=0
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `offertaBC_asta_idx` ON `trinitydb`.`offertabustachiusa` (`asta` ASC) ;

CREATE INDEX `offertaBC_offerente_idx` ON `trinitydb`.`offertabustachiusa` (`offerente` ASC) ;


-- -----------------------------------------------------
-- Table `trinitydb`.`offertasuperamentoimmediato`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `trinitydb`.`offertasuperamentoimmediato` (
  `idOffertaSI` INT(11) NOT NULL AUTO_INCREMENT ,
  `valore` INT(11) NOT NULL ,
  `asta` INT(11) NOT NULL ,
  `offerente` INT(11) NOT NULL ,
  PRIMARY KEY (`idOffertaSI`) ,
  CONSTRAINT `offertaSI_asta`
    FOREIGN KEY (`asta` )
    REFERENCES `trinitydb`.`astasuperamentoimmediato` (`idAsta` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT=0
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `offertaSI_asta_idx` ON `trinitydb`.`offertasuperamentoimmediato` (`asta` ASC) ;

CREATE INDEX `offertaSI_offerente_idx` ON `trinitydb`.`offertasuperamentoimmediato` (`offerente` ASC) ;

USE `trinitydb` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
