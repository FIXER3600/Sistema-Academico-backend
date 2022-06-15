package com.siga.api.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siga.api.domain.repository.AlunoNotaRepository;
import com.siga.api.domain.repository.NotaRepository;
import com.siga.api.model.entity.Aluno;
import com.siga.api.model.entity.AlunoNota;
import com.siga.api.model.entity.Avaliacao;
import com.siga.api.model.entity.Notas;
import com.siga.api.model.entity.id.NotaId;

@Service
public class AlunoNotaService {

	@Autowired
	private AlunoNotaRepository alunoNotaRepository;
	
	@Autowired
	private NotaRepository notaRepository;
	
	
	public List<AlunoNota> getAlunoNota(int codigoAvaliacao){
		List<AlunoNota> lista = alunoNotaRepository.findAlunosNota(codigoAvaliacao);


		for(AlunoNota aluno : lista) {
			if(aluno.getNota() == null) {
				aluno.setNota((float) 0.0);
			}
		}
		
		return lista;
	}
	
	
	public void atualizaNotaAluno(AlunoNota aluno, int codigoAvaliacao) {
		
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setCodigo(codigoAvaliacao);
		
		
		Aluno a = new Aluno();
		a.setRa(aluno.getRa());
		a.setNome(aluno.getNome());
		
		NotaId id = new NotaId();
		id.setAluno(a);
		id.setAvaliacao(avaliacao);
		
		
		
		Notas n = new Notas();
		n.setId(id);
		n.setNota(aluno.getNota());
		
		notaRepository.save(n);

	}
}
