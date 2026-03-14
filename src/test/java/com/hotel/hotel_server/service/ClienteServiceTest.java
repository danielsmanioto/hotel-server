package com.hotel.hotel_server.service;

import com.hotel.hotel_server.model.Cliente;
import com.hotel.hotel_server.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    private ClienteRepository repository;

    @InjectMocks
    private ClienteService service;

    @Test
    void deveListarTodosClientes() {
        List<Cliente> clientes = List.of(
                new Cliente("1", "12345678900", "João", "Silva"),
                new Cliente("2", "98765432100", "Maria", "Souza")
        );
        when(repository.findAll()).thenReturn(clientes);

        List<Cliente> resultado = service.listarTodos();

        assertThat(resultado).hasSize(2);
        assertThat(resultado.get(0).getNome()).isEqualTo("João");
        verify(repository).findAll();
    }

    @Test
    void deveSalvarCliente() {
        Cliente cliente = new Cliente(null, "12345678900", "João", "Silva");
        Cliente salvo = new Cliente("1", "12345678900", "João", "Silva");
        when(repository.save(cliente)).thenReturn(salvo);

        Cliente resultado = service.salvar(cliente);

        assertThat(resultado.getId()).isEqualTo("1");
        assertThat(resultado.getCpf()).isEqualTo("12345678900");
        verify(repository).save(cliente);
    }
}
