package com.siga.api.controller;


import com.siga.api.domain.service.AlunoService;
import com.siga.api.domain.service.MatriculaService;
import com.siga.api.model.entity.Matricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    MatriculaService service;

    @Autowired
    AlunoService alunoService;


    @GetMapping
    public ResponseEntity<List<Matricula>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @GetMapping("/matricula/{id}")
    public ResponseEntity<Matricula> findById(@PathVariable Integer id) {
        Matricula matricula = service.getById(id);
        if (matricula != null) {
            return ResponseEntity.ok().body(matricula);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/matricula/create")
    public ResponseEntity<Matricula> saveMatricula(@RequestBody Matricula matricula) {
        matricula = service.saveMatricula(matricula);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(matricula.getId()).toUri();
        return ResponseEntity.created(uri).body(matricula);
    }

    @DeleteMapping("/matricula/delete/{id}")
    public ResponseEntity<Void> deleteMatricula(@PathVariable Integer id) {
        Matricula matricula = service.getById(id);
        if (matricula != null) {
            service.deleteMatricula(id);
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.notFound().build();
    }

}
