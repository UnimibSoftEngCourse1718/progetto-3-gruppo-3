USE trinitydb;
CREATE TABLE astasuperamentoimmediato (
	idAstaSuperamentoImmediato INT NOT NULL,
	baseAsta INT NOT NULL,
	oraInizio TIME NOT NULL,
	oraFine TIME NOT NULL,
	timeSlot DATE NOT NULL,
	oggetto INT NOT NULL,
	venditore INT NOT NULL,
	PRIMARY KEY (idAstaSuperamentoImmediato)
) ENGINE=InnoDB;

CREATE TABLE astamanager (
	idAstaManager INT NOT NULL,
	userAstaManager VARCHAR(45) NOT NULL,
	passwordAstaManager VARCHAR(45) NOT NULL,
	PRIMARY KEY (idAstaManager)
) ENGINE=InnoDB;

CREATE TABLE amministratore (
	idAmministratore INT NOT NULL,
	userAmministratore VARCHAR(45) NOT NULL,
	passwordAmministratore VARCHAR(45) NOT NULL,
	PRIMARY KEY (idAmministratore)
) ENGINE=InnoDB;

CREATE TABLE categoria (
	idCategoria INT NOT NULL,
	nomeCategoria VARCHAR(45),
	PRIMARY KEY (idCategoria)
) ENGINE=InnoDB;

CREATE TABLE astabustachiusa (
	idAstaBustaChiusa INT NOT NULL,
	baseAsta INT NOT NULL,
	oraInizio TIME NOT NULL,
	oraFine TIME NOT NULL,
	timeslot TIME NOT NULL,
	oggetto INT NOT NULL,
	venditore INT NOT NULL,
	PRIMARY KEY (idAstaBustaChiusa)
) ENGINE=InnoDB;

CREATE TABLE utenteregistrato (
	idUtente INT NOT NULL,
	nomeUtente VARCHAR(45) NOT NULL,
	cognomeUtente VARCHAR(45) NOT NULL,
	email VARCHAR(45) NOT NULL,
	password VARCHAR(45) NOT NULL,
	indirizzo VARCHAR(45) NOT NULL,
	numeroCarta INT NOT NULL,
	crediti VARCHAR(45) NOT NULL,
	PRIMARY KEY (idUtente)
) ENGINE=InnoDB;

CREATE TABLE offertasuperamentoimmediato (
	idOffertaSI INT NOT NULL,
	valore INT NOT NULL,
	offerta INT NOT NULL,
	asta INT NOT NULL,
	PRIMARY KEY (idOffertaSI)
) ENGINE=InnoDB;

CREATE TABLE oggetto (
	idOggetto INT NOT NULL,
	nomeOggetto VARCHAR(45) NOT NULL,
	descrizione VARCHAR(100) NOT NULL,
	categoria INT NOT NULL,
	PRIMARY KEY (idOggetto)
) ENGINE=InnoDB;

CREATE TABLE offertabustachiusa (
	idOffertaBC INT NOT NULL,
	valore INT NOT NULL,
	offerente INT NOT NULL,
	asta INT NOT NULL,
	PRIMARY KEY (idOffertaBC)
) ENGINE=InnoDB;

CREATE INDEX astaSI_oggetto_idx ON astasuperamentoimmediato (oggetto ASC);

CREATE INDEX offerente_idx ON offertabustachiusa (offerente ASC);

CREATE INDEX astaBC_oggetto_idx ON astabustachiusa (oggetto ASC);

CREATE INDEX astaSI_venditore_idx ON astasuperamentoimmediato (venditore ASC);

CREATE INDEX oggetto_categoria_idx ON oggetto (categoria ASC);

CREATE INDEX astaBC_venditore_idx ON astabustachiusa (venditore ASC);

CREATE INDEX idOfferente_idx ON offertasuperamentoimmediato (offerta ASC);

CREATE INDEX offertaSI_asta_idx ON offertasuperamentoimmediato (asta ASC);

CREATE INDEX offertaBC_asta_idx ON offertabustachiusa (asta ASC);
