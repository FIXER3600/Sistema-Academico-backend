package com.siga.api.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Aluno")

@Getter
@Setter

@NoArgsConstructor



//findAlunosByDisciplina
@NamedNativeQuery(
		
		name = "Aluno.findAlunoByDisciplina",
		query = "select Aluno.Ra, Aluno.Nome, Aluno.CodigoCurso, ad.RaAluno, ad.CodigoDisciplina, disc.Codigo from Aluno "
				+ "inner join Aluno_Disciplina as ad "
				+ "on ad.RaAluno = Aluno.Ra "
				+ "inner join Disciplina disc "
				+ "on disc.Codigo = ad.CodigoDisciplina "
				+ "where CodigoDisciplina = ?1",
		resultClass = Aluno.class
				)
public class Aluno {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ra;
	
	@Column
	private String nome;
	
	@ManyToOne(targetEntity = Curso.class)
	@JoinColumn(name = "CodigoCurso")
	private Curso curso;

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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
}
