package com.videoLocadora.domain.controle_acervo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Titulo {

    @Id
    private Long id;

    @Column(length = 255, nullable = false)
    private String nome;

    @Column(nullable = false)
    private String ano;

    @Column(nullable = false)
    private String sinopse;

    @Column(nullable = false)
    private String categoria;

    @ManyToMany
    @JoinTable(name = "tituloAtor", joinColumns = @JoinColumn(name = "idTitulo"), inverseJoinColumns = @JoinColumn(name = "idAtor"))
    private List<Ator> atores;

    @ManyToOne
    @JoinColumn(name = "diretor_id")
    private Diretor diretor;

    @ManyToOne
    @JoinColumn(name = "idClasse")
    private Classe classe;

    @OneToMany(mappedBy = "titulo")
    private List<Item> itens;
}
