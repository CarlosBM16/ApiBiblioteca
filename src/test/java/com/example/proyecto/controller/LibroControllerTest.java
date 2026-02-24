package com.example.proyecto.controller;

import static org.mockito.ArgumentMatchers.any;

import org.springframework.http.MediaType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.proyecto.controller.LibroController;
import com.example.proyecto.dtos.request.create.LibroCreateDTO;
import com.example.proyecto.dtos.response.LibroDTO;
import com.example.proyecto.service.LibroService;


import tools.jackson.databind.ObjectMapper;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LibroController.class)
public class LibroControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private LibroService libroService;

    @Autowired
    private ObjectMapper objectMapper;

    private LibroCreateDTO libroCreateDTO;
    private LibroDTO libroResponseDTO;

    @BeforeEach
    void setUp() {
        libroCreateDTO = new LibroCreateDTO();
        libroCreateDTO.setTitulo("Elantris");
        libroCreateDTO.setAutor("Sanderson");

        libroResponseDTO = new LibroDTO();
        libroResponseDTO.setIdLibro(1L);
        libroResponseDTO.setTitulo("Elantris");
        libroResponseDTO.setAutor("Sanderson");
    }
    

    @Test
    void crearLibro_Exito() throws Exception {
        when(libroService.crearLibro(any(LibroCreateDTO.class))).thenReturn(libroResponseDTO);

        mockMvc.perform(post("/api/libros")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(libroCreateDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.idLibro").value(1L))
                .andExpect(jsonPath("$.titulo").value("Elantris"));

        verify(libroService, times(1)).crearLibro(any(LibroCreateDTO.class));
    }

}
