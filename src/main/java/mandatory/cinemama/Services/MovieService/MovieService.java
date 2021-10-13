package mandatory.cinemama.Services.MovieService;

import java.util.List;
import java.util.Optional;
import mandatory.cinemama.Entities.Movie;

public interface MovieService {
  public Optional<Movie> findMovieById(Long id);

  public void deleteMovieById(Long id);

  public List<Movie> findAllMovies();

  public Movie findMovieByTitle(String title);

  public Movie addMovie(Movie movie);
}
