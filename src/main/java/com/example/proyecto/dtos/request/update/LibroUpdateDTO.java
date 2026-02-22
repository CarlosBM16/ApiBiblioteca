package com.example.proyecto.dtos.request.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LibroUpdateDTO {
    @NotBlank(message = "El título del libro no puede estar vacío")
    @Size(max = 150, message = "El título del libro no puede tener más de 150 caracteres.")
    private String titulo;

    @NotBlank(message = "El autor no puede estar vacío")
    @Size(max = 100, message = "El autor no puede tener más de 100 caracteres")
    private String autor;
}
