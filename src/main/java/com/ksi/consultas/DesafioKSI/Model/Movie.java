package com.ksi.consultas.DesafioKSI.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Lob
    private String titulo;
    private String ano;
    @Lob
    private String nomeDiretor;
    @Lob
    private String descricao;
    @Lob
    private String poster;
    private String imdbID;
    public Movie(Long id, String titulo, String ano, String nomeDiretor, String descricao, String poster, String imdbID) {
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.nomeDiretor = nomeDiretor;
        this.descricao = descricao;
        this.poster = poster;
        this.imdbID = imdbID;
    }

    public Movie() {

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

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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