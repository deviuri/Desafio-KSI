package com.ksi.consultas.DesafioKSI.Repository;

import com.ksi.consultas.DesafioKSI.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
