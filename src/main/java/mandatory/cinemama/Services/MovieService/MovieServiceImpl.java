package mandatory.cinemama.Services.MovieService;

import java.util.List;
import java.util.Optional;
import mandatory.cinemama.Entities.Movie;
import mandatory.cinemama.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

  private MovieRepository movieRepository;

  @Autowired
  public MovieServiceImpl(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  @Override
  public Movie findMovieById(Long id) {
    Optional<Movie> movie = movieRepository.findById(id);
    return movie.get();
  }

  @Override
  public void deleteMovieById(Long id) {
    movieRepository.deleteById(id);
  }

  @Override
  public List<Movie> findAllMovies() {
    List<Movie> allMovies = movieRepository.findAll();
    return allMovies;
  }

  @Override
  public Movie findMovieByTitle(String title) {
    Optional<Movie> foundMovies = movieRepository.findByTitle(title);
    return foundMovies.get();
  }

  @Override
  public Movie addMovie(Movie movie) {
    Movie newMovie = movieRepository.save(movie);
    return newMovie;
  }
}
