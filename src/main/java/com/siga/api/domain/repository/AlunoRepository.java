package com.siga.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.api.model.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
	
	List<Aluno> findAlunoByDisciplina(String codigoDisciplina);
	
	
}
