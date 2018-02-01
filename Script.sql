--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `trinitydb`.`utenteregistrato` DROP PRIMARY KEY;

DROP TABLE `trinitydb`.`utenteregistrato`;

CREATE TABLE `trinitydb`.`utenteregistrato` (
	`idUtente` INT NOT NULL,
	`nomeUtente` VARCHAR(45) NOT NULL,
	`cognomeUtente` VARCHAR(45) NOT NULL,
	`email` VARCHAR(45),
	`password` VARCHAR(45),
	`indirizzo` VARCHAR(45),
	`numeroCarta` INT,
	PRIMARY KEY (`idUtente`)
) ENGINE=InnoDB;

ALTER TABLE `trinitydb`.`utenteregistrato` ADD PRIMARY KEY (`idUtente`);

