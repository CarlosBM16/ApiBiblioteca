package com.example.proyecto.service;

import java.util.List;

import com.example.proyecto.dtos.response.SocioDTO;

public interface SocioService {
    List<SocioDTO> obtenerTodosSocios();
    SocioDTO obtenerSocioPorId(Long id);
}
