package com.videoLocadora.domain.atendimento_cliente;

import java.sql.Date;

import com.videoLocadora.domain.controle_acervo.Item;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date dataLocacao;

    @Column
    private Date dataDevolucaoPrevista;

    @Column
    private Date dataDevolucaoEfetiva;

    @Column
    private double valorCobrado;

    @Column
    private double multaCobrada;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Item item;

    
}
