package com.siga.api.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import com.sun.istack.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "AlunoFalta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@NamedNativeQuery(name = "AlunoFalta.findAlunosFalta",
					query = "select * from fn_aluno_falta(?1, ?2)",
					resultClass = AlunoFalta.class)

public class AlunoFalta {


	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ra;
	
	@Column
	private String nome;
	
	@Column(name = "presenca")
	@Nullable
	private Integer qtdeFalta;

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

	public Integer getQtdeFalta() {
		return qtdeFalta;
	}

	public void setQtdeFalta(Integer qtdeFalta) {
		this.qtdeFalta = qtdeFalta;
	}
	
	
}
