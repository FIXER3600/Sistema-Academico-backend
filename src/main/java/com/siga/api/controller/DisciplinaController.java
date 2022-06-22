package com.siga.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.siga.api.domain.repository.DisciplinaRepository;
import com.siga.api.model.entity.Disciplina;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@GetMapping("/disciplina/{codigo}")
	public ResponseEntity<Disciplina> getByCodigo(@PathVariable String codigo) {
		Disciplina disciplina = disciplinaRepository.getById(codigo);
		return ResponseEntity.ok().body(disciplina);
	}

	@GetMapping("/curso/{codigoCurso}")
	public List<Disciplina> getDisciplinaByCurso(@PathVariable int codigoCurso){
		return disciplinaRepository.findDisciplinasByCurso(codigoCurso);
	}
	
	@PostMapping("/curso/create")
	public ResponseEntity<Disciplina> saveDisciplina(@RequestBody Disciplina disciplina) {
		disciplina = disciplinaRepository.save(disciplina);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(disciplina.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(disciplina);
	}

	@PutMapping("/curso/update/{codigo}")
	public ResponseEntity<Disciplina> updateDisciplina(@PathVariable String codigo, @RequestBody Disciplina disciplina) {
		if (disciplina != null) {
			disciplina.setCodigo(codigo);
			disciplinaRepository.save(disciplina);
			return ResponseEntity.accepted().body(disciplina);
		}
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/curso/delete/{codigo}")
	public ResponseEntity<Void> deleteDisciplina(@PathVariable String codigo) {
		Disciplina disciplina = disciplinaRepository.findByCodigo(codigo);
		if (disciplina != null) {
			disciplinaRepository.deleteById(codigo);
			return ResponseEntity.accepted().build();
		}
		return ResponseEntity.noContent().build();
	}
	@GetMapping("/sigla/{siglaDisciplina}")
	public List<Disciplina> getDisciplinaBySigla(@PathVariable String siglaDisciplina){

		return disciplinaRepository.findAllBySigla(siglaDisciplina);
				
	}
}
