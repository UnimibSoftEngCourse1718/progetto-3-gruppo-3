// Aggiunta modifica tabella AstaSuperamentoImmediato

ALTER TABLE `trinitydb`.`astasuperamentoimmediato` ADD COLUMN `attiva` TINYINT NOT NULL DEFAULT 1  AFTER `venditore` ;
