package com.ksi.consultas.DesafioKSI.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ksi.consultas.DesafioKSI.DTOs.MovieDTO;
import com.ksi.consultas.DesafioKSI.Model.Movie;
import com.ksi.consultas.DesafioKSI.MovieDTO.CriarTestes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieTeste {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Long id;
    private Long naoExisteID;
    private String naoExisteTitulo;


    @BeforeEach
    void setUp() {
        id = 1L;
        naoExisteID = 1000L;
        naoExisteTitulo = "Não existe";
    }

    @Test
    public void QuandoNaoExistirIdVaiRetornaNotFound() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/editar/{id}", naoExisteID))
                .andExpect(status().isNotFound());

    }

    @Test
    public void QuandoExistirTituloVaiRedirecionar() throws Exception {
        Movie movieDTO = CriarTestes.criarMovie();
        String jsonBody = objectMapper.writeValueAsString(movieDTO);
        mockMvc.perform(MockMvcRequestBuilders.get("/adicionar/{titulo}", movieDTO.getTitulo())
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().is3xxRedirection());
    }


    @Test public void QuandoNaoExistirTituloVaiRetornaNotFound() throws Exception {
        MovieDTO movieDTO = new MovieDTO(CriarTestes.criarMovie());
        String jsonBody = objectMapper.writeValueAsString(movieDTO);
        mockMvc.perform(MockMvcRequestBuilders.get("/adicionar/{titulo}", "Título que não existe") )
                .andExpect(status().is3xxRedirection());
    }

}
