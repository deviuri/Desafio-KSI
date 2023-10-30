package com.ksi.consultas.DesafioKSI.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Movies {

    @JsonProperty("Search")
    public List<MovieEx> movies;
    public String totalResults;
    @JsonProperty("Response")
    public String response;

}
