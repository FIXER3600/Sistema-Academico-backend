package com.siga.api.domain.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.siga.api.domain.repository.AlunoMediaRepository;
import com.siga.api.domain.repository.DisciplinaRepository;
import com.siga.api.model.entity.AlunoMedia;
import com.siga.api.model.entity.Disciplina;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class AlunoMediaService {
	@Autowired
	private AlunoMediaRepository alunoMediaRepository;
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private DataSource dataSource;

	public List<AlunoMedia> getListaAlunos(String codigoDisciplina) {
		List<AlunoMedia> listaAlunos = new ArrayList<>();

		listaAlunos = alunoMediaRepository.getListaAlunos(codigoDisciplina);
		for (AlunoMedia am : listaAlunos) {
			am.setNota1(converteNull(am.getNota1()));
			am.setNota2(converteNull(am.getNota2()));
			am.setNota3(converteNull(am.getNota3()));
			am.setNota4(converteNull(am.getNota4()));
			am.setExame(converteNull(am.getExame()));
			am.setMedia_final(converteNull(am.getMedia_final()));

			if (am.getSituacao() == null) {
				am.setSituacao("---");
			}
		}

		return listaAlunos;
	}
	
	public void exportRelatorio(String codigoDisciplina, OutputStream os) throws JRException {
		Disciplina disc = disciplinaRepository.findByCodigo(codigoDisciplina);

		getExportManager(codigoDisciplina, disc.getNome(), os);
	}
	
	private void getExportManager(String codigoDisciplina, String nomeDisciplina, OutputStream os) throws JRException {
		JasperPrint jasperPrint = getJasperPrint(codigoDisciplina, nomeDisciplina);
		JasperExportManager.exportReportToPdfStream(jasperPrint, os);

	}
	
	private JasperPrint getJasperPrint(String codigoDisciplina, String nomeDisciplina) {

		String urlImagem = "C:\\Users\\Guilherme\\SigaII\\src\\main\\resources\\logotipo1.png";

		try {
			Connection connection = dataSource.getConnection();

			File file = ResourceUtils.getFile("classpath:relatorioUDFNota.jrxml");

			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

			Map<String, Object> parameters = new HashMap<>();
			parameters.put("logo", urlImagem);
			parameters.put("codDisc", codigoDisciplina);
			parameters.put("nomeDisc", nomeDisciplina);

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
			return jasperPrint;

		} catch (SQLException | FileNotFoundException | JRException e) {
			System.err.println(e.getStackTrace());
			return null;
		}

	}

	private Float converteNull(Float elemento) {
		if (elemento == null) {
			return (float) 0.0;
		}

		return elemento;
	}
}
