package com.videoLocadora.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videoLocadora.domain.controle_acervo.Ator;
import com.videoLocadora.repository.AtorRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/ator")
@AllArgsConstructor
public class AtorController {

    private final AtorRepository atorRepository;

    // Lista todos os atores
    @GetMapping("/list")
    public List<Ator> listarAtores() {
        return atorRepository.findAll();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Ator> buscarAtorPorId(@PathVariable Long id) {
        return atorRepository.findById(id)
                .map(ator -> ResponseEntity.ok().body(ator))
                .orElse(ResponseEntity.notFound().build());
    }

    // Adiciona novo ator
    @PostMapping("/add")
    public Ator adicionarAtor(@RequestBody Ator ator) {
        return atorRepository.save(ator);
    }

    // Atualiza ator
    @PutMapping("/update/{id}")
    public ResponseEntity<Ator> atualizarAtor(@PathVariable Long id, @RequestBody Ator atorAtualizado) {
        return atorRepository.findById(id)
                .map(ator -> {
                    ator.setNome(atorAtualizado.getNome());
                    Ator atualizado = atorRepository.save(ator);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Deleta ator
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletarAtor(@PathVariable Long id) {
        if (atorRepository.existsById(id)) {
            atorRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
