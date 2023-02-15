package com.ceiba.reserva.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.reserva.comando.ComandoSolicitudActivarReserva;
import com.ceiba.reserva.comando.ComandoSolicitudReservar;
import com.ceiba.reserva.testdatabuilder.ComandoActivarReservaTestDataBuilder;
import com.ceiba.reserva.testdatabuilder.ComandoReservaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorReserva.class)
public class ComandoControladorReservaTest {

        @Autowired
        private ObjectMapper objectMapper;

        @Autowired
        private MockMvc mocMvc;

        @Test
        void reservar() throws Exception {
                // arrange
                ComandoSolicitudReservar entrada = new ComandoReservaTestDataBuilder().reservarMoto().build();

                // act - assert
                mocMvc.perform(post("/reserva/reservar")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(entrada)))
                        .andExpect(status().isCreated())
                        .andExpect(content().json("{\n" +
                                "    \"valor\": 6\n" +
                                "}"));
        }

        @Test
        void activarReserva() throws Exception {
                // arrange
                ComandoSolicitudActivarReserva entrada = new ComandoActivarReservaTestDataBuilder().activarReserva().build();

                // act - assert
                mocMvc.perform(post("/reserva/activarReserva")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(entrada)))
                        .andExpect(status().isOk());
        }
        @Test
        void eliminar() throws Exception {
                // arrange
                Long id = 2L;

                // act - assert
                mocMvc.perform(delete("/reserva/{id}", id)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
        }
}
