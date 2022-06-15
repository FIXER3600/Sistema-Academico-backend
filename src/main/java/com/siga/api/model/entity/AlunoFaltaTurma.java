package com.siga.api.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "AlunoFaltaTurma")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@NamedNativeQuery(name = "AlunoFaltaTurma.getListaAlunoFaltaTurma",
					query = "select * from fn_get_all_faltas(?1)",
					resultClass = AlunoFaltaTurma.class)


public class AlunoFaltaTurma {
	
	@Id
	@Column(name = "ra_aluno")
	private int ra;

	@Column(name = "nome_aluno")
	private String nomeAluno;
	
	@Column
	private String semana1;
	
	@Column
	private String semana2;
	
	@Column
	private String semana3;
	
	@Column
	private String semana4;
	
	@Column
	private String semana5;
	
	@Column
	private String semana6;
	
	@Column
	private String semana7;
	
	@Column
	private String semana8;
	
	@Column
	private String semana9;
	
	@Column
	private String semana10;
	
	@Column
	private String semana11;
	
	@Column
	private String semana12;
	
	@Column
	private String semana13;
	
	@Column
	private String semana14;
	
	@Column
	private String semana15;
	
	@Column
	private String semana16;
	
	@Column
	private String semana17;
	
	@Column
	private String semana18;
	
	@Column
	private String semana19;
	
	@Column
	private String semana20;
	
	@Column(name = "total_faltas")
	private String totalFaltas;

	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getSemana1() {
		return semana1;
	}

	public void setSemana1(String semana1) {
		this.semana1 = semana1;
	}

	public String getSemana2() {
		return semana2;
	}

	public void setSemana2(String semana2) {
		this.semana2 = semana2;
	}

	public String getSemana3() {
		return semana3;
	}

	public void setSemana3(String semana3) {
		this.semana3 = semana3;
	}

	public String getSemana4() {
		return semana4;
	}

	public void setSemana4(String semana4) {
		this.semana4 = semana4;
	}

	public String getSemana5() {
		return semana5;
	}

	public void setSemana5(String semana5) {
		this.semana5 = semana5;
	}

	public String getSemana6() {
		return semana6;
	}

	public void setSemana6(String semana6) {
		this.semana6 = semana6;
	}

	public String getSemana7() {
		return semana7;
	}

	public void setSemana7(String semana7) {
		this.semana7 = semana7;
	}

	public String getSemana8() {
		return semana8;
	}

	public void setSemana8(String semana8) {
		this.semana8 = semana8;
	}

	public String getSemana9() {
		return semana9;
	}

	public void setSemana9(String semana9) {
		this.semana9 = semana9;
	}

	public String getSemana10() {
		return semana10;
	}

	public void setSemana10(String semana10) {
		this.semana10 = semana10;
	}

	public String getSemana11() {
		return semana11;
	}

	public void setSemana11(String semana11) {
		this.semana11 = semana11;
	}

	public String getSemana12() {
		return semana12;
	}

	public void setSemana12(String semana12) {
		this.semana12 = semana12;
	}

	public String getSemana13() {
		return semana13;
	}

	public void setSemana13(String semana13) {
		this.semana13 = semana13;
	}

	public String getSemana14() {
		return semana14;
	}

	public void setSemana14(String semana14) {
		this.semana14 = semana14;
	}

	public String getSemana15() {
		return semana15;
	}

	public void setSemana15(String semana15) {
		this.semana15 = semana15;
	}

	public String getSemana16() {
		return semana16;
	}

	public void setSemana16(String semana16) {
		this.semana16 = semana16;
	}

	public String getSemana17() {
		return semana17;
	}

	public void setSemana17(String semana17) {
		this.semana17 = semana17;
	}

	public String getSemana18() {
		return semana18;
	}

	public void setSemana18(String semana18) {
		this.semana18 = semana18;
	}

	public String getSemana19() {
		return semana19;
	}

	public void setSemana19(String semana19) {
		this.semana19 = semana19;
	}

	public String getSemana20() {
		return semana20;
	}

	public void setSemana20(String semana20) {
		this.semana20 = semana20;
	}

	public String getTotalFaltas() {
		return totalFaltas;
	}

	public void setTotalFaltas(String totalFaltas) {
		this.totalFaltas = totalFaltas;
	}
	
	
}
