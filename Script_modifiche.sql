-- Aggiunta modifica tabella AstaSuperamentoImmediato

ALTER TABLE astasuperamentoimmediato MODIFY `attiva` TINYINT NOT NULL DEFAULT 1;

-- Aggiunta modifica tabella AstaBustaChiusa

ALTER TABLE astabustachiusa MODIFY `attiva` TINYINT NOT NULL DEFAULT 1;


-- Aggiunta modifica tabella AstaSuperamentoImmediato

ALTER TABLE `trinitydb`.`astasuperamentoimmediato` CHANGE COLUMN `timeSlot` `timeSlot` INT(11) NOT NULL DEFAULT 3  ;

-- Aggiunte modifiche tabella AstaBustaChiusa

ALTER TABLE `trinitydb`.`astabustachiusa` CHANGE COLUMN `oraInizio` `oraInizio` BIGINT NOT NULL  , CHANGE COLUMN `oraFine` `oraFine` BIGINT NOT NULL  , CHANGE COLUMN `timeslot` `timeslot` INT NOT NULL DEFAULT 3  ;

