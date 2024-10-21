package com.videoLocadora.service;

import java.time.LocalDate;
import java.time.ZoneId;
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
        // Format the date to dd/MM/yyyy
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedPrazo = classe.prazoDeDevolucao().toInstant()
                .atZone(ZoneId.systemDefault())
                .format(formatter);

        // Cria um novo objeto ClasseDTO com a data formatada
        ClasseDTO classeComDataFormatada = new ClasseDTO(
                classe.id(),
                classe.nome(),
                classe.valor(),
                Date.from(LocalDate.parse(formattedPrazo, formatter)
                        .atStartOfDay(ZoneId.systemDefault())
                        .toInstant()));

        return classeMapper.toDTO(classeRepository.save(classeMapper.toEntity(classeComDataFormatada)));
    }

    public ClasseDTO atualizarClasse(Long id, ClasseDTO classeAtualizado) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return classeRepository.findById(id)
                .map(classe -> {
                    String formattedPrazo = classeAtualizado.prazoDeDevolucao().toInstant()
                            .atZone(ZoneId.systemDefault())
                            .format(formatter);

                    // Cria um novo objeto ClasseDTO com os valores atualizados
                    ClasseDTO classeAtualizada = new ClasseDTO(
                            classe.getId(),
                            classeAtualizado.nome(),
                            classeAtualizado.valor(),
                            Date.from(LocalDate.parse(formattedPrazo, formatter)
                                    .atStartOfDay(ZoneId.systemDefault())
                                    .toInstant()));

                    return classeMapper.toDTO(classeRepository.save(classeMapper.toEntity(classeAtualizada)));
                })
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void deletarAtor(Long id) {
        classeRepository.delete(classeRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
