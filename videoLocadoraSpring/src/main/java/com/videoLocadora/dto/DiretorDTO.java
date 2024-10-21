package com.videoLocadora.dto;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DiretorDTO(
    @JsonProperty("_id") Long id,
    @Length(min = 5, max = 150) String nome
    ) {
}
