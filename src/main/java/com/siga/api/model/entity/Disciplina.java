package com.siga.api.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@NamedNativeQuery(name = "Disciplina.findDisciplinasByCurso",
					query = "select *  from Disciplina where CodigoCurso = ?1 ",
					resultClass = Disciplina.class)
public class Disciplina {

	@Id
	private String codigo;
	
	@Column
	private String nome;
	
	@Column
	private String sigla;
	
	@Column
	private char turno;
	
	@Column
	private int numAulas;
	
	@ManyToOne(targetEntity = Curso.class)
	@JoinColumn(name = "CodigoCurso")
	private Curso curso;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public char getTurno() {
		return turno;
	}

	public void setTurno(char turno) {
		this.turno = turno;
	}

	public int getNumAulas() {
		return numAulas;
	}

	public void setNumAulas(int numAulas) {
		this.numAulas = numAulas;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
}
