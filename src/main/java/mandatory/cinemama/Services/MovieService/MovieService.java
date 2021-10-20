package mandatory.cinemama.Services.MovieService;

import java.time.LocalTime;
import java.util.List;
import mandatory.cinemama.DTOs.MovieDTO;
import mandatory.cinemama.Entities.Movie;

public interface MovieService {
  public List<Movie> findAllMovies();

  public Movie findMovieById(Long id);

  public Movie findMovieByTitle(String title);

  public List<MovieDTO> findDescriptiveMovieInfoByMovieTitleContaining(
    String title
  );

  public List<Movie> findMoviesByInfoContaining(String info);

  public List<Movie> findMoviesByMinAgeLessThan(int minAge);

  public List<Movie> findMoviesByMinAgeGreaterThan(int minAge);

  public List<Movie> findMoviesByRating(int rating);

  public List<Movie> findMoviesByScreenTimeLessThan(LocalTime screenTime);

  public List<Movie> findMoviesByScreenTimeGreaterThan(LocalTime screenTime);

  public void updateMovieById(Movie movie, Long id);

  public void addMovie(Movie movie);

  public void deleteMovieById(Long id);
}
