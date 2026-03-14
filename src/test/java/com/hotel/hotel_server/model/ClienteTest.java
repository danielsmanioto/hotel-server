package com.hotel.hotel_server.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClienteTest {

    @Test
    void deveCriarClienteComConstrutorCompleto() {
        Cliente cliente = new Cliente("1", "12345678900", "João", "Silva");

        assertThat(cliente.getId()).isEqualTo("1");
        assertThat(cliente.getCpf()).isEqualTo("12345678900");
        assertThat(cliente.getNome()).isEqualTo("João");
        assertThat(cliente.getSobrenome()).isEqualTo("Silva");
    }

    @Test
    void deveAtualizarCamposComSetters() {
        Cliente cliente = new Cliente();

        cliente.setId("10");
        cliente.setCpf("99999999999");
        cliente.setNome("Ana");
        cliente.setSobrenome("Lima");

        assertThat(cliente.getId()).isEqualTo("10");
        assertThat(cliente.getCpf()).isEqualTo("99999999999");
        assertThat(cliente.getNome()).isEqualTo("Ana");
        assertThat(cliente.getSobrenome()).isEqualTo("Lima");
    }
}
