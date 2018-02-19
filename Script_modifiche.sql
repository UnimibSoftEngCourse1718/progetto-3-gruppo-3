-- Aggiunta modifica tabella AstaSuperamentoImmediato

ALTER TABLE astasuperamentoimmediato MODIFY `attiva` TINYINT NOT NULL DEFAULT 1;

-- Aggiunta modifica tabella AstaBustaChiusa

ALTER TABLE astabustachiusa MODIFY `attiva` TINYINT NOT NULL DEFAULT 1;