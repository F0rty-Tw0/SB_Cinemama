package mandatory.cinemama.Services.MovieService;

import java.time.LocalTime;
import java.util.List;
import mandatory.cinemama.Entities.Movie;
import mandatory.cinemama.ErrorHandler.ErrorMessageCreator;
import mandatory.cinemama.ErrorHandler.Exceptions.ResourceNotFoundException;
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

  private String type = "Movie";

  @Override
  public List<Movie> findAllMovies() {
    List<Movie> allMovies = movieRepository.findAll();
    return allMovies;
  }

  @Override
  public Movie findMovieById(Long id) {
    Movie movie = movieRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );
    return movie;
  }

  @Override
  public Movie findMovieByTitle(String title) {
    Movie foundMovies = movieRepository
      .findByTitle(title)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(title, type)
          )
      );
    return foundMovies;
  }

  @Override
  public List<Movie> findMoviesByInfoContaining(String info) {
    List<Movie> allMovies = movieRepository.findByInfoContaining(info);
    return allMovies;
  }

  @Override
  public List<Movie> findMoviesByMinAgeLessThan(int minAge) {
    List<Movie> allMovies = movieRepository.findByMinAgeLessThan(minAge);
    return allMovies;
  }

  @Override
  public List<Movie> findMoviesByMinAgeGreaterThan(int minAge) {
    List<Movie> allMovies = movieRepository.findByMinAgeGreaterThan(minAge);
    return allMovies;
  }

  @Override
  public List<Movie> findMoviesByRating(int rating) {
    List<Movie> allMovies = movieRepository.findByRating(rating);
    return allMovies;
  }

  @Override
  public List<Movie> findMoviesByScreenTimeLessThan(LocalTime screenTime) {
    List<Movie> allMovies = movieRepository.findByScreenTimeLessThan(
      screenTime
    );
    return allMovies;
  }

  @Override
  public List<Movie> findMoviesByScreenTimeGreaterThan(LocalTime screenTime) {
    List<Movie> allMovies = movieRepository.findByScreenTimeGreaterThan(
      screenTime
    );
    return allMovies;
  }

  @Override
  public String findInfoByTitle(String title) {
    Movie info = movieRepository
      .findInfoByTitle(title)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(title, type)
          )
      );
    return info.getInfo();
  }

  @Override
  public void updateMovieById(Movie movie, Long id) {
    Movie foundMovie = movieRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );

    foundMovie.setActors(movie.getActors());
    foundMovie.setDirectors(movie.getDirectors());
    foundMovie.setGenres(movie.getGenres());
    foundMovie.setTitle(movie.getTitle());
    foundMovie.setInfo(movie.getInfo());
    foundMovie.setRating(movie.getRating());
    foundMovie.setMinAge(movie.getMinAge());
    movieRepository.save(foundMovie);
  }

  @Override
  public void addMovie(Movie movie) {
    movieRepository.save(movie);
  }

  @Override
  public void deleteMovieById(Long id) {
    movieRepository.deleteById(id);
  }
}
