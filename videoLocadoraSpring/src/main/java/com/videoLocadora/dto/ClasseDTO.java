package com.videoLocadora.dto;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.DecimalMin;

public record ClasseDTO(
    @JsonProperty("_id") Long id,
    @Length(min = 5, max = 150) String nome,
    @Nonnull @DecimalMin("0.0") Double valor,
    @Nonnull Date prazoDeDevolucao
) {
    
}
