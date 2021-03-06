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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "Aluno")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@NoArgsConstructor
@AllArgsConstructor


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
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ra;

	@Column(name = "Nome")
	private String nome;
	
	@Column(name = "Genero")
	private String genero;

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
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
}
