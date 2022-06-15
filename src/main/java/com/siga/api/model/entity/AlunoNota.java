package com.siga.api.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import com.sun.istack.Nullable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "AlunoNota")
@Getter
@Setter
@NoArgsConstructor
@NamedNativeQuery(name = "AlunoNota.findAlunosNota",
		query = "select Ra, Nome, Notas.Nota from Aluno "
		+ "inner join Aluno_Disciplina as ad "
		+ "on ad.RaAluno = Aluno.Ra "
		+ "inner join Avaliacao "
		+ "on ad.CodigoDisciplina = Avaliacao.CodigoDisciplina "
		+ "inner join Notas "
		+ "on Notas.CodigoAvaliacao = Avaliacao.Codigo and Notas.RaAluno = Ra "
		+ "where Notas.CodigoAvaliacao = ?1",
		resultClass = AlunoNota.class)

public class AlunoNota {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ra;
	
	@Column
	private String nome;
	
	@Column
	@Nullable
	private Float nota;

	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getNota() {
		return nota;
	}

	public void setNota(Float nota) {
		this.nota = nota;
	}
	
	
}
