package com.siga.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siga.api.model.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
