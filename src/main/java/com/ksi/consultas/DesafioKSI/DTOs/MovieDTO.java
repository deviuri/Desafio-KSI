package com.ksi.consultas.DesafioKSI.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ksi.consultas.DesafioKSI.Model.Movie;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MovieDTO {

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

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.titulo = movie.getTitulo();
        this.nomeDiretor = movie.getNomeDiretor();
        this.ano = movie.getAno();
        this.descricao = movie.getDescricao();
        this.poster = movie.getPoster();
        this.imdbID = movie.getImdbID();
    }

    public MovieDTO() {
    }

    public MovieDTO(String titulo, String ano, String descricao, String nomeDiretor, String poster, String imdbID) {
        this.titulo = titulo;
        this.ano = ano;
        this.descricao = descricao;
        this.nomeDiretor = nomeDiretor;
        this.poster = poster;
        this.imdbID = imdbID;
    }

    public MovieDTO(MovieDTO movie) {

        if (movie.getDescricao().equals("N/A")){
            this.setDescricao("Sem descrição");
        }else {
            this.descricao = movie.getDescricao();
        }
        if (movie.getNomeDiretor().equals("N/A")){
            this.setNomeDiretor("Desconhecido");
        }else {
            this.nomeDiretor = movie.getNomeDiretor();
        }

        this.id = movie.getId();
        this.titulo = movie.getTitulo();
        this.ano = movie.getAno();
        this.poster = movie.getPoster();
        this.imdbID = movie.getImdbID();
    }

}
