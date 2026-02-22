package com.example.proyecto.mapper;

import org.springframework.stereotype.Component;

import com.example.proyecto.dtos.request.create.LibroCreateDTO;
import com.example.proyecto.dtos.request.update.LibroUpdateDTO;
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

    public Libro toEntity(LibroCreateDTO dto) {
        if (dto == null) return null;

        Libro libro = new Libro();
        libro.setTitulo(dto.getTitulo());
        libro.setAutor(dto.getAutor());

        return libro;
    }

    public void updateEntityFromDto(LibroUpdateDTO dto, Libro libro) {
        if (dto == null || libro == null) return;

        libro.setTitulo(dto.getTitulo());
        libro.setAutor(dto.getAutor());
    }
}
