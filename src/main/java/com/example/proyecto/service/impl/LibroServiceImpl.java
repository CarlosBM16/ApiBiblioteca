package com.example.proyecto.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import com.example.proyecto.dtos.response.LibroDTO;
import com.example.proyecto.mapper.LibroMapper;
import com.example.proyecto.model.Libro;
import com.example.proyecto.repository.LibroRepository;
import com.example.proyecto.service.LibroService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LibroServiceImpl implements LibroService{
    private final LibroRepository libroRepository;
    private final LibroMapper libroMapper;

    @Override
    public List<LibroDTO> obtenerTodosLibros() {
        return libroRepository.findAll()
            .stream()
            .map(libroMapper::toDto)
            .toList();
    }

    @Override
    public LibroDTO obtenerLibroPorId(Long id) {
        Libro libro = libroRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Libro con id " + id + " no encontrado"));

        return libroMapper.toDto(libro);
    }
}
