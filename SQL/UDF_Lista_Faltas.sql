
--UDF que retorna (Ra, Nome, QtdePresenca)
create function fn_aluno_falta(@CodigoDisciplina char(8), @DataFalta date)
returns @alunos_falta table(
	ra int,
	nome varchar(100),
	presenca int
)
as
begin

	declare @qtdePresenca as int,
			@existeAlunoFalta as int,
			
			@Ra as int

	--insere todos os alunos da disciplina
	insert into @alunos_falta(ra, nome) select Ra, Nome from Aluno
													inner join Aluno_Disciplina 
													on Aluno_Disciplina.RaAluno = Aluno.Ra
													where Aluno_Disciplina.CodigoDisciplina = @CodigoDisciplina

	
	DECLARE c CURSOR FOR select Ra from Aluno
								inner join Aluno_Disciplina 
								on Aluno_Disciplina.RaAluno = Aluno.Ra
								where Aluno_Disciplina.CodigoDisciplina = @CodigoDisciplina
					

	OPEN c
	FETCH NEXT FROM c INTO @Ra

	WHILE @@FETCH_STATUS = 0
	BEGIN

		set @existeAlunoFalta = (select count(RaAluno) from Faltas 
								where CodigoDisciplina = @CodigoDisciplina and DataFalta = @DataFalta and RaAluno = @Ra)

		if(@existeAlunoFalta != 0)
		begin

			set @qtdePresenca = (select Presenca from Faltas 
								where CodigoDisciplina = @CodigoDisciplina and DataFalta = @DataFalta and RaAluno = @Ra)

			update @alunos_falta set presenca = @qtdePresenca where ra = @Ra
		end
		else
		begin
			update @alunos_falta set presenca = null where ra = @Ra
		end

		FETCH NEXT FROM c INTO @Ra
	END

	CLOSE c
	DEALLOCATE c


	RETURN

end


select * from fn_aluno_falta('4203-010', '2021-05-28')