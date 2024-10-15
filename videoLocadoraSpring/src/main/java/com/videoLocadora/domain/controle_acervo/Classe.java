package com.videoLocadora.domain.controle_acervo;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String nome;

    @Column(nullable = false)   
    private double valor;

    @Column(nullable = false)
    private Date prazoDevolucao;

    @OneToMany(mappedBy = "classe")
    private List<Titulo> titulos;

}
