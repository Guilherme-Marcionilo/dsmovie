package com.devsuperior.dsmovie.services;

import com.devsuperior.dsmovie.dto.MovieDto;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Transactional
    public Page<MovieDto> findAll(Pageable pageable) {
        Page<Movie> possibleMovies =  movieRepository.findAll(pageable);
        return possibleMovies.map(MovieDto::new);
    }

    public Optional<MovieDto> findById(Long id) {
        Optional<Movie> possibleMovie = movieRepository.findById(id);
        return possibleMovie.map(MovieDto::new);
    }
}
