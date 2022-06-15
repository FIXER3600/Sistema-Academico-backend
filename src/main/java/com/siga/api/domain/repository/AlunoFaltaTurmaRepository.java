package com.siga.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.api.model.entity.AlunoFaltaTurma;

@Repository
public interface AlunoFaltaTurmaRepository extends JpaRepository<AlunoFaltaTurma, Integer>{

	public List<AlunoFaltaTurma> getListaAlunoFaltaTurma(String codigoDisciplina);
}
