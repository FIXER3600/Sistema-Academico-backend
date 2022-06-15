
--Pegar todos os alunos de uma determinada disciplina por codigo da disciplina
select Aluno.Ra, Aluno.Nome, ad.RaAluno, ad.CodigoDisciplina, disc.Codigo from Aluno 
inner join Aluno_Disciplina as ad
on ad.RaAluno = Aluno.Ra
inner join Disciplina disc
on disc.Codigo = ad.CodigoDisciplina
where CodigoDisciplina = '4203-010'

select * from Disciplina where CodigoCurso = 1 group by Disciplina.Nome



--Pegar todas as disciplinas de um curso por turno
select Nome, Turno from Disciplina where CodigoCurso = 1 and Turno = 'T'


--Pegar todas as avaliações de uma disciplina
select Tipo, Peso from Avaliacao where CodigoDisciplina = '4203-010'

--UDF que retorna essa desgraça aqui 
--RA_Aluno, Nome_Aluno, Nota1, Nota2, ..., Média_Final, Situação(Aprovado ou  Reprovado))

drop  function fn_get_alunos_media

create function fn_get_alunos_media(@CodigoDisciplina as char(8))

returns @alunos_media table(
	ra_aluno int,
	nome_aluno varchar(100),
	nota1 decimal (7,2),
	nota2 decimal (7,2),
	nota3 decimal (7,2),
	nota4 decimal (7,2),
	exame decimal(7,2),
	media_final decimal (7,2), 
	situacao varchar(50)
)
as
begin

	declare @nomeAluno as varchar(100),
			@nomeDisciplina as varchar(50),
			@media_final as decimal (7,2), 
			@situacao as varchar(50),
			@pesoAvaliacao as decimal(7,2),
			@tipoAvaliacao varchar(50),
			@notaProva as decimal(7,2),
			@nota1 as decimal(7,2),
			@nota2 as decimal(7,2),
			@nota3 as decimal(7,2),
			@exame as decimal(7,2),

			@Ra as int,
			@CodigoAvaliacao as int,
			@Nota as decimal(7,2)
	
	
	--Pega de uma disciplina em especifico
	DECLARE c CURSOR FOR SELECT RaAluno, CodigoAvaliacao, Nota FROM Notas 
						inner join Avaliacao
						on Avaliacao.Codigo = CodigoAvaliacao
						where Avaliacao.CodigoDisciplina = @CodigoDisciplina
					

	OPEN c
	FETCH NEXT FROM c INTO @Ra, @CodigoAvaliacao, @Nota


	insert into @alunos_media (ra_aluno) select distinct RaAluno FROM Notas 
						inner join Avaliacao
						on Avaliacao.Codigo = Notas.CodigoAvaliacao
						where Avaliacao.CodigoDisciplina = @CodigoDisciplina
						

	--Coloca p1, p2, p3 pe, trabalhos etc
	WHILE @@FETCH_STATUS = 0
	BEGIN

		set @nomeDisciplina = (select Nome from Disciplina where Codigo = @CodigoDisciplina)
		set @nomeAluno = (select Nome from Aluno where Ra = @Ra)
		update @alunos_media set nome_aluno = @nomeAluno where ra_aluno = @Ra

		SET @pesoAvaliacao = (select Peso from Avaliacao where Codigo = @CodigoAvaliacao)

		SET @tipoAvaliacao =  (select Tipo from Avaliacao where Codigo = @CodigoAvaliacao)
		
		SET @notaProva = (@pesoAvaliacao * @Nota)

		
		IF (@tipoAvaliacao = 'P1' or @tipoAvaliacao = 'MC')
		BEGIN
			update @alunos_media set nota1 = @notaProva where ra_aluno = @Ra
			
			
		END
		IF (@tipoAvaliacao = 'P2' or @tipoAvaliacao = 'MR')
		BEGIN
			update @alunos_media set nota2 = @notaProva where ra_aluno = @Ra
		END

		IF (@tipoAvaliacao = 'P3' or @tipoAvaliacao = 'T')
		BEGIN
			update @alunos_media set nota3 = @notaProva where ra_aluno = @Ra
		END
		
		IF (@tipoAvaliacao = 'PE')
		BEGIN
			update @alunos_media set nota4 = @notaProva where ra_aluno = @Ra
		END

		IF (@tipoAvaliacao = 'E')
		BEGIN
			update @alunos_media set exame = @notaProva where ra_aluno = @Ra
		END

		--Calcula a media
		set @media_final = (select (ISNULL(nota1, 0) + ISNULL(nota2, 0) + ISNULL(nota3, 0) + ISNULL(nota4, 0)) 
							from @alunos_media where ra_aluno = @Ra)

		update @alunos_media set media_final =  @media_final where ra_aluno = @Ra	
 

		--Coloca os status min 2 notas
		set @nota1 = (select nota1 from @alunos_media where ra_aluno = @Ra)
		set @nota2 = (select nota2 from @alunos_media where ra_aluno = @Ra)
		
		if(@nota1 is not null and @nota2 is not null)
		begin

		
			if(@media_final >= 3 and @media_final < 6 and (select exame from @alunos_media where ra_aluno = @Ra) is null)
			begin
				update @alunos_media set situacao = 'Exame' where ra_aluno = @Ra	
			end
		
			if(@media_final >= 3 and @media_final < 6 and (select exame from @alunos_media where ra_aluno = @Ra) is  not null)
			begin

				set @exame = (select exame from @alunos_media where ra_aluno = @Ra)
				set @media_final = (@media_final + @exame) / 2

				update @alunos_media set media_final =  @media_final where ra_aluno = @Ra	

				if(@media_final < 6)
				begin
					update @alunos_media set situacao = 'Reprovado' where ra_aluno = @Ra	
				end
				
			end

			if(@media_final >= 6)
			begin
				update @alunos_media set situacao = 'Aprovado' where ra_aluno = @Ra	
			end

			if(@media_final < 3)
			begin
				update @alunos_media set situacao = 'Reprovado' where ra_aluno = @Ra	
			end
		end
	
		FETCH NEXT FROM c INTO @Ra, @CodigoAvaliacao, @Nota
	END
 
	CLOSE c
	DEALLOCATE c


	RETURN

end
--Retorno da udf com pre exame?

select * from fn_get_alunos_media('5005-220')



--function teste pra inserir na tabela notas
create function fn_aluno_avaliacao(@raAluno int, @CodigoDisicplina char(8))
returns @notas table(
	ra_aluno int,
	codigo_avaliacao int
)
as
begin

	insert into @notas (codigo_avaliacao) select Codigo from Avaliacao where CodigoDisciplina = @CodigoDisicplina 

	update @notas set ra_aluno = @raAluno

	return
end

select * from fn_aluno_avaliacao( 1001, '4203-010')


select Aluno.Ra, Aluno.Nome, Faltas.Presenca from Aluno 
left join Faltas
on Faltas.RaAluno is null
where Faltas.CodigoDisciplina = '4203-010' and Faltas.DataFalta = '2021-05-28'