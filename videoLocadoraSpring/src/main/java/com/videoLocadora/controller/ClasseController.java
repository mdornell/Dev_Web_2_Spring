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

import com.videoLocadora.dto.ClasseDTO;
import com.videoLocadora.service.ClasseService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/classe")
@AllArgsConstructor
public class ClasseController {
    
    private final ClasseService  classeService;

    // Lista todas as classes
    @GetMapping("/list")
    public List<ClasseDTO> listarClasses() {
        return classeService.listarClasse();
    }

    // Buscar classe
    @GetMapping("/list/{id}")
    public ClasseDTO buscarClassePorId(@PathVariable Long id){
        return classeService.buscarClassePorId(id);
    }
    
    // Adiciona novo classe
    @PostMapping("/add")
    public ClasseDTO adicionarClasse(@RequestBody ClasseDTO classe) {
        System.out.println("\n\n\n\n\n\n\n\n"+classe+"\n\n\n\n\n\n\n\n");
        return classeService.adicionarClasse(classe);
    }

    // Atualiza classe
    @PutMapping("/update/{id}")
    public ClasseDTO atualizarClasse(@PathVariable Long id, @RequestBody ClasseDTO classe) {
        return classeService.atualizarClasse(id, classe);
    }

    // Deleta classe
    @DeleteMapping("/delete/{id}")
    public void deletarClasse(@PathVariable Long id) {
        classeService.deletarAtor(id);
    }

}
