package com.siga.api.domain.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siga.api.domain.repository.FaltaRepository;
import com.siga.api.model.dto.FaltaDTO;
import com.siga.api.model.entity.Aluno;
import com.siga.api.model.entity.Disciplina;
import com.siga.api.model.entity.Falta;
import com.siga.api.model.entity.id.FaltaId;

@Service
public class FaltaService {
	
	@Autowired
	private FaltaRepository faltaRepository;
	
	public Falta updateFalta(FaltaDTO faltaDTO) {
		
		Aluno aluno = new Aluno();
		aluno.setRa(faltaDTO.getRa());
		
		Disciplina disciplina = new Disciplina();
		disciplina.setCodigo(faltaDTO.getDisciplina());
		
		Date diaSeguinte =  new Date(faltaDTO.getDataFalta().getTime() + 24*60*60*1000);
		
		
		FaltaId id = new FaltaId();
		id.setAluno(aluno);
		id.setDataFalta(diaSeguinte);
		id.setDisciplina(disciplina);
		
		Falta falta = new Falta();
		falta.setId(id);
		falta.setPresenca(faltaDTO.getQtdePresenca());
		return falta;
	}
	
	public List<Date> dataAulasDadas(String codigoDisciplina){
		
		List<Date> datasAulas = new ArrayList<Date>();
		
		List<Falta> faltas = faltaRepository.getDatasFalta(codigoDisciplina);
		
		for(Falta f : faltas) {
			datasAulas.add(f.getId().getDataFalta());
		}
		
		return datasAulas;
	}
}
