package com.siga.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siga.api.domain.repository.CursoRepository;
import com.siga.api.model.entity.Curso;

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
	
	@GetMapping("/{codigoCurso}")
	public ResponseEntity<Curso> getCursoByCodigo(@PathVariable int codigoCurso){
		return cursoRepository.findById(codigoCurso)
				.map(curso -> ResponseEntity.ok(curso))
				.orElse(ResponseEntity.notFound().build());
	}
}
