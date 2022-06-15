package com.siga.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.api.model.entity.AlunoMedia;

@Repository
public interface AlunoMediaRepository extends JpaRepository<AlunoMedia, Integer>{

	public List<AlunoMedia> getListaAlunos(String codigoDisciplina);
}
