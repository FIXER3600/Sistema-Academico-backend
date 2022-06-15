package com.siga.api.model.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.siga.api.model.entity.id.NotaId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Notas")
public class Notas {


	@EmbeddedId
	@NonNull
	private NotaId id;
	
	
	@Column(name="Nota")
	private Float nota;

	public Notas() {
		// TODO Auto-generated constructor stub
		super();
	}

	public NotaId getId() {
		return id;
	}

	public void setId(NotaId id) {
		this.id = id;
	}

	public Float getNota() {
		return nota;
	}

	public void setNota(Float nota) {
		this.nota = nota;
	}
	

	
}
