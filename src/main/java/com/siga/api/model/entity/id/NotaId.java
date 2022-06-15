package com.siga.api.model.entity.id;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.siga.api.model.entity.Aluno;
import com.siga.api.model.entity.Avaliacao;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class NotaId implements Serializable{

	private static final long serialVersionUID = 1L;

	  @GeneratedValue
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RaAluno",  nullable = false, insertable = false, updatable = false)
	private Aluno aluno;
	
	  @GeneratedValue
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CodigoAvaliacao", nullable = false, insertable = false, updatable = false)
	private Avaliacao avaliacao;


	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


	public Avaliacao getAvaliacao() {
		return avaliacao;
	}


	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}


	

	

	
}
