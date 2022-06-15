CREATE DATABASE Siga
GO

USE Siga
GO

CREATE TABLE Curso(
Codigo		INT	IDENTITY         NOT NULL,
Nome		VARCHAR(100)         NOT NUll,
PRIMARY KEY (Codigo),
)
GO

CREATE TABLE Disciplina(
Codigo CHAR(8)			NOT NULL,
Nome VARCHAR(100)		NOT NULL,
Sigla VARCHAR(3)        NOT NULL,
Turno VARCHAR(1)		NOT NULL,
NumAulas INT			NOT NULL,
CodigoCurso INT			NOT NULL,
PRIMARY KEY (Codigo),
FOREIGN KEY (CodigoCurso) REFERENCES Curso (Codigo),
)
GO

CREATE TABLE Aluno(
Ra				INT		IDENTITY(1001, 1)   NOT NULL,
Nome			VARCHAR(100)				NOT NULL,
CodigoCurso		INT							NOT NULL,

PRIMARY KEY (Ra),
FOREIGN KEY (CodigoCurso) REFERENCES Curso (Codigo),

)
GO

CREATE TABLE Aluno_Disciplina(
RaAluno				INT		NOT NULL,
CodigoDisciplina	CHAR(8) NOT NULL,

PRIMARY KEY(RaAluno, CodigoDisciplina),
FOREIGN KEY (RaAluno) REFERENCES Aluno (Ra),
FOREIGN KEY (CodigoDisciplina) REFERENCES Disciplina (Codigo),
)
GO

CREATE TABLE Faltas(
RaAluno INT				NOT NUll,
CodigoDisciplina CHAR(8)	NOT NULL,
DataFalta Date				NOT NULL,
Presenca INT			NOT NULL,
PRIMARY KEY (RaAluno, CodigoDisciplina, DataFalta),
FOREIGN KEY (RaAluno) REFERENCES Aluno (Ra),
FOREIGN KEY (CodigoDisciplina) REFERENCES Disciplina (Codigo),
)
GO


CREATE TABLE Avaliacao(
Codigo INT IDENTITY			NOT NUll,
Tipo VARCHAR(2)				NOT NULL,
Peso DECIMAL(7,2)			NOT NULL,
CodigoDisciplina CHAR(8)	NOT NULL,


PRIMARY KEY (Codigo),
FOREIGN KEY (CodigoDisciplina) REFERENCES Disciplina (Codigo),
)
GO


CREATE TABLE Notas(
RaAluno INT						NOT NUll,
CodigoAvaliacao INT				NOT NULL,
Nota DECIMAL (7,2),

PRIMARY KEY (RaAluno, CodigoAvaliacao),
FOREIGN KEY (CodigoAvaliacao) REFERENCES Avaliacao (Codigo),
FOREIGN KEY (RaAluno) REFERENCES Aluno(Ra),
)
GO


select * from Notas

select * from Faltas where CodigoDisciplina = '4203-010' and RaAluno = 1001