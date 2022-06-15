package com.siga.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siga.api.domain.repository.AlunoRepository;
import com.siga.api.model.entity.Aluno;

@CrossOrigin
@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;

	
	@GetMapping
	public List<Aluno> getAlunos(){
		return alunoRepository.findAll();
	}
	
	@GetMapping("/disciplina/{codigoDisciplina}")
	public List<Aluno> getAlunosByDisciplina(@PathVariable String codigoDisciplina){
		return alunoRepository.findAlunoByDisciplina(codigoDisciplina);
	}
	
	
	
	
	@GetMapping("/{raAluno}")
	public ResponseEntity<Aluno> getAlunosByRa(@PathVariable int raAluno){
		return alunoRepository.findById(raAluno)
				.map(aluno -> ResponseEntity.ok(aluno))
				.orElse(ResponseEntity.notFound().build());
	}
}
