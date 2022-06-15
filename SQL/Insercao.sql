USE Siga
INSERT INTO Curso(Nome)
VALUES ('ADS'),
		('COMEX')
GO

INSERT INTO Aluno(Nome, CodigoCurso)
VALUES ('Lucas Akira', 1),
	   ('Guilherme Barros', 1),
	   ('Gabriel Fernandez',1),
	   ('Victor Zamora', 1),
	   ('Walison Vitorio', 1),
	   ('Vinicius Gadelha', 1),
	   ('Eloy Neto', 2)
GO

INSERT INTO Disciplina(CodigoCurso, Codigo, Nome, Sigla, Turno, NumAulas)
VALUES (1, '4203-010', 'Arquitetura e Organização de Computadores', 'AOC', 'T', '4'),
	   (1, '4203-020', 'Arquitetura e Organização de Computadores', 'AOC', 'N', '4'),
	   (1,'4208-010', 'Laboratório de Hardware', 'LDH', 'T', '4'),
	   (1,'4226-004', 'Banco de Dados', 'BDD', 'T', '4'),
	   (1,'4213-003', 'Sistemas Operacionais I', 'SOI', 'T', '4'),
	   (1,'4213-013', 'Sistemas Operacionais I', 'SOI', 'N', '4'),
	   (1,'4233-005', 'Laboratório de Banco de Dados', 'LBD', 'T', '4'),
	   (2,'5005-220', 'Métodos Para a Produção do Conhecimento', 'MPC', 'T', '4')
GO

SELECT * FROM Disciplina

INSERT INTO Avaliacao(CodigoDisciplina, Tipo, Peso)
VALUES 
	--Arquitetura T e N
	('4203-010', 'P1', 0.3),
	('4203-010', 'P2', 0.5),
	('4203-010', 'T', 0.2),
    ('4203-020', 'P1', 0.3),
	('4203-020', 'P2', 0.5),
	('4203-020', 'T', 0.2),

	--LAB Hardware T
	('4208-010', 'P1', 0.3),
	('4208-010', 'P2', 0.5),
	('4208-010', 'T', 0.2),
	-- Banco de dados T
	('4226-004', 'P1', 0.3),
	('4226-004', 'P2', 0.5),
	('4226-004', 'T', 0.2),
	--Sistemas operacionais T E e N
	('4213-013', 'PE', 0.2),
	('4213-013', 'P1', 0.35),
	('4213-013', 'P2', 0.35),
	('4213-013', 'T', 0.3),
	('4213-003', 'PE', 0.2),
	('4213-003', 'P1', 0.35),
	('4213-003', 'P2', 0.35),
	('4213-003', 'T', 0.3),
	--Lab banco de dados T
	('4233-005', 'P1', 0.33),
	('4233-005', 'P2', 0.33),
	('4233-005', 'P3', 0.33),
	--Métodos Para a Produção do Conhecimento - COMEX T
	('5005-220', 'MC', 0.8),
	('5005-220', 'MR', 0.2)
	   
GO

INSERT INTO Avaliacao(CodigoDisciplina, Tipo, Peso)
VALUES 
	--Arquitetura T e N
	('4203-010', 'E', 1),
   ('4203-020', 'E', 1),

	--LAB Hardware T
	('4208-010', 'E', 1),
	-- Banco de dados T
	('4226-004', 'E', 1),

	--Sistemas operacionais T E e N
	('4213-013', 'E', 1),

	('4213-003', 'E', 1),

	--Lab banco de dados T
	('4233-005', 'E', 1),

	--Métodos Para a Produção do Conhecimento - COMEX T
	('5005-220', 'E',1)

GO
SELECT * FROM Avaliacao


INSERT INTO Aluno_Disciplina(RaAluno, CodigoDisciplina)
values 
		(2009,'4208-010'),
		(2010,'4208-010'),
		(2011,'4208-010'),
		(2013,'4208-010'),
		(2014,'4208-010'),
		(2009, '4203-010'),
		(2010, '4203-010'),
		(2011, '4233-005'),
		(2012, '4208-010'),
		(2013, '4213-013'),
		(2014, '4213-013'),
		(2015, '5005-220')

INSERT INTO Aluno_Disciplina(RaAluno, CodigoDisciplina)
values (2010, '4213-003')
		

SELECT * FROM Aluno_Disciplina




INSERT INTO Notas(RaAluno, CodigoAvaliacao)
VALUES 
		(2009, 1),
       (2009, 2),
       (2009, 3),
	   (2010, 1),  
	   (2010, 2), 
	   (2010, 3),
	   (2011, 1),  
	   (2011, 2), 
	   (2011, 3),
	   (2012, 1),  
	   (2012, 2), 
	   (2012, 3),
	   (2013, 1),  
	   (2013, 2), 
	   (2013, 3),
	   (2014, 1),  
	   (2014, 2), 
	   (2014, 3),
	   (2015, 24),
	   (2015,25),
       (2009, 4),
       (2009, 5),
       (2009,6),
	   (2010, 4),  
	   (2010, 5), 
	   (2010, 6),
	   (2011, 4),  
	   (2011, 5), 
	   (2011, 6),
	   (2012, 4),  
	   (2012, 5), 
	   (2012, 6),
	   (2013, 4),  
	   (2013, 5), 
	   (2013, 6),
	   (2014, 4),  
	   (2014, 5), 
	   (2014, 6)
	  
GO

SELECT * FROM Avaliacao

SELECT * FROM Notas

INSERT INTO Faltas(RaAluno, CodigoDisciplina, DataFalta ,Presenca)
VALUES (1002, '4203-010', '2021-05-28', 2),
       (1003, '4203-010', '2021-05-28', 0),
       (1004, '4233-005', '2021-05-29', 0),
	   (1005, '4208-010', '2021-05-29', 1),  
	   (1006, '4213-013', '2021-05-30', 2), 
	   (1007, '4213-013', '2021-05-30', 1)
	   
GO


select * from faltas where DataFalta = '2021-06-25'