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
  INDEX `oggetto_categoria_idx` (`categoria` ASC) ,
  CONSTRAINT `oggetto_categoria`
    FOREIGN KEY (`categoria` )
    REFERENCES `trinitydb`.`categoria` (`idCategoria` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;


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
  `creditiDisp` INT(11) NOT NULL DEFAULT '0' ,
  `creditiCont` INT(11) NOT NULL DEFAULT '0' ,
  PRIMARY KEY (`idUtente`) ,
  UNIQUE INDEX `email` (`email` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `trinitydb`.`astabustachiusa`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `trinitydb`.`astabustachiusa` (
  `idAsta` INT(11) NOT NULL AUTO_INCREMENT ,
  `baseAsta` INT(11) NOT NULL ,
  `oraInizio` BIGINT(20) NOT NULL ,
  `oraFine` BIGINT(20) NOT NULL ,
  `oggetto` INT(11) NOT NULL ,
  `venditore` INT(11) NOT NULL ,
  `attiva` TINYINT(4) NOT NULL DEFAULT '1' ,
  PRIMARY KEY (`idAsta`) ,
  INDEX `astaBC_oggetto_idx` (`oggetto` ASC) ,
  INDEX `astaBC_venditore_idx` (`venditore` ASC) ,
  CONSTRAINT `astaBC_oggetto`
    FOREIGN KEY (`oggetto` )
    REFERENCES `trinitydb`.`oggetto` (`idOggetto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `astaBC_venditore`
    FOREIGN KEY (`venditore` )
    REFERENCES `trinitydb`.`utenteregistrato` (`idUtente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `trinitydb`.`astamanager`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `trinitydb`.`astamanager` (
  `idAstaManager` INT(11) NOT NULL AUTO_INCREMENT ,
  `userAstaManager` VARCHAR(45) NOT NULL ,
  `passwordAstaManager` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idAstaManager`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `trinitydb`.`astasuperamentoimmediato`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `trinitydb`.`astasuperamentoimmediato` (
  `idAsta` INT(11) NOT NULL AUTO_INCREMENT ,
  `baseAsta` INT(11) NOT NULL ,
  `oraInizio` BIGINT(20) NOT NULL ,
  `oraFine` BIGINT(20) NOT NULL ,
  `timeSlot` INT(11) NOT NULL DEFAULT '3' ,
  `oggetto` INT(11) NOT NULL ,
  `venditore` INT(11) NOT NULL ,
  `attiva` TINYINT(4) NOT NULL DEFAULT '1' ,
  PRIMARY KEY (`idAsta`) ,
  INDEX `astaSI_oggetto_idx` (`oggetto` ASC) ,
  INDEX `astaSI_venditore_idx` (`venditore` ASC) ,
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
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `trinitydb`.`offertabustachiusa`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `trinitydb`.`offertabustachiusa` (
  `idOffertaBC` INT(11) NOT NULL AUTO_INCREMENT ,
  `valore` INT(11) NOT NULL ,
  `asta` INT(11) NOT NULL ,
  `offerente` INT(11) NOT NULL ,
  PRIMARY KEY (`idOffertaBC`) ,
  INDEX `offertaBC_asta_idx` (`asta` ASC) ,
  INDEX `offertaBC_offerente_idx` (`offerente` ASC) ,
  CONSTRAINT `offertaBC_asta`
    FOREIGN KEY (`asta` )
    REFERENCES `trinitydb`.`astabustachiusa` (`idAsta` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `trinitydb`.`offertasuperamentoimmediato`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `trinitydb`.`offertasuperamentoimmediato` (
  `idOffertaSI` INT(11) NOT NULL AUTO_INCREMENT ,
  `valore` INT(11) NOT NULL ,
  `asta` INT(11) NOT NULL ,
  `offerente` INT(11) NOT NULL ,
  PRIMARY KEY (`idOffertaSI`) ,
  INDEX `offertaSI_asta_idx` (`asta` ASC) ,
  INDEX `offertaSI_offerente_idx` (`offerente` ASC) ,
  CONSTRAINT `offertaSI_asta`
    FOREIGN KEY (`asta` )
    REFERENCES `trinitydb`.`astasuperamentoimmediato` (`idAsta` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;

USE `trinitydb` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


use trinitydb;

-- inserimento utenti --
INSERT INTO `utenteregistrato` (`idUtente`, `nomeUtente`, `cognomeUtente`, `email`, `password`, `indirizzo`, `numeroCarta`, `creditiDisp`,  `creditiCont`) VALUES ('1', 'Luca', 'Rossi', 'luca.rossi@gmail.com', 'p0lucarossi', 'Via Nolana, 113, San Pietro', '2849 4927 5647 2844', '100', '100');
INSERT INTO `utenteregistrato` (`idUtente`, `nomeUtente`, `cognomeUtente`, `email`, `password`, `indirizzo`, `numeroCarta`, `creditiDisp`,  `creditiCont`) VALUES ('2', 'Marco', 'Ferrari', 'marco.ferrari@libero.it', 'p1marcoferrari', 'Viale di Savoia, 128, San Frediano', '6603 4816 2514 4938', '2000', '2000');
INSERT INTO `utenteregistrato` (`idUtente`, `nomeUtente`, `cognomeUtente`, `email`, `password`, `indirizzo`, `numeroCarta`, `creditiDisp`,  `creditiCont`) VALUES ('3', 'Giulia', 'Bianchi', 'giulia.bianchi@hotmail.it', 'p2giuliabianchi', 'Via Leopardi, 147, Bagni Mormio', '5873 2810 1099 2204', '3660', '3660');
INSERT INTO `utenteregistrato` (`idUtente`, `nomeUtente`, `cognomeUtente`, `email`, `password`, `indirizzo`, `numeroCarta`, `creditiDisp`,  `creditiCont`) VALUES ('4', 'Matteo', 'Colombo', 'matteo.colombo@gmail.it', 'p3matteocolombo', 'Via Alessandro Manzoni, 45, Castana', '3380 0039 9385 7736', '454', '454');
INSERT INTO `utenteregistrato` (`idUtente`, `nomeUtente`, `cognomeUtente`, `email`, `password`, `indirizzo`, `numeroCarta`, `creditiDisp`,  `creditiCont`) VALUES ('5', 'Elisa', 'Verdi', 'elisa.verdi@libero.it', 'p4elisaverdi', 'Via Camuzzoni, 111, San Pietro', '3748 1700 9352 3761', '33', '33');
INSERT INTO `utenteregistrato` (`idUtente`, `nomeUtente`, `cognomeUtente`, `email`, `password`, `indirizzo`, `numeroCarta`, `creditiDisp`,  `creditiCont`) VALUES ('6', 'Pietro', 'Esposito', 'pietro.esposito@gmail.com', 'p5pietroesposito', 'Via Moiariello, 1, Vernante', '7736 6344 8473 6473', '68', '68');
INSERT INTO `utenteregistrato` (`idUtente`, `nomeUtente`, `cognomeUtente`, `email`, `password`, `indirizzo`, `numeroCarta`, `creditiDisp`,  `creditiCont`) VALUES ('7', 'Alice', 'Viola', 'alice.viola@hotmail.it', 'p6aliceviola', 'Via Zannoni, 45, Vaneze Di Bondone', '0079 5968 7364 2622', '112', '112');
-- utente test --
INSERT INTO `utenteregistrato` (`idUtente`, `nomeUtente`, `cognomeUtente`, `email`, `password`, `indirizzo`, `numeroCarta`, `creditiDisp`,  `creditiCont`) VALUES ('8', 'NomeTest', 'CognomeTest', 'test@test.test', 'test', 'Via Zannoni, 45, Vanze', '0079 5968 7364 2622', '10000', '10000');

-- inserimento categorie --
INSERT INTO `categoria` (`idCategoria`, `nomeCategoria`) VALUES ('1', 'abbigliamento e accessori');
INSERT INTO `categoria` (`idCategoria`, `nomeCategoria`) VALUES ('2', 'elettronica');
INSERT INTO `categoria` (`idCategoria`, `nomeCategoria`) VALUES ('3', 'giochi e giocattoli');
INSERT INTO `categoria` (`idCategoria`, `nomeCategoria`) VALUES ('4', 'gioielli');
INSERT INTO `categoria` (`idCategoria`, `nomeCategoria`) VALUES ('5', 'informatica');
INSERT INTO `categoria` (`idCategoria`, `nomeCategoria`) VALUES ('6', 'libri');
INSERT INTO `categoria` (`idCategoria`, `nomeCategoria`) VALUES ('7', 'sport e tempo libero');
INSERT INTO `categoria` (`idCategoria`, `nomeCategoria`) VALUES ('8', 'strumenti musicali');
INSERT INTO `categoria` (`idCategoria`, `nomeCategoria`) VALUES ('9', 'valigeria');

-- inserimento oggetti --
INSERT INTO `oggetto` (`idOggetto`, `nomeOggetto`, `descrizione`, `categoria`) VALUES ('1', 'maglia nike uomo', 'taglia L', '1');
INSERT INTO `oggetto` (`idOggetto`, `nomeOggetto`, `descrizione`, `categoria`) VALUES ('2', 'smartphone samsung s8', 'stato: nuovo', '2');
INSERT INTO `oggetto` (`idOggetto`, `nomeOggetto`, `descrizione`, `categoria`) VALUES ('3', 'anello', 'materiale: oro', '4');
INSERT INTO `oggetto` (`idOggetto`, `nomeOggetto`, `descrizione`, `categoria`) VALUES ('4', 'windows 10', '2 copie', '5');
INSERT INTO `oggetto` (`idOggetto`, `nomeOggetto`, `descrizione`, `categoria`) VALUES ('5', 'piccolo principe', 'nuovo', '6');
INSERT INTO `oggetto` (`idOggetto`, `nomeOggetto`, `descrizione`, `categoria`) VALUES ('6', 'pallone calcio', 'serie a 2017', '7');
INSERT INTO `oggetto` (`idOggetto`, `nomeOggetto`, `descrizione`, `categoria`) VALUES ('7', 'pianola', 'yamaha', '8');
INSERT INTO `oggetto` (`idOggetto`, `nomeOggetto`, `descrizione`, `categoria`) VALUES ('8', 'valigia viaggio', 'traveler', '9');
INSERT INTO `oggetto` (`idOggetto`, `nomeOggetto`, `descrizione`, `categoria`) VALUES ('9', 'scarpe donna', 'numero 42', '1');
INSERT INTO `oggetto` (`idOggetto`, `nomeOggetto`, `descrizione`, `categoria`) VALUES ('10', 'cappello', 'rosso, bambino', '1');
INSERT INTO `oggetto` (`idOggetto`, `nomeOggetto`, `descrizione`, `categoria`) VALUES ('11', 'tablet', 'ipad', '2');
INSERT INTO `oggetto` (`idOggetto`, `nomeOggetto`, `descrizione`, `categoria`) VALUES ('12', 'mouse', 'logitech', '5');

-- inserimento asteSI --
INSERT INTO `trinitydb`.`astasuperamentoimmediato` (`idAsta`, `baseAsta`, `oraInizio`, `oraFine`, `timeSlot`, `oggetto`, `venditore`, `attiva`) VALUES ('1', '10', '1514801471', '1519294271', '3', '1', '2', '0');
INSERT INTO `trinitydb`.`astasuperamentoimmediato` (`idAsta`, `baseAsta`, `oraInizio`, `oraFine`, `timeSlot`, `oggetto`, `venditore`, `attiva`) VALUES ('2', '10', '1514801471', '1519294271', '3', '2', '3', '0');
INSERT INTO `trinitydb`.`astasuperamentoimmediato` (`idAsta`, `baseAsta`, `oraInizio`, `oraFine`, `timeSlot`, `oggetto`, `venditore`, `attiva`) VALUES ('3', '10', '1514801471', '1521713471', '3', '3', '3', '1');
INSERT INTO `trinitydb`.`astasuperamentoimmediato` (`idAsta`, `baseAsta`, `oraInizio`, `oraFine`, `timeSlot`, `oggetto`, `venditore`, `attiva`) VALUES ('4', '10', '1514801471', '1521713471', '3', '4', '4', '1');
INSERT INTO `trinitydb`.`astasuperamentoimmediato` (`idAsta`, `baseAsta`, `oraInizio`, `oraFine`, `timeSlot`, `oggetto`, `venditore`, `attiva`) VALUES ('5', '10', '1514801471', '1521713471', '3', '5', '5', '1');
INSERT INTO `trinitydb`.`astasuperamentoimmediato` (`idAsta`, `baseAsta`, `oraInizio`, `oraFine`, `timeSlot`, `oggetto`, `venditore`, `attiva`) VALUES ('10', '10', '1514801471', '1519294271', '3', '12', '8', '0');


INSERT INTO `trinitydb`.`astabustachiusa` (`idAsta`, `baseAsta`, `oraInizio`, `oraFine`, `oggetto`, `venditore`, `attiva`) VALUES ('6', '10', '1514801471', '1521713471', '6', '6', '1');
INSERT INTO `trinitydb`.`astabustachiusa` (`idAsta`, `baseAsta`, `oraInizio`, `oraFine`, `oggetto`, `venditore`, `attiva`) VALUES ('7', '10', '1514801471', '1519294271', '7', '6', '0');
INSERT INTO `trinitydb`.`astabustachiusa` (`idAsta`, `baseAsta`, `oraInizio`, `oraFine`, `oggetto`, `venditore`, `attiva`) VALUES ('8', '10', '1514801471', '1519294271', '8', '7', '0');
INSERT INTO `trinitydb`.`astabustachiusa` (`idAsta`, `baseAsta`, `oraInizio`, `oraFine`, `oggetto`, `venditore`, `attiva`) VALUES ('9', '10', '1514801471', '1521713471', '9', '8', '1');



INSERT INTO `trinitydb`.`offertasuperamentoimmediato` (`idOffertaSI`, `valore`, `asta`, `offerente`) VALUES ('1', '100', '1', '3');
INSERT INTO `trinitydb`.`offertasuperamentoimmediato` (`idOffertaSI`, `valore`, `asta`, `offerente`) VALUES ('2', '120', '2', '2');
INSERT INTO `trinitydb`.`offertasuperamentoimmediato` (`idOffertaSI`, `valore`, `asta`, `offerente`) VALUES ('3', '30', '3', '1');
INSERT INTO `trinitydb`.`offertasuperamentoimmediato` (`idOffertaSI`, `valore`, `asta`, `offerente`) VALUES ('4', '150', '4', '4');


INSERT INTO `trinitydb`.`offertabustachiusa` (`idOffertaBC`, `valore`, `asta`, `offerente`) VALUES ('1', '150', '9', '2');
INSERT INTO `trinitydb`.`offertabustachiusa` (`idOffertaBC`, `valore`, `asta`, `offerente`) VALUES ('2', '160', '9', '3');
INSERT INTO `trinitydb`.`offertabustachiusa` (`idOffertaBC`, `valore`, `asta`, `offerente`) VALUES ('3', '200', '9', '1');