package com.videoLocadora.dto.mapper;

import org.springframework.stereotype.Component;

import com.videoLocadora.domain.controle_acervo.Diretor;
import com.videoLocadora.dto.DiretorDTO;

@Component
public class DiretorMapper {
    
     public DiretorDTO toDTO(Diretor diretor) {
        if(diretor == null) {
            return null;
        }
        return new DiretorDTO(diretor.getId(), diretor.getNome());
    }

    public Diretor toEntity(DiretorDTO diretorDTO) {
        if(diretorDTO == null) {
            return null;
        }
        Diretor a = new Diretor();
        if(diretorDTO.id() != null) {
            a.setId(diretorDTO.id());
        }
        a.setNome(diretorDTO.nome());

        return a;
    }
}
