package com.example.proyecto.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto.dtos.response.LibroDTO;
import com.example.proyecto.service.LibroService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/libros")
@RequiredArgsConstructor
public class LibroController {
    private final LibroService libroService;

    @GetMapping
    public ResponseEntity<List<LibroDTO>> obtenerTodosLibros() {
        List<LibroDTO> libros = libroService.obtenerTodosLibros();

        if (libros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(libros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroDTO> obtenerLibroPorId(@PathVariable Long id) {
        LibroDTO libroDTO = libroService.obtenerLibroPorId(id);
        return ResponseEntity.ok(libroDTO);
    }
}
