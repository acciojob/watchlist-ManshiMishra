package com.driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {
    private Map<String, Movie> movieDb = new HashMap<>();
    private Map<String, Director> directorDb = new HashMap<>();
    private Map<String, String> movieDirectorMap = new HashMap<>();

    public String addMovie(Movie movie) {
        String key=movie.getName();
        movieDb.put(key,movie);
        return "Movie added successfully";
    }


    public String addDirector(Director director) {
        String key=director.getName();
        directorDb.put(key,director);
        return "Director added successfully";
    }

    public String pairMovieDirector(String movieName, String directorName) {
        movieDirectorMap.put(movieName, directorName);
        return "Pair them successfully";
    }
    public Movie getMovieByItsName(String name) {
        return movieDb.get(name);
        // return movieRepository.getMovieByItsName(name);
    }


    public Director getDirectorByItsName(String name) {
        return directorDb.get(name);
    }

    public List<String> getMoviesByItsDirectorName(String directorName) {
        return movieDirectorMap.entrySet()
                .stream()
                .filter(e -> e.getValue().equals(directorName))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<String> findAllMovies() {
        return movieDb.keySet().stream().collect(Collectors.toList());
    }

    public String removeDirectorByName(String name) {
        directorDb.remove(name);
        movieDirectorMap.entrySet().removeIf(e -> e.getValue().equals(name));
        return name;
    }

    public void deleteAllDirectors() {
        directorDb.clear();
        movieDirectorMap.clear();
    }
}
