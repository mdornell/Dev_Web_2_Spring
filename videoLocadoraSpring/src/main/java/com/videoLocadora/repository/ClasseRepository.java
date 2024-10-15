package com.videoLocadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.videoLocadora.domain.controle_acervo.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Long> {
    
}
