package com.siga.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.api.model.entity.AlunoNota;

@Repository
public interface AlunoNotaRepository  extends JpaRepository<AlunoNota, Integer>{

	public List<AlunoNota> findAlunosNota (int codigoAvaliacao);
}
