
package com.siga.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siga.api.model.entity.Notas;
import com.siga.api.model.entity.id.NotaId;

@Repository
public interface NotaRepository extends JpaRepository<Notas, NotaId>{

}
