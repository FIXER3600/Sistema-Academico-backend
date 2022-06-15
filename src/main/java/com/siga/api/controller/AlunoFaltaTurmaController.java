package com.siga.api.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siga.api.domain.service.AlunoFaltaTurmaService;
import com.siga.api.model.entity.AlunoFaltaTurma;

import net.sf.jasperreports.engine.JRException;

@CrossOrigin
@RestController
@RequestMapping("/faltas")
public class AlunoFaltaTurmaController {

	@Autowired
	private AlunoFaltaTurmaService alunoService;
	
	@GetMapping("/{codigoDisciplina}")
	public List<AlunoFaltaTurma> getListaALunoFalta(@PathVariable String codigoDisciplina){
		return alunoService.getListaAlunoFalta(codigoDisciplina);
	}
	
	@GetMapping("/{codigoDisciplina}/relatorio")
		public void getRelatorio(HttpServletResponse response, @PathVariable String codigoDisciplina){
		
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", String.format("inline; filename=\"Relatorio Faltas Turma.pdf\""));
		try {
			OutputStream out = response.getOutputStream();
			alunoService.exportRelatorio(codigoDisciplina, out);
			
			
			System.out.println(out.toString());
			
			
		} catch (IOException | JRException e) {
			System.out.println(e.getMessage());
		}
	
	
	}
}
