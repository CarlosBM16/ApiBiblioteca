package com.example.proyecto.mapper;

import org.springframework.stereotype.Component;

import com.example.proyecto.dtos.response.LibroDTO;
import com.example.proyecto.model.Libro;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
@Data
public class LibroMapper {
    public LibroDTO toDto(Libro libro) {
        if (libro == null) return null;

        LibroDTO dto = new LibroDTO();

        dto.setIdLibro(libro.getId_libro());
        dto.setAutor(libro.getAutor());
        dto.setTitulo(libro.getTitulo());

        return dto;
    }
}
