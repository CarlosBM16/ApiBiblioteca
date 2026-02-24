package com.example.proyecto.services;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.proyecto.model.Libro;
import com.example.proyecto.repository.LibroRepository;
import com.example.proyecto.service.impl.LibroServiceImpl;

@ExtendWith(MockitoExtension.class)

public class LibroServiceTest {
    @Mock
    private LibroRepository libroRepository;

    @InjectMocks
    private LibroServiceImpl libroService;

    private Libro libroTest;

    @BeforeEach
    void setUp() {
        libroTest = new Libro();

        libroTest.setId_libro(1L);
        libroTest.setTitulo("Elantris");
        libroTest.setAutor("Sanderson");
        libroTest.setSocio(null);

    }

    @Test
    void eliminar_Libro() {
        Long id = 1L;

        when(libroRepository.findById(id)).thenReturn(Optional.of(libroTest));

        libroService.eliminarLibro(id);

        verify(libroRepository, times(1)).deleteById(libroTest.getId_libro());
    }
    
}
