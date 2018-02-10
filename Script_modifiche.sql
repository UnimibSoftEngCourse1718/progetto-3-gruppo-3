/* Script in cui inserire le modifiche ad trinitydb */

use trinitydb;

ALTER TABLE utenteregistrato MODIFY `email` VARCHAR(45) NOT NULL unique;

/* Visualizza lo stato della tabella modificata */
DESCRIBE utenteregistrato;