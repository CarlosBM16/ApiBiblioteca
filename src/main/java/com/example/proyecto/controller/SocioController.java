package com.example.proyecto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto.dtos.request.create.SocioCreateDTO;
import com.example.proyecto.dtos.request.update.SocioUpdateDTO;
import com.example.proyecto.dtos.response.SocioDTO;
import com.example.proyecto.service.SocioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/socios")
@RequiredArgsConstructor
public class SocioController {
    private final SocioService socioService;

    @GetMapping
    public ResponseEntity<List<SocioDTO>> obtenerTodosLibros() {
        List<SocioDTO> socios = socioService.obtenerTodosSocios();

        if (socios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(socios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SocioDTO> obtenerSocioPorId(@PathVariable Long id) {
        SocioDTO socioDTO = socioService.obtenerSocioPorId(id);
        return ResponseEntity.ok(socioDTO);
    }

    @PostMapping
    public ResponseEntity<SocioDTO> crearSocio(@Valid @RequestBody SocioCreateDTO dto) {
        SocioDTO socioCreado = socioService.crearSocio(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(socioCreado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SocioDTO> actualizarSocio(@PathVariable Long id, @Valid @RequestBody SocioUpdateDTO dto) {
        SocioDTO socioActualizado = socioService.actualizarSocio(id, dto);
        return ResponseEntity.ok(socioActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSocio(@PathVariable Long id) {
        socioService.eliminarSocio(id);
        return ResponseEntity.noContent().build();
    }
}
