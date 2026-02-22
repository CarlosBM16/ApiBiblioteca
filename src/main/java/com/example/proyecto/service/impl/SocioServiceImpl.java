package com.example.proyecto.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.proyecto.dtos.request.create.SocioCreateDTO;
import com.example.proyecto.dtos.response.SocioDTO;
import com.example.proyecto.mapper.SocioMapper;
import com.example.proyecto.model.Socio;
import com.example.proyecto.repository.SocioRepository;
import com.example.proyecto.service.SocioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SocioServiceImpl implements SocioService {
    private final SocioRepository socioRepository;
    private final SocioMapper socioMapper;

    @Override
    public List<SocioDTO> obtenerTodosSocios() {
        return socioRepository.findAll()
            .stream()
            .map(socioMapper::toDto)
            .toList();
    }

    @Override
    public SocioDTO obtenerSocioPorId(Long id) {
        Socio socio = socioRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Socio con id " + id + " no encontrado"));

        return socioMapper.toDto(socio);
    }

    @Override
    public SocioDTO crearSocio(SocioCreateDTO dto) {
        Socio socio = socioMapper.toEntity(dto);

        socio.getPerfil().setSocio(socio);

        Socio socioGuardado = socioRepository.save(socio);
        return socioMapper.toDto(socioGuardado);
    }
    
}
