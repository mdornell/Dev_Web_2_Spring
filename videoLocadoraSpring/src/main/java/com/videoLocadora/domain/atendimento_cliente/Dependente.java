package com.videoLocadora.domain.atendimento_cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class Dependente extends Cliente {

    @ManyToOne
    private Socio socio;
    
}
