package com.ksi.consultas.DesafioKSI.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ksi.consultas.DesafioKSI.DTOs.MovieDTO;
import lombok.Data;

@Data
public class MovieEx {

    private Long id;
    @JsonProperty("Title")
    private String titulo;
    @JsonProperty("Year")
    private String ano;
    @JsonProperty("Plot")
    private String descricao;
    @JsonProperty("Director")
    private String nomeDiretor;
    @JsonProperty("Poster")
    public String poster;
    @JsonProperty("imdbID")
    private String imdbID;

    public MovieEx(MovieDTO dto) {
        this.id = dto.getId();
        this.titulo = dto.getTitulo();
        this.ano = dto.getAno();
        this.descricao = dto.getDescricao();
        this.nomeDiretor = dto.getNomeDiretor();
        this.poster = dto.poster;
        this.imdbID = dto.getImdbID();
    }

    public MovieEx(Long id, String titulo, String ano, String descricao, String nomeDiretor, String poster, String imdbID) {
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.descricao = descricao;
        this.nomeDiretor = nomeDiretor;
        this.poster = poster;
        this.imdbID = imdbID;
    }

    public MovieEx() {
    }
}
