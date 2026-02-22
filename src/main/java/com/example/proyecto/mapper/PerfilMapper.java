package com.example.proyecto.mapper;

import org.springframework.stereotype.Component;

import com.example.proyecto.dtos.request.create.PerfilCreateDTO;
import com.example.proyecto.dtos.request.update.PerfilUpdateDTO;
import com.example.proyecto.dtos.response.PerfilDTO;
import com.example.proyecto.model.Perfil;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
@Data
public class PerfilMapper {
    public PerfilDTO toDto(Perfil perfil) {
        if (perfil == null) return null;

        PerfilDTO dto = new PerfilDTO();

        dto.setId(perfil.getId_perfil());
        dto.setBiografia(perfil.getBiografia());
        dto.setFechaRegistro(perfil.getFecha_registro());

        return dto;
    }

    public Perfil toEntity(PerfilCreateDTO dto) {
        if (dto == null) return null;

        Perfil perfil = new Perfil();
        perfil.setBiografia(dto.getBiografia());
        perfil.setFecha_registro(dto.getFechaRegistro());
        
        return perfil;
    }

    public void updateEntityFromDto(PerfilUpdateDTO dto, Perfil perfil) {
        if (dto == null || perfil == null) return;

        perfil.setBiografia(dto.getBiografia());
        perfil.setFecha_registro(dto.getFechaRegistro());
    }
}
