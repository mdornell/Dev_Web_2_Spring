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

     public DiretorDTO buscarAtorPorId(Long id) {
        return diretorRepository.findById(id)
        .map(diretorMapper::toDTO)
        .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public DiretorDTO adicionarAtor(DiretorDTO ator) {
        return diretorMapper.toDTO(diretorRepository.save(diretorMapper.toEntity(ator)));
    }

    public DiretorDTO atualizarAtor(Long id, DiretorDTO atorAtualizado) {
        return diretorRepository.findById(id)
                .map(ator -> {
                    ator.setNome(atorAtualizado.nome());
                    return diretorMapper.toDTO(diretorRepository.save(ator));
                })
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void deletarAtor(Long id) {
        diretorRepository.delete(diretorRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
    
}
