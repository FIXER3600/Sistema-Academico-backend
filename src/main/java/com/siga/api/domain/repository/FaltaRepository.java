package com.siga.api.domain.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.api.model.entity.Falta;
import com.siga.api.model.entity.id.FaltaId;

@Repository
public interface FaltaRepository extends JpaRepository<Falta, FaltaId>{

	public List<Falta> findByDisciplinaAndData (String codigoDisciplina, Date data);
	public Falta findByAluno(int raAluno);
	public List<Falta> getDatasFalta(String codigoDisciplina);
	

}
