package com.siga.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.siga.api.domain.repository.CursoRepository;
import com.siga.api.model.entity.Curso;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin
@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<Curso> getCursos(){
		return cursoRepository.findAll();
	}

	@GetMapping("/curso/{codigo}")
	public ResponseEntity<Curso> getByCodigo(@PathVariable Integer codigo) {
		Curso curso = cursoRepository.getById(codigo);
		return ResponseEntity.ok().body(curso);
	}

	@PostMapping("/curso/create")
	public ResponseEntity<Curso> saveCurso(@RequestBody Curso curso){
		curso = cursoRepository.save(curso);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(curso.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(curso);
	}

	@PutMapping("/curso/update/{codigo}")
	public ResponseEntity<Curso> updateCurso(@PathVariable Integer codigo, @RequestBody Curso curso) {
		if (curso != null){
			curso.setCodigo(codigo);
			cursoRepository.save(curso);
			return ResponseEntity.accepted().body(curso);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/curso/delete/{codigo}")
	public ResponseEntity<Void> deleteCurso(@PathVariable Integer codigo) {
		cursoRepository.deleteById(codigo);
		return ResponseEntity.accepted().build();
	}
	
	@GetMapping("/{codigoCurso}")
	public ResponseEntity<Curso> getCursoByCodigo(@PathVariable int codigoCurso){
		return cursoRepository.findById(codigoCurso)
				.map(curso -> ResponseEntity.ok(curso))
				.orElse(ResponseEntity.notFound().build());
	}
}
