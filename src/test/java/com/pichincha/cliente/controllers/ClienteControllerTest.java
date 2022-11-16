package com.pichincha.cliente.controllers;

import com.pichincha.cliente.models.Cliente;
import com.pichincha.cliente.services.IClienteService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClienteControllerTest {

    @InjectMocks
    ClienteController controlador;

    @Mock
    IClienteService service;

    Cliente cliente;
    List<Cliente> clientes;

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

        clientes = Arrays.asList(cliente);
    }

    @Test
    void findAll() {
        Mockito.when(service.findAll()).thenReturn(clientes);
        ResponseEntity<List<Cliente>> response = controlador.findAll();

        assertEquals(1, response.getBody().stream().count());
    }

    @Test
    void findById() {
        Mockito.when(service.fintById(Mockito.any())).thenReturn(cliente);
        ResponseEntity<Cliente> response = controlador.findById(1);

        assertEquals("30", response.getBody().getEdad());
    }

    @Test
    void insert() {
        Mockito.when(service.insert(Mockito.any())).thenReturn(cliente);
        ResponseEntity<Cliente> response = controlador.insert(cliente);

        assertNotNull(response);
        assertEquals("William Mamani", response.getBody().getNombre());
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}