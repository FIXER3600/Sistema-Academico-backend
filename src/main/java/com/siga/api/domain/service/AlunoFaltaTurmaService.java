package com.siga.api.domain.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.siga.api.domain.repository.AlunoFaltaTurmaRepository;
import com.siga.api.domain.repository.DisciplinaRepository;
import com.siga.api.model.entity.AlunoFaltaTurma;
import com.siga.api.model.entity.Disciplina;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class AlunoFaltaTurmaService {

	@Autowired
	private AlunoFaltaTurmaRepository alunoFaltaTurmaRepository;
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private DataSource dataSource;
	
	public List<AlunoFaltaTurma> getListaAlunoFalta(String codigoDisciplina){
		
		List<AlunoFaltaTurma> lista = alunoFaltaTurmaRepository.getListaAlunoFaltaTurma(codigoDisciplina);
		
		for(AlunoFaltaTurma aft : lista){
			aft.setSemana1(isNull(aft.getSemana1()));
			aft.setSemana2(isNull(aft.getSemana2()));
			aft.setSemana3(isNull(aft.getSemana3()));
			aft.setSemana4(isNull(aft.getSemana4()));
			aft.setSemana5(isNull(aft.getSemana5()));
			aft.setSemana6(isNull(aft.getSemana6()));
			aft.setSemana7(isNull(aft.getSemana7()));
			aft.setSemana8(isNull(aft.getSemana8()));
			aft.setSemana9(isNull(aft.getSemana9()));
			aft.setSemana10(isNull(aft.getSemana10()));
			aft.setSemana11(isNull(aft.getSemana11()));
			aft.setSemana12(isNull(aft.getSemana12()));
			aft.setSemana13(isNull(aft.getSemana13()));
			aft.setSemana14(isNull(aft.getSemana14()));
			aft.setSemana15(isNull(aft.getSemana15()));
			aft.setSemana16(isNull(aft.getSemana16()));
			aft.setSemana17(isNull(aft.getSemana17()));
			aft.setSemana18(isNull(aft.getSemana18()));
			aft.setSemana19(isNull(aft.getSemana19()));
			aft.setSemana20(isNull(aft.getSemana20()));
			
			aft.setTotalFaltas(isNull(aft.getTotalFaltas()));
			
		}
		
		return lista;
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
		
		String urlImagem = "C:\\\\Users\\\\Guilherme\\\\Downloads\\\\AV3-LabBD-main\\\\AV3-LabBD-main\\\\API\\\\siga\\\\src\\\\main\\\\resources\\\\logotipo1.png";
		
		
		try {
			Connection connection = dataSource.getConnection();
			

			File file = ResourceUtils.getFile("classpath:relatorioUDFFalta.jrxml");
			
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
	
	private String isNull(String valor) {
		if(valor == null) {
			return "----";
		}
		
		return valor;
	}
	
}
