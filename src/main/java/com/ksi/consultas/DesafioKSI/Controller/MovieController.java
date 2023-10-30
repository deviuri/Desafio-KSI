package com.ksi.consultas.DesafioKSI.Controller;

import com.ksi.consultas.DesafioKSI.DTOs.MovieDTO;
import com.ksi.consultas.DesafioKSI.Model.MovieEx;
import com.ksi.consultas.DesafioKSI.Model.Movies;
import com.ksi.consultas.DesafioKSI.Repository.MovieRepository;
import com.ksi.consultas.DesafioKSI.Service.MovieService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service, MovieRepository repository) {
        this.service = service;
    }

    @GetMapping("buscar/{titulo}")
    public MovieDTO getMovie(@PathVariable() String titulo, @RequestParam(required = false) String plot, Model model) {
        MovieDTO movieDTO = service.get(titulo, plot);
        model.addAttribute("movie", movieDTO);
        return movieDTO;
    }

    @GetMapping()
    public String getAllByRepository(Pageable pageable, Model model, @RequestParam(name = "size",defaultValue = "8", required = false) int size) {
        Page<MovieDTO> movieDTO = service.getAll(pageable);

        model.addAttribute("movie", movieDTO);

        return "filme/filmesLista";
    }

    @GetMapping("/filmes")
    public String getMovies(@RequestParam String titulo, @RequestParam(required = false) String page, @RequestParam(required = false) String plot, Model model) {
        Movies movies = service.getMovies(titulo, page);

        List<MovieEx> movieExes = movies.getMovies();


        if (movieExes != null) {
            movieExes.forEach(x -> {
                service.getDTO(x.getImdbID(), plot);
                x.setDescricao(service.getDTO(x.getImdbID()).getDescricao());
                x.setNomeDiretor(service.getDTO(x.getImdbID()).getNomeDiretor());
            });

            model.addAttribute("movies", movieExes);

        }


        return "filme/filmesLista";
    }

    @GetMapping("editar/{titulo}")
    public String edit(@PathVariable String titulo, @RequestParam(required = false) String plot, Model model){
        MovieDTO movieDTO = service.get(titulo, plot);
        model.addAttribute("filme", movieDTO);

        return "filme/filmesLista";
    }

    @PostMapping("editar/{id}")
    public String edit(@PathVariable long id, @Valid MovieDTO movie, BindingResult result, RedirectAttributes redirect) {

        if (result.hasErrors()){
            redirect.addFlashAttribute("mensagem", "Verifique todos os campos");
            return "redirect:filme/filmesLista";
        }
        this.service.editMovie(id, movie);
        return "redirect:filme/filmesLista";
    }


}
