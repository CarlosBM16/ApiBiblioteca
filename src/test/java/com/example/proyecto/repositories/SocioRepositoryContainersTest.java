package com.example.proyecto.repositories;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.postgresql.PostgreSQLContainer;

import com.example.proyecto.model.Perfil;
import com.example.proyecto.model.Socio;
import com.example.proyecto.repository.SocioRepository;

import jakarta.persistence.EntityManager;


@DataJpaTest
@Testcontainers
@TestPropertySource(properties = {"spring.jpa.hibernate.ddl-auto=create-drop"}) // Hibernate genera las tablas en el contenedor
public class SocioRepositoryContainersTest {
    @Container
    @ServiceConnection
    static PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:17.6-alpine");

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void eliminarSocio_DebeEliminarPerfilEnCascada() {
        // GIVEN
        Socio socio = new Socio();
        socio.setNombre("nombre");
        socio.setEmail("email@mail.com");
        socio.setLibros(new ArrayList<>());
        
        Perfil perfil = new Perfil();
        perfil.setBiografia("biografia");
        perfil.setFecha_registro(LocalDate.now());
        perfil.setSocio(socio);
        socio.setPerfil(perfil);

        Socio socioGuardado = socioRepository.save(socio);
        Long idPerfil = socioGuardado.getPerfil().getId_perfil();

        // WHEN
        socioRepository.delete(socioGuardado);
        socioRepository.flush();
        entityManager.clear();

        // THEN
        assertFalse(socioRepository.findById(socioGuardado.getId()).isPresent());

        // Se verifica que se haya borrado el perfil
        Perfil perfilEnDB = entityManager.find(Perfil.class, idPerfil);
        assertNull(perfilEnDB, "El perfil debería haber sido borrado por la cascada en Postgres");
    }
}
