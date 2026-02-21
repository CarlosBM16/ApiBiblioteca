package com.example.proyecto.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.proyecto.dtos.response.LibroDTO;
import com.example.proyecto.dtos.response.SocioDTO;
import com.example.proyecto.model.Socio;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
@Data
public class SocioMapper {
    private final PerfilMapper perfilMapper;

    public SocioDTO toDto(Socio socio) {
        if (socio == null) return null;

        SocioDTO dto = new SocioDTO();

        dto.setId(socio.getId());
        dto.setNombre(socio.getNombre());
        dto.setEmail(socio.getEmail());
        dto.setPerfil(perfilMapper.toDto(socio.getPerfil()));
        
        if (socio.getLibros() != null) {
            dto.setLibros(socio.getLibros().stream().map(libro -> {
                LibroDTO dto2 = new LibroDTO();
                dto2.setIdLibro(libro.getId_libro());
                dto2.setTitulo(libro.getTitulo());
                dto2.setAutor(libro.getAutor());
                return dto2;
            }).collect(Collectors.toList()));
        } else {
            dto.setLibros(null);
        }

        return dto;
    }
}