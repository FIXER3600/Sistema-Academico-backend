
drop function fn_get_all_faltas

create function fn_get_all_faltas(@CodigoDisciplina char(8))
returns @alunos_falta table(
	ra_aluno int,
	nome_aluno varchar(100),
	semana1 char(4),
	semana2 char(4),
	semana3 char(4),
	semana4 char(4),
	semana5 char(4),
	semana6 char(4),
	semana7 char(4),
	semana8 char(4),
	semana9 char(4),
	semana10 char(4),
	semana11 char(4),
	semana12 char(4),
	semana13 char(4),
	semana14 char(4),
	semana15 char(4),
	semana16 char(4),
	semana17 char(4),
	semana18 char(4),
	semana19 char(4),
	semana20 char(4),
	total_faltas int
	
)
as
begin


	declare @Ra as int,
			@DataFalta as date,
			@Presenca as int,

			@dataSemana as date,
			@contadorAulasDadas as int,
			@charFalta as char(4),
			@numAulas as int,
			@nomeColuna as varchar(50),
			@totalFaltas as int


	--Insere o RA e o nome dos alunos da disciplina

	insert into @alunos_falta (ra_aluno, nome_aluno) select distinct RaAluno, Aluno.Nome FROM Faltas 
													inner join Aluno
													on Faltas.RaAluno = Aluno.Ra
													where Faltas.CodigoDisciplina = @CodigoDisciplina


	--Pega de uma disciplina em especifico
	DECLARE c CURSOR FOR SELECT RaAluno, DataFalta, Presenca FROM Faltas 
						where CodigoDisciplina = @CodigoDisciplina
						order by DataFalta
					

	OPEN c
	FETCH NEXT FROM c INTO @Ra, @DataFalta, @Presenca


	set @numAulas = (select NumAulas from Disciplina where Codigo = @CodigoDisciplina)
	set @dataSemana = (SELECT top 1 DataFalta FROM Faltas 	where CodigoDisciplina = @CodigoDisciplina order by DataFalta)
	set @contadorAulasDadas = 1

	WHILE @@FETCH_STATUS = 0
	BEGIN

		if(@dataSemana != @DataFalta)
		begin
			set @contadorAulasDadas = @contadorAulasDadas + 1
			set @dataSemana = @DataFalta
		end

		

			if(@Presenca = 1)
			begin
				if(@numAulas = 2)	
				begin
					set @charFalta = 'FP'
				end
				else
				begin 
					set @charFalta = 'FPPP'
				end
			end
			else if(@Presenca = 2)
			begin
				if(@numAulas = 2)	
				begin
					set @charFalta = 'FF'
				end
				else
				begin 
					set @charFalta = 'FFPP'
				end
			end
			else if(@Presenca = 3)
			begin
				
				set @charFalta = 'FFFP'
				
			end
			else if(@Presenca = 4)
			begin
				set @charFalta = 'FFFF'
				
			end
			else
			begin
				set @charFalta = 'PPPP'
			end

			--IF semanas // 
			if(@contadorAulasDadas = 1)
			begin
				update @alunos_falta set semana1 = @charFalta where ra_aluno = @Ra
			end
			if(@contadorAulasDadas = 2)
			begin
				update @alunos_falta set semana2 = @charFalta where ra_aluno = @Ra
			end
			if(@contadorAulasDadas = 3)
			begin
				update @alunos_falta set semana3 = @charFalta where ra_aluno = @Ra
			end
			if(@contadorAulasDadas = 4)
			begin
				update @alunos_falta set semana4 = @charFalta where ra_aluno = @Ra

			end
			if(@contadorAulasDadas = 5)
			begin
				update @alunos_falta set semana5 = @charFalta where ra_aluno = @Ra

			end
			if(@contadorAulasDadas = 6)
			begin
				update @alunos_falta set semana6 = @charFalta where ra_aluno = @Ra

			end
			if(@contadorAulasDadas = 7)
			begin
				update @alunos_falta set semana7 = @charFalta where ra_aluno = @Ra

			end
			if(@contadorAulasDadas = 8)
			begin
				update @alunos_falta set semana8 = @charFalta where ra_aluno = @Ra

			end
			if(@contadorAulasDadas = 9)
			begin
				update @alunos_falta set semana9 = @charFalta where ra_aluno = @Ra

			end
			if(@contadorAulasDadas = 10)
			begin
				update @alunos_falta set semana10 = @charFalta where ra_aluno = @Ra

			end
			if(@contadorAulasDadas = 11)
			begin
				update @alunos_falta set semana11 = @charFalta where ra_aluno = @Ra

			end
			if(@contadorAulasDadas = 12)
			begin
				update @alunos_falta set semana12 = @charFalta where ra_aluno = @Ra

			end
			if(@contadorAulasDadas = 13)
			begin
				update @alunos_falta set semana13 = @charFalta where ra_aluno = @Ra

			end
			if(@contadorAulasDadas = 14)
			begin
				update @alunos_falta set semana14 = @charFalta where ra_aluno = @Ra

			end
			if(@contadorAulasDadas = 15)
			begin
				update @alunos_falta set semana15 = @charFalta where ra_aluno = @Ra

			end
			if(@contadorAulasDadas = 16)
			begin
				update @alunos_falta set semana16 = @charFalta where ra_aluno = @Ra

			end
			if(@contadorAulasDadas = 17)
			begin
				update @alunos_falta set semana17 = @charFalta where ra_aluno = @Ra

			end
			if(@contadorAulasDadas = 18)
			begin
				update @alunos_falta set semana18 = @charFalta where ra_aluno = @Ra

			end
			if(@contadorAulasDadas = 19)
			begin
				update @alunos_falta set semana19 = @charFalta where ra_aluno = @Ra

			end
			if(@contadorAulasDadas = 20)
			begin
				update @alunos_falta set semana20 = @charFalta where ra_aluno = @Ra

			end

			
			update @alunos_falta set total_faltas = (ISNULL(total_faltas, 0) + @Presenca)  where ra_aluno = @Ra


		FETCH NEXT FROM c INTO @Ra, @DataFalta, @Presenca
	END
	return

end



select * from fn_get_all_faltas('4203-010')

SELECT RaAluno, CodigoDisciplina, DataFalta FROM Faltas where CodigoDisciplina = '4203-010' and RaAluno = (select top 1 RaAluno from Aluno_Disciplina where CodigoDisciplina = '4203-010') order by DataFalta



SELECT distinct DataFalta FROM Faltas where CodigoDisciplina = '4203-010' order by DataFalta

select ra_aluno, nome_aluno, 
semana1, semana2, semana3, semana4, semana5, semana6, semana7, semana8, semana9, semana10,
semana11, semana12, semana13, semana14, semana15, semana16, semana17, semana18, semana19, semana20, total_faltas
from fn_get_all_faltas('4203-010')
