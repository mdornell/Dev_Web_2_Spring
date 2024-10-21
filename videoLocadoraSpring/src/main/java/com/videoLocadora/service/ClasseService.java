package com.videoLocadora.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.videoLocadora.dto.ClasseDTO;
import com.videoLocadora.dto.mapper.ClasseMapper;
import com.videoLocadora.exception.RecordNotFoundException;
import com.videoLocadora.repository.ClasseRepository;

@Service
public class ClasseService {

    private ClasseRepository classeRepository;
    private final ClasseMapper classeMapper;

    public ClasseService(ClasseRepository classeRepository, ClasseMapper classeMapper) {
        this.classeRepository = classeRepository;
        this.classeMapper = classeMapper;
    }

    // Lista todos os Classe
    public List<ClasseDTO> listarClasse() {
        return classeRepository.findAll()
                .stream()
                .map(classeMapper::toDTO)
                .toList();
    }

    public ClasseDTO buscarClassePorId(Long id) {
        return classeRepository.findById(id)
                .map(classeMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public ClasseDTO adicionarClasse(ClasseDTO classe) {
        return classeMapper.toDTO(classeRepository.save(classeMapper.toEntity(classe)));
    }

    public ClasseDTO atualizarClasse(Long id, ClasseDTO classeAtualizado) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return classeRepository.findById(id)
                .map(classe -> {
                    classe.setNome(classeAtualizado.nome());
                    classe.setValor(classeAtualizado.valor());
                    String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(classeAtualizado.prazoDeDevolucao());
                    LocalDate localDate = LocalDate.parse(formattedDate, formatter);
                    Date date = java.sql.Date.valueOf(localDate);
                    classe.setPrazoDevolucao(date);
                    return classeMapper.toDTO(classeRepository.save(classe));
                })
                .orElseThrow(() -> new RecordNotFoundException(id));
                    
    }

    public void deletarAtor(Long id) {
        classeRepository.delete(classeRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
