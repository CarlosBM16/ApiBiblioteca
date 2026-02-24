package com.example.proyecto.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.proyecto.dtos.request.create.LibroCreateDTO;
import com.example.proyecto.dtos.request.update.LibroUpdateDTO;
import com.example.proyecto.dtos.response.LibroDTO;
import com.example.proyecto.mapper.LibroMapper;
import com.example.proyecto.model.Libro;
import com.example.proyecto.repository.LibroRepository;
import com.example.proyecto.service.LibroService;

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

    @Override
    public LibroDTO crearLibro(LibroCreateDTO dto) {
        Libro libro = libroMapper.toEntity(dto);

        Libro libroGuardado = libroRepository.save(libro);

        return libroMapper.toDto(libroGuardado);
    }

    @Override
    public LibroDTO actualizarLibro(Long id, LibroUpdateDTO dto) {
        Libro libroExistente = libroRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Libro con id " + id + " no encontrado"));

        libroMapper.updateEntityFromDto(dto, libroExistente);

        Libro libroActualizado = libroRepository.save(libroExistente);

        return libroMapper.toDto(libroActualizado);

    }

    @Override
    public void eliminarLibro(Long id) {
        Libro libro = libroRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Libro con id " + id + " no encontrado"));

            libroRepository.deleteById(libro.getId_libro());
    }
}
