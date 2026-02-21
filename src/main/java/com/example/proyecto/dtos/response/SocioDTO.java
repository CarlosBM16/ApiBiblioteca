package com.example.proyecto.dtos.response;

import java.util.List;

import lombok.Data;

@Data
public class SocioDTO {
    private Long id;
    private String nombre;
    private String email;
    private PerfilDTO perfil;
    private List<LibroDTO> libros;
}
