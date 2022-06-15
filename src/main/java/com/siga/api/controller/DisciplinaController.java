package com.siga.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siga.api.domain.repository.DisciplinaRepository;
import com.siga.api.model.entity.Disciplina;

@CrossOrigin
@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	
	@GetMapping
	public List<Disciplina> getDisciplinas(){
		return disciplinaRepository.findAll();
	}
	
	@GetMapping("/curso/{codigoCurso}")
	public List<Disciplina> getDisciplinaByCurso(@PathVariable int codigoCurso){
		
		
		
		return disciplinaRepository.findDisciplinasByCurso(codigoCurso);
				
	}
	
	@GetMapping("/sigla/{siglaDisciplina}")
	public List<Disciplina> getDisciplinaBySigla(@PathVariable String siglaDisciplina){

		return disciplinaRepository.findAllBySigla(siglaDisciplina);
				
	}
}
