package com.siga.api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Aluno_Disciplina")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "RaAluno")
    private Integer raAluno;
    @Column(name = "CodigoDisciplina")
    private String codigoDisciplina;

}
