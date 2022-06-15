package com.siga.api.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siga.api.domain.repository.FaltaRepository;
import com.siga.api.domain.service.FaltaService;
import com.siga.api.model.dto.FaltaDTO;
import com.siga.api.model.entity.Falta;

@CrossOrigin
@RestController
@RequestMapping("/faltas")
public class FaltaController {

	@Autowired
	private FaltaRepository faltaRepository;
	
	@Autowired
	private FaltaService faltaService;
	
	@PutMapping
	public void updateFalta(@RequestBody ArrayList<FaltaDTO> listaFaltaDTO){
	
		for(FaltaDTO f : listaFaltaDTO) {
			Falta falta = faltaService.updateFalta(f);
			faltaRepository.save(falta);
		}
	}
	
	@GetMapping()
	public List<Falta> getFaltas(){
		return faltaRepository.findAll();

	}
	

	@GetMapping("/aluno/{raAluno}")
	public Falta getFaltaByAluno(@PathVariable int raAluno){
		return faltaRepository.findByAluno(raAluno);
	}
	
	@GetMapping("/datas-aula/{codigoAvaliacao}")
	public List<Date> getFaltaByAluno(@PathVariable String codigoAvaliacao){
	return faltaService.dataAulasDadas(codigoAvaliacao);
	}
}
