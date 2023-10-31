package com.ksi.consultas.DesafioKSI.Service;

import com.ksi.consultas.DesafioKSI.Infra.exceptions.DatabaseException;
import com.ksi.consultas.DesafioKSI.Infra.exceptions.NoSuchElementException;
import com.ksi.consultas.DesafioKSI.Infra.exceptions.ResourceNotFoundException;
import com.ksi.consultas.DesafioKSI.Cliente.MovieViaOMD;
import com.ksi.consultas.DesafioKSI.DTOs.MovieDTO;
import com.ksi.consultas.DesafioKSI.Model.Movie;
import com.ksi.consultas.DesafioKSI.Model.MovieEx;
import com.ksi.consultas.DesafioKSI.Model.Movies;
import com.ksi.consultas.DesafioKSI.Repository.MovieRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {
    private final MovieViaOMD movie;
    private final MovieRepository repository;


    public MovieDTO get(String titulo, String plot) {
        MovieDTO movieDTO = this.movie.getMovie(titulo, plot);

        movieDTO.setId(insertMovie(movieDTO));

        return movieDTO;
    }

    public MovieEx getDTO(String titulo, String plot) {
        try {
            MovieDTO movieDTO = new MovieDTO(this.movie.getMovie(titulo, plot));
            return new MovieEx(movieDTO);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Filme com titulo: " + titulo + " não foi encontrado!");
        } catch (DataIntegrityViolationException | NoSuchElementException e) {
            throw new DatabaseException("Filme não existe em nosso Banco de Dados");
        }
    }

    public Page<MovieDTO> getAll(Pageable paginado) {
        return repository.findAll(paginado).map(MovieDTO::new);
    }

    public Movies getMovies(String titulo, String page) {
        try {
            return this.movie.getMovies(titulo, page);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Filme não foi encontrado!");
        } catch (DataIntegrityViolationException | NoSuchElementException e) {
            throw new DatabaseException("Filme não existe em nosso Banco de Dados");
        }
    }

    public void editMovie(Long id, MovieDTO dto) {
        try {
            edit(id, dto);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Filme não foi encontrado!");
        } catch (DataIntegrityViolationException | NoSuchElementException e) {
            throw new DatabaseException("Filme não existe em nosso Banco de Dados");
        }
    }

    public MovieDTO getOne(long id) {
        Optional<Movie> movieOP = repository.findById(id);
        Movie movie = movieOP.orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado"));
        return new MovieDTO(movie);
    }

    public void del(long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Filme não foi encontrado!");
        } catch (DataIntegrityViolationException | NoSuchElementException e) {
            throw new DatabaseException("Filme não existe em nosso Banco de Dados");
        }
    }









    private long insertMovie(MovieDTO dto) {
        Movie movie = new Movie();

        if (!(dto.getAno() == null || dto.getAno().equals("N/A"))) {
            movie.setAno(dto.getAno());
        } else {
            movie.setAno("Não veio.");
        }

        movie.setTitulo(dto.getTitulo());
        if (dto.getNomeDiretor().equals("N/A")) {
            movie.setNomeDiretor("Não encontrado");
        } else {
            movie.setNomeDiretor(dto.getNomeDiretor());
        }
        if (dto.getDescricao().equals("N/A")) {
            movie.setDescricao("Sem descrição.");
        } else {
            movie.setDescricao(dto.getDescricao());
        }
        if (!(dto.poster == null || dto.poster.equals("N/A"))) {
            movie.setPoster(dto.poster);
        }
        movie.setImdbID(dto.getImdbID());

        repository.save(movie);
        return movie.getId();
    }

    private void edit(long id, MovieDTO dto) {
        Movie movie = repository.getReferenceById(id);
        if (dto.getAno() != null) {
            movie.setAno(dto.getAno());
        }
        if (dto.getTitulo() != null) {
            movie.setTitulo(dto.getTitulo());
        }

        if (dto.getNomeDiretor() != null) {
            movie.setNomeDiretor(dto.getNomeDiretor());
        }

        if (dto.getDescricao() != null) {
            movie.setDescricao(dto.getDescricao());
        }

        if (dto.poster != null) {
            movie.setPoster(dto.poster);
        }

        repository.save(movie);
    }



    public MovieService(MovieViaOMD movie, MovieRepository repository) {
        this.movie = movie;
        this.repository = repository;
    }
}
