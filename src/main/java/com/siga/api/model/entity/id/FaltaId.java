	package com.siga.api.model.entity.id;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.siga.api.model.entity.Aluno;
import com.siga.api.model.entity.Disciplina;
import com.sun.istack.Nullable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class FaltaId implements Serializable{
	
	public FaltaId() {
		// TODO Auto-generated constructor stub
		super();
	}

	private static final long serialVersionUID = 1L;
	
	@Nullable
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RaAluno",nullable = false, insertable = false, updatable = false)
	private Aluno aluno;
	
	@Nullable
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CodigoDisciplina", nullable = false, insertable = false, updatable = false)
	private Disciplina disciplina;
	
	@Nullable

	@Column(name = "DataFalta")
	private Date dataFalta;



	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Date getDataFalta() {
		return dataFalta;
	}

	public void setDataFalta(Date dataFalta) {
		this.dataFalta = dataFalta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
