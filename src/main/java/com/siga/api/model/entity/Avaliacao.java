package com.siga.api.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@NamedNativeQuery(name = "Avaliacao.findAvaliacaoByDisciplina",
							query = "select *  from Avaliacao where CodigoDisciplina = ?1 ",
							resultClass = Avaliacao.class)
public class Avaliacao {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@Column
	private String tipo;
	
	@Column
	private float peso;
	
	@ManyToOne(targetEntity = Disciplina.class)
	@JoinColumn(name = "CodigoDisciplina")
	private Disciplina disciplina;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	
	
}
