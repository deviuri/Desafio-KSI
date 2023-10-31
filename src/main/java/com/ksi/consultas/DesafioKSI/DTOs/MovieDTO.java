package com.ksi.consultas.DesafioKSI.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ksi.consultas.DesafioKSI.Model.Movie;
import lombok.Data;

@Data
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
    private String poster;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }
}
