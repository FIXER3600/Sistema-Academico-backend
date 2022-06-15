package com.siga.api.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

@NamedNativeQuery(name = "AlunoMedia.getListaAlunos",
					query = "select ra_aluno, nome_aluno, nota1, nota2, nota3, nota4, "
							+ "exame, media_final, situacao from fn_get_alunos_media(?1)",
					resultClass = AlunoMedia.class)
public class AlunoMedia {

	
	@Id

	private int ra_aluno;
	

	private String nome_aluno;
	
	@Column
	private Float nota1;
	
	@Column
	private Float nota2;
	
	@Column
	private Float nota3;
	
	@Column
	private Float nota4;
	
	@Column
	private Float exame;
	
	@Column
	private Float media_final;
	
	@Column
	private String situacao;

	public int getRa_aluno() {
		return ra_aluno;
	}

	public void setRa_aluno(int ra_aluno) {
		this.ra_aluno = ra_aluno;
	}

	public String getNome_aluno() {
		return nome_aluno;
	}

	public void setNome_aluno(String nome_aluno) {
		this.nome_aluno = nome_aluno;
	}

	public Float getNota1() {
		return nota1;
	}

	public void setNota1(Float nota1) {
		this.nota1 = nota1;
	}

	public Float getNota2() {
		return nota2;
	}

	public void setNota2(Float nota2) {
		this.nota2 = nota2;
	}

	public Float getNota3() {
		return nota3;
	}

	public void setNota3(Float nota3) {
		this.nota3 = nota3;
	}

	public Float getNota4() {
		return nota4;
	}

	public void setNota4(Float nota4) {
		this.nota4 = nota4;
	}

	public Float getExame() {
		return exame;
	}

	public void setExame(Float exame) {
		this.exame = exame;
	}

	public Float getMedia_final() {
		return media_final;
	}

	public void setMedia_final(Float media_final) {
		this.media_final = media_final;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
}
