package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie) {
        String ans=movieRepository.addMovie(movie);
        return ans;
    }

    public String addDirector(Director director) {
       String ans= movieRepository.addDirector(director);
        return ans;
    }

    public String pairMovieDirector(String movieName, String directorName) {
        return movieRepository.pairMovieDirector(movieName, directorName);
    }

    public Movie getMovieByItsName(String name) {
        return movieRepository.getMovieByItsName(name);
    }

    public Director getDirectorByItsName(String name) {
        return movieRepository.getDirectorByItsName(name);
    }

    public List<String> getMoviesByItsDirectorName(String directorName) {
        return movieRepository.getMoviesByItsDirectorName(directorName);
    }

    public List<String> findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public String removeDirectorByName(String name) {
        return movieRepository.removeDirectorByName(name);
    }

    public void deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
    }
}

