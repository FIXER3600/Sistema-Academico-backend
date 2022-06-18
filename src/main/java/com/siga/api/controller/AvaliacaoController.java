package com.siga.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.siga.api.domain.repository.AvaliacaoRepository;
import com.siga.api.model.entity.Avaliacao;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@PostMapping("/create")
	public ResponseEntity<Avaliacao> saveAvaliacao(@RequestBody Avaliacao avaliacao) {
		avaliacao = avaliacaoRepository.save(avaliacao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}").buildAndExpand(avaliacao.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(avaliacao);
	}

	@PutMapping("/update/{codigo}")
	public ResponseEntity<Avaliacao> updateAvaliacao(@PathVariable Integer codigo, @RequestBody Avaliacao avaliacao) {
		if (avaliacao != null) {
			avaliacao.setCodigo(codigo);
			avaliacaoRepository.save(avaliacao);
			return ResponseEntity.accepted().body(avaliacao);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/delete/{codigo}")
	public ResponseEntity<Void> deleteAvaliacao(@PathVariable Integer codigo) {
		avaliacaoRepository.deleteById(codigo);
		return ResponseEntity.accepted().build();
	}
	
	@GetMapping("/disciplina/{codigoDisciplina}")
	public List<Avaliacao> getAvaliacaoByDisciplina(@PathVariable String codigoDisciplina){
		
		
		return avaliacaoRepository.findAvaliacaoByDisciplina(codigoDisciplina);
	}
}
