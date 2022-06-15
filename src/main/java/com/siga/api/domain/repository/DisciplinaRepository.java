package com.siga.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siga.api.model.entity.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, String>{

	public List<Disciplina> findDisciplinasByCurso(int codigoCurso);
	public List<Disciplina> findAllBySigla(String sigla);
	public Disciplina findByCodigo(String codigo);
}
