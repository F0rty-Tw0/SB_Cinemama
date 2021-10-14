package mandatory.cinemama.Controllers.MovieController;

import java.util.List;

import javax.transaction.Transactional;

import mandatory.cinemama.Entities.Movie;
import mandatory.cinemama.Services.MovieService.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController implements MovieControllerInterface {

  @Autowired
  private MovieService movieService;

  @Override
  public Movie findMovieById(Long id) {
    return movieService.findMovieById(id);
  }

  @Transactional
  @Override
  public void deleteMovieById(Long id) {
    movieService.deleteMovieById(id);
  }

  @Override
  public List<Movie> findAllMovies() {
    return movieService.findAllMovies();
  }

  @Override
  public Movie findMovieByTitle(String title) {
    return movieService.findMovieByTitle(title);
  }

  @Override
  public Movie addMovie(Movie movie) {
    return movieService.addMovie(movie);
  }
}
