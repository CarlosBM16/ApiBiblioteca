package com.example.proyecto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto.dtos.request.create.LibroCreateDTO;
import com.example.proyecto.dtos.response.LibroDTO;
import com.example.proyecto.service.LibroService;

import jakarta.validation.Valid;
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

    @PostMapping
    public ResponseEntity<LibroDTO> crearLibro(@Valid @RequestBody LibroCreateDTO dto) {
        LibroDTO libroCreado = libroService.crearLibro(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(libroCreado);
    }
}
