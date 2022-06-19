package com.siga.api.domain.service;

import com.siga.api.domain.repository.AlunoRepository;
import com.siga.api.domain.repository.DisciplinaRepository;
import com.siga.api.domain.repository.MatriculaRepository;
import com.siga.api.model.entity.Aluno;
import com.siga.api.model.entity.Disciplina;
import com.siga.api.model.entity.Matricula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    @Autowired
    MatriculaRepository matriculaRepository;
    @Autowired
    AlunoRepository alunoRepository;
    @Autowired
    DisciplinaRepository disciplinaRepository;

    public List<Matricula> getAll() {
        return matriculaRepository.findAll();
    }

    public Matricula getById(Integer id) {
        return matriculaRepository.getById(id);
    }


    public Matricula saveMatricula(Matricula matricula) {
       Aluno aluno = alunoRepository.getById(matricula.getRaAluno());
       matricula.setNomeAluno(aluno.getNome());
       Disciplina disciplina = disciplinaRepository.findByCodigo(matricula.getCodigoDisciplina());
       matricula.setNomeDisciplina(disciplina.getNome());
       return matriculaRepository.save(matricula);
    }

    public void deleteMatricula(Integer id) {
       matriculaRepository.deleteById(id);
    }

}
