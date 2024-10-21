package com.videoLocadora.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videoLocadora.dto.AtorDTO;
import com.videoLocadora.service.AtorService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/ator")
@AllArgsConstructor
public class AtorController {

    private final AtorService atorService;

    // Lista todos os atores
    @GetMapping("/list")
    public List<AtorDTO> listarAtores() {
        return atorService.listarAtores();
    }

    @GetMapping("/list/{id}")
    public AtorDTO buscarAtorPorId(@PathVariable Long id) {
        return atorService.buscarAtorPorId(id);
    }

    // Adiciona novo ator
    @PostMapping("/add")
    public AtorDTO adicionarAtor(@RequestBody AtorDTO ator) {
        return atorService.adicionarAtor(ator);
    }

    // Atualiza ator
    @PutMapping("/update/{id}")
    public AtorDTO atualizarAtor(@PathVariable Long id, @RequestBody AtorDTO ator) {
        return atorService.atualizarAtor(id, ator);
    }

    // Deleta ator
    @DeleteMapping("/delete/{id}")
    public void deletarAtor(@PathVariable Long id) {
        atorService.deletarAtor(id);
    }

}
