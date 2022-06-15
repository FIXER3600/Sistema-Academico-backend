package com.siga.api.domain.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.api.model.entity.AlunoFalta;

@Repository
public interface AlunoFaltaRepository extends JpaRepository<AlunoFalta, Integer>{

	List<AlunoFalta> findAlunosFalta(String codigoDiscplina, Date data);
}
