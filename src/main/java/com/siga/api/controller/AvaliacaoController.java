package com.siga.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siga.api.domain.repository.AvaliacaoRepository;
import com.siga.api.model.entity.Avaliacao;

@CrossOrigin
@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@GetMapping
	public List<Avaliacao> getAvaliacao(){
		return avaliacaoRepository.findAll();
	}
	
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Avaliacao> getAvaliacao(@PathVariable int codigo){
		return avaliacaoRepository.findById(codigo)
				.map(avaliacao -> ResponseEntity.ok(avaliacao))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/disciplina/{codigoDisciplina}")
	public List<Avaliacao> getAvaliacaoByDisciplina(@PathVariable String codigoDisciplina){
		
		
		return avaliacaoRepository.findAvaliacaoByDisciplina(codigoDisciplina);
	}
}
