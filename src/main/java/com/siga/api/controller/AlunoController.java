package com.siga.api.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.siga.api.domain.repository.CursoRepository;
import com.siga.api.model.entity.Curso;
import org.apache.coyote.Response;
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

	@Autowired
	CursoRepository cursoRepository;

	
	@GetMapping
	public List<Aluno> getAlunos(){
		return alunoRepository.findAll();
	}

	@GetMapping("/aluno/{ra}")
	public ResponseEntity<Aluno> getByRa(@PathVariable Integer ra) {
		Aluno aluno = alunoRepository.getById(ra);
		return ResponseEntity.ok().body(aluno);
	}

	@GetMapping("aluno/curso/{codigoCurso}")
	public ResponseEntity<List<Aluno>> getByCurso(@PathVariable Integer codigoCurso) {
		Curso curso = cursoRepository.getById(codigoCurso);
		List<Aluno> alunos = alunoRepository.findAll();
		alunos = alunos.stream()
				.filter(aluno -> aluno.getCurso().equals(curso)).collect(Collectors.toList());
		return ResponseEntity.ok().body(alunos);
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
