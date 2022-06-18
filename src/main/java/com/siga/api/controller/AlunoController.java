package com.siga.api.controller;

import java.net.URI;
import java.util.List;

import com.siga.api.domain.repository.CursoRepository;
import com.siga.api.model.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.siga.api.domain.repository.AlunoRepository;
import com.siga.api.model.entity.Aluno;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@PostMapping("/aluno/create")
	public ResponseEntity<Aluno> saveAluno(@RequestBody Aluno aluno) {
		aluno = alunoRepository.save(aluno);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluno.getRa()).toUri();
		return ResponseEntity.created(uri).body(aluno);
	}

	@PutMapping("/aluno/update/{id}")
	public ResponseEntity<Aluno> updateAluno(@PathVariable Integer id, @RequestBody Aluno aluno) {
		aluno.setRa(id);
		alunoRepository.save(aluno);
		return ResponseEntity.ok().body(aluno);
	}

	@DeleteMapping("/aluno/delete/{id}")
	public ResponseEntity<Void> deleteAluno(@PathVariable Integer id) {
		Aluno aluno = alunoRepository.findById(id).orElse(null);
		if (aluno == null) {
			return ResponseEntity.badRequest().build();
		}
		alunoRepository.deleteById(aluno.getRa());
		return ResponseEntity.accepted().build();
	}

	@GetMapping("/{raAluno}")
	public ResponseEntity<Aluno> getAlunosByRa(@PathVariable int raAluno){
		return alunoRepository.findById(raAluno)
				.map(aluno -> ResponseEntity.ok(aluno))
				.orElse(ResponseEntity.notFound().build());
	}
}
