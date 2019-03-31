CREATE TABLE IF NOT EXISTS Modelos(
	id IDENTITY(1,1) PRIMARY KEY,
	nombre CHAR(20) NOT NULL,
	valorFacial REAL NOT NULL,
	unidad CHAR(10) NOT NULL,
	diametro SMALLINT NULL,
	peso REAL NOT NULL,
	metal CHAR(25) NOT NULL,
	descripcion CHAR(50) NULL
);

CREATE TABLE IF NOT EXISTS Proveedor(
	cif CHAR(9) NOT NULL PRIMARY KEY,
	nombre CHAR(20) NOT NULL,
	cp INT NULL,
	mail CHAR(30) UNIQUE NULL,
	tlf INT UNIQUE NULL
);

CREATE TABLE IF NOT EXISTS Ejemplares(
	id IDENTITY(1,1) PRIMARY KEY,
	ejemplaresDisponibles SMALLINT NOT NULL,
	modelo CHAR(20) NOT NULL,
	anoAcunacion SMALLINT NOT NULL,
	ciudadAcunacion CHAR(25) NOT NULL,
	fechaAdquisicion DATE NOT NULL,
	estadoConservacion CHAR(15) NULL,
	proveedor CHAR(20) NOT NULL,
	
	CONSTRAINT FK_Proveedor FOREIGN KEY (proveedor)
	REFERENCES Proveedor(nombre),
	
	CONSTRAINT FK_Modelos FOREIGN KEY (modelo)
	REFERENCES Modelos(nombre)
);
