package com.example.proyecto.dtos.request.update;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

@Data
public class PerfilUpdateDTO {
    @NotBlank(message = "La biografía del perfil no puede estar vacía")
    private String biografia;

    @NotNull(message = "La fecha de registro es obligatoria")
    @PastOrPresent(message = "La fecha de registro no puede ser una fecha futura")
    private LocalDate fechaRegistro;
}
