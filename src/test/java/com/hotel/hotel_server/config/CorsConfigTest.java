package com.hotel.hotel_server.config;

import com.hotel.hotel_server.controller.ClienteController;
import com.hotel.hotel_server.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ClienteController.class)
@Import(CorsConfig.class)
class CorsConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @Test
    void devePermitirCorsParaAngularLocalhost4200() throws Exception {
        mockMvc.perform(options("/clientes")
                        .header(HttpHeaders.ORIGIN, "http://localhost:4200")
                        .header(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD, "GET"))
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "http://localhost:4200"));
    }
}
