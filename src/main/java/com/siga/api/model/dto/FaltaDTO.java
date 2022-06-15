package com.siga.api.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FaltaDTO {

	private int ra;
	private String disciplina;
	private Date dataFalta;
	private int qtdePresenca;
	public int getRa() {
		return ra;
	}
	public void setRa(int ra) {
		this.ra = ra;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public Date getDataFalta() {
		return dataFalta;
	}
	public void setDataFalta(Date dataFalta) {
		this.dataFalta = dataFalta;
	}
	public int getQtdePresenca() {
		return qtdePresenca;
	}
	public void setQtdePresenca(int qtdePresenca) {
		this.qtdePresenca = qtdePresenca;
	}
	
	
}
