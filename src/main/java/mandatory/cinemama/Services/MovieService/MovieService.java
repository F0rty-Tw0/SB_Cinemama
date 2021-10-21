package mandatory.cinemama.Services.MovieService;

import java.time.LocalTime;
import java.util.List;
import mandatory.cinemama.DTOs.MovieDTO;
import mandatory.cinemama.DTOs.ImputDTOs.MovieInputDTO;
import mandatory.cinemama.Entities.Movie;

public interface MovieService {
  public List<Movie> findAllMovies(boolean isExtended);

  public Movie findMovieById(Long id);

  public List<MovieDTO> findMovieByTitle(String title);

  public List<MovieDTO> findMoviesByInfoContaining(String info);

  public List<MovieDTO> findMoviesByMinAgeLessThan(int minAge);

  public List<MovieDTO> findMoviesByMinAgeGreaterThan(int minAge);

  public List<MovieDTO> findMoviesByRating(int rating);

  public List<MovieDTO> findMoviesByScreenTimeLessThan(LocalTime screenTime);

  public List<MovieDTO> findMoviesByScreenTimeGreaterThan(LocalTime screenTime);

  public void updateMovieById(MovieInputDTO movie, Long id);

  public void addMovie(MovieInputDTO movie);

  public void deleteMovieById(Long id);
}
