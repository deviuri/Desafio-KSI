package com.ksi.consultas.DesafioKSI.Service;

import com.ksi.consultas.DesafioKSI.Cliente.MovieViaOMD;
import com.ksi.consultas.DesafioKSI.DTOs.MovieDTO;
import com.ksi.consultas.DesafioKSI.Model.Movie;
import com.ksi.consultas.DesafioKSI.Model.MovieEx;
import com.ksi.consultas.DesafioKSI.Model.Movies;
import com.ksi.consultas.DesafioKSI.Repository.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private final MovieViaOMD movie;
    private final MovieRepository repository;


    public MovieDTO get(String titulo, String plot){
       MovieDTO movieDTO = this.movie.getMovie(titulo, plot);

       movieDTO.setId(insertMovie(movieDTO));

       return movieDTO;
    }

    public MovieEx getDTO(String titulo, String plot){
        MovieDTO movieDTO = new MovieDTO(this.movie.getMovie(titulo, plot));

        return new MovieEx(movieDTO);
    }

    public MovieDTO getOne(long id) {
        return new MovieDTO(repository.getReferenceById(id));
    }

    public Page<MovieDTO> getAll(Pageable paginado){
        return repository.findAll(paginado).map(MovieDTO::new);
    }

    public Movies getMovies(String titulo, String page){
        return this.movie.getMovies(titulo, page);
    }

    public void editMovie(Long id, MovieDTO dto){
        edit(id, dto);
    }

    private long insertMovie(MovieDTO dto){
        Movie movie = new Movie();

        if (!(dto.getAno() == null || dto.getAno().equals("N/A"))){
            movie.setAno(dto.getAno());
        }else {
            movie.setAno("Não veio.");
        }

        movie.setTitulo(dto.getTitulo());
        if (dto.getNomeDiretor().equals("N/A")){
            movie.setNomeDiretor("Não encontrado");
        }else {
            movie.setNomeDiretor(dto.getNomeDiretor());
        }
        if (dto.getDescricao().equals("N/A")){
            movie.setDescricao("Sem descrição.");
        }else {
            movie.setDescricao(dto.getDescricao());
        }
        if (!(dto.poster == null || dto.poster.equals("N/A"))){
            movie.setPoster(dto.poster);
        }

        repository.save(movie);
        return movie.getId();
    }

    private void edit(long id, MovieDTO dto){
        Movie movie = repository.getReferenceById(id);
        if (dto.getAno() != null) {
            movie.setAno(dto.getAno());
        }
        if (dto.getTitulo() != null) {
            movie.setTitulo(dto.getTitulo());
        }

        if (dto.getNomeDiretor() != null){
            movie.setNomeDiretor(dto.getNomeDiretor());
        }

        if (dto.getDescricao() != null){
            movie.setDescricao(dto.getDescricao());
        }

        if (dto.poster != null){
            movie.setPoster(dto.poster);
        }

        repository.save(movie);
        new MovieDTO(movie);
    }

    public MovieService(MovieViaOMD movie, MovieRepository repository) {
        this.movie = movie;
        this.repository = repository;
    }

}
