package com.videoLocadora.dto.mapper;

import org.springframework.stereotype.Component;

import com.videoLocadora.domain.controle_acervo.Ator;
import com.videoLocadora.dto.AtorDTO;

@Component
public class AtorMapper {
    
    public AtorDTO toDTO(Ator ator) {
        if(ator == null) {
            return null;
        }
        return new AtorDTO(ator.getId(), ator.getNome());
    }

    public Ator toEntity(AtorDTO atorDTO) {
        if(atorDTO == null) {
            return null;
        }
        Ator a = new Ator();
        if(atorDTO.id() != null) {
            a.setId(atorDTO.id());
        }
        a.setNome(atorDTO.nome());

        return a;
    }
}
