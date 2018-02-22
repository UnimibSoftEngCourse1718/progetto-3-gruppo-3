use trinitydb;

-- Aggiunta modifica tabella AstaSuperamentoImmediato

ALTER TABLE `astasuperamentoimmediato` MODIFY `attiva` TINYINT NOT NULL DEFAULT 1;

-- Aggiunta modifica tabella AstaBustaChiusa
ALTER TABLE `astabustachiusa` MODIFY `attiva` TINYINT NOT NULL DEFAULT 1;

-- Aggiunta modifica tabella AstaSuperamentoImmediato
ALTER TABLE `trinitydb`.`astasuperamentoimmediato` CHANGE COLUMN `timeSlot` `timeSlot` INT(11) NOT NULL DEFAULT 3  ;

-- Aggiunte modifiche tabella AstaBustaChiusa
ALTER TABLE `trinitydb`.`astabustachiusa` CHANGE COLUMN `oraInizio` `oraInizio` BIGINT NOT NULL  , CHANGE COLUMN `oraFine` `oraFine` BIGINT NOT NULL  , CHANGE COLUMN `timeslot` `timeslot` INT NOT NULL DEFAULT 3  ;

-- Modifica colonna crediti in creditiDisp (creditiDisonibili)
ALTER TABLE `utenteregistrato` CHANGE COLUMN `crediti` `creditiDisp` INT NOT NULL DEFAULT '0'  ;

-- Aggiunta colonna creditiCont (creditiContabili)
ALTER TABLE `utenteregistrato` ADD `creditiCont` INT(11) NOT NULL DEFAULT '0' ;

-- Aggiunta modifica tabella AstaSuperamentoImmediato

ALTER TABLE `trinitydb`.`astasuperamentoimmediato` CHANGE COLUMN `timeSlot` `timeSlot` INT(11) NOT NULL DEFAULT 3  ;

-- Aggiunte modifiche tabella AstaBustaChiusa

ALTER TABLE `trinitydb`.`astabustachiusa` CHANGE COLUMN `oraInizio` `oraInizio` BIGINT NOT NULL  , CHANGE COLUMN `oraFine` `oraFine` BIGINT NOT NULL  , CHANGE COLUMN `timeslot` `timeslot` INT NOT NULL DEFAULT 3  ;

ALTER TABLE `trinitydb`.`astabustachiusa` CHANGE COLUMN `attiva` `attiva` TINYINT NOT NULL DEFAULT '1' ;

ALTER TABLE `trinitydb`.`astabustachiusa` DROP COLUMN `timeslot`;

ALTER TABLE `trinitydb`.`astabustachiusa` CHANGE COLUMN `idAstaBustaChiusa` `idAsta` INT(11) NOT NULL AUTO_INCREMENT;

