package com.videoLocadora.domain.atendimento_cliente;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int numInscricao;

    @Column(length = 255, nullable = false)
    private String nome;

    @Column
    private Date dataNascimento;

    @Column
    private char sexo;
    
    @Column(nullable = false)
    private boolean estaAtivo;

    @OneToMany(mappedBy = "cliente")
    private List<Locacao> locacoes;
}
