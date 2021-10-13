package mandatory.cinemama.Services.MovieService;

import mandatory.cinemama.Entities.Movie;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface MovieService {
    public Optional<Movie> findById(Long id);


    public void deleteMovieById(Long id);

    public List<Movie> findAllMovies();

    public List<Movie> findMoviesByActor(String actor);

    public List<Movie> findMoviesByDirector(String director);

    public List<Movie> findMoviesByGenre(String genre);

    public Movie findMovieByTitle (String title);

    public Movie addMovie(Movie movie);

    public Movie updateMovie(long id);
}
