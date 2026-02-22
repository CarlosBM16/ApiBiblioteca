package com.example.proyecto.service;

import java.util.List;

import com.example.proyecto.dtos.request.create.SocioCreateDTO;
import com.example.proyecto.dtos.request.update.SocioUpdateDTO;
import com.example.proyecto.dtos.response.SocioDTO;

public interface SocioService {
    List<SocioDTO> obtenerTodosSocios();
    SocioDTO obtenerSocioPorId(Long id);
    SocioDTO crearSocio(SocioCreateDTO dto);
    SocioDTO actualizarSocio(Long id, SocioUpdateDTO dto);
}
