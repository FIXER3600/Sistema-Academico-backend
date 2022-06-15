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



--Trigger pra quando o aluno for iserido na disciplina ele vá para a tabela notas como null

create trigger t_add_aluno_notas on Aluno_Disciplina
for insert 
as
begin
	declare @RaAluno as int,
			@CodigoDisciplina as char(8)

	set @RaAluno =  (select RaAluno from INSERTED)
	set @CodigoDisciplina =  (select CodigoDisciplina from INSERTED)


	insert into Notas (RaAluno, CodigoAvaliacao) select * from fn_aluno_avaliacao(@RaAluno, ''+@CodigoDisciplina+'')

end

