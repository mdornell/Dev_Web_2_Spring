package com.videoLocadora.dto.mapper;

import org.springframework.stereotype.Component;

import com.videoLocadora.domain.controle_acervo.Classe;
import com.videoLocadora.dto.ClasseDTO;

@Component
public class ClasseMapper {

    public ClasseDTO toDTO(Classe classe) {
        if(classe == null) {
            return null;
        }
        return new ClasseDTO(classe.getId(), classe.getNome(), classe.getValor(), classe.getPrazoDevolucao());
    }

    public Classe toEntity(ClasseDTO classeDTO) {
        if(classeDTO == null) {
            return null;
        }
        Classe a = new Classe();
        if(classeDTO.id() != null) {
            a.setId(classeDTO.id());
        }
        a.setNome(classeDTO.nome());
        a.setValor(classeDTO.valor());
        a.setPrazoDevolucao(classeDTO.prazoDeDevolucao());
    
        return a;
    }
    
}
