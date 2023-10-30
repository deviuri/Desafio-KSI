package com.ksi.consultas.DesafioKSI.Cliente;


import com.ksi.consultas.DesafioKSI.DTOs.MovieDTO;
import com.ksi.consultas.DesafioKSI.Model.Movies;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(url = "http://www.omdbapi.com/?apikey=4572a315&type=movie", name = "Movies")
public interface MovieViaOMD {

    @GetMapping
    MovieDTO getMovie(@RequestParam("i") String titulo, @RequestParam(name = "plot", defaultValue = "short", required = false) String plot);

    @GetMapping
    Movies getMovies(@RequestParam(name = "s", required = false) String titulo, @RequestParam(name = "page", required = false, defaultValue = "1") String page);
}
