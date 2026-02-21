package com.example.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyecto.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{

}