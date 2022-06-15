package com.siga.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siga.api.domain.service.AlunoFaltaService;
import com.siga.api.model.entity.AlunoFalta;

@CrossOrigin
@RestController
@RequestMapping("/faltas")
public class AlunoFaltaController {

	@Autowired
	private AlunoFaltaService alunoFaltaService;
	
	@GetMapping("/{codigoDisciplina}/{dataFalta}")
	public List<AlunoFalta> getFaltas(@PathVariable String codigoDisciplina, @PathVariable String dataFalta){
		
		return alunoFaltaService.getAlunoFalta(codigoDisciplina, dataFalta);
	
	}
	
	
}
