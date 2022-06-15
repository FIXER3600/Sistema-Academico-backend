 package com.siga.api.domain.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siga.api.domain.repository.AlunoFaltaRepository;
import com.siga.api.model.entity.AlunoFalta;

@Service
public class AlunoFaltaService {

	@Autowired
	private AlunoFaltaRepository alunoFaltaRepository;
	
	
	public List<AlunoFalta> getAlunoFalta(String codigoDisciplina, String dataFalta){
		
		Date data;
		data = Date.valueOf(dataFalta);
		
		List<AlunoFalta> lista = alunoFaltaRepository.findAlunosFalta(codigoDisciplina, data);


		for(AlunoFalta aluno : lista) {
		
			if(aluno.getQtdeFalta() == null) {
				aluno.setQtdeFalta(0);
			}
		}
		
		return lista;
	}
	
	
	
	
	
}
