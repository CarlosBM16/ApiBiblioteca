package com.example.proyecto.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    private Long id_perfil;

    @Column(name = "biografia")
    private String biografia;

    @Column(name = "fecha_registro")
    private LocalDate fecha_registro;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "id_socio", nullable = false)
    private Socio socio;
}
