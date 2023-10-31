package com.ksi.consultas.DesafioKSI.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
public class Movie {

    public String imdbID;
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
    public String poster;

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

}