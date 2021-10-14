package mandatory.cinemama.Controllers.MovieController;

import java.time.LocalTime;
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
  public List<Movie> findAllMovies() {
    return movieService.findAllMovies();
  }

  @Override
  public Movie findMovieById(Long id) {
    return movieService.findMovieById(id);
  }

  @Override
  public Movie findMovieByTitle(String title) {
    return movieService.findMovieByTitle(title);
  }

  @Override
  public void addMovie(Movie movie) {
    movieService.addMovie(movie);
  }

  @Transactional
  @Override
  public void deleteMovieById(Long id) {
    movieService.deleteMovieById(id);
  }

  @Override
  public List<Movie> findMoviesByInfoIgnoreCaseContaining(String info) {
    return movieService.findMoviesByInfoIgnoreCaseContaining(info);
  }

  @Override
  public List<Movie> findMoviesByMinAgeLessThan(int minAge) {
    return movieService.findMoviesByMinAgeLessThan(minAge);
  }

  @Override
  public List<Movie> findMoviesByMinAgeGreaterThan(int minAge) {
    return movieService.findMoviesByMinAgeGreaterThan(minAge);
  }

  @Override
  public List<Movie> findMoviesByRating(int rating) {
    return movieService.findMoviesByRating(rating);
  }

  @Override
  public List<Movie> findMoviesByScreenTimeLessThan(LocalTime screenTime) {
    return movieService.findMoviesByScreenTimeLessThan(screenTime);
  }

  @Override
  public List<Movie> findMoviesByScreenTimeGreaterThan(LocalTime screenTime) {
    return movieService.findMoviesByScreenTimeGreaterThan(screenTime);
  }

  @Override
  public String findInfoByTitle(String title) {
    return movieService.findInfoByTitle(title);
  }
}
