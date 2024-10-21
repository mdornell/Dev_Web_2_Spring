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

import com.videoLocadora.dto.DiretorDTO;
import com.videoLocadora.service.DiretorService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/diretor")
@AllArgsConstructor
public class DiretorController {
    
    private final DiretorService  diretorService;

    // Lista todos os diretores
    @GetMapping("/list")
    public List<DiretorDTO> listarDiretores() {
        return diretorService.listar();
    }

    @GetMapping("/list/{id}")
    public DiretorDTO buscarAtorPorId(@PathVariable Long id) {
        return diretorService.buscarDiretorPorId(id);
    }

    // Adiciona novo ator
    @PostMapping("/add")
    public DiretorDTO adicionarAtor(@RequestBody DiretorDTO ator) {
        return diretorService.adicionarDiretor(ator);
    }

    // Atualiza ator
    @PutMapping("/update/{id}")
    public DiretorDTO atualizarAtor(@PathVariable Long id, @RequestBody DiretorDTO ator) {
        return diretorService.atualizarDiretor(id, ator);
    }

    // Deleta ator
    @DeleteMapping("/delete/{id}")
    public void deletarAtor(@PathVariable Long id) {
        diretorService.deletarDiretor(id);
    }

    
}
