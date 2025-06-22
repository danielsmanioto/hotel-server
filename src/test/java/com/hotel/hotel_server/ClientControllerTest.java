package com.hotel.hotel_server;

import com.hotel.hotel_server.controller.ClienteController;
import com.hotel.hotel_server.model.Cliente;
import com.hotel.hotel_server.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(ClienteController.class)
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @Test
    void deveListarClientes() throws Exception {
        List<Cliente> clientes = List.of(
                new Cliente("1", "12345678900", "João", "Silva"),
                new Cliente("2", "98765432100", "Maria", "Souza")
        );
        Mockito.when(clienteService.listarTodos()).thenReturn(clientes);

        mockMvc.perform(get("/clientes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    [
                        {"id":"1","cpf":"12345678900","nome":"João","sobrenome":"Silva"},
                        {"id":"2","cpf":"98765432100","nome":"Maria","sobrenome":"Souza"}
                    ]
                """));
    }
}