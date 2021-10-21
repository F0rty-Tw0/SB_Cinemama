package mandatory.cinemama.Controllers.MovieController;

import java.time.LocalTime;
import java.util.List;
import javax.transaction.Transactional;
import mandatory.cinemama.DTOs.MovieDTO;
import mandatory.cinemama.DTOs.ImputDTOs.MovieInputDTO;
import mandatory.cinemama.Entities.Movie;
import mandatory.cinemama.Services.MovieService.MovieService;
import mandatory.cinemama.Utils.CheckExtended;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController implements MovieControllerInterface {

  @Autowired
  private MovieService movieService;

  @Override
  public List<Movie> findAllMovies(String type) {
    return movieService.findAllMovies(CheckExtended.isExtended(type));
  }

  @Override
  public Movie findMovieById(Long id) {
    return movieService.findMovieById(id);
  }

  @Override
  public List<MovieDTO> findMovieByTitle(String title) {
    return movieService.findMovieByTitle(title);
  }

  @Override
  public List<MovieDTO> findMoviesByInfoContaining(String info) {
    return movieService.findMoviesByInfoContaining(info);
  }

  @Override
  public List<MovieDTO> findMoviesByMinAgeLessThan(int minAge) {
    return movieService.findMoviesByMinAgeLessThan(minAge);
  }

  @Override
  public List<MovieDTO> findMoviesByMinAgeGreaterThan(int minAge) {
    return movieService.findMoviesByMinAgeGreaterThan(minAge);
  }

  @Override
  public List<MovieDTO> findMoviesByRating(int rating) {
    return movieService.findMoviesByRating(rating);
  }

  @Override
  public List<MovieDTO> findMoviesByScreenTimeLessThan(LocalTime screenTime) {
    return movieService.findMoviesByScreenTimeLessThan(screenTime);
  }

  @Override
  public List<MovieDTO> findMoviesByScreenTimeGreaterThan(
    LocalTime screenTime
  ) {
    return movieService.findMoviesByScreenTimeGreaterThan(screenTime);
  }

  @Override
  public void updateMovieById(MovieInputDTO movie, Long id) {
    movieService.updateMovieById(movie, id);
  }

  @Override
  public void addMovie(MovieInputDTO movie) {
    movieService.addMovie(movie);
  }

  @Transactional
  @Override
  public void deleteMovieById(Long id) {
    movieService.deleteMovieById(id);
  }
}
