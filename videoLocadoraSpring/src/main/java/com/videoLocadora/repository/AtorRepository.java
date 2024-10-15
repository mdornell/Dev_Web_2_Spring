package com.videoLocadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.videoLocadora.domain.controle_acervo.Ator;

@Repository
public interface AtorRepository extends JpaRepository<Ator, Long> {
    
}
