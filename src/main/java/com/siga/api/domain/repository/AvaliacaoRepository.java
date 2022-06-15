package com.siga.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siga.api.model.entity.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer>{

	public List<Avaliacao> findAvaliacaoByDisciplina(String codigo);
}
