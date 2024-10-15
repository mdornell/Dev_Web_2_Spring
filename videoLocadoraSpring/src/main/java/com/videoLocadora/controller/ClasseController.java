package com.videoLocadora.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videoLocadora.domain.controle_acervo.Classe;
import com.videoLocadora.repository.ClasseRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/classe")
@AllArgsConstructor
public class ClasseController {
    
    private final ClasseRepository classeRepository;

    // Lista todas as classes
    @GetMapping("/list")
    public List<Classe> listarClasses() {
        return classeRepository.findAll();
    }

    // Buscar ator
    @GetMapping("/list/{id}")
    public ResponseEntity<Classe> buscarClassePorId(@PathVariable Long id){
        return classeRepository.findById(id)
            .map(classe -> ResponseEntity.ok().body(classe))
            .orElse(ResponseEntity.notFound().build());
    }
    
}
