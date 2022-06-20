package com.siga.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Aluno_Disciplina")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "RaAluno")
    private Integer raAluno;
    @Column(name = "NomeAluno")
    private String nomeAluno;
    @Column(name = "CodigoDisciplina")
    private String codigoDisciplina;
    @Column(name = "NomeDisciplina")
    private String nomeDisciplina;

}
