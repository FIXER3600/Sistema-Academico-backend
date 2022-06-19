package com.siga.api.domain.service;

import com.siga.api.domain.repository.MatriculaRepository;
import com.siga.api.model.entity.Matricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    @Autowired
    MatriculaRepository matriculaRepository;

    public List<Matricula> getAll() {
        return matriculaRepository.findAll();
    }

    public Matricula getById(Integer id) {
        return matriculaRepository.getById(id);
    }


    public Matricula saveMatricula(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    public void deleteMatricula(Integer id) {
       matriculaRepository.deleteById(id);
    }

}
