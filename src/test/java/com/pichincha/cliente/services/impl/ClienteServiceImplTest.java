package com.pichincha.cliente.services.impl;

import com.pichincha.cliente.exceptions.ModelNotFoundException;
import com.pichincha.cliente.models.Cliente;
import com.pichincha.cliente.repositories.IClienteRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClienteServiceImplTest {

    @InjectMocks
    private ClienteServiceImpl service;
    @Mock
    private IClienteRepository repo;

    Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = Cliente.builder()
                .clienteId(1)
                .nombre("William Mamani")
                .genero("M")
                .edad(30)
                .dni("12345678")
                .direccion("direccion")
                .telefono("123456789")
                .contrasenia("123")
                .estado("true")
                .build();
    }

    @Test
    void insert() {
    }

    @Test
    void update() {
    }

    @Test
    void findAll() {
    }

    @Test
    void fintById() {
        Mockito.when(repo.findById(Mockito.any())).thenReturn(Optional.ofNullable(cliente));
        Cliente resultado = service.fintById(1);

        assertEquals("12345678", resultado.getDni());
    }

    @Test
    void fintByIdConError() throws ModelNotFoundException {
        Mockito.when(repo.findById(Mockito.any())).thenReturn(Optional.ofNullable(cliente));
        Optional<Cliente> resultado = repo.findById(2);

        assertNotNull(resultado);
    }

    @Test
    void delete() {
    }
}