package com.videoLocadora.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.videoLocadora.dto.DiretorDTO;
import com.videoLocadora.dto.mapper.DiretorMapper;
import com.videoLocadora.exception.RecordNotFoundException;
import com.videoLocadora.repository.DiretorRepository;

@Service
public class DiretorService {

    
    private DiretorRepository diretorRepository;
    private final DiretorMapper diretorMapper;

    public DiretorService( DiretorRepository diretorRepository, DiretorMapper diretorMapper) {
        this.diretorRepository = diretorRepository;
        this.diretorMapper = diretorMapper; ;
    }

    // Lista todos os atores
    public List<DiretorDTO> listar() {
        return diretorRepository.findAll()
        .stream()
        .map(diretorMapper::toDTO)
        .toList();
    }

     public DiretorDTO buscarDiretorPorId(Long id) {
        return diretorRepository.findById(id)
        .map(diretorMapper::toDTO)
        .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public DiretorDTO adicionarDiretor(DiretorDTO diretor) {
        return diretorMapper.toDTO(diretorRepository.save(diretorMapper.toEntity(diretor)));
    }

    public DiretorDTO atualizarDiretor(Long id, DiretorDTO diretorAtualizado) {
        return diretorRepository.findById(id)
                .map(diretor -> {
                    diretor.setNome(diretorAtualizado.nome());
                    return diretorMapper.toDTO(diretorRepository.save(diretor));
                })
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void deletarDiretor(Long id) {
        diretorRepository.delete(diretorRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
    
}
