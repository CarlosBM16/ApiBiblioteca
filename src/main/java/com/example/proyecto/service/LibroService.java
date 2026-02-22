package com.example.proyecto.service;

import java.util.List;

import com.example.proyecto.dtos.request.create.LibroCreateDTO;
import com.example.proyecto.dtos.response.LibroDTO;

public interface LibroService {
    List<LibroDTO> obtenerTodosLibros();
    LibroDTO obtenerLibroPorId(Long id);
    LibroDTO crearLibro(LibroCreateDTO dto);
}
