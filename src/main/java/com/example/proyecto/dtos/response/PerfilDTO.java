package com.example.proyecto.dtos.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PerfilDTO {
    private Long id;
    private String biografia;
    private LocalDate fechaRegistro;
}
