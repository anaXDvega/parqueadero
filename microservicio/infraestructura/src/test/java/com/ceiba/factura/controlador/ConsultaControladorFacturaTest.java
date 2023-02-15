package com.ceiba.factura.controlador;

import com.ceiba.ApplicationMock;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorFactura.class)
public class ConsultaControladorFacturaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    void consultarFacturas() throws Exception {
        // act - assert
        mocMvc.perform(get("/factura")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].idReserva", is(2)))
                .andExpect(jsonPath("$[1].idReserva", is(3)))
                .andExpect(jsonPath("$[2].idReserva", is(1)));
                }

    @Test
    void consultarPorId() throws Exception {
            // act - assert
        mocMvc.perform(get("/factura/{id}", 3)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{ \"id\": 3,\n" +
                        "    \"idReserva\": 3,\n" +
                        "    \"fechaInicio\": \"2022-12-29 13:18:00\",\n" +
                        "    \"valorTotal\": 910,\n" +
                        "    \"estado\": \"FINALIZADO\"\n" +
                        "}"));
    }
}
