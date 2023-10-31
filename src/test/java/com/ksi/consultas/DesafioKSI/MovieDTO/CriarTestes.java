package com.ksi.consultas.DesafioKSI.MovieDTO;

import com.ksi.consultas.DesafioKSI.Model.Movie;

public class CriarTestes {

    public static Movie criarMovie(){
        return new Movie(1L, "Filme Teste", "2018", "Iuri Martins", "Sem descrição", "Sem Imagem", "imdbIDTeste");
    }
}
