package com.videoLocadora.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.videoLocadora.dto.AtorDTO;
import com.videoLocadora.dto.mapper.AtorMapper;
import com.videoLocadora.exception.RecordNotFoundException;
import com.videoLocadora.repository.AtorRepository;

@Service
public class AtorService {

    private AtorRepository atorRepository;
    private final AtorMapper atorMapper;

    public AtorService(AtorRepository atorRepository, AtorMapper atorMapper) {
        this.atorRepository = atorRepository;
        this.atorMapper = atorMapper;
    }

    // Lista todos os atores
    public List<AtorDTO> listarAtores() {
        return atorRepository.findAll()
        .stream()
        .map(atorMapper::toDTO)
        .toList();
    }

    public AtorDTO buscarAtorPorId(Long id) {
        return atorRepository.findById(id)
        .map(atorMapper::toDTO)
        .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public AtorDTO adicionarAtor(AtorDTO ator) {
        return atorMapper.toDTO(atorRepository.save(atorMapper.toEntity(ator)));
    }

    public AtorDTO atualizarAtor(Long id, AtorDTO atorAtualizado) {
        return atorRepository.findById(id)
                .map(ator -> {
                    ator.setNome(atorAtualizado.nome());
                    return atorMapper.toDTO(atorRepository.save(ator));
                })
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void deletarAtor(Long id) {
        atorRepository.delete(atorRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }

}
