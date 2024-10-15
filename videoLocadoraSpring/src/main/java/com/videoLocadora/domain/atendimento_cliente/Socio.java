package com.videoLocadora.domain.atendimento_cliente;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Entity
public class Socio extends Cliente {

    @Column
    private String cpf;

    @Column
    private String endereco;

    @Column
    private String telefone;

    @OneToMany(mappedBy = "socio")
    private List<Dependente> dependentes;

}
